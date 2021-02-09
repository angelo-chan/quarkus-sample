package org.acme.sample.exception.base;

import static org.acme.sample.util.ErrorCodes.PASSWORD_NOT_MATCH;

public class PasswordNotMatchException extends BadRequestException {

    public PasswordNotMatchException() {
        super(PASSWORD_NOT_MATCH, "Password not match");
    }
}
