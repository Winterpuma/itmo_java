package com.example.lab.service.impl;

import com.example.lab.domain.dto.AuthorDto;
import com.example.lab.exception.EntityNotFoundException;
import com.example.lab.mapper.AuthorMapper;
import com.example.lab.repository.AuthorRepository;
import com.example.lab.service.AuthorService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Data
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper mapper;


    public AuthorDto find(UUID id) {
        return mapper.map(authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, true)));
    }

    public AuthorDto add(AuthorDto author) {
        return mapper.map(authorRepository.save(mapper.map(author)));
    }

    public AuthorDto update(AuthorDto author) {
        if (authorRepository.existsById(author.getId())) {
            return mapper.map(authorRepository.save(mapper.map(author)));
        } else {
            throw new EntityNotFoundException(author.getId(), true);
        }
    }

    public void delete(UUID id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(id, true);
        }
    }
}
