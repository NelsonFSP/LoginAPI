package com.nfspdev.loginAPI.entrypoint.dto.mapper;

import com.nfspdev.loginAPI.core.domain.User;
import com.nfspdev.loginAPI.entrypoint.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IDtoMapper {

    IDtoMapper INSTANCE = Mappers.getMapper(IDtoMapper.class);

    UserDTO userToDto(User user);
    User dtoToUser(UserDTO userDTO);
}
