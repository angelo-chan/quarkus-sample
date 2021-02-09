package org.acme.sample.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.mongodb.panache.MongoEntity;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import lombok.Getter;
import lombok.Setter;
import org.acme.sample.model.base.PanacheMongoEntityDefault;
import org.acme.sample.object.Gender;
import org.acme.sample.object.Status;
import org.acme.sample.object.Type;
import org.apache.commons.lang3.StringUtils;
import org.wildfly.security.credential.PasswordCredential;
import org.wildfly.security.evidence.PasswordGuessEvidence;
import org.wildfly.security.password.util.ModularCrypt;

import javax.annotation.Nonnull;
import java.security.spec.InvalidKeySpecException;
import java.util.Set;

import static org.acme.sample.util.CollectionConstants.COLLECTION_USERS;

@Getter
@Setter
@MongoEntity(collection = COLLECTION_USERS)
public class User extends PanacheMongoEntityDefault {

    Type type = Type.PLATFORM;

    Status status = Status.ACTIVE;

    String username;

    String password;

    String realName;

    Gender gender;

    Set<String> roles;

    Set<String> scopes;

    String phone;

    public String sign() {
        JwtClaimsBuilder builder = Jwt.claims().subject(id.toString())
                .claim("type", type)
                .claim("username", username)
                .claim("realName", realName);
        if (roles != null) {
            builder.groups(roles);
        }
        if (scopes != null) {
            builder.claim("scopes", scopes);
        }
        return builder.sign();
    }

    public void persist() {
        hashPassword();
        super.persist();
    }

    public void update() {
        hashPassword();
        super.update();
    }

    /**
     * persist or update
     */
    public void persistOrUpdate() {
        hashPassword();
        super.persistOrUpdate();
    }

    public static User findByUsername(String username) {
        return find("username", username).firstResult();
    }

    /**
     * Hash password
     */
    public void hashPassword() {
        if (StringUtils.isEmpty(password) || StringUtils.startsWith(password, "$2a$")) {
            return;
        }
        this.password = BcryptUtil.bcryptHash(password);
    }

    /**
     * Verify password
     *
     * @param rawPassword raw password
     * @return passed or not
     */
    public boolean verifyPassword(@Nonnull String rawPassword) {
        try {
            PasswordCredential passwordCredential = new PasswordCredential(ModularCrypt.decode(this.password));
            return passwordCredential.verify(new PasswordGuessEvidence(rawPassword.toCharArray()));
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
