package com.andy.service.business;

import com.andy.model.Spot;
import com.andy.service.database.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: Lim, Andy
 * @Date: 2021/4/6
 * @Proposal:
 */
@Service
public class ActivityService {

    @Autowired
    private SpotService spotService;

    public boolean isOpen(UUID spotId) {
        Spot spot = spotService.getByUuid(spotId);

        if(spot != null && spot.getIsOpen()) {
            return true;
        }

        return false;
    }
}
