package util;

import java.util.regex.Pattern;

public class Validator {

    public static Pattern sentence = Pattern.compile("[^.!?]*[.!?]");
    public static Pattern word = Pattern.compile(
                    "[A-z]+[-]?[\\w]*|" +
                    "(([1-9][0-9]*)|0)"
    );
    public static Pattern symbol = Pattern.compile(
            "[+*.,<>?|/'\";:{}()~`!@#$%^&_=\\s]+"

    );

}
