package com.example.lab.client.controller;

import com.example.lab.client.service.LibraryService;
import com.example.lab.client.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library-client")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/book", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookDto book) {
        libraryService.addBook(book);
    }

    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto getBook(@PathVariable("id") int bookId) {
        return libraryService.getBookForId(bookId);
    }

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDto> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @PutMapping(value = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateBook(@RequestBody BookDto book) {
        libraryService.updateBook(book);
    }

    @DeleteMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteBook(@PathVariable("id") int bookId) {
        libraryService.deleteBook(bookId);
    }
}
