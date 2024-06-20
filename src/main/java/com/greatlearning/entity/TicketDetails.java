package com.greatlearning.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket_details")
public class TicketDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id;

	@NotEmpty(message = "Field cannot be empty")
	@Column(name = "ticket_title")
	private String ticketTitle;

	@NotEmpty(message = "Field cannot be empty")
	@Column(name = "ticket_short_description")
	private String ticketShortDescription;

	@NotEmpty(message = "Field cannot be empty")
	@Column(name = "content")
	private String content;

	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "ticket_created_on")
	private Date ticketCreatedOn;

	@PrePersist
	private void onCreate() {
		ticketCreatedOn = new Date();
	}

}
