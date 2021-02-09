package org.acme.sample.exception.base;

import static org.acme.sample.util.ErrorCodes.OPERATION_NOT_SUPPORTED;

public class OperationNotSupportedException extends BadRequestException {

    public OperationNotSupportedException() {
        super(OPERATION_NOT_SUPPORTED, "Operate not support");
    }
}
