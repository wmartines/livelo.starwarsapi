package br.com.livelo.starwarsapi;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
class FilmTest {
	
	/** The mvc. */
    @Autowired
    public MockMvc mvc;

	@Test
	void testA_shoud_find_film_2() throws Exception {
		
		mvc.perform(get("/film/2")
				.headers(HttpHeaders.EMPTY))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("The Empire Strikes Back")))
                .andExpect(jsonPath("$.episodeId", is(5)))
                .andExpect(jsonPath("$.director", is("Irvin Kershner")))
                .andExpect(jsonPath("$.producer", is("Gary Kurtz, Rick McCallum")))
                .andExpect(jsonPath("$.releaseDate", is("1980-05-17")))
                .andExpect(jsonPath("$.characters", iterableWithSize(16)))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Luke Skywalker")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("C-3PO")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("R2-D2")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Darth Vader")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Leia Organa")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Obi-Wan Kenobi")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Chewbacca")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Han Solo")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Wedge Antilles")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Yoda")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Palpatine")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Boba Fett")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("IG-88")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Bossk")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Lando Calrissian")))
                .andExpect(jsonPath("$.characters[*].name", hasItem("Lobot")))
                .andExpect(jsonPath("$.created", is("2014-12-12T11:26:24.656+00:00")))
                .andExpect(jsonPath("$.edited", is("2014-12-15T13:07:53.386+00:00")))
                .andExpect(jsonPath("$.url", is("https://swapi.dev/api/films/2/")));
	}	

}
