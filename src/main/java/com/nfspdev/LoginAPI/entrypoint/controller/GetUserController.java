package com.nfspdev.loginAPI.entrypoint.controller;

import com.nfspdev.loginAPI.adapters.IUserRepository;

import com.nfspdev.loginAPI.adapters.dto.UserEntity;
import com.nfspdev.loginAPI.adapters.dto.mapper.IAdapterMapper;
import com.nfspdev.loginAPI.core.domain.User;
import com.nfspdev.loginAPI.entrypoint.dto.UserDTO;
import com.nfspdev.loginAPI.entrypoint.dto.mapper.IDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GetUserController {
    private final IUserRepository service;
    private final IAdapterMapper adapterMapper;
    private final IDtoMapper dtoMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Optional<UserEntity> entidadeRecuperada = service.findUserById(id);
        if(entidadeRecuperada.isPresent()){
            UserEntity usuarioRecuperado = entidadeRecuperada.get();
            User usuarioConvertidoDominio = adapterMapper.toDomain(usuarioRecuperado);
            UserDTO usuarioConvertidoDto = dtoMapper.userToDto(usuarioConvertidoDominio);
            return ResponseEntity.ok(usuarioConvertidoDto);
        }
        return ResponseEntity.notFound().build();
    }
}
