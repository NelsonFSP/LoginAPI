package com.nfspdev.LoginAPI.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nfspdev.LoginAPI.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}
