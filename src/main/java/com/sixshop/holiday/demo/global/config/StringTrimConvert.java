package com.sixshop.holiday.demo.global.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class StringTrimConvert implements Converter<String, String> {

    @Override
    public String convert(String source) {
        if(StringUtils.isEmpty(source)) {
            return StringUtils.EMPTY;
        }
        return source.trim();
    }
}
