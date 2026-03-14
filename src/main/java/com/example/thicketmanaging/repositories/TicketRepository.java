package com.example.thicketmanaging.repositories;

import com.example.thicketmanaging.entities.Ticket;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByCategoryId(Long categoryId);

}