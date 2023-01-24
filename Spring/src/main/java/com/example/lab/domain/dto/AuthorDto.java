package com.example.lab.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class AuthorDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;
}