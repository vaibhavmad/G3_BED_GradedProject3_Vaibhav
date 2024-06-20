package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.TicketDetails;
import com.greatlearning.repository.TicketTrackerRepository;

@Service
public class TicketTrackerServiceImpl implements TicketTrackerService {
	@Autowired
	TicketTrackerRepository ticketTrackerRepository;

	@Override
	public List<TicketDetails> getAllTickets() {
		return ticketTrackerRepository.findAll();
	}

	@Override
	public TicketDetails saveTicket(TicketDetails ticketDetails) {
		return ticketTrackerRepository.save(ticketDetails);
	}

	@Override
	public TicketDetails getTicketById(long id) {
		return ticketTrackerRepository.findById(id).get();
	}

	@Override
	public TicketDetails editTicket(long id, TicketDetails ticketDetails) {
		TicketDetails existingTicket = getTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTicketTitle(ticketDetails.getTicketTitle());
		existingTicket.setTicketShortDescription(ticketDetails.getTicketShortDescription());
		existingTicket.setContent(ticketDetails.getContent());
		return saveTicket(existingTicket);
	}

	@Override
	public void deleteTicketById(long id) {
		ticketTrackerRepository.deleteById(id);
	}

	@Override
	public List<TicketDetails> findByKeyword(String keyword) {
		return ticketTrackerRepository.findByKeyword(keyword);
	}

}
