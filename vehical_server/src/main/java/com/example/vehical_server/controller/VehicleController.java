package com.example.vehical_server.controller;

import com.example.vehical_server.dto.VehicleDTO;
import com.example.vehical_server.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;



    @GetMapping
    public List<VehicleDTO> getAllVehicle() {
        return service.getAllVehicle();
    }

    @PostMapping
    public VehicleDTO saveVehicle(@RequestBody VehicleDTO dto){
        return service.saveVehicle(dto);
    }

    @PutMapping
    public VehicleDTO updateVehicle(@RequestBody VehicleDTO dto){
        return service.updateVehicle(dto);
    }

    @GetMapping(path = "/{Id}")
    public VehicleDTO getById(@PathVariable("Id") String id){
        return service.findById(id);
    }


}
