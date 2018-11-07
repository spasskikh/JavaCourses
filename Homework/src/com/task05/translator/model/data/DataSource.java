package com.task05.translator.model.data;

import java.util.HashMap;
import java.util.Map;

public class DataSource {

    public static Map<String, String> get() {
        Map<String, String> map = new HashMap<>();
        map.put("this","это");
        map.put("is","есть");
        map.put("red","красный");
        map.put("table","стол");
        return map;
    }
}
