package com.andy.service.database.impl;

import com.andy.model.Spot;
import com.andy.model.input.SpotInput;
import com.andy.repository.SpotRepository;
import com.andy.service.database.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
}
