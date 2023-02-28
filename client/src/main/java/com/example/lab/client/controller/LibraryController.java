package com.example.lab.client.controller;

import com.example.lab.client.service.LibraryService;
import com.example.lab.client.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping(value = "/library-client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto getBook(@PathVariable("id") int bookId) {
        return libraryService.getBookForId(bookId);
    }
}
