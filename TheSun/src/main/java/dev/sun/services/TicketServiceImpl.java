package dev.sun.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import dev.sun.entities.Ticket;
import dev.sun.repositories.TicketRepository;

@Service
@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepo;

	@Override
	public int updateTicket(Ticket ticket) {

		int rsult = ticketRepo.updateTicket(ticket.getTicketId(), ticket.getPlacementTime(), ticket.getStatus(),
				ticket.getNote());

		return rsult;
	}

	@Override
	public Ticket getTicketById(int id) {
		return ticketRepo.findById(id).get();
	}

	@Override
	public List<Ticket> getAllTickets() {
		return (List<Ticket>) ticketRepo.findAll();
	}

	@Override
	public boolean deleteTicket(Ticket ticket) {
		boolean result = true;
		try {
			ticketRepo.delete(ticket);

		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public Ticket createTicket(Ticket ticket) {
		ticket.setTicketId(0);
		return ticketRepo.save(ticket);
	}

	@Override
	public Ticket updateStatus(int id, String status) {
		Ticket ticket = this.getTicketById(id);
		// t.setStatus(ORDERSTATUS.InProgress.toString());

		ticketRepo.updateTicketStatus(id, status, ticket.getPlacementTime());

		// ticketRepo.save(ticket);
		return ticket;
	}

	@Override
	public Ticket updateNote(int id, String notes) {
		Ticket ticket = this.getTicketById(id);
		ticketRepo.updateTicketNote(id, notes, ticket.getPlacementTime());
		// ticketRepo.updateTicket(id, ticket.getPlacementTime(), ticket.getStatus(),
		// notes);
		return ticket;
	}

	@Override
	public List<Ticket> getTicketsByUserId(int userId) {
		// TODO Auto-generated method stub
		return ticketRepo.findTicketsByUserId(userId);
	}
}

