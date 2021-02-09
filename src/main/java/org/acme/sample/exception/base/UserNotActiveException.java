package org.acme.sample.exception.base;

import static org.acme.sample.util.ErrorCodes.USER_NOT_ACTIVE;

public class UserNotActiveException extends ConflictException {

    public UserNotActiveException() {
        super(USER_NOT_ACTIVE, "User not active");
    }
}
