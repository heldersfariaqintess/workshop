package org.qintess.mapper;


import org.mapstruct.Mapper;
import org.qintess.dto.PlanoServicoCompletoDTO;
import org.qintess.entity.PlanoServico;


@Mapper(componentModel = "cdi")
public interface PlanoServicoCompletoMapper {
    PlanoServicoCompletoDTO toPlanoServicoCompleto(PlanoServico planoServico);
}
