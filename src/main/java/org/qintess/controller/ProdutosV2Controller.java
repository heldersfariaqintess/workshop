package org.qintess.controller;

import org.qintess.dto.ProdutoDTO;
import org.qintess.service.ProdutoService;

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
@Path("/v2/produtos")
public class ProdutosV2Controller {

    @Inject
    ProdutoService produtoService;

    @GET
    @Path("/")
    public List<ProdutoDTO> findAll() {
        return produtoService.findAllJpql();
    }

    @GET
    @Path("/{id}")
    public Optional<ProdutoDTO> findById(@PathParam("id") Long id) {
        return Optional.empty();
    }

    @POST
    @Path("/")
    public ProdutoDTO save(ProdutoDTO dto) {
        return produtoService.saveJpql(dto);
    }

    @PUT
    @Path("/{id}")
    public ProdutoDTO update(@PathParam("id") Long id, ProdutoDTO produto) {
        produto.setId(id);
        return produto;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
    }
}
