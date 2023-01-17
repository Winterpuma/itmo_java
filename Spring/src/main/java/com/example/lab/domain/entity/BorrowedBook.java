package com.example.lab.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BorrowedBook {
    @Id
    private String id;
}
