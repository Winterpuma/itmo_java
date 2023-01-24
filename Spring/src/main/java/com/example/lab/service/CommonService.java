package com.example.lab.service;

import java.util.List;
import java.util.Set;

public interface CommonService<T> {
    T find(int id);

    List<T> findAll();

    void add(T entity);

    void update(T entity);

    void delete(int id);
}
