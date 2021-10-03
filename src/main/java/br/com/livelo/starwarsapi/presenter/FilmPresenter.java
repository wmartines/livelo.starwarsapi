package br.com.livelo.starwarsapi.presenter;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor	
public class FilmPresenter {
	
	public String title;
	
	public int episodeId;
	
	public String openingCrawl;
	
	public String director;
	
	public String producer;
	
	public String releaseDate;
	
	@JsonInclude(Include.NON_NULL)
	public List<PeoplePresenter> characters;
	
	public Date created;
	
	public Date edited;
	
	public String url;

}
