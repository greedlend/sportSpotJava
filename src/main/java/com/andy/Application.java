package com.andy;

import com.andy.model.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import redis.clients.jedis.Jedis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/26
 * @Proposal:
 */
@SpringBootApplication
public class Application {


    public static void main(String[] args) throws ParseException {
        int[] intArray = {1, 2, 3};
        Class clazz = intArray.getClass();
        System.out.println(clazz.getName()); // [I

        String orderStateStr = "10,20,30,15_11";
        List<String> listOfOrderState =
                Arrays.stream(orderStateStr.split(",")).filter(str -> str.contains("_")).collect(toList());


        int i = 0;


//        List<String> listOfStringCountry = listOfRuledCountry.stream().map(rc -> rc.getCountryCode()).collect(toList());

        int stop=0;


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

    private static String transformToGMTDiff(String sendLocalHour, String nowHour) {
        Integer sendLocalHourInt = Integer.valueOf(sendLocalHour) == 0 ? 24:Integer.valueOf(sendLocalHour);
        Integer nowHourInt = Integer.valueOf(nowHour) == 0 ? 24:Integer.valueOf(nowHour);

        Integer sum = sendLocalHourInt - nowHourInt;
        if(sum > 12) {
            sum = sum - 24;
        }else if (sum < -12) {
            sum = sum + 24;
        }

        return sum < 0 ? sum.toString() : "+" + sum.toString();
    }

    public static class SmsMarketNewRuleCountry {

        private Integer ruleId;

        private String countryCode;

        public Integer getRuleId() {
            return ruleId;
        }

        public void setRuleId(Integer ruleId) {
            this.ruleId = ruleId;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode == null ? null : countryCode.trim();
        }
    }
}
