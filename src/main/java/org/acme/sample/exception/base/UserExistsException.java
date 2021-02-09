package org.acme.sample.exception.base;

import static org.acme.sample.util.ErrorCodes.USER_EXISTS;

public class UserExistsException extends ConflictException {

    public UserExistsException() {
        super(USER_EXISTS, "User already exists");
    }
}
