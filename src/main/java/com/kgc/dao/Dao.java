package com.kgc.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
    void insert(T t);

    void delete(Serializable id);

    void update(T t);

    T findById(Serializable id);

    List<T> findAll();
}
