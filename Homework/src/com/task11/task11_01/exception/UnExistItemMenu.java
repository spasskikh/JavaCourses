package com.task11.task11_01.exception;

public class UnExistItemMenu extends RuntimeException {

    public UnExistItemMenu(String message) {
        super(message);
    }
}
