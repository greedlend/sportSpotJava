package com.andy;

//import com.andy.model.Spot;
//import org.apache.commons.codec.digest.DigestUtils;

import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
//import org.apache.commons.

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


        String dateStr = "2021-11-04";
        String timeStr = "22:00";
        SimpleDateFormat sdf = new SimpleDateFormat();
//        sdf.setTimeZone(TimeZone.getTimeZone("CST"));
        sdf.applyPattern("yyyy-MM-ddHH:mm");

        Date date = sdf.parse(dateStr+timeStr);


        Calendar cal = Calendar.getInstance();
//        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
        cal.setTime(date);



        SimpleDateFormat sdf2 = new SimpleDateFormat();
        sdf2.applyPattern("yyyy-MM-ddHH:mm");
        sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));

        String saa = sdf2.format(date);

        int a =1;
//        String salt = "a1ee3a0fa9ea4365cdbc8790276c6a956bb7023a";
//        String password = "ZWUN9389";
//        String name = "Ryuzaki.Chang";
//
//        String sha512Password = DigestUtils.sha512Hex(salt+password+ name);
//        List<String> listOfStringCountry = listOfRuledCountry.stream().map(rc -> rc.getCountryCode()).collect(toList());

//        int a = NameUtils.printInt();
        Map<String, String> map =new HashMap<>();
        map.put("signName", "VanFx");
        map.put("userName", "Ann");
        String aa = "Salute, ${signName} provide you a better price，hope ${userName} would evaluate it.";

        String regStr = "(\\$\\{\\w*\\})";
        for (String key: map.keySet()) {
            String ak = "\\$\\{("+ key + ")\\}";
            aa = aa.replaceAll(regStr, map.get(key));
        }



        int stop=0;



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
