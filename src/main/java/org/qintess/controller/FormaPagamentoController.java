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
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;

/**
 * USAR QUERY NATIVA
 */
@Path("/v1/formas-pagamento")
public class FormaPagamentoController {

    @Inject
    FormaPagamentoService formaPagamentoService;

    @GET
    @Path("/")
    public List<FormaPagamentoDTO> findAll(@QueryParam( "nome") String nome) {
        return formaPagamentoService.findAllNative(nome);
    }

    @GET
    @Path("/{id}")
    public Optional<FormaPagamentoDTO> findById(@PathParam("id") Long id) {
        return formaPagamentoService.findByIdNative(id);
    }

    @POST
    @Path("/")
    public FormaPagamentoDTO save(FormaPagamentoDTO formaPagamentoDTO) {
        return formaPagamentoService.saveNative(formaPagamentoDTO);
    }

    @PUT
    @Path("/{id}")
    public FormaPagamentoDTO update(@PathParam("id") Long id, FormaPagamentoDTO formaPagamentoDTO) {
        formaPagamentoDTO.setId(id);
        return formaPagamentoService.updateNative(formaPagamentoDTO);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        formaPagamentoService.deleteNative(id);
    }
}
