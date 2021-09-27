package br.com.livelo.starwarsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.livelo.starwarsapi.service.consumer.PeopleConsumerService;

/**
 * The Class PeopleController.
 */
@RestController
@RequestMapping(value = "people")
public class PeopleController {
	
	/** The people consumer service. */
	@Autowired
	private PeopleConsumerService peopleConsumerService;
	
	/**
	 * Find all.
	 *
	 * @return the response entity
	 */
	@GetMapping()
	public ResponseEntity<?> findAll(){
		
		peopleConsumerService.findPeople("");
		
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
