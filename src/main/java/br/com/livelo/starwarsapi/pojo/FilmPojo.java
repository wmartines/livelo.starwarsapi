package br.com.livelo.starwarsapi.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmPojo {

	public String title;
	
	@JsonAlias("episode_id")
	public int episodeId;
	
	@JsonAlias("opening_crawl")
	public String openingCrawl;
	
	public String director;
	
	public String producer;
	
	@JsonAlias("release_date")
	public String releaseDate;
	
	public List<String> characters;
	
	public List<String> planets;
	
	public List<String> starships;
	
	public List<String> vehicles;
	
	public List<String> species;
	
	public Date created;
	
	public Date edited;
	
	public String url;

}
