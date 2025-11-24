package com.nfspdev.loginAPI.adapters;

import com.nfspdev.loginAPI.adapters.dto.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends MongoRepository<UserEntity, String> {

    List<UserEntity> findAllUsers();

    Optional<UserEntity> findUserById(String id);

    UserEntity saveUser(UserEntity obj);

    void deleteUser(String id);

    void updateUser(UserEntity obj);
}