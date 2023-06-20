package org.qintess.controller;

import org.qintess.dto.StatusDTO;
import org.qintess.service.StatusService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;


@Path("/v1/status")
public class StatusController {

    @Inject
    StatusService statusService;

    @GET
    @Path("/")
    public List<StatusDTO> findAllNative() {
        return statusService.findAllNative();
    }
}
