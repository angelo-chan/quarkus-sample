package org.acme.sample.object;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

import static org.acme.sample.util.RoleConstants.SYSTEM;
import static org.acme.sample.util.RoleConstants.USER;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class Role {

    public static final Role ROLE_SYSTEM = new Role(Type.PLATFORM, SYSTEM, "System Admin");

    public static final Role ROLE_USER = new Role(Type.USER, USER, "User");

    public static final List<Role> ROLES = Arrays.asList(ROLE_SYSTEM, ROLE_USER);

    Type type;

    String role;

    String label;
}
