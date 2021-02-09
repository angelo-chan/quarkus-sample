package org.acme.sample.object;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@RegisterForReflection
public class UserInfo {

    String id;

    Type type;

    Status status;

    String username;

    String realName;

    Gender gender;

    Set<String> roles;

    Set<String> scopes;

    String phone;

    @Schema(format = "date-time")
    Date createdAt;

    @Schema(format = "date-time")
    Date updatedAt;
}
