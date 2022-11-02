package com.nelson.LoginAPI.entrypoint;

import com.nelson.LoginAPI.domain.User;
import com.nelson.LoginAPI.service.UserService;
import com.nelson.LoginAPI.userDTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class Controller {

    private final UserService service;
    private final UserDTO userDTO;
    private final User user;

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(User::fromUserToDTo).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        var obj = service.findById(id);
        return ResponseEntity.ok().body(obj.fromUserToDTo());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
        var obj = service.insert(objDto.dtoToUser());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
        var obj = objDto.dtoToUser();
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.ok().build();
    }
}
