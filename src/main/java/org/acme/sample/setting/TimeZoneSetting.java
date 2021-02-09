package org.acme.sample.setting;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.TimeZone;

@ApplicationScoped
public class TimeZoneSetting {

    void onStart(@Observes StartupEvent event) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

}
