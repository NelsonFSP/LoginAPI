package com.nfspdev.loginapi.entrypoint.dto.mapper;

import com.nfspdev.loginapi.core.domain.User;
import com.nfspdev.loginapi.entrypoint.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IDtoMapper {

    IDtoMapper INSTANCE = Mappers.getMapper(IDtoMapper.class);

    UserDTO toDto(User user);
    User toUser(UserDTO userDTO);
}
