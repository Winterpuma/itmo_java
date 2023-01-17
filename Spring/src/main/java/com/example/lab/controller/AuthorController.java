package com.example.lab.controller;

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

import java.util.UUID;

@RequestMapping("library/v1/author")
public interface AuthorController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AuthorDto addAuthor(@RequestBody AuthorDto author);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    AuthorDto getAuthor(@PathVariable("id") UUID authorId);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AuthorDto updateAuthor(@RequestBody AuthorDto author);

    @DeleteMapping(value = "/{id}")
    void deleteAuthor(@PathVariable("id") UUID authorId);
}
