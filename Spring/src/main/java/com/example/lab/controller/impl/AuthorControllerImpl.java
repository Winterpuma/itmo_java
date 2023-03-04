package com.example.lab.controller.impl;

import com.example.lab.controller.AuthorController;
import com.example.lab.domain.dto.AuthorAllDto;
import com.example.lab.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService authorService;

    public void addAuthor(AuthorAllDto author) {
        authorService.add(author);
    }

    public List<AuthorAllDto> getAllAuthors() {
        return authorService.findAll();
    }

    public AuthorAllDto getAuthor(int authorId) {
        return authorService.find(authorId);
    }

    public void updateAuthor(AuthorAllDto author) {
        authorService.update(author);
    }

    public void deleteAuthor(int authorId) {
        authorService.delete(authorId);
    }

    public String test() { return "test"; }//"{name: \"test\"}";}
}
