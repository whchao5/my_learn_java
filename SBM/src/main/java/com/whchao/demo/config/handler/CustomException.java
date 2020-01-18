package com.whchao.demo.config.handler;

public class CustomException extends RuntimeException {

    private int code;

    public CustomException() {

    }

    public CustomException(int code, String message) {
        super(message);
        this.setCode(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
