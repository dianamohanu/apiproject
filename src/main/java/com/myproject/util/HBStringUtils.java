package com.myproject.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class HBStringUtils {

    public static List<String> splitStringOnSymbol(String string, String symbol) {
        List<String> result = new ArrayList<>();

        if (!StringUtils.isEmpty(string) && !StringUtils.isEmpty(symbol)) {
            String[] results = string.split(symbol);
            for (int i = 0; i < results.length; i++) {
                result.add(results[i]);
            }
        }

        return result;
    }
}
