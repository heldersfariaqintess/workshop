package org.qintess.service;

import org.qintess.dto.StatusDTO;
import org.qintess.mapper.StatusMapper;
import org.qintess.repository.StatusRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class StatusService {

    @Inject
    StatusRepository repository;

    @Inject
    StatusMapper statusMapper;

    @Transactional
    public List<StatusDTO> findAllPanache(){
        return repository.findAll().stream().map(statusMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<StatusDTO> findAllNative(){
        return repository.findAllNative().stream().map(statusMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<StatusDTO> findAllJpql() {
        return repository.findAllJpql().stream().map(statusMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<StatusDTO> findAll() {
        return repository.findAll().stream().map(this.statusMapper::toDto).collect(Collectors.toList());
    }
}
