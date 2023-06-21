package org.qintess.controller;

import org.qintess.dto.PlanoCompletoDTO;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * USAR QUERY NATIVA
 */
@Path("/v1/planos")
public class PlanoController {

    @GET
    @Path("/")
    public List<PlanoCompletoDTO> findAll() {
        return Collections.emptyList();
    }

    @GET
    @Path("/{id}")
    public Optional<PlanoCompletoDTO> findById(@PathParam("id") Long id) {
        return Optional.empty();
    }

    @POST
    @Path("/")
    public PlanoCompletoDTO save(PlanoCompletoDTO plano) {
        return plano;
    }

    @PUT
    @Path("/{id}")
    public PlanoCompletoDTO update(@PathParam("id") Long id, PlanoCompletoDTO plano) {
        plano.setId(id);
        return plano;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
    }
}
