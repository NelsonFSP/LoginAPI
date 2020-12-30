package com.nelson.LoginAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nelson.LoginAPI.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
