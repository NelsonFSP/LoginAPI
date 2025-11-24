package com.nfspdev.loginAPI.adapters.dto.mapper;

import com.nfspdev.loginAPI.adapters.dto.UserEntity;
import com.nfspdev.loginAPI.core.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IAdapterMapper {

   IAdapterMapper INSTANCE = Mappers.getMapper(IAdapterMapper.class);

    UserEntity toEntity(User user);
    User toDomain(UserEntity entity);
}
