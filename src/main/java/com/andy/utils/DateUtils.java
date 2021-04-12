package com.andy.utils;

import graphql.relay.ConnectionCursor;
import graphql.relay.DefaultConnectionCursor;
import org.springframework.stereotype.Component;
import sun.java2d.pipe.SpanShapeRenderer;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
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
