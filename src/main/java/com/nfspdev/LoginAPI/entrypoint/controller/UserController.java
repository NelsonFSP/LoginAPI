package com.nfspdev.loginapi.entrypoint.controller;

import com.nfspdev.loginapi.core.domain.User;
import com.nfspdev.loginapi.core.usecase.ports.IUsuario;
import com.nfspdev.loginapi.entrypoint.dto.UserDTO;
import com.nfspdev.loginapi.entrypoint.dto.mapper.IDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private final IUsuario service;
    private final IDtoMapper dtoMapper;

    @Autowired
    public UserController(IUsuario service, IDtoMapper dtoMapper) {
        this.service = service;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping(value="/user")
    public ResponseEntity<UserDTO> novoUsuario(@RequestBody UserDTO novoUsuario){
        User usuarioConvertidoParaEntidadeDeDominio = dtoMapper.toUser(novoUsuario);
        UserDTO usuarioSalvoDto = dtoMapper.toDto(service.salvarUsuario(usuarioConvertidoParaEntidadeDeDominio));
        return ResponseEntity.ok(usuarioSalvoDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> buscarUsuario(@PathVariable String id){
        UserDTO usuarioSalvoDto = dtoMapper.toDto(service.buscarUsuario(id));
        return ResponseEntity.ok(usuarioSalvoDto);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDTO>> buscarUsuarios(){
        List<UserDTO> usuarioSalvoDto = service.listarUsuarios().stream().map(dtoMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(usuarioSalvoDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        service.deletarUsuario(id);
        return ResponseEntity.accepted().body("Usuário " + id + "deletado");
    }
}
