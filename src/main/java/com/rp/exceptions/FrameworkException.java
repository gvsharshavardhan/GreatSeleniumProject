package com.rp.exceptions;

public class FrameworkException extends RuntimeException {

    public FrameworkException(String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
    }

    public FrameworkException(String exceptionMessage) {
        super(exceptionMessage);
    }
}