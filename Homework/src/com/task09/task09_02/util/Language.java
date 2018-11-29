package com.task09.task09_02.util;

import java.util.Locale;

public enum Language {
    ENG(new Locale("en", "UK")),
    RUS(new Locale("ru", "RU")),
    UA(new Locale("uk", "UA"));

    private Locale locale;
    private Language(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }
}
