package org.acme.sample.migration;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import org.acme.sample.model.User;
import org.acme.sample.object.Gender;
import org.acme.sample.object.Role;
import org.acme.sample.object.Status;
import org.acme.sample.object.Type;
import org.bson.Document;

import java.util.Collections;

import static org.acme.sample.util.CollectionConstants.COLLECTION_USERS;

@SuppressWarnings("unused")
@ChangeLog(order = "001")
public class InitChangelog {

    @ChangeSet(order = "001", id = "add_username_index_to_users", author = "angelo")
    public void addUsernameIndexToUsers(MongoDatabase mongoDatabase) {
        MongoCollection userCollection = mongoDatabase.getCollection(COLLECTION_USERS);
        userCollection.createIndex(new Document("username", 1), new IndexOptions().unique(true));
    }

    @ChangeSet(order = "002", id = "add_system_user", author = "angelo")
    public void addSystemUser() {
        User admin = new User();
        admin.setType(Type.PLATFORM);
        admin.setStatus(Status.ACTIVE);
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRealName("SYSTEM ADMIN");
        admin.setRoles(Collections.singleton(Role.ROLE_SYSTEM.getRole()));
        admin.setScopes(Collections.singleton("*"));
        admin.setGender(Gender.M);
        admin.persist();
    }
}
