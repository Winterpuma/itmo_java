package com.example.lab.client.model;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private int id;
    private String title;
    private Date releaseDate;
    private Set<AuthorDto> authors;
}
