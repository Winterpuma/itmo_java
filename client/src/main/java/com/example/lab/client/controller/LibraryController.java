package com.example.lab.client.controller;

import com.example.lab.client.model.AuthorAllDto;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/author", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void addAuthor(@RequestBody AuthorAllDto author) {
        libraryService.addAuthor(author);
    }

    @GetMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AuthorAllDto> getAllAuthors() {
        return libraryService.getAllAuthors();
    }

    @GetMapping(value = "/author/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    AuthorAllDto getAuthor(@PathVariable("id") int authorId) {
        return libraryService.getAuthor(authorId);
    }

    @PutMapping(value = "/author", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void updateAuthor(@RequestBody AuthorAllDto author) {
        libraryService.updateAuthor(author);
    }

    @DeleteMapping(value = "/author/{id}")
    void deleteAuthor(@PathVariable("id") int authorId) {
        libraryService.deleteAuthor(authorId);
    }
}
