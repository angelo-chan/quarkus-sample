package org.acme.sample.exception;


import org.acme.sample.exception.base.BadRequestException;

import static org.acme.sample.util.ErrorCodes.INVALID_ROLE;

public class InvalidRoleException extends BadRequestException {

    public InvalidRoleException() {
        super(INVALID_ROLE, "Invalid role");
    }
}
