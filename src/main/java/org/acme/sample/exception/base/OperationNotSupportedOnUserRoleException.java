package org.acme.sample.exception.base;

import static org.acme.sample.util.ErrorCodes.OPERATION_NOT_SUPPORTED_ON_USER_ROLE;

public class OperationNotSupportedOnUserRoleException extends BadRequestException {

    public OperationNotSupportedOnUserRoleException() {
        super(OPERATION_NOT_SUPPORTED_ON_USER_ROLE, "Operate not support on user role");
    }
}
