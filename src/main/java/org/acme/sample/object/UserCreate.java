package org.acme.sample.object;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class UserCreate {

    @Schema(defaultValue = "PLATFORM")
    Type type = Type.PLATFORM;

    @Schema(defaultValue = "ACTIVE")
    Status status = Status.ACTIVE;

    @NotBlank
    String username;

    @NotBlank
    @Size(min = 5, max = 32)
    String password;

    @NotBlank
    String realName;

    @NotNull
    Gender gender;

    Set<String> roles;

    Set<String> scopes;

    String phone;
}
