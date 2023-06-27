package org.qintess.service;

import org.qintess.dto.ServicoDTO;
import org.qintess.entity.Servico;
import org.qintess.mapper.ServicoMapper;
import org.qintess.repository.ServicoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class ServicoService {

    @Inject
    ServicoRepository servicoRepository;

    @Inject
    ServicoMapper servicoMapper;

    public List<ServicoDTO> findAllJpql() {
        return servicoRepository.findAllJpql().stream().map(servicoMapper::toDto).collect(Collectors.toList());
    }

    public Optional<ServicoDTO> findByCodigoJpql(String codigo) {
        return servicoRepository.findByCodigoJpql(codigo).map(servicoMapper::toDto);
    }

    public ServicoDTO saveJpql(ServicoDTO dto) {
        Servico entity = servicoMapper.toEntity(dto);
        entity = servicoRepository.saveJpql(entity);
        return servicoMapper.toDto(entity);
    }

    public List<ServicoDTO> findAllJpql(List<Long> idsServico) {
        return servicoRepository.findAllJpql(idsServico).stream().map(servicoMapper::toDto).collect(Collectors.toList());
    }
}
