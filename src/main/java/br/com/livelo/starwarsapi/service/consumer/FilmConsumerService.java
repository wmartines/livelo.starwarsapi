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

import br.com.livelo.starwarsapi.exception.BusinessException;
import br.com.livelo.starwarsapi.pojo.FilmPojo;

/**
 * The Class FilmConsumerService.
 */
@Service
public class FilmConsumerService {
	
	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;
	
	/** The url. */
	@Value("${integration.url.film}")
	private String  url;
	
	/** The Constant URL. */
	
	/**
	 * Find film.
	 *
	 * @param id the id
	 * @return the film pojo
	 */
	public FilmPojo findFilmById(String id) {
		try {
			
			// find film
			var uri = UriComponentsBuilder.fromUriString(url).uriVariables(Map.of("id", id)).build().toUri();
			ResponseEntity<FilmPojo> responseEntity = restTemplate.getForEntity(uri, FilmPojo.class);

			return responseEntity.getBody();
			
		} catch (BusinessException e) {
			throw new BusinessException("An error occoured while find film by id: " + id);
		} 
	}
}
