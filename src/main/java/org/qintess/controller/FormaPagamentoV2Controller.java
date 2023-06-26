package org.qintess.controller;

import org.qintess.dto.FormaPagamentoDTO;
import org.qintess.service.FormaPagamentoService;

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
@Path("/v2/formas-pagamento")
public class FormaPagamentoV2Controller {

    @Inject
    FormaPagamentoService formaPagamentoService;

    @GET
    @Path("/")
    public List<FormaPagamentoDTO> findAll() {
        return formaPagamentoService.findAllJpql();
    }

    @GET
    @Path("/{id}")
    public Optional<FormaPagamentoDTO> findById(@PathParam("id") Long id) {
        return Optional.empty();
    }

    @POST
    @Path("/")
    public FormaPagamentoDTO save(FormaPagamentoDTO formaPagamentoDTO) {
        return formaPagamentoDTO;
    }

    @PUT
    @Path("/{id}")
    public FormaPagamentoDTO update(@PathParam("id") Long id, FormaPagamentoDTO formaPagamentoDTO) {
        formaPagamentoDTO.setId(id);
        return formaPagamentoDTO;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
    }
}
