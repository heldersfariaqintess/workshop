package org.qintess.controller;

import org.qintess.dto.PlanoCompletoDTO;
import org.qintess.service.PlanoCompletoService;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

/**
 * USAR JPQL
 */
@Path("/v2/planos")
public class PlanoV2Controller {

    @Inject
    PlanoCompletoService planoCompletoService;

    @GET
    @Path("/")
    public List<PlanoCompletoDTO> findAll() {
        return planoCompletoService.findAllJpql();
    }

    @GET
    @Path("/{id}")
    public Optional<PlanoCompletoDTO> findById(@PathParam("id") Long id) {
        return Optional.empty();
    }

    @POST
    @Path("/")
    public PlanoCompletoDTO save(PlanoCompletoDTO plano) {
        return planoCompletoService.saveJpql(plano);
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
