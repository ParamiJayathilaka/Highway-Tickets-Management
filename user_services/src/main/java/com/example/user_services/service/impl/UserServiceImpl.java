package com.example.user_services.service.impl;

import com.example.user_services.dto.UserDTO;
import com.example.user_services.entity.User;
import com.example.user_services.repo.UserRepo;
import com.example.user_services.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public UserDTO saveUser(UserDTO dto) {
        if (repo.existsById(dto.getId())){
            new RuntimeException("all ready exits");
        }
        return mapper.map(repo.save(mapper.map(dto, User.class)),UserDTO.class);
    }

    @Override
    public UserDTO updateUser(UserDTO dto) {
        if (repo.existsById(dto.getId())){
            new RuntimeException("all ready exits");
        }
        return mapper.map(repo.save(mapper.map(dto, User.class)),UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<UserDTO>>() {
        }.getType()); }

    @Override
    public UserDTO findUserById(String id) {
        User user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return mapper.map(user,UserDTO.class);
    }

}
