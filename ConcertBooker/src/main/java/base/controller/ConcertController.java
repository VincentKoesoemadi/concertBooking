package base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import base.model.BaseResponse;
import base.model.Concert;
import base.service.ConcertService;

@RestController
@RequestMapping("/concert")
public class ConcertController {
	
	@Autowired
    private ConcertService concertService;
	
	@GetMapping(path="/getconcertlist", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Concert> getConcertList() {
		List<Concert> concertList = concertService.getConcertList();
		return concertList;
	}
	
	@GetMapping(value = {"/availableconcertlist", "/availableconcertlist/{venue}"}, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Concert> getAvailableConcertList(@PathVariable(required = false) String venue) {
		List<Concert> concertList = concertService.getAvailableConcert(venue);
		return concertList;
	}
}
