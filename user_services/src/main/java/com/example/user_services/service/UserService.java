package com.example.user_services.service;

import com.example.user_services.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO dto);
    UserDTO updateUser(UserDTO dto);
    List<UserDTO> getAllUser();
    UserDTO findUserById(String id);
}
