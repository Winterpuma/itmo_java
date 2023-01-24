package com.example.lab.service.impl;

import com.example.lab.domain.dto.AuthorDto;
import com.example.lab.domain.dto.BookDto;
import com.example.lab.domain.entity.Author;
import com.example.lab.domain.entity.Book;
import com.example.lab.exception.EntityNotFoundException;
import com.example.lab.exception.NonMatchingIdException;
import com.example.lab.mapper.BookMapper;
import com.example.lab.mapper.MapStructMapper;
import com.example.lab.repository.BookRepository;
import com.example.lab.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final MapStructMapper mapper;

    public BookDto find(int id) {
        return mapper.map(bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, true)));
    }

    public List<BookDto> findAll() {
        return mapper.mapListBook(bookRepository.findAll());
    }

    public void add(BookDto book) {
        bookRepository.save(mapper.map(book));
    }

    public void update(BookDto book) {
        if (bookRepository.existsById(book.getId())) {
            bookRepository.save(mapper.map(book));
        } else {
            throw new EntityNotFoundException(book.getId(), true);
        }
    }


    public void delete(int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(id, true);
        }
    }
}
