package org.acme.sample.util;

public interface ErrorCodes {

    // CORE

    String INTERNAL_SERVER_ERROR = "00500";

    String BAD_REQUEST = "00400";

    String FORBIDDEN = "00403";

    String VALIDATION_ERROR = "00422";

    String PASSWORD_NOT_MATCH = "01100";

    String USER_NOT_ACTIVE = "01700";

    String USER_EXISTS = "01701";

    String USER_NOT_FOUND = "01400";

    String OPERATION_NOT_SUPPORTED = "01401";

    String OPERATION_NOT_SUPPORTED_ON_USER_ROLE = "01402";

    // BUSINESS

}
