package org.qintess.controller;

import org.qintess.dto.StatusDTO;
import org.qintess.service.StatusService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;


@Path("/v2/status")
public class StatusV2Controller {

    @Inject
    StatusService statusService;

    @GET
    @Path("/")
    public List<StatusDTO> findAllJpql() {
        return statusService.findAllJpql();
    }
}
