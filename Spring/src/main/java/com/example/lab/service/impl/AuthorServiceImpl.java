package com.example.lab.service.impl;

import com.example.lab.domain.dto.AuthorAllDto;
import com.example.lab.domain.dto.AuthorDto;
import com.example.lab.domain.entity.Author;
import com.example.lab.exception.EntityNotFoundException;
import com.example.lab.mapper.AuthorMapper;
import com.example.lab.mapper.MapStructMapper;
import com.example.lab.repository.AuthorRepository;
import com.example.lab.service.AuthorService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
@Data
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final MapStructMapper mapper;

    public AuthorAllDto find(int id) {
        return mapper.mapAll(authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, true)));
    }

    public List<AuthorAllDto> findAll() {
        return mapper.mapListAuthor(authorRepository.findAll());
    }

    public void add(AuthorAllDto author) {
        authorRepository.save(mapper.map(author));
    }

    public void update(AuthorAllDto author) {
        if (authorRepository.existsById(author.getId())) {
            authorRepository.save(mapper.map(author));
        } else {
            throw new EntityNotFoundException(author.getId(), true);
        }
    }

    public void delete(int id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(id, true);
        }
    }
}
