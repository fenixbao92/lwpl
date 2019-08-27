package com.fenixbao92.lwpl.common.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    @Override
    public Date convert(String s) {
        if ("".equals(s) || s == null) {
            return null;
        }
//        System.out.println(s);
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        return null;
    }
}