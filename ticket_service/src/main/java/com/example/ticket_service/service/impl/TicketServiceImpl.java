package com.example.ticket_service.service.impl;

import com.example.ticket_service.dto.TicketDTO;
import com.example.ticket_service.entity.Ticket;
import com.example.ticket_service.repo.TicketRepo;
import com.example.ticket_service.service.TicketService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RestTemplate template;

    public Map<String, Object> getId(String id) {
        String url = "/api/vehicles/" + id;
        ResponseEntity<Map> response = template.getForEntity(url, Map.class);
        return response.getBody();
    }

    @Override
    public TicketDTO saveTicket(TicketDTO ticketDTO) {
        if (repo.existsById(ticketDTO.getId())){
            new RuntimeException("all ready Exits");
        }
        try {
            TicketDTO dto = template.getForObject("http://localhost:8080/user/" + ticketDTO.getUserId(), TicketDTO.class);
            TicketDTO vdto = template.getForObject("http://localhost:8080/vehicle/" + ticketDTO.getVehicleId(), TicketDTO.class);
            if (dto != null && vdto != null) {
                return mapper.map(repo.save(mapper.map(ticketDTO, Ticket.class)), TicketDTO.class);
            } else {
                throw new RuntimeException("ID does not match: " + ticketDTO.getUserId());
            }
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Error fetching user: " + e.getMessage());
        }
    }

    @Override
    public TicketDTO updateTicket(TicketDTO ticketDTO) {
        if (repo.existsById(ticketDTO.getId())){
            new RuntimeException("all ready Exits");
        }
        return mapper.map(repo.save(mapper.map(ticketDTO, Ticket.class)), TicketDTO.class);

    }

    @Override
    public List<TicketDTO> getAllTicket() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<TicketDTO>>() {
        }.getType());
    }

    @Override
    public void deleteTicket(String id) {
        if (!repo.existsById(id)){
            new RuntimeException("all ready Exits");
        }
        repo.deleteById(id);
    }
}
