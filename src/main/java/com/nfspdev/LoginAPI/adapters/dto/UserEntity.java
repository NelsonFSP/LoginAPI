package com.nfspdev.loginAPI.adapters.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public record UserEntity(
    String id,
    String name,
    String login,
    String password
) {
}
