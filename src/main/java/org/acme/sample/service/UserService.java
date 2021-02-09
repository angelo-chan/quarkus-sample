package org.acme.sample.service;

import com.mongodb.ErrorCategory;
import com.mongodb.MongoWriteException;
import org.acme.sample.exception.base.UserExistsException;
import org.acme.sample.mapper.UserMapper;
import org.acme.sample.model.User;
import org.acme.sample.object.UserCreate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;

@ApplicationScoped
public class UserService {

    @Inject
    UserMapper userMapper;

    @Inject
    Checker checker;

    /**
     * Create a user
     *
     * @param userCreate user create
     * @return user
     * @throws UserExistsException if user exists
     */
    public User create(UserCreate userCreate) {
        checker.checkRoles(userCreate.getRoles(), userCreate.getType());
        User user = userMapper.fromCreate(userCreate);
        try {
            user.persist();
        } catch (MongoWriteException e) {
            handleMongoWriteException(e);
        }
        return user;
    }

    /**
     * handle mongo write exception
     *
     * @param e exception
     * @throws UserExistsException if user exists
     */
    private void handleMongoWriteException(MongoWriteException e) {
        if (ErrorCategory.fromErrorCode(e.getCode()) == ErrorCategory.DUPLICATE_KEY) {
            throw new UserExistsException();
        }
        throw new InternalServerErrorException(e);
    }
}
