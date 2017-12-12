package com.eurasia.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yvettee on 2017/12/5.
 */
public class CustomDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String source) {
        //实现将日期串转成日期类型（yyyy-MM-dd HH:mm:ss）
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
