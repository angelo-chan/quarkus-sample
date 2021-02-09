package org.acme.sample.exception.base;

public abstract class NotFoundException extends ServiceException {

    public NotFoundException(String errorCode, String errorMessage) {
        super(404, errorCode, errorMessage);
    }
}
