package base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.model.Ticket;
import base.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    
    public Ticket getBalanceByConcert(long concertId) {
		return ticketRepository.getBalanceByConcert(concertId);
    }
}
