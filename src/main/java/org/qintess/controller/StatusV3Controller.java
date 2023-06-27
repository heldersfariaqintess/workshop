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
 * USAR PANACHE FRAMEWORK
 */
@Path("/v3/status")
public class StatusV3Controller {

    @Inject
    StatusService statusService;

    @GET
    @Path("/")
    public List<StatusDTO> findAllPanache() {
        return statusService.findAllPanache();
    }

    @GET
    @Path("/{id}")
    public Optional<StatusDTO> findById(@PathParam("id") Long id) {
        return Optional.empty();
    }
}
