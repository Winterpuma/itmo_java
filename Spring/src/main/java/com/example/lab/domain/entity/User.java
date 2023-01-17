package com.example.lab.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "_user")
public class User {
    @Id
    private String id;
}
