package org.acme.sample.exception.base;

public abstract class BadRequestException extends ServiceException {

    public BadRequestException(String errorCode, String errorMessage) {
        super(400, errorCode, errorMessage);
    }
}
