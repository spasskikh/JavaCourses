package com.task11.task11_02.exception;

public class UnExistItemMenu extends RuntimeException {

    public UnExistItemMenu(String message) {
        super(message);
    }
}
