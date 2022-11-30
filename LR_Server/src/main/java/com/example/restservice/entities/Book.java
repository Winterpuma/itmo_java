package com.example.restservice.entities;

import java.util.List;

public class Book {
    private final long id;
    private final List<Author> authors;

    public Book(long id, List<Author> authors) {
        this.id = id;
        this.authors = authors;
    }

    public long getId() {
        return id;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
