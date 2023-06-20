package org.qintess.controller;

import org.qintess.dto.StatusDTO;
import org.qintess.service.StatusService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;


@Path("/v3/status")
public class StatusV3Controller {

    @Inject
    StatusService statusService;

    @GET
    @Path("/")
    public List<StatusDTO> findAllPanache() {
        return statusService.findAllPanache();
    }
}
