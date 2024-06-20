package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.TicketDetails;

public interface TicketTrackerService {
	List<TicketDetails> getAllTickets();

	TicketDetails saveTicket(TicketDetails ticketDetails);

	TicketDetails getTicketById(long id);

	TicketDetails editTicket(long id, TicketDetails ticketDetails);

	void deleteTicketById(long id);

	List<TicketDetails> findByKeyword(String keyword);

}
