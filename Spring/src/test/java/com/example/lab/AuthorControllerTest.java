package com.example.lab;


import com.example.lab.controller.AuthorController;
import com.example.lab.domain.dto.AuthorAllDto;
import com.example.lab.service.AuthorService;
// import org.junit.Test; wrong
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    private static final String LIBRARY = "/library/v1/author";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuthorService service;

    @Test
    public void givenAuthors_whenGetAuthors_thenReturnJsonArray()
            throws Exception {

        AuthorAllDto alex = new AuthorAllDto();
        alex.setName("Alex");

        List<AuthorAllDto> allEmployees = Arrays.asList(alex);

        given(service.findAll()).willReturn(allEmployees);

        mvc.perform(get(LIBRARY)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(alex.getName())));
    }

    @Test
    public void givenAuthor_whenGetAuthor_thenReturnJsonArray()
            throws Exception {

        AuthorAllDto alex = new AuthorAllDto();
        alex.setName("Alex");

        List<AuthorAllDto> allEmployees = Arrays.asList(alex);

        given(service.findAll()).willReturn(allEmployees);

        mvc.perform(get(LIBRARY)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(alex.getName())));
    }
}