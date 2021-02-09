package org.acme.sample.exception.base;

public abstract class ConflictException extends ServiceException {

    public ConflictException(String errorCode, String errorMessage) {
        super(409, errorCode, errorMessage);
    }
}
