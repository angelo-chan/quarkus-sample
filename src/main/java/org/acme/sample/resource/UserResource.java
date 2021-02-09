package org.acme.sample.resource;

import org.acme.sample.mapper.UserMapper;
import org.acme.sample.object.UserCreate;
import org.acme.sample.object.UserInfo;
import org.acme.sample.object.base.ErrorEntity;
import org.acme.sample.object.base.ValidationErrorEntity;
import org.acme.sample.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.acme.sample.util.RoleConstants.SYSTEM;

@Path("/users")
@Tag(name = "User")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserMapper userMapper;

    @Inject
    UserService userService;

    @Operation(summary = "[SYSTEM] - Create a user", description = "Create a user.<br>" +
            "<i>Required roles</i>: <b>SYSTEM</b>")
    @APIResponses({
            @APIResponse(responseCode = "201", description = "success", content = @Content(schema = @Schema(implementation = UserInfo.class))),
            @APIResponse(responseCode = "422", description = "校验错误", content = @Content(schema = @Schema(implementation = ValidationErrorEntity.class))),
            @APIResponse(responseCode = "409", content = @Content(schema = @Schema(implementation = ErrorEntity.class)),
                    description = "<table><tr><td><b>ErrorCode</b></td><td><b>ErrorMessage</b></td></tr>" +
                            "<tr><td>01701</td><td>User already exists</td></tr>" +
                            "</table>")
    })
    @POST
    @SecurityRequirement(name = "Bearer")
    @RolesAllowed({SYSTEM})
    public Response create(@NotNull @Valid UserCreate userCreate) {
        return Response.status(Response.Status.CREATED).entity(userMapper.toInfo(userService.create(userCreate))).build();
    }
}
