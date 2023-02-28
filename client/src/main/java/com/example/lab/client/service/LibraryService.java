package com.example.lab.client.service;

import com.example.lab.client.client.BookClient;
import com.example.lab.client.model.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final BookClient bookClient;

    public void addBook(BookDto book) {
        bookClient.addBook(book);
    }

    public BookDto getBookForId(int id) {
        return bookClient.getBook(id);
    }

    public List<BookDto> getAllBooks() {
        return bookClient.getAllBooks();
    }

    public void updateBook(BookDto book) {
        bookClient.updateBook(book);
    }

    public void deleteBook(int bookId) {
        bookClient.deleteBook(bookId);
    }
}
