package org.acme.sample.object;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenRequest {

    @NotBlank
    String username;

    @NotBlank
    String password;
}
