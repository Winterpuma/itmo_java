package com.example.lab.client.service;

import com.example.lab.client.client.BookClient;
import com.example.lab.client.model.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final BookClient bookClient;

    public BookDto getBookForId(int id) {
        return bookClient.getBook(id);
    }
}
