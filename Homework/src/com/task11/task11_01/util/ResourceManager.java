package com.task11.task11_01.util;

import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;

    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle("task11_01/message_en_UK");
    }

    public String getMessage(String key) {
        return resourceBundle.getString(key);
    }
}
