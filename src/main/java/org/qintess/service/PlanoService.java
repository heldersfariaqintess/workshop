package org.qintess.service;

import org.qintess.dto.PlanoDTO;
import org.qintess.entity.Plano;
import org.qintess.mapper.PlanoMapper;
import org.qintess.repository.PlanoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

@Transactional
@ApplicationScoped
public class PlanoService {

    @Inject
    PlanoRepository planoRepository;

    @Inject
    PlanoMapper planoMapper;

    public PlanoDTO saveJpql(@Valid PlanoDTO dto) {
        Plano entity = planoMapper.toEntity(dto);
        entity = planoRepository.saveJpql(entity);
        return planoMapper.toDto(entity);
    }
}
