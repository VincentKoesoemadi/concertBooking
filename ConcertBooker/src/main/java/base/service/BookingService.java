package base.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.model.BaseResponse;
import base.model.Booking;
import base.model.Ticket;
import base.repository.BookingRepository;
import base.repository.TicketRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private TicketRepository ticketRepository;
    
    public BaseResponse bookConcert(Booking booking) {
    	long concertId = booking.getConcert().getId();
    	BaseResponse response = new BaseResponse();
    	boolean bookingValid;
    	
    	Ticket ticket = ticketRepository.getBalanceByConcert(concertId);
    	
    	bookingValid = validateBooking(ticket, booking, response);
    	
    	if(bookingValid) {
    		int ticketBalance = ticket.getBalance();
    		
    		booking = bookingRepository.save(booking);
    		ticket.setBalance(ticketBalance - booking.getNumberOfTicket());
    		ticketRepository.save(ticket);

    		String bookingID = String.valueOf(concertId).concat(booking.getPhone()).concat(String.valueOf(booking.getId()));

    		//TODO generate email for booking ID
    		
    		response.setStatusCode("200");
    		response.setStatusMessage("Booking successful. Here is your booking ID " + bookingID +".");
    	}
    	
		return response;
    }
    
    private boolean validateBooking(Ticket ticket, Booking booking, BaseResponse response) {
    	Date today = new Date();
    	boolean valid = true;
    	if (null == ticket) {
    		response.setStatusCode("500");
    		response.setStatusMessage("Concert not found.");
    		valid = false;
    	} else if (today.before(ticket.getBookStart())) {
    		response.setStatusCode("502");
    		response.setStatusMessage("The booking period for this concert starts at "+ ticket.getBookStart()+".");
    		valid = false;
    	} else if (today.after(ticket.getBookEnd())) {
    		response.setStatusCode("503");
    		response.setStatusMessage("The booking period for this concert has ended.");
    		valid = false;
    	} else if(ticket.getBalance() < booking.getNumberOfTicket()) {
    		response.setStatusCode("501");
    		response.setStatusMessage("Sorry, we only have "+ ticket.getBalance() +" remaining ticket(s) for this concert.");
    		valid = false;
    	} else if(booking.getNumberOfTicket() <= 0) {
    		response.setStatusCode("504");
    		response.setStatusMessage("Please input number of tickets.");
    		valid = false;
    	} 
    	return valid;
    }
}

