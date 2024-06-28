package com.nfspdev.LoginAPI.entrypoint.controller;

import com.nfspdev.LoginAPI.service.UserService;
import com.nfspdev.LoginAPI.userDTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUserController {
    private final UserService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        var obj = service.findById(id);
        return ResponseEntity.ok().body(obj.fromUserToDTo());
    }
}
