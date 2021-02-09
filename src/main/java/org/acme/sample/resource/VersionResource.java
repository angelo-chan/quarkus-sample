package org.acme.sample.resource;

import org.acme.sample.service.VersionService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/q/version")
@Tag(name = "Misc")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VersionResource {

    @Inject
    VersionService versionService;

    @GET
    @Operation(summary = "get version", description = "get application version")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVersion() {
        return Response.status(Response.Status.OK).entity(versionService.getVersion())
                .type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
