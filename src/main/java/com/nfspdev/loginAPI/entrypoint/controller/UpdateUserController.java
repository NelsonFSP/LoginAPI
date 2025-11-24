package com.nfspdev.loginAPI.entrypoint.controller;

import com.nfspdev.LoginAPI.service.UserService;
import com.nfspdev.LoginAPI.userDTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateUserController {
    private final UserService service;
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
        var obj = objDto.dtoToUser();
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.ok().build();
    }
}
