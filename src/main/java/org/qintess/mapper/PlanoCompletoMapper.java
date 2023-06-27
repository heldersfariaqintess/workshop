package org.qintess.mapper;


import org.mapstruct.Mapper;
import org.qintess.dto.PlanoCompletoDTO;
import org.qintess.dto.PlanoDTO;
import org.qintess.entity.Plano;


@Mapper(componentModel = "cdi")
public interface PlanoCompletoMapper {

    PlanoCompletoDTO toPlanoCompleto(Plano plano);

    PlanoCompletoDTO toPlanoCompleto(PlanoDTO planoDTO);
}
