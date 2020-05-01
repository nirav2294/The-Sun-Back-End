package dev.sun.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pizza_id")
	private int pizzaId;

	// TODO
	// need to work on this later
	@ManyToOne
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;

	@ManyToMany
	@JoinTable(name = "pizza_topping", joinColumns = { @JoinColumn(name = "pt_pizza") }, inverseJoinColumns = {
			@JoinColumn(name = "pt_topping") })
	private Set<Topping> toppings = new HashSet<Topping>();


	public Pizza() {
		super();
	}

	public Pizza(int pizzaId, Ticket ticketId) {
		super();
		this.pizzaId = pizzaId;
		this.ticket = ticketId;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public Ticket getTicketId() {
		return ticket;
	}

	public void setTicketId(Ticket ticketId) {
		this.ticket = ticketId;
	}

	@Override
	public String toString() {
		return "Pizza [pizzaId=" + pizzaId + ", ticketId=" + ticket.toString() + ", toppings=" + toppings + "]";
	}

}
