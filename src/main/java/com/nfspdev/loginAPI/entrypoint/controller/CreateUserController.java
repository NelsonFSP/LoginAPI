package com.nfspdev.loginAPI.entrypoint.controller;

import com.nfspdev.loginAPI.core.service.DatabaseServiceImpl;
import com.nfspdev.loginAPI.entrypoint.dto.UserDTO;
import com.nfspdev.loginAPI.entrypoint.dto.mapper.IMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class CreateUserController {

    @Value("${rest.scheme}")
    private final String scheme;
    @Value("${rest.host}")
    private final String host;
    @Value("${rest.port}")
    private final int port;
    @Value("${rest.path.users}")
    private final String path;

    private final DatabaseServiceImpl service;
    private final IMapper mapper;


    @PostMapping(value = "/create/{id}")
    public ResponseEntity<?> insert(@RequestBody UserDTO objDto){
        var obj = service.save(mapper.dtoToUser(objDto));
        URI uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .port(port)
                .path(path)
                .build()
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
