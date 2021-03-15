package com.andy.service.database.impl;

import com.andy.model.Spot;
import com.andy.repository.SpotRepository;
import com.andy.service.database.SpotService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

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
    public Spot addsSpot(Spot spot) {
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
