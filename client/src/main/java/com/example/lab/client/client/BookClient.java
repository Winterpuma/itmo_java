package com.example.lab.client.client;

import com.example.lab.client.model.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "${book-service-client.name}", url = "${book-service-client.url}")
public interface BookClient {
    @GetMapping(value = "${book-service-client.retrieve-book.url}", produces = MediaType.APPLICATION_JSON_VALUE)
    BookDto getBook(@PathVariable("id") int bookId);
}
