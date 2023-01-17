package com.example.lab.controller.impl;

import com.example.lab.controller.BookController;
import com.example.lab.domain.dto.BookDto;
import com.example.lab.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    public BookDto addBook(BookDto book) {
        return bookService.add(book);
    }

    public BookDto getBook(UUID bookId) {
        return bookService.find(bookId);
    }

    public BookDto updateBook(BookDto book) {
        return bookService.update(book);
    }

    public void deleteBook(UUID bookId) {
        bookService.delete(bookId);
    }
}
