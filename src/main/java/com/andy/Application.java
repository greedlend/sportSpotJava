package com.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

import java.util.UUID;

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
        Jedis jedis = new Jedis();
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
