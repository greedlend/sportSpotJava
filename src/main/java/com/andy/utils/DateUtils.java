package com.andy.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtils {

    private static SimpleDateFormat getSdf(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(format);
        return sdf;
    }

    public static Date strToDate(String dateString, String format) throws ParseException {
        SimpleDateFormat sdf = getSdf(format);
        Date result = sdf.parse(dateString);
        return result;
    }

    public static String dateToStr(Date date, String format) {
        SimpleDateFormat sdf = getSdf(format);
        String result = sdf.format(date);
        return result;
    }
}
