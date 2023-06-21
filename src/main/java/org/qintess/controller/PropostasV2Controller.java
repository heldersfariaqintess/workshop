package org.qintess.controller;

import org.qintess.dto.FiltroProposta;
import org.qintess.dto.PropostaCompletaDTO;
import org.qintess.dto.PropostaResumida;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * USAR JPQL
 */
@Path("/v1/propostas")
public class PropostasV2Controller {

    @GET
    @Path("/")
    public List<PropostaCompletaDTO> findAll(@QueryParam("idCliente") Long idCliente,
                                             @QueryParam("idPlano") Long idPlano,
                                             @QueryParam("idFormaPagamento") Long idFormaPagamento,
                                             @QueryParam("diaVencimento") Integer diaVencimento) {
        return Collections.emptyList();
    }

    @GET
    @Path("/{id}")
    public Optional<PropostaCompletaDTO> findById(@PathParam("id") Long id) {
        return Optional.empty();
    }

    @POST
    @Path("/")
    public PropostaCompletaDTO save(PropostaCompletaDTO proposta) {
        // AQUI A PROPOSTA PRECISARÁ SALVAR O CLIENTE
        return proposta;
    }

    @PUT
    @Path("/{id}")
    public PropostaCompletaDTO update(@PathParam("id") Long id, PropostaCompletaDTO proposta) {
        // AQUI A PROPOSTA PODE ATUALIZAR O CLIENTE
        proposta.setId(id);
        return proposta;
    }

    @POST
    @Path("/")
    public List<PropostaResumida> filtro(FiltroProposta filtroProposta) {
        return Collections.emptyList();
    }


    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
    }
}
