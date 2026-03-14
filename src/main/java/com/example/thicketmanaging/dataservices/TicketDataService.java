package com.example.thicketmanaging.dataservices;

import com.example.thicketmanaging.entities.Ticket;
import com.example.thicketmanaging.repositories.TicketRepository;
import com.example.thicketmanaging.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketDataService {


    @Autowired
    private  TicketRepository ticketRepository;


    @Autowired
    private  UserRepository userRepository;

    public List<Ticket> getTicketsByCategory(Long categoryId) {
        return ticketRepository.findByCategoryId(categoryId);
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    public Optional<Ticket> updateTicket(Long id, Ticket ticketUpdated) {
        Ticket ticket = ticketRepository.findById(id).get();
        ticket.setDescription(ticketUpdated.getDescription());
        ticket.setTitle(ticketUpdated.getTitle());
        ticket.setStatus(ticketUpdated.getStatus());
        ticket.setUser(userRepository.findById(ticketUpdated.getUser().getId()).get());
        ticketRepository.save(ticket);
        return Optional.of(ticket);
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}