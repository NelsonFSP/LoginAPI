package com.nfspdev.loginapi.core.service;

import com.nfspdev.loginapi.adapters.IUserRepository;
import com.nfspdev.loginapi.adapters.dto.UserEntity;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.List;
import java.util.Map;


@Service
public  class DatabaseServiceImpl implements IUserRepository {

    private final DynamoDbTemplate dynamoDbTemplate;

    @Autowired
    public DatabaseServiceImpl(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }


    @Override
    public List<UserEntity> findAllUsers() {
        return dynamoDbTemplate.scanAll(UserEntity.class).items().stream().toList();
    }

    @Override
    public UserEntity findUserById(String id) {

        ScanEnhancedRequest scanRequest = ScanEnhancedRequest.builder()
                .consistentRead(true)
                .attributesToProject("id", "name", "login")
                .filterExpression(Expression.builder()
                        .expression("id = :id_value")
                        .expressionValues(
                                Map.of( ":id_value", AttributeValue.fromS(id)))
                        .build())
                .build();
        return dynamoDbTemplate.scan(scanRequest, UserEntity.class).items().stream().findFirst().orElseThrow();
    }

    @Override
    public UserEntity saveUser(UserEntity obj) {
        return dynamoDbTemplate.save(obj);
    }

    @Override
    public void deleteUser(String id) {
        dynamoDbTemplate.save(findUserById(id));
    }

    @Override
    public UserEntity updateUser(UserEntity atualizacao) {
        return dynamoDbTemplate.update(atualizacao);
    }
}
