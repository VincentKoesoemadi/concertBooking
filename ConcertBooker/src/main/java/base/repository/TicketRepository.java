package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import base.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT 	TOP 1 * "
	    		+ "FROM 	TICKET "
	    		+ "WHERE 	CONCERT_ID = :concertId "
	    		+ "			AND BALANCE > 0 "
	    		+ "ORDER BY BOOK_START ", nativeQuery = true)
    Ticket getBalanceByConcert(@Param("concertId") long concertId);
}
