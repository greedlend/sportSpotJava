package com.andy.controller;

import com.andy.config.BaseConfiguration;
import com.andy.model.Spot;
import com.andy.model.input.SpotInput;
import com.andy.service.database.SpotService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author: Lim, Andy
 * @Date: 2021/3/2
 * @Proposal:
 */
//Spring4之后新加入的注解，原来返回json需要@ResponseBody和@Controller配合。
//即@RestController 是@ResponseBody和@Controller的组合注解。
@Log4j2
@RestController
@RequestMapping("/spot")
public class SpotController {

    private static final String punchKey = "Punch-Spot-";

    @Autowired
    private BaseConfiguration baseConfig;

    @Autowired
    private SpotService spotService;


    /**
     *
     * @ResponseBody: Spring treats the result value of the method as the HTTP response body
     * tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
     * */
    @RequestMapping(value= "/listAll")
    @ResponseBody
    public List<Spot> listAll() {
        return spotService.listAll();
    }

    /**
     * @RequestBody:
     *  the @RequestBody annotation maps the HttpRequest body to a transfer or domain object,
     *  enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
     *  the type we annotate with the @RequestBody annotation must correspond to the JSON sent from our client-side controller
     * */
    @RequestMapping(value= "/list")
    public ResponseEntity list(
            @RequestParam(value = "sortBy", required = true) String sortBy,
            @RequestParam(value = "direction",required = true) String direction) {

        Map<String,Object> params = new HashMap<>();
        params.put("sortBy", sortBy);
        params.put("direction", direction);

        try {
            params = spotService.fillUpSearchParams(params);
        }catch (Exception validateException){
            log.error(validateException.getStackTrace()[0]);
            return new ResponseEntity<>("Plz check the requested parameters. " + validateException.getMessage(), HttpStatus.OK);
        }
        // test fetch
        List<Spot> result = spotService.list(params);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value= "/adds",method = RequestMethod.POST)
    public String addsSpot(@RequestBody SpotInput spot, HttpServletRequest request, HttpServletResponse response) {

        Spot result = spotService.addsSpot(spot);
        return null == result? "failed":"ok";
    }

    @RequestMapping(value="punch", method = RequestMethod.GET)
    public ResponseEntity punch(
            @RequestParam(value = "spotUuid", required = true) String uuid,
            @RequestParam(value = "playersNumber",required = true) Integer playersNumber,
            HttpServletRequest httpServletRequest) {

        //todo: adds redis to avoid repeating submit
        HttpSession session = httpServletRequest.getSession();

        session.getAttribute("test");
        String redisPunchKey = punchKey + uuid;
        Jedis jedis = new Jedis();
        if(null == jedis.get(redisPunchKey)) {
            jedis.setex(redisPunchKey, 10, Integer.toString(playersNumber));
        }else {
            return new ResponseEntity<>("This Spot has been punched within 10 sec, plz hold, or just update this Spot.", HttpStatus.ACCEPTED);
        }

        try {
            spotService.punchSpot(uuid, playersNumber);
        }catch (Exception validateException) {
            Arrays.stream(validateException.getStackTrace())
                    .filter(excp -> excp.getClassName().contains(this.getClass().getPackage().getName().substring(0,7)))
                    .forEach(excp -> log.error(excp.toString()));
            return new ResponseEntity<>("Punch wrongly, plz check the requested parameters. " + validateException.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="updatePlayers", method = RequestMethod.GET)
    public ResponseEntity updatePlayers(
            @RequestParam(value = "spotUuid", required = true) String uuid,
            @RequestParam(value = "playersNumber",required = true) Integer playersNumber) {

        try {
            spotService.punchSpot(uuid, playersNumber);
        }catch (Exception validateException) {
            Arrays.stream(validateException.getStackTrace())
                    .filter(excp -> excp.getClassName().contains(this.getClass().getPackage().getName().substring(0,7)))
                    .forEach(excp -> log.error(excp.toString()));
            return new ResponseEntity<>("Punch wrongly, plz check the requested parameters. " + validateException.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
