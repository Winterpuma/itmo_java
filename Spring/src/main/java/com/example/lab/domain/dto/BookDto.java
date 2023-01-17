package com.example.lab.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
public class BookDto implements Serializable {
    private UUID id;

    private String title;

    private int releaseYear;

    private Set<UUID> authors;
}
