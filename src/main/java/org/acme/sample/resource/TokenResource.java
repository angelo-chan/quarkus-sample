package org.acme.sample.resource;

import org.acme.sample.exception.base.PasswordNotMatchException;
import org.acme.sample.exception.base.UserNotActiveException;
import org.acme.sample.exception.base.UserNotFoundException;
import org.acme.sample.model.User;
import org.acme.sample.object.Status;
import org.acme.sample.object.Token;
import org.acme.sample.object.TokenRequest;
import org.acme.sample.object.base.ErrorEntity;
import org.acme.sample.object.base.ValidationErrorEntity;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/token")
@Tag(name = "Token")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TokenResource {

    @ConfigProperty(name = "smallrye.jwt.new-token.lifespan", defaultValue = "300")
    long lifeSpan;

    @Operation(summary = "[ANONYMOUS] - get a token", description = "get a token.<br>")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "success", content = @Content(schema = @Schema(implementation = Token.class))),
            @APIResponse(responseCode = "422", description = "校验错误", content = @Content(schema = @Schema(implementation = ValidationErrorEntity.class))),
            @APIResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorEntity.class)),
                    description = "<table><tr><td><b>ErrorCode</b></td><td><b>ErrorMessage</b></td></tr>" +
                            "<tr><td>01400</td><td>User not found</td></tr>" +
                            "</table>"),
            @APIResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ErrorEntity.class)),
                    description = "<table><tr><td><b>ErrorCode</b></td><td><b>ErrorMessage</b></td></tr>" +
                            "<tr><td>01100</td><td>Password not match</td></tr>" +
                            "</table>"),
            @APIResponse(responseCode = "409", content = @Content(schema = @Schema(implementation = ErrorEntity.class)),
                    description = "<table><tr><td><b>ErrorCode</b></td><td><b>ErrorMessage</b></td></tr>" +
                            "<tr><td>01700</td><td>User not active</td></tr>" +
                            "</table>")
    })
    @POST
    public Token token(@NotNull @Valid TokenRequest tokenRequest) {
        User user = User.findByUsername(tokenRequest.getUsername());
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (user.getStatus() != Status.ACTIVE) {
            throw new UserNotActiveException();
        }
        if (user.verifyPassword(tokenRequest.getPassword())) {
            return new Token(user.sign(), lifeSpan);
        } else {
            throw new PasswordNotMatchException();
        }
    }
}
