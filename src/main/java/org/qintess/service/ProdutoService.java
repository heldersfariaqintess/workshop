package org.qintess.service;

import org.qintess.dto.ProdutoDTO;
import org.qintess.entity.Produto;
import org.qintess.mapper.ProdutoMapper;
import org.qintess.repository.ProdutoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Transactional
@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoMapper produtoMapper;

    @Inject
    ProdutoRepository produtoRepository;

    public List<ProdutoDTO> findAllByIdJpql(List<Long> ids) {
        return produtoRepository.findAllJpql(ids).stream().map(produtoMapper::toDto).collect(toList());
    }

    public List<ProdutoDTO> findAllJpql() {
        return produtoRepository.findAllJpql().stream().map(produtoMapper::toDto).collect(toList());
    }

    public ProdutoDTO saveJpql(@Valid ProdutoDTO dto) {
        Produto entity = produtoMapper.toEntity(dto);
        entity = produtoRepository.saveJpql(entity);
        return produtoMapper.toDto(entity);
    }
}
