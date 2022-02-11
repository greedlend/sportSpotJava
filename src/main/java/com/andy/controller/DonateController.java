package com.andy.controller;

import com.andy.exceptions.ValidateException;
import com.andy.model.RequestGatewayGreen;
import com.andy.service.business.DonateDispatchService;
import com.andy.service.business.DonateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/donate")
public class DonateController {

    @Autowired
    private DonateDispatchService donateDispatchService;

    @RequestMapping(value = "donatePage", method = RequestMethod.GET)
    public ModelAndView donatePage(
            HttpServletRequest httpServletRequest) {
        ModelAndView mv = new ModelAndView();
        Map<String,Object> map = new HashMap<>();
        map.put("url", "http://aaa.com");
        map.put("name", "myname");
        mv.addObject("user", map);
        mv.addObject("name", "myname");

        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value="getInitialPayPage", method = RequestMethod.GET)
    public ResponseEntity getInitialPayPage(
            @RequestParam(value = "provider", required = true) String provider,
            HttpServletRequest httpServletRequest) {

        DonateService donateService;
        try {
            donateService = donateDispatchService.getServiceByProvider(provider);
            RequestGatewayGreen aa = new RequestGatewayGreen();
            aa.setAmount(BigDecimal.valueOf(1));
            aa.setBrandName("Green");
            donateService.send(aa);
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
