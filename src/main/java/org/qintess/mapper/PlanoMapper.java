package org.qintess.mapper;


import org.mapstruct.Mapper;
import org.qintess.dto.PlanoDTO;
import org.qintess.entity.Plano;


@Mapper(componentModel = "cdi")
public interface PlanoMapper extends EntityMapper<PlanoDTO, Plano> {
}
