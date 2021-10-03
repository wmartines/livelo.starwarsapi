package br.com.livelo.starwarsapi.service.consumer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.livelo.starwarsapi.pojo.PeoplePojo;

@Service
public class PeopleConsumerService {
	
	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;
	
	/** The url. */
	@Value("${integration.url.people}")
	private String  url;
	
	
	/**
	 * Find people by id.
	 *
	 * @param id the id
	 * @return the people pojo
	 */
	public PeoplePojo findPeopleById(String id) {
		try {

			// find people
			var uri = UriComponentsBuilder.fromUriString(url).uriVariables(Map.of("id", id)).build().toUri();
			ResponseEntity<PeoplePojo> responseEntity = restTemplate.getForEntity(uri, PeoplePojo.class);

			return responseEntity.getBody();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "people not found");
		}
	}
}
