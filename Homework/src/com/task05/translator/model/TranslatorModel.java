package com.task05.translator.model;

import com.task05.translator.model.data.DataSource;

import java.util.HashMap;
import java.util.Map;

public class TranslatorModel {

    private Map<String, String> dictionary;

    public TranslatorModel() {
        dictionary = new HashMap<>();
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void init() {
        dictionary.putAll(DataSource.get());
    }

    public void add(String key, String value) {
        dictionary.put(key, value);
    }
}
