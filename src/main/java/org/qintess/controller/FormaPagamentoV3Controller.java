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
 * USAR PANACHE FRAMEWORK
 */
@Path("/v3/formas-pagamento")
public class FormaPagamentoV3Controller {

    @Inject
    FormaPagamentoService formaPagamentoService;

    @GET
    @Path("/")
    public List<FormaPagamentoDTO> findAll(@QueryParam("nome") String nome) {
        return formaPagamentoService.findAllPanache(nome);
    }

    @GET
    @Path("/{id}")
    public Optional<FormaPagamentoDTO> findById(@PathParam("id") Long id) {
        return formaPagamentoService.findByIdPanache(id);
    }

    @POST
    @Path("/")
    public FormaPagamentoDTO save(FormaPagamentoDTO dto) {
        return formaPagamentoService.savePanache(dto);
    }

    @PUT
    @Path("/{id}")
    public FormaPagamentoDTO update(@PathParam("id") Long id, FormaPagamentoDTO dto) {
        dto.setId(id);
        return formaPagamentoService.updatePanache(dto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        formaPagamentoService.deletePanache(id);
    }
}
