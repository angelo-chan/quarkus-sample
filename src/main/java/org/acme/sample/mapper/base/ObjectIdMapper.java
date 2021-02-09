package org.acme.sample.mapper.base;

import org.acme.sample.exception.base.InternalServerErrorException;
import org.bson.types.ObjectId;

public interface ObjectIdMapper {

    default String objectIdToString(ObjectId value) {
        if (value != null) {
            return value.toHexString();
        }
        return null;
    }

    default ObjectId stringToObjectId(String value) {
        if (value != null) {
            if (ObjectId.isValid(value)) {
                return new ObjectId(value);
            } else {
                throw new InternalServerErrorException("Invalid ObjectId");
            }
        }
        return null;
    }
}
