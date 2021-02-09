package org.acme.sample.exception.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import static org.acme.sample.util.ErrorCodes.INTERNAL_SERVER_ERROR;

public class InternalServerErrorException extends ServiceException {

    private Throwable throwable;

    private String stackTrace;

    public InternalServerErrorException() {
        super(500, INTERNAL_SERVER_ERROR, "Internal server error");
    }

    public InternalServerErrorException(Throwable throwable) {
        super(500, INTERNAL_SERVER_ERROR, "Internal server error", throwable);
        this.throwable = throwable;
    }

    public InternalServerErrorException(String stackTrace) {
        super(500, INTERNAL_SERVER_ERROR, "Internal server error");
        this.stackTrace = stackTrace;
    }

    public String getStackTraceString() {
        if (StringUtils.isEmpty(stackTrace) && throwable != null) {
            stackTrace = ExceptionUtils.getStackTrace(throwable);
        }
        return stackTrace;
    }
}
