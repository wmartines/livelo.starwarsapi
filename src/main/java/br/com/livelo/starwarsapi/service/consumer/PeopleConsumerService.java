package br.com.livelo.starwarsapi.service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PeopleConsumerService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void findPeople(String id) {
		
		var response = restTemplate.getForEntity("https://swapi.dev/api/people/" + id, String.class);
		
		System.out.println(response);
		
	}

}
