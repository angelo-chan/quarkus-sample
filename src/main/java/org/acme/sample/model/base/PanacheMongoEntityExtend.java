package org.acme.sample.model.base;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.Date;

@Getter
@Setter
public abstract class PanacheMongoEntityExtend extends PanacheMongoEntityBase {

    @BsonId
    public String id;

    Date createdAt = new Date();

    Date updatedAt = new Date();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "<" + id + ">";
    }

    public void save() {
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
