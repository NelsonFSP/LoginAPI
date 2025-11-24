package com.nfspdev.loginAPI.entrypoint.controller;

import com.nfspdev.loginAPI.core.domain.User;
import com.nfspdev.loginAPI.core.service.DatabaseServiceImpl;
import com.nfspdev.loginAPI.entrypoint.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ListAllUsersController {

    private final DatabaseServiceImpl service;

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(User::fromUserToDTo).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


}
