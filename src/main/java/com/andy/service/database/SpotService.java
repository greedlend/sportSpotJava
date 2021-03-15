package com.andy.service.database;


import com.andy.model.Spot;

import java.util.List;
import java.util.UUID;

public interface SpotService {

    Spot getByUuid(UUID uuid);

    List<Spot> listAll();

    Spot addsSpot(Spot spot);

    Spot updateSpot(Spot spot);

    void deleteSpot(UUID uuid);
}
