package org.acme.sample.util;

import io.quarkus.runtime.configuration.ProfileManager;
import lombok.Getter;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class StackTraceSupport {

    static final List<String> STACKTRACE_PROFILES = Arrays.asList("dev", "ci");

    @Getter
    boolean showStackTrace;

    @PostConstruct
    public void init() {
        if (STACKTRACE_PROFILES.contains(ProfileManager.getActiveProfile())) {
            showStackTrace = true;
        } else {
            showStackTrace = false;
        }
    }

    public String getStackTrace(Throwable throwable) {
        if (showStackTrace) {
            return ExceptionUtils.getStackTrace(throwable);
        }
        return null;
    }
}
