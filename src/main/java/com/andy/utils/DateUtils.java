package com.andy.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtils {

    private SimpleDateFormat getSdf(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(format);
        return sdf;
    }

    public Date strToDate(String dateString, String format) throws ParseException {
        SimpleDateFormat sdf = getSdf(format);
        Date result = sdf.parse(dateString);
        return result;
    }

    public String dateToStr(Date date, String format) {
        SimpleDateFormat sdf = getSdf(format);
        String result = sdf.format(date);
        return result;
    }
}
