package com.example.lab.controller.impl;

import com.example.lab.controller.AuthorController;
import com.example.lab.service.AuthorService;
import com.example.lab.domain.dto.AuthorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService authorService;

    public AuthorDto addAuthor(AuthorDto author) {
        return authorService.add(author);
    }

    public AuthorDto getAuthor(UUID authorId) {
        return authorService.find(authorId);
    }

    public AuthorDto updateAuthor(AuthorDto author) {
        return authorService.update(author);
    }

    public void deleteAuthor(UUID authorId) {
        authorService.delete(authorId);
    }
}
