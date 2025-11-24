package com.nfspdev.loginAPI.adapters;

import com.nfspdev.loginAPI.core.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {

    List<User> findAll();

    Optional<User> findById(String id);

    User save(User obj);

    void delete(String id);

    void update(User obj);
}