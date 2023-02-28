package com.example.lab.client.client;

import com.example.lab.client.model.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "${book-service-client.name}", url = "${book-service-client.url}")
public interface BookClient {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void addBook(@RequestBody BookDto book);

    @GetMapping(value = "${book-service-client.retrieve-book.url}", produces = MediaType.APPLICATION_JSON_VALUE)
    BookDto getBook(@PathVariable("id") int bookId);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<BookDto> getAllBooks();

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void updateBook(@RequestBody BookDto book);

    @DeleteMapping(value = "${book-service-client.delete-book.url}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteBook(@PathVariable("id") int bookId);
}
