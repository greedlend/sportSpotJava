package com.andy.utils;

/**
 * @Author: Lim, Andy
 * @Date: 2022/5/5
 * @Proposal:
 */
public class MathUtil {

    public static Double doThing(double a, double b) {

        Double aD = Double.valueOf(a);
        Double bD = Double.valueOf(b);
        return Double.valueOf(Math.abs(aD-bD));
    }
}
