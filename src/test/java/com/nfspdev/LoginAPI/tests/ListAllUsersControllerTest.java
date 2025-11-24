package com.nfspdev.loginAPI.tests;

import com.nfspdev.loginAPI.adapters.IUserRepository;
import com.nfspdev.loginAPI.adapters.dto.UserEntity;
import com.nfspdev.loginAPI.core.domain.User;
import com.nfspdev.loginAPI.core.service.DatabaseServiceImpl;
import com.nfspdev.loginAPI.entrypoint.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ListAllUsersControllerTest {

    private final IUserRepository service;
    private final

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserEntity> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(User::fromUserToDTo).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


}
