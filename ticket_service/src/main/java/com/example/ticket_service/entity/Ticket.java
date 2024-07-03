package com.example.ticket_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Ticket {
    @Id
    private String id;
    private String userId;
    private String vehicleId;
    private String entrance;
    private String exits;
    private double price;
}
