package com.nfspdev.loginAPI.entrypoint.controller;


import com.nfspdev.loginAPI.adapters.IUserRepository;
import com.nfspdev.loginAPI.entrypoint.dto.UserDTO;
import com.nfspdev.loginAPI.entrypoint.dto.mapper.IMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class CreateUserController {
    private final IUserRepository service;
    private final IMapper mapper;
    @PostMapping(value = "/create/{id}")
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
        var obj = service.insert(mapper.dtoToUser(objDto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
