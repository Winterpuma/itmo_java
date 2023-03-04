package com.example.lab;

import com.example.lab.controller.AuthorController;
import com.example.lab.domain.dto.AuthorAllDto;
import com.example.lab.service.AuthorService;
// import org.junit.Test; wrong
import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    private static final String LIBRARY = "/library/v1/author";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorService service;

    @Test
    public void getAllAuthors()
            throws Exception {

        AuthorAllDto alex = new AuthorAllDto();
        alex.setName("Alex");

        List<AuthorAllDto> allAuthors = Arrays.asList(alex);

        given(service.findAll()).willReturn(allAuthors);

        mockMvc.perform(get(LIBRARY))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(alex.getName())));
    }

    @Test
    public void getAuthorById()
            throws Exception {

        AuthorAllDto alex = new AuthorAllDto();
        alex.setName("Alex");

        given(service.find(1)).willReturn(alex);

        mockMvc.perform(get(LIBRARY + "/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(alex.getName())));
    }

    @Test
    public void deleteAuthorById()
            throws Exception {

        mockMvc.perform(delete(LIBRARY + "/1"))
            .andExpect(status().isOk());
    }

    @Test
    public void createAuthor()
            throws Exception{

        AuthorAllDto alex = new AuthorAllDto();
        alex.setName("Alex");

        mockMvc.perform(post(LIBRARY)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(alex)))
                .andExpect(status().is(201));
    }

    @Test
    public void updateAuthor()
            throws Exception{

        AuthorAllDto alex = new AuthorAllDto();
        alex.setName("Alex");

        mockMvc.perform(put(LIBRARY)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(alex)))
                .andExpect(status().isOk());
    }

    @Test
    public void createAuthorNoBody()
            throws Exception{
        mockMvc.perform(post(LIBRARY).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }
}