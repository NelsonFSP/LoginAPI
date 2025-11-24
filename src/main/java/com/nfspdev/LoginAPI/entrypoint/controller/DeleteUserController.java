package com.nfspdev.loginAPI.entrypoint.controller;

import com.nfspdev.loginAPI.adapters.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteUserController {
    private final IUserRepository service;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        service.deleteUser(id);
        return ResponseEntity.accepted().build();
    }
}
