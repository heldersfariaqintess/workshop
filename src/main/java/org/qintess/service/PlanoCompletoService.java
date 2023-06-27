package org.qintess.service;

import org.qintess.dto.PlanoCompletoDTO;
import org.qintess.dto.PlanoDTO;
import org.qintess.dto.PlanoServicoCompletoDTO;
import org.qintess.dto.ProdutoDTO;
import org.qintess.mapper.PlanoCompletoMapper;
import org.qintess.repository.PlanoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Transactional
@ApplicationScoped
public class PlanoCompletoService {

    @Inject
    PlanoRepository planoRepository;

    @Inject
    PlanoService planoService;

    @Inject
    PlanoCompletoMapper planoCompletoMapper;

    @Inject
    ProdutoService produtoService;

    @Inject
    PlanoServicoCompletoService planoServicoCompletoService;

    public List<PlanoCompletoDTO> findAllJpql() {

        List<PlanoCompletoDTO> planos = planoRepository.findAllJpql().stream()
                .map(planoCompletoMapper::toPlanoCompleto)
                .collect(toList());

        if (!planos.isEmpty()) {

            List<Long> ids = planos.stream()
                    .map(PlanoCompletoDTO::getId)
                    .collect(toList());

            Map<Long, ProdutoDTO> mapProdutos = produtoService.findAllByIdJpql(ids).stream()
                    .collect(toMap(ProdutoDTO::getId, identity()));

            List<PlanoServicoCompletoDTO> servicos = planoServicoCompletoService.findAllByIdsPlano(ids);

            planos.forEach(p -> {
                p.setProduto(mapProdutos.get(p.getIdProduto()));
                p.setServicos(servicos.stream().filter(ps -> ps.getIdPlano().equals(p.getId())).collect(toList()));
            });
        }

        return planos;
    }

    public PlanoCompletoDTO saveJpql(@Valid PlanoCompletoDTO planoCompleto) {
        PlanoDTO planoDTO = planoService.saveJpql(planoCompleto);
        planoCompleto.setId(planoDTO.getId());

        List<PlanoServicoCompletoDTO> servicos = planoCompleto.getServicos();

        if (servicos != null && !servicos.isEmpty()) {
            servicos.forEach(planoServico -> {
                planoServico.setIdPlano(planoDTO.getId());
                planoServicoCompletoService.saveJpql(planoServico);
            });
        }
        return planoCompleto;
    }
}
