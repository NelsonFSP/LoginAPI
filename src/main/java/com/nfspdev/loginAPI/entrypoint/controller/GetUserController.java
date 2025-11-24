package com.nfspdev.loginAPI.entrypoint.controller;

import com.nfspdev.loginAPI.core.service.DatabaseServiceImpl;
import com.nfspdev.loginAPI.entrypoint.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUserController {
    private final DatabaseServiceImpl service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        var obj = service.findById(id);
        return ResponseEntity.ok().body(obj.fromUserToDTo());
    }
}
