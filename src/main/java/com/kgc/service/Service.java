package com.kgc.service;

import java.io.Serializable;
import java.util.List;

public interface Service<T> {
    void insert(T t);

    void delete(Serializable id);

    void update(T t);

    T findById(Serializable id);

    List<T> findAll();
}
