package com.example.ticket_service.repo;

import com.example.ticket_service.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, String> {
}
