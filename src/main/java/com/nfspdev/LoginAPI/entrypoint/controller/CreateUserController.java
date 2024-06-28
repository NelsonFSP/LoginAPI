package com.nfspdev.LoginAPI.entrypoint.controller;

import com.nfspdev.LoginAPI.service.UserService;
import com.nfspdev.LoginAPI.userDTO.UserDTO;
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
    private final UserService service;
    @PostMapping(value = "/create/{id}")
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
        var obj = service.insert(objDto.dtoToUser());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
