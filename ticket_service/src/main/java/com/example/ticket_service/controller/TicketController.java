package com.example.ticket_service.controller;

import com.example.ticket_service.dto.TicketDTO;
import com.example.ticket_service.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<TicketDTO> getAllTicket(){
        return ticketService.getAllTicket();
    }

    @PostMapping
    public TicketDTO saveTicket(@RequestBody TicketDTO dto){
        System.out.println("saveTicket");
        return ticketService.saveTicket(dto);
    }

    @PutMapping
    public TicketDTO updateTicket(@RequestBody TicketDTO dto){
        System.out.println("updateTicket");
        return ticketService.updateTicket(dto);
    }

    @DeleteMapping
    public void deleteTicket(String id){
        System.out.println("deleteTicket");
        ticketService.deleteTicket(id);
    }
}
