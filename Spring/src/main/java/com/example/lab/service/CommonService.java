package com.example.lab.service;

import java.util.UUID;

public interface CommonService<T> {
    T find(UUID id);

    T add(T entity);

    T update(T entity);

    void delete(UUID id);
}
