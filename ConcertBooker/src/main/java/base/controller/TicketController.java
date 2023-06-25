package base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import base.model.BaseResponse;
import base.model.Booking;
import base.model.Ticket;
import base.service.BookingService;
import base.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
    private TicketService ticketService;
	
	@Autowired
    private BookingService bookingService;
	
	@GetMapping(value ="/getbalance/{concertId}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Ticket getAvailableConcertList(@PathVariable long concertId) {
		Ticket ticket = ticketService.getBalanceByConcert(concertId);
		return ticket;
	}
	
	@PostMapping(value ="/book", consumes = "application/json", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public BaseResponse book(@RequestBody Booking booking) {
		BaseResponse response = bookingService.bookConcert(booking);
		return response;
	}
}

