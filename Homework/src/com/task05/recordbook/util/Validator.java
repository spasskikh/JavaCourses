package com.task05.recordbook.util;

import java.util.regex.Pattern;

public class Validator {

    public static Pattern name = Pattern.compile("[A-Z][a-z]*");
    public static Pattern phone = Pattern.compile("\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}");

}
