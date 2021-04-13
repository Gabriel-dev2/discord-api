package com.discord.api;

public class ApiException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
