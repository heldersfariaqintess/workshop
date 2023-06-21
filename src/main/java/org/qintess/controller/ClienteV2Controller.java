package org.qintess.controller;

import org.qintess.dto.ClienteDTO;
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
@Path("/v2/clientes")
public class ClienteV2Controller {

    @GET
    @Path("/")
    public List<ClienteDTO> findAll() {
        return Collections.emptyList();
    }

    @GET
    @Path("/{id}")
    public Optional<ClienteDTO> findById(@PathParam("id") Long id) {
        return Optional.empty();
    }
}
