package com.example.vehical_server.service;

import com.example.vehical_server.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    VehicleDTO saveVehicle(VehicleDTO dto);
    VehicleDTO updateVehicle(VehicleDTO dto);
    List<VehicleDTO> getAllVehicle();
    VehicleDTO findById(String id);
}
