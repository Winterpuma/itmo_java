package com.example.lab.service.impl;

import com.example.lab.domain.dto.BookDto;
import com.example.lab.exception.EntityNotFoundException;
import com.example.lab.exception.NonMatchingIdException;
import com.example.lab.mapper.BookMapper;
import com.example.lab.repository.BookRepository;
import com.example.lab.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookMapper mapper;
    private final BookRepository bookRepository;

    public BookDto find(UUID id) {
        return mapper.map(bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, true)));
    }

    public BookDto add(BookDto book) {
        UUID id = UUID.randomUUID();
        book.setId(id);
        return mapper.map(
                bookRepository.save(mapper.map(book))
        );
    }


    public BookDto update(BookDto book) {
        if (bookRepository.existsById(book.getId())) {
            return mapper.map(
                    bookRepository.save(mapper.map(book)));
        } else {
            throw new EntityNotFoundException(book.getId(), true);
        }
    }


    public void delete(UUID id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(id, true);
        }
    }
}
