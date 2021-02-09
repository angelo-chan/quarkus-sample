package org.acme.sample.service;

import com.google.common.collect.Sets;
import org.acme.sample.exception.InvalidRoleException;
import org.acme.sample.object.Role;
import org.acme.sample.object.Type;
import org.apache.commons.collections.CollectionUtils;

import javax.annotation.Nullable;
import javax.enterprise.context.ApplicationScoped;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The checker will always check against realtime database entries
 */
@ApplicationScoped
public class Checker {

    /**
     * check roles
     *
     * @param roles roles
     * @param type  user type
     */
    public void checkRoles(@Nullable Set<String> roles, @NotNull Type type) {
        if (CollectionUtils.isEmpty(roles)) {
            return;
        }
        Set<String> filteredRoles = Role.ROLES.stream().filter(r -> r.getType() == type).map(Role::getRole).collect(Collectors.toSet());
        if (!Sets.difference(roles, filteredRoles).isEmpty()) {
            throw new InvalidRoleException();
        }
    }
}
