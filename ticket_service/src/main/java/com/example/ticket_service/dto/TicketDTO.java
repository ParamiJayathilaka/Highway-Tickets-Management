package com.example.ticket_service.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TicketDTO {
    private String id;
    private String userId;
    private String vehicleId;
    private String entrance;
    private String exits;
    private double price;
}
