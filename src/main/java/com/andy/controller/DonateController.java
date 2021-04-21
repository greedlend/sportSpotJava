package com.andy.controller;

import com.andy.exceptions.ValidateException;
import com.andy.service.business.DonateDispatchService;
import com.andy.service.business.DonateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/donate")
public class DonateController {

    @Autowired
    private DonateDispatchService donateDispatchService;

    @RequestMapping(value="getInitialPayPage", method = RequestMethod.GET)
    public ResponseEntity punch(
            @RequestParam(value = "provider", required = true) String provider,
            HttpServletRequest httpServletRequest) {

        DonateService donateService;
        try {
            donateService = donateDispatchService.getServiceByProvider(provider);
        } catch(ValidateException e) {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }

        String pageHtml = donateService.htmlMethod();

        return new ResponseEntity(pageHtml, HttpStatus.OK);
    }
}
