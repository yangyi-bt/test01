package com.kgc.service;

import com.kgc.dao.Dao;
import com.kgc.entity.User;
import com.kgc.utils.PageBean;

import java.util.List;

public interface UserService extends Dao<User> {
    int getRows(User user);

    List<User> findAll(PageBean pageBean, User user);
}
