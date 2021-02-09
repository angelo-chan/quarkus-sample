package org.acme.sample.setting;

import com.github.cloudyrock.mongock.driver.mongodb.sync.v4.driver.MongoSync4Driver;
import com.github.cloudyrock.standalone.MongockStandalone;
import com.mongodb.client.MongoClient;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class MigrationSetting {

    @Inject
    MongoClient mongoClient;

    @ConfigProperty(name = "quarkus.mongodb.database")
    String db;

    void onStart(@Observes StartupEvent event) {
        MongockStandalone.builder()
                .setDriver(MongoSync4Driver.withDefaultLock(mongoClient, db))
                                .addChangeLogsScanPackage("org.acme.sample.migration")
                                .buildRunner().execute();
    }
}
