package com.example.lab.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@RequiredArgsConstructor
public class AuthorModel {
    private final String id;

    private final String firstName;

    private final String secondName;
}
