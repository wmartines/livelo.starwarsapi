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
class PeopleTest {
	
	/** The mvc. */
    @Autowired
    public MockMvc mvc;

	@Test
	void testA_shoud_find_people_2() throws Exception {
		
		mvc.perform(get("/people/2")
				.headers(HttpHeaders.EMPTY))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("C-3PO")))
                .andExpect(jsonPath("$.height", is("167")))
                .andExpect(jsonPath("$.mass", is("75")))
                .andExpect(jsonPath("$.hairColor", is("n/a")))
                .andExpect(jsonPath("$.skinColor", is("gold")))
                .andExpect(jsonPath("$.eyeColor", is("yellow")))
                .andExpect(jsonPath("$.birthYear", is("112BBY")))
                .andExpect(jsonPath("$.gender", is("n/a")))
                .andExpect(jsonPath("$.films", iterableWithSize(6)))
                .andExpect(jsonPath("$.films[*].title", hasItem("A New Hope")))
                .andExpect(jsonPath("$.films[*].title", hasItem("The Empire Strikes Back")))
                .andExpect(jsonPath("$.films[*].title", hasItem("Return of the Jedi")))
                .andExpect(jsonPath("$.films[*].title", hasItem("The Phantom Menace")))
                .andExpect(jsonPath("$.films[*].title", hasItem("Attack of the Clones")))
                .andExpect(jsonPath("$.films[*].title", hasItem("Revenge of the Sith")))
                .andExpect(jsonPath("$.created", is("2014-12-10T15:10:51.357+00:00")))
                .andExpect(jsonPath("$.edited", is("2014-12-20T21:17:50.309+00:00")))
                .andExpect(jsonPath("$.url", is("https://swapi.dev/api/people/2/")));
	}

}
