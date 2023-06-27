package org.qintess.controller;

import org.qintess.dto.StatusDTO;
import org.qintess.service.StatusService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

/**
 * USAR QUERY NATIVA
 */
@Path("/v1/status")
public class StatusController {

    @Inject
    StatusService statusService;

    @GET
    @Path("/")
    public List<StatusDTO> findAllNative() {
        return statusService.findAllNative();
    }

    @GET
    @Path("/{id}")
    public Optional<StatusDTO> findById(@PathParam("id") Long id) {
        return Optional.empty();
    }
}
