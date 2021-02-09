package org.acme.sample.exception.base;

import static org.acme.sample.util.ErrorCodes.FORBIDDEN;

public class ForbiddenException extends ServiceException {

    public ForbiddenException() {
        super(403, FORBIDDEN, "Forbidden");
    }

    protected ForbiddenException(String errorCode, String errorMessage) {
        super(403, errorCode, errorMessage);
    }
}
