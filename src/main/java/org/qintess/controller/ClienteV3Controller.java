package org.qintess.controller;

import org.qintess.dto.ClienteDTO;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * USAR PANACHE FRAMEWORK
 */
@Path("/v3/clientes")
public class ClienteV3Controller {

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

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
    }
}
