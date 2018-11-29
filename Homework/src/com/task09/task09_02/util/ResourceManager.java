package com.task09.task09_02.util;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;

    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle("task09_02/properties/message",
                new Locale("en", "UK"));
    }

    public void changeLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("task09_02/properties/message", locale);
    }

    public String getMessage(String key) {
        return resourceBundle.getString(key);
    }
}
