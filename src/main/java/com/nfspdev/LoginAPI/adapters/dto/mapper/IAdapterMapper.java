package com.nfspdev.loginApi.adapters.dto.mapper;

import org.mapstruct.factory.Mappers;
import com.nfspdev.loginApi.adapters.dto.UserEntity;
import com.nfspdev.loginApi.core.domain.User;
import org.mapstruct.Mapper;

@Mapper
public interface IAdapterMapper {

    IAdapterMapper INSTANCE = Mappers.getMapper(IAdapterMapper.class);

    UserEntity toEntity(User user);

    User toDomain(UserEntity entity);
}
