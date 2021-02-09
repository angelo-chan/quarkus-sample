package org.acme.sample.exception.base;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    int httpStatus;

    String errorCode;

    String errorMessage;

    @Override
    public String getMessage() {
        return this.errorMessage;
    }

    protected ServiceException(int httpStatus, String errorCode, String errorMessage) {
        super();
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    protected ServiceException(int httpStatus, String errorCode, String errorMessage, Throwable cause) {
        super(cause);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
