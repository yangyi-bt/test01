package com.kgc.service.impl;

import com.kgc.dao.UserDao;
import com.kgc.dao.impl.UserDaoImpl;
import com.kgc.entity.User;
import com.kgc.service.UserService;
import com.kgc.utils.PageBean;

import java.io.Serializable;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public int getRows(User user) {
        return userDao.getRows(user);
    }

    @Override
    public List<User> findAll(PageBean pageBean, User user) {
        return userDao.findAll(pageBean,user);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void delete(Serializable id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User findById(Serializable id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
