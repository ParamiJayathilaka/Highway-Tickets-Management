package com.example.vehical_server.service.impl;

import com.example.vehical_server.dto.VehicleDTO;
import com.example.vehical_server.entity.Vehicle;
import com.example.vehical_server.repo.VehicleRepo;
import com.example.vehical_server.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO dto) {
        if (repo.existsById(dto.getId())){
            new RuntimeException("all ready exits");
        }
        return mapper.map(repo.save(mapper.map(dto, Vehicle.class)),VehicleDTO.class);
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO dto) {
        if (repo.existsById(dto.getId())){
            new RuntimeException("all ready exits");
        }
        return mapper.map(repo.save(mapper.map(dto, Vehicle.class)),VehicleDTO.class);

    }


    public List<VehicleDTO> getAllVehicle() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<VehicleDTO>>() {
        }.getType()); }

    @Override
    public VehicleDTO findById(String id) {
        Vehicle vehicle = repo.findById(id).orElseThrow(() -> new RuntimeException("vehicle not found with id: " + id));
        return mapper.map(vehicle,VehicleDTO.class);
    }
}
