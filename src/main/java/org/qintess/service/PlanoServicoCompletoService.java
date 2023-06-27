package org.qintess.service;

import org.qintess.dto.PlanoServicoCompletoDTO;
import org.qintess.dto.PlanoServicoDTO;
import org.qintess.dto.ServicoDTO;
import org.qintess.entity.PlanoServico;
import org.qintess.mapper.PlanoServicoCompletoMapper;
import org.qintess.mapper.PlanoServicoMapper;
import org.qintess.repository.PlanoServicoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Transactional
@ApplicationScoped
public class PlanoServicoCompletoService {

    @Inject
    ServicoService servicoService;

    @Inject
    PlanoServicoRepository planoServicoRepository;

    @Inject
    PlanoServicoMapper planoServicoMapper;

    @Inject
    PlanoServicoCompletoMapper planoServicoCompletoMapper;

    public List<PlanoServicoCompletoDTO> findAllByIdsPlano(List<Long> ids) {

        List<PlanoServico> planoServicos = planoServicoRepository.findAllByIdPlanoJpql(ids);

        List<Long> idsServico = planoServicos.stream().map(PlanoServico::getIdServico).collect(toList());

        Map<Long, ServicoDTO> servicos = servicoService.findAllJpql(idsServico).stream().collect(Collectors.toMap(ServicoDTO::getId, Function.identity()));

        return planoServicos.stream().map(planoServicoCompletoMapper::toPlanoServicoCompleto)
                .peek(ps -> ps.setServico(servicos.get(ps.getIdServico())))
                .collect(toList());
    }

    public PlanoServicoDTO saveJpql(PlanoServicoCompletoDTO dto) {
        Optional<ServicoDTO> servicoDTOOptional = servicoService.findByCodigoJpql(dto.getServico().getCodigo());

        ServicoDTO servicoPersistido = servicoDTOOptional.orElseGet(() -> servicoService.saveJpql(dto.getServico()));

        PlanoServico entity = planoServicoMapper.toEntity(dto);

        entity.setIdServico(servicoPersistido.getId());
        dto.setServico(servicoPersistido);
        dto.setIdServico(servicoPersistido.getId());

        planoServicoRepository.saveJpql(entity);

        return dto;
    }
}
