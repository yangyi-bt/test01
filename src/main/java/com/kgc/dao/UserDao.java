package com.kgc.dao;

import com.kgc.entity.User;
import com.kgc.utils.PageBean;

import java.util.List;

public interface UserDao extends Dao<User> {
    int getRows(User user);

    List<User> findAll(PageBean pageBean,User user);
}
