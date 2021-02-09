package org.acme.sample.exception.base;

import static org.acme.sample.util.ErrorCodes.USER_NOT_FOUND;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        super(USER_NOT_FOUND, "User not found");
    }
}
