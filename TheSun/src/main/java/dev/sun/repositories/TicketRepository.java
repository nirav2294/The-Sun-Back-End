package dev.sun.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.sun.entities.Ticket;

@Component
@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer>{

}
