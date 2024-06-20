package com.greatlearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.TicketDetails;

@Repository
public interface TicketTrackerRepository extends JpaRepository<TicketDetails, Long> {

	@Query(value = "select * from  ticket_details ticket where ticket.ticket_title like %:keyword% or ticket.ticket_short_description like %:keyword%", nativeQuery = true)
	List<TicketDetails> findByKeyword(@Param("keyword") String keyword);

}
