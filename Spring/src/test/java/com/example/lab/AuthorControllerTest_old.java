package com.example.lab;

import com.example.lab.controller.AuthorController;
import com.example.lab.domain.dto.AuthorAllDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest_old {

    private static final String LIBRARY = "/library/v1/author";

    @Autowired
    private WebApplicationContext webApplicationContext;
    //@Autowired
    private MockMvc mvc;

    @MockBean
    private AuthorController authorController;

    @BeforeEach
    public void setup() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void getTest() throws Exception {

        mvc.perform(get(LIBRARY + "/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("test"))
                //.andExpect(jsonPath("$", hasSize(1)))

                .andExpect(jsonPath("$[0].name", is("test")));
    }

    @Test
    public void getAuthors() throws Exception {
        AuthorAllDto author = new AuthorAllDto();
        author.setName("TestName hmm");

        List<AuthorAllDto> allAuthors = singletonList(author);

        given(authorController.getAllAuthors()).willReturn(allAuthors);

        mvc.perform(get(LIBRARY + "")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(author.getName())));
    }

    /*@Test
    public void getArrivalsById() throws Exception {
        Arrival arrival = new Arrival();
        arrival.setCity("Yerevan");

        given(arrivalController.getArrivalById(arrival.getId())).willReturn(arrival);

        mvc.perform(get(VERSION + ARRIVAL + arrival.getId())
                        .with(user("blaze").password("Q1w2e3r4"))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("city", is(arrival.getCity())));
    }*/
}