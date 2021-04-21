package com.andy.service.business;

import com.andy.exceptions.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DonateDispatchService {

    @Autowired
    private AllpayServiceImpl allpayService;

    @Autowired
    private GreenPayServiceImpl greenPayService;

    public DonateService getServiceByProvider(String provider) throws ValidateException {

        switch (provider) {
            case "allpay":
                return allpayService;
            case "green":
                return greenPayService;
            default:
                throw new ValidateException("no such payment");
        }
    }
}
