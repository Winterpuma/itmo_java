package com.example.lab.domain.dto;

import com.example.lab.domain.model.BookState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
public class BookDto implements Serializable {
    private UUID id;

    private String title;

    private Date year;

    private BookState state;

    private Set<AuthorDto> authors;
}
