package com.example.lab.client.client;

import com.example.lab.client.model.AuthorAllDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "${author-service-client.name}", url = "${author-service-client.url}")
public interface AuthorClient {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void addAuthor(@RequestBody AuthorAllDto author);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<AuthorAllDto> getAllAuthors();

    @GetMapping(value = "${author-service-client.add-author.url}", produces = MediaType.APPLICATION_JSON_VALUE)
    AuthorAllDto getAuthor(@PathVariable("id") int authorId);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void updateAuthor(@RequestBody AuthorAllDto author);

    @DeleteMapping(value = "${author-service-client.delete-author.url}")
    void deleteAuthor(@PathVariable("id") int authorId);
}
