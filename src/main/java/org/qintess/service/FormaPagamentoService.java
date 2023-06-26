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

    //JPQL

    public List<FormaPagamentoDTO> findAllJpql() {
        return repository.findAllJpql().stream().map(formaPagamentoMapper::toDto).collect(toList());
    }


    public List<FormaPagamentoDTO> findAllPanache() {
        return repository.findAll().stream().map(formaPagamentoMapper::toDto).collect(toList());
    }

    //USANDO FRAMEWORK PANACHE

    public List<FormaPagamentoDTO> findAll() {
        return repository.findAll().stream().map(this.formaPagamentoMapper::toDto).collect(toList());
    }
}
