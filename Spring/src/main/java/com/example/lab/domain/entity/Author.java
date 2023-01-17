package com.example.lab.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
public class Author {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;
}
