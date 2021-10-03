package br.com.livelo.starwarsapi.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.livelo.starwarsapi.pojo.PeoplePojo;
import br.com.livelo.starwarsapi.presenter.FilmPresenter;
import br.com.livelo.starwarsapi.presenter.PeoplePresenter;
import br.com.livelo.starwarsapi.service.consumer.FilmConsumerService;
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
	
	/** The film consumer service. */
	@Autowired
	private FilmConsumerService filmConsumerService;
	
	/**
	 * Find all.
	 *
	 * @return the response entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id){
		
        return new ResponseEntity<>(convertToPresenter(peopleConsumerService.findPeopleById(id)), HttpStatus.OK);
    }
	
	/**
	 * Convert to presenter.
	 *
	 * @param pojo the pojo
	 * @return the people presenter
	 */
	private PeoplePresenter convertToPresenter(PeoplePojo pojo){

    	return PeoplePresenter.builder()
    			.name(pojo.getName())
    			.birthYear(pojo.getBirthYear())
    			.created(pojo.getCreated())
    			.edited(pojo.getEdited())
    			.eyeColor(pojo.getEyeColor())
    			.gender(pojo.getGender())
    			.url(pojo.getUrl())
    			.height(pojo.getHeight())
    			.skinColor(pojo.getSkinColor())
    			.mass(pojo.getMass())
    			.hairColor(pojo.getHairColor())
    			.films(pojo.getFilms().stream().map(this::convertFilmToPresenter).collect(Collectors.toList()))
    			.build();
    }
	
	/**
	 * Convert film to presenter.
	 *
	 * @param filmUrl the film url
	 * @return the film presenter
	 */
	private FilmPresenter convertFilmToPresenter(String filmUrl) {
		
		// find film
		var id = filmUrl.replaceAll("\\D+","");
		var film = filmConsumerService.findFilmById(id);
		
		return FilmPresenter.builder()
				.director(film.getDirector())
				.episodeId(film.getEpisodeId())
				.openingCrawl(film.getOpeningCrawl())
				.producer(film.getProducer())
				.releaseDate(film.getReleaseDate())
				.created(film.getCreated())
				.edited(film.getEdited())
				.url(film.getUrl())
				.title(film.getTitle())
				.build();
	}
}
