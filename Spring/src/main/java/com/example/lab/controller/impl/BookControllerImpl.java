package com.example.lab.controller.impl;

import com.example.lab.controller.BookController;
import com.example.lab.domain.dto.BookDto;
import com.example.lab.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    public void addBook(BookDto book) {
        bookService.add(book);
    }

    public BookDto getBook(int bookId) {
        return bookService.find(bookId);
    }

    public List<BookDto> getAllBooks() {
        return bookService.findAll();
    }

    public void updateBook(BookDto book) {
        bookService.update(book);
    }

    public void deleteBook(int bookId) {
        bookService.delete(bookId);
    }
}
