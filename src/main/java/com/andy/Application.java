package com.andy;

import com.andy.model.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/26
 * @Proposal:
 */
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        int[] intArray = {1, 2, 3};
        Class clazz = intArray.getClass();
        System.out.println(clazz.getName()); // [I

        String courtryDiff = "+3";

        System.out.println(new Date());
//        TimeZone
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        System.out.println(sdf.format(new Date()));

//        List<Spot> list = new ArrayList<>();
//        int i = 0;
//        while(i<5) {
//            int a = i%2;
//            Spot spot = new Spot();
//            spot.setPlayersNumber(a);
//            spot.setAddress("ADR_" + i);
//            list.add(spot);
//            i++;
//        }
//        Map<Integer, IntSummaryStatistics> map =
//                list.stream().collect(Collectors.groupingBy(Spot::getPlayersNumber, Collectors.summarizingInt(Spot::getPlayersNumber)));
        /**
         * output: summary of this list object, such as "sum", "count"
         * */

//        Jedis jedis = new Jedis();
//
//        UUID uuid = UUID.randomUUID();
//        uuid.toString();
//        UUID uuid = UUID.fromString("5ew1ec5-qweq-qwe0-2134545fs");
//        jedis.hset
//        jedis.setnx();
//        jedis.unlink("key");
        SpringApplication.run(Application.class, args);
    }
}
