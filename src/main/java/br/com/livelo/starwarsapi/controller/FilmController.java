package br.com.livelo.starwarsapi.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.livelo.starwarsapi.pojo.FilmPojo;
import br.com.livelo.starwarsapi.presenter.FilmPresenter;
import br.com.livelo.starwarsapi.presenter.PeoplePresenter;
import br.com.livelo.starwarsapi.service.consumer.FilmConsumerService;
import br.com.livelo.starwarsapi.service.consumer.PeopleConsumerService;

/**
 * The Class FilmController.
 */
@RestController
@RequestMapping(value = "film")
public class FilmController {
	
	/** The people consumer service. */
	@Autowired
	private PeopleConsumerService peopleConsumerService;
	
	/** The film consumer service. */
	@Autowired
	private FilmConsumerService filmConsumerService;
	
	/**
	 * Find all.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id){
		
        return new ResponseEntity<>(convertToPresenter(filmConsumerService.findFilmById(id)), HttpStatus.OK);
    }
	
	/**
	 * Convert to presenter.
	 *
	 * @param pojo the pojo
	 * @return the film presenter
	 */
	private FilmPresenter convertToPresenter(FilmPojo pojo){

		return FilmPresenter.builder()
				.director(pojo.getDirector())
				.episodeId(pojo.getEpisodeId())
				.openingCrawl(pojo.getOpeningCrawl())
				.producer(pojo.getProducer())
				.releaseDate(pojo.getReleaseDate())
				.created(pojo.getCreated())
				.edited(pojo.getEdited())
				.url(pojo.getUrl())
				.title(pojo.getTitle())
				.characters(pojo.getCharacters().stream().map(this::convertCharacterToPresenter).collect(Collectors.toList()))
				.build();
    }
	
	/**
	 * Convert character to presenter.
	 *
	 * @param characterUrl the character url
	 * @return the people presenter
	 */
	private PeoplePresenter convertCharacterToPresenter(String characterUrl) {
		
		// find character
		var id = characterUrl.replaceAll("\\D+","");
		var character = peopleConsumerService.findPeopleById(id);
		
		return PeoplePresenter.builder()
    			.name(character.getName())
    			.birthYear(character.getBirthYear())
    			.created(character.getCreated())
    			.edited(character.getEdited())
    			.eyeColor(character.getEyeColor())
    			.gender(character.getGender())
    			.url(character.getUrl())
    			.height(character.getHeight())
    			.skinColor(character.getSkinColor())
    			.mass(character.getMass())
    			.hairColor(character.getHairColor())
    			.build();
		
		
	}
}
