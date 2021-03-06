package com.andy.service.database;


import com.andy.exceptions.ValidateException;
import com.andy.model.Spot;
import com.andy.model.input.SpotInput;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface SpotService {

    Spot getByUuid(UUID uuid);

    List<Spot> listAll();

    Spot addsSpot(SpotInput spotInput);

    Spot insertSpot(Spot spot);

    Spot updateSpot(Spot spot);

    void deleteSpot(UUID uuid);

    List<Spot> list(Map<String, Object> params);

    Map<String, Object> fillUpSearchParams(Map<String, Object> params) throws ValidateException;

    void punchSpot(String uuid, Integer playerNumber) throws Exception;
}
