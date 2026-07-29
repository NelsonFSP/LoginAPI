package com.nfspdev.loginApi.adapters;

import com.nfspdev.loginApi.adapters.dto.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {

    List<UserEntity> findAllUsers();

    UserEntity findUserById(String id);

    UserEntity saveUser(UserEntity obj);

    void deleteUser(String id);

    UserEntity updateUser(UserEntity obj);
}