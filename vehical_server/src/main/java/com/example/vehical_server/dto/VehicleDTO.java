package com.example.vehical_server.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VehicleDTO {

    private String id;
    private String name;
    private String model;
    private String number;
}
