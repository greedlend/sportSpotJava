package com.andy.service.database.impl;

import com.andy.exceptions.ValidateException;
import com.andy.model.Spot;
import com.andy.model.input.SpotInput;
import com.andy.repository.SpotRepository;
import com.andy.service.database.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SpotServiceImpl implements SpotService{

    @Autowired
    private SpotRepository spotRepository;

    @Override
    public Spot getByUuid(UUID uuid) {
        return spotRepository.getOne(uuid);
    }

    @Override
    public List<Spot> listAll() {
        return spotRepository.findAll();
    }

    @Override
    public Spot addsSpot(SpotInput spotInput) {
        Spot spot = new Spot();
        spot.setUuid(UUID.randomUUID());
        spot.setAddress(spotInput.getAddress());
        spot.setPlayersNumber(0);
        spot.setOpenTime(spotInput.getOpenTime());
        spot.setCloseTime(spotInput.getCloseTime());
        spot.setIsOpen(true);
        spot.setIsDel(false);

        return this.insertSpot(spot);
    }

    @Override
    public Spot insertSpot(Spot spot) {
        return spotRepository.saveAndFlush(spot);
    }

    @Override
    public Spot updateSpot(Spot spot) {
        return spotRepository.saveAndFlush(spot);
    }

    @Override
    public void deleteSpot(UUID uuid) {
        spotRepository.deleteById(uuid);
    }

    @Override
    public List<Spot> list(Map<String, Object> params) {

        if(params.containsKey("sort")) {
            List<Sort.Order> orders = (List<Sort.Order>)params.get("sort");
            return spotRepository.findAll(Sort.by(orders));
        }
        return spotRepository.findAll();
    }

    @Override
    public Map<String, Object> fillUpSearchParams(Map<String, Object> args) throws Exception{

        Map<String, Object> params = new HashMap<>();
        String sortBy = (String)args.get("sortBy");
        String direction = (String)args.get("direction");

        if(!Arrays.stream(direction.split(",")).allMatch(element -> element.equals("asc") || element.equals("desc"))) {
            throw new ValidateException("Validate Exception, fillUpSearchParams");
        }

        if(0 < sortBy.split(",").length) {
            List<Sort.Order> orders = new ArrayList<>();
            String[] sortByArray = sortBy.split(",");
            String[] directionArray = direction.split(",");
            int index = 0;
            for (String target : sortByArray) {
                Sort.Order order = new Sort.Order(
                        "asc".equals(directionArray[index]) ? Sort.Direction.ASC:Sort.Direction.DESC
                        , target);
                orders.add(order);
                index++;
            }
            params.put("sort", orders);
        }


        return params;
    }
}
