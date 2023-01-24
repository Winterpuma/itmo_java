package com.example.lab.controller;

import com.example.lab.domain.dto.AuthorAllDto;
import com.example.lab.domain.dto.AuthorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequestMapping("library/v1/author")
public interface AuthorController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void addAuthor(@RequestBody AuthorAllDto author);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<AuthorAllDto> getAllAuthors();

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    AuthorAllDto getAuthor(@PathVariable("id") int authorId);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void updateAuthor(@RequestBody AuthorAllDto author);

    @DeleteMapping(value = "/{id}")
    void deleteAuthor(@PathVariable("id") int authorId);
}
