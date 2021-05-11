package com.andy.controller;

import com.andy.exceptions.ValidateException;
import com.andy.service.business.DonateDispatchService;
import com.andy.service.business.DonateService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/donate")
public class DonateController {

    @Autowired
    private DonateDispatchService donateDispatchService;

    @RequestMapping(value="getInitialPayPage", method = RequestMethod.GET)
    public ResponseEntity getInitialPayPage(
            @RequestParam(value = "provider", required = true) String provider,
            HttpServletRequest httpServletRequest) {

        DonateService donateService;
        try {
            donateService = donateDispatchService.getServiceByProvider(provider);
        } catch(ValidateException e) {
            log.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

        String pageHtml = donateService.htmlMethod();

        return new ResponseEntity(pageHtml, HttpStatus.OK);
    }

    @RequestMapping(value="submitPay", method = RequestMethod.POST)
    public ResponseEntity punch(
            @RequestParam(value="provider", required = true)  String provider,
            @RequestBody String jsonBody,
            HttpServletRequest httpServletRequest) {

        DonateService donateService;
        try {
            donateService = donateDispatchService.getServiceByProvider(provider);
            Boolean isValid = donateService.checkParams(jsonBody);
        } catch(ValidateException e) {
            log.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(jsonBody, HttpStatus.OK);
    }
}
