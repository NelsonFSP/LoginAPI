package com.nfspdev.loginAPI.entrypoint.controller;

import com.nfspdev.loginAPI.core.usecase.ports.IUsuario;
import com.nfspdev.loginAPI.entrypoint.dto.UserDTO;
import com.nfspdev.loginAPI.entrypoint.dto.mapper.IDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private IUsuario service;

    private final IDtoMapper dtoMapper;

    @PostMapping(value="/user")
    public ResponseEntity<?> novoUsuario(@RequestBody UserDTO novoUsuario){
        return ResponseEntity.ok(service.salvarUsuario(dtoMapper.toUser(novoUsuario)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarUsuario(@PathVariable String id){
        return ResponseEntity.ok(dtoMapper.toDto(service.buscarUsuario(id)));
    }

    @GetMapping(value = "/users")
    public ResponseEntity<?> buscarUsuarios(@PathVariable String id){
        return ResponseEntity.ok(service.listarUsuarios());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        service.deletarUsuario(id);
        return ResponseEntity.accepted().build();
    }
}
