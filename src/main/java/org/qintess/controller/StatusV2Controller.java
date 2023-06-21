package org.qintess.controller;

import org.qintess.dto.StatusDTO;
import org.qintess.service.StatusService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * USAR JPQL
 */
@Path("/v2/status")
public class StatusV2Controller {

    @Inject
    StatusService statusService;

    @GET
    @Path("/")
    public List<StatusDTO> findAllJpql() {
        return statusService.findAllJpql();
    }

    @GET
    @Path("/{id}")
    public Optional<StatusDTO> findById(@PathParam("id") Long id) {
        return Optional.empty();
    }
}
