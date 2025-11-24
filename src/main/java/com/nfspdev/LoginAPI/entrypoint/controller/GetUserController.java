package com.nfspdev.loginAPI.entrypoint.controller;

import com.nfspdev.loginAPI.adapters.IUserRepository;
import com.nfspdev.loginAPI.entrypoint.dto.UserDTO;
import com.nfspdev.loginAPI.entrypoint.dto.mapper.IMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUserController {
    private final IUserRepository service;
    private final IMapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        var obj = service.findById(id);
        return obj.map(user -> ResponseEntity.ok().body(mapper.userToDto(user))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
