package com.andy.service.business;

import com.andy.exceptions.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DonateDispatchService {

    @Autowired
    private ApplicationContext context;

    public DonateService getServiceByProvider(String provider) throws ValidateException {

        DonateService targetService = (DonateService) context.getBean(provider);
        log.info("get Bean{}", targetService.getClass().getName());
        return targetService;

    }

}