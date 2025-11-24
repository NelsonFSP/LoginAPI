package com.nfspdev.loginAPI.tests;

import com.nfspdev.loginAPI.core.service.DatabaseServiceImpl;
import com.nfspdev.loginAPI.entrypoint.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateUserControllerTest {
    private final DatabaseServiceImpl service;
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
        var obj = objDto.dtoToUser();
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.ok().build();
    }
}
