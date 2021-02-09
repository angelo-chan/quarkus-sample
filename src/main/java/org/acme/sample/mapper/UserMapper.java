package org.acme.sample.mapper;

import org.acme.sample.mapper.base.ObjectIdMapper;
import org.acme.sample.model.User;
import org.acme.sample.object.UserCreate;
import org.acme.sample.object.UserInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper extends ObjectIdMapper {

    User fromCreate(UserCreate userCreate);

    UserInfo toInfo(User user);
}
