package com.greatlearning.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.entity.TicketDetails;
import com.greatlearning.service.TicketTrackerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TicketTrackerController {
	private final TicketTrackerService ticketTrackerService;

	@GetMapping("/tickets")
	public String listTickets(Model model, String keyword) {
		if (keyword != null) {
			model.addAttribute("tickets", ticketTrackerService.findByKeyword(keyword));
		} else {
			model.addAttribute("tickets", ticketTrackerService.getAllTickets());
		}

		return "tickets";
	}

	@GetMapping("/tickets/new")
	public String createTicketForm(Model model) {
		TicketDetails ticketDetails = new TicketDetails();
		model.addAttribute("ticket", ticketDetails);
		return "create_ticket";
	}

	@PostMapping("/tickets")
	public String saveTicket(@Valid @ModelAttribute("ticket") TicketDetails ticketDetails, BindingResult result) {
		if (result.hasErrors()) {
			return "create_ticket";
		}
		ticketTrackerService.saveTicket(ticketDetails);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable long id, Model model) {
		model.addAttribute("ticket", ticketTrackerService.getTicketById(id));
		return "edit_ticket";
	}

	@PostMapping("/tickets/{id}")
	public String editTicket(@PathVariable long id, @Valid @ModelAttribute("ticket") TicketDetails ticketDetails,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "edit_ticket";
		}
		ticketTrackerService.editTicket(id, ticketDetails);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable Long id) {
		ticketTrackerService.deleteTicketById(id);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/view/{id}")
	public String viewTicketForm(@PathVariable long id, Model model) {
		model.addAttribute("ticket", ticketTrackerService.getTicketById(id));
		return "view_Ticket";
	}

}
