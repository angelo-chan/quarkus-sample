package org.acme.sample;

import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeIn;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

import javax.ws.rs.core.Application;

import static org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType.HTTP;

@OpenAPIDefinition(
        info = @Info(
                title = "Sample API",
                version = "1.0",
                contact = @Contact(
                        name = "Sample API Support",
                        email = "chriswinniechen@gmail.com")
        ),
        components = @Components(
                securitySchemes = {
                        @SecurityScheme(
                                securitySchemeName = "Bearer",
                                type = HTTP,
                                description = "Enter JWT Bearer token **_only_**",
                                scheme = "bearer",
                                bearerFormat = "JWT",
                                in = SecuritySchemeIn.HEADER
                        ),
                        @SecurityScheme(
                                securitySchemeName = "BasicAuth",
                                type = HTTP,
                                scheme = "basic",
                                in = SecuritySchemeIn.HEADER
                        )
                }
        )
)
public class ApiApplication extends Application {
}
