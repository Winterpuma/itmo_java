package com.example.lab.controller;

import com.example.lab.domain.dto.BookDto;
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

@RequestMapping("library/v1/book")
public interface BookController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void addBook(@RequestBody BookDto book);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    BookDto getBook(@PathVariable("id") int bookId);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<BookDto> getAllBooks();

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void updateBook(@RequestBody BookDto book);

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteBook(@PathVariable("id") int bookId);
}
