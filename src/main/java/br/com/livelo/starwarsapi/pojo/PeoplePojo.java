package br.com.livelo.starwarsapi.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The Class PeoplePojo.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeoplePojo {
	
	public String name;
    
    public String height;
    
    public String mass;
    
    @JsonAlias("hair_color")
    public String hairColor;
    
    @JsonAlias("skin_color")
    public String skinColor;
    
    @JsonAlias("eye_color")
    public String eyeColor;
    
    @JsonAlias("birth_year")
    public String birthYear;
    
    public String gender;
    
    public String homeworld;
    
    public List<String> films;
    
    public List<String> species;
    
    public List<String> vehicles;
    
    public List<String> starships;
    
    public Date created;
    
    public Date edited;
    
    public String url;

}
