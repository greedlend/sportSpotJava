package com.andy.service.database;


import com.andy.model.Spot;
import com.andy.model.input.SpotInput;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface SpotService {

    Spot getByUuid(UUID uuid);

    List<Spot> listAll();

    Spot addsSpot(SpotInput spotInput);

    Spot insertSpot(Spot spot);

    Spot updateSpot(Spot spot);

    void deleteSpot(UUID uuid);
}
