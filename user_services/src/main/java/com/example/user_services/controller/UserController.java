package com.example.user_services.controller;

import com.example.user_services.dto.UserDTO;
import com.example.user_services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(path = "/{Id}")
    public UserDTO getById(@PathVariable("Id") String id){
        return service.findUserById(id);
    }

    @GetMapping
    public List<UserDTO> getAllUser(){
        return service.getAllUser();
    }

    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO dto){
        return service.saveUser(dto);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO dto){
        return service.updateUser(dto);
    }
}
