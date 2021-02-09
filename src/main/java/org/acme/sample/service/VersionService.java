package org.acme.sample.service;

import org.acme.sample.object.Version;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ApplicationScoped
public class VersionService {

    private static final String UNKNOWN = "unknown";

    private static final String GIT_PROPERTIES = "git.properties";

    @ConfigProperty(name = "quarkus.application.name", defaultValue = UNKNOWN)
    String name;

    @ConfigProperty(name = "quarkus.application.version", defaultValue = UNKNOWN)
    String version;

    @ConfigProperty(name = "quarkus.profile", defaultValue = UNKNOWN)
    String profile;

    static Properties gitProperties = new Properties();

    static {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            cl = VersionService.class.getClassLoader();
        }
        InputStream is;
        if (cl == null) {
            is = ClassLoader.getSystemResourceAsStream(GIT_PROPERTIES);
        } else {
            is = cl.getResourceAsStream(GIT_PROPERTIES);
        }
        try {
            gitProperties.load(is);
        } catch (IOException e) {
            // ignore
        }
    }

    /**
     * Get version
     *
     * @return version
     */
    public Version getVersion() {
        return new Version(name, version, profile,
                gitProperties.getProperty("git.branch", UNKNOWN),
                gitProperties.getProperty("git.build.time", UNKNOWN),
                gitProperties.getProperty("git.commit.id.full", UNKNOWN));
    }
}
