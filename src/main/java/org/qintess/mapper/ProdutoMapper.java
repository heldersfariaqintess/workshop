package org.qintess.mapper;


import org.mapstruct.Mapper;
import org.qintess.dto.ProdutoDTO;
import org.qintess.entity.Produto;


@Mapper(componentModel = "cdi")
public interface ProdutoMapper extends EntityMapper<ProdutoDTO, Produto> {

}
