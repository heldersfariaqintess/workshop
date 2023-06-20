package org.qintess.mapper;


import org.mapstruct.Mapper;
import org.qintess.dto.ClienteDTO;
import org.qintess.entity.Cliente;


@Mapper(componentModel = "cdi")
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {

}
