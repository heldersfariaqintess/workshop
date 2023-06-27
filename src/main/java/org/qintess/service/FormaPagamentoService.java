package org.qintess.service;

import org.qintess.commons.exception.NotFoundQintessException;
import org.qintess.dto.FormaPagamentoDTO;
import org.qintess.entity.FormaPagamento;
import org.qintess.mapper.FormaPagamentoMapper;
import org.qintess.repository.FormaPagamentoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Transactional
@ApplicationScoped
public class FormaPagamentoService {

    @Inject
    FormaPagamentoRepository repository;

    @Inject
    FormaPagamentoMapper formaPagamentoMapper;

    // Native QUERY
    public List<FormaPagamentoDTO> findAllNative(String nome) {
        return repository.findAllNative(nome)
                .stream()
                .map(formaPagamentoMapper::toDto)
                .collect(toList());
    }

    public Optional<FormaPagamentoDTO> findByIdNative(Long id) {
        if (id == null) {
            return Optional.empty();
        }

        return repository.findByIdNative(id).map(formaPagamentoMapper::toDto);
    }

    public FormaPagamentoDTO saveNative(@Valid FormaPagamentoDTO formaPagamentoDTO) {
        FormaPagamento entity = formaPagamentoMapper.toEntity(formaPagamentoDTO);
        entity = repository.saveNative(entity);
        return formaPagamentoMapper.toDto(entity);
    }

    public FormaPagamentoDTO updateNative(@Valid FormaPagamentoDTO dto) {

        Optional<FormaPagamento> formaPagamentoBanco = repository.findByIdNative(dto.getId());

        if (formaPagamentoBanco.isEmpty()) {
            throw new NotFoundQintessException("Forma Pagamento não encontrada.");
        }

        FormaPagamento entity = formaPagamentoBanco.get();

        entity.setNome(dto.getNome());

        entity = repository.updateNative(entity);

        return formaPagamentoMapper.toDto(entity);
    }

    public void deleteNative(Long id) {
        Optional<FormaPagamento> formaPagamentoBanco = repository.findByIdNative(id);

        if (formaPagamentoBanco.isEmpty()) {
            throw new NotFoundQintessException("Forma Pagamento não encontrada.");
        }

        repository.deleteNative(id);
    }

    //JPQL e HQL
    public List<FormaPagamentoDTO> findAllJpql(String nome) {
        return repository.findAllJpql(nome).stream().map(formaPagamentoMapper::toDto).collect(toList());
    }

    public Optional<FormaPagamentoDTO> findByIdJpql(Long id) {
        return repository.findByIdJpql(id).map(formaPagamentoMapper::toDto);
    }

    public FormaPagamentoDTO saveJqpl(@Valid FormaPagamentoDTO formaPagamentoDTO) {
        FormaPagamento entity = formaPagamentoMapper.toEntity(formaPagamentoDTO);
        entity = repository.saveJpql(entity);
        return formaPagamentoMapper.toDto(entity);
    }

    public FormaPagamentoDTO updateJpql(@Valid FormaPagamentoDTO dto) {

        Optional<FormaPagamento> formaPagamentoBanco = repository.findByIdJpql(dto.getId());

        if (formaPagamentoBanco.isEmpty()) {
            throw new NotFoundQintessException("Forma Pagamento não encontrada.");
        }

        FormaPagamento entity = formaPagamentoBanco.get();

        entity.setNome(dto.getNome());

        entity = repository.updateJpql(entity);

        return formaPagamentoMapper.toDto(entity);
    }

    public void deleteJqpl(Long id) {
        Optional<FormaPagamento> formaPagamentoBanco = repository.findByIdJpql(id);

        if (formaPagamentoBanco.isEmpty()) {
            throw new NotFoundQintessException("Forma Pagamento não encontrada.");
        }
        repository.deleteJpql(id);
    }

    //USANDO FRAMEWORK PANACHE
    public List<FormaPagamentoDTO> findAllPanache(String nome) {
        return repository.findAll(nome).stream().map(formaPagamentoMapper::toDto).collect(toList());
    }

    public Optional<FormaPagamentoDTO> findByIdPanache(Long id) {
        if (id == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(repository.findById(id))
                .map(formaPagamentoMapper::toDto);
    }

    public FormaPagamentoDTO updatePanache(@Valid FormaPagamentoDTO dto) {
        repository.update(formaPagamentoMapper.toEntity(dto));
        return dto;
    }

    public FormaPagamentoDTO savePanache(@Valid FormaPagamentoDTO dto) {
        FormaPagamento entity = formaPagamentoMapper.toEntity(dto);
        repository.persist(entity);
        return formaPagamentoMapper.toDto(entity);
    }

    public void deletePanache(Long id) {
        FormaPagamento formaPagamentoBanco = repository.findById(id);

        if (formaPagamentoBanco == null) {
            throw new NotFoundQintessException("Forma Pagamento não encontrada.");
        }

        repository.deleteById(id);
    }
}
