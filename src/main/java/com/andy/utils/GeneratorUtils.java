package com.andy.utils;

import java.util.UUID;

/**
 * @Author: Lim, Andy
 * @Date: 2020/10/29
 * @Proposal:
 */
public class GeneratorUtils {

    public static final UUID generateUUID() {

        UUID uuid = UUID.randomUUID();
        return uuid;
    }

    public static final String generateTempPassword() {


        return "pwd";
    }

}
