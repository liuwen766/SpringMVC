package com.liuwen.converter;

import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class DateConverter implements Converter<String, Date> {
    private String pattern;
    public DateConverter(String pattern){
        this.pattern = pattern;
    }
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new
                SimpleDateFormat(this.pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
