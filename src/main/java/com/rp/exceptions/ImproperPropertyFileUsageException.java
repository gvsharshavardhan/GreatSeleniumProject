package com.rp.exceptions;

public class ImproperPropertyFileUsageException extends FrameworkException{

    public ImproperPropertyFileUsageException(String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
    }
    public ImproperPropertyFileUsageException(String exceptionMessage) {
        super(exceptionMessage);
    }
}