package org.acme.sample.model.base;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Extension for reactive mongo entity.
 * <p>
 * modify persistOrUpdate/update method to populate the updatedAt.
 */
@Getter
@Setter
public abstract class PanacheMongoEntityDefault extends PanacheMongoEntity {

    Date createdAt = new Date();

    Date updatedAt = new Date();

    public void persistOrUpdate() {
        if (id != null) {
            updatedAt = new Date();
        }
        super.persistOrUpdate();
    }

    public void update() {
        updatedAt = new Date();
        super.update();
    }
}
