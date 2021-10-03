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
public class PeoplePresenter {
	
public String name;
    
    public String height;
    
    public String mass;
    
    public String hairColor;
    
    public String skinColor;
    
    public String eyeColor;
    
    public String birthYear;
    
    public String gender;
    
    @JsonInclude(Include.NON_NULL)
    public List<FilmPresenter> films;
    
    public Date created;
    
    public Date edited;
    
    public String url;

}
