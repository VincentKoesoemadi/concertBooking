package base.service;

import java.util.List;

import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.model.Concert;
import base.repository.ConcertRepository;

@Service
public class ConcertService {

    @Autowired
    private ConcertRepository concertRepository;
    
    public List<Concert> getConcertList() {
    	return concertRepository.findAll();
    }
    
    public List<Concert> getAvailableConcert(String venue) {
    	if(StringHelper.isBlank(venue)) {
    		return getConcertList();
    	} else {
    		return concertRepository.getConcertByVenue(venue);
    	}
    }
}
