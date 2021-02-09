package org.acme.sample.object.base;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.sample.util.ErrorCodes;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class ErrorEntity {

    String errorCode;

    String errorMessage;

    String devStackTrace;

    public ErrorEntity(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorEntity(String devStackTrace) {
        this.errorCode = ErrorCodes.INTERNAL_SERVER_ERROR;
        this.errorMessage = "Internal server error";
        this.devStackTrace = devStackTrace;
    }
}
