package com.kgc.dao.impl;

import com.kgc.dao.UserDao;
import com.kgc.entity.User;
import com.kgc.utils.DataSourcePooled;
import com.kgc.utils.EmptyUtils;
import com.kgc.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private QueryRunner runner = new QueryRunner(DataSourcePooled.getDataSource());
    @Override
    public int getRows(User user) {
        String sql = "select count(*) from user where 1=1 ";
        if (user.getCards_id() != -1){
            sql += " and user.cards_id = "+user.getCards_id();
        }
        if (user.getUser_name() != null){
            sql += " and user.user_name like '%"+user.getUser_name()+"%' ";
        }
        Long num = 0L;
        try {
            num = runner.query(sql, new ScalarHandler<Long>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num.intValue();
    }

    @Override
    public List<User> findAll(PageBean pageBean, User user) {
        String sql = "select user.user_id,user.user_num,user.user_name," +
                "user.user_addr,user.create_date,user.cards_id,card.card_name " +
                "from user,card where user.cards_id=card.card_id ";
        if (EmptyUtils.isNotEmpty(user.getUser_name())){
            sql += " and user.user_name like '%"+user.getUser_name()+"%' ";
        }
        if (user.getCards_id() != -1){
            sql += " and user.cards_id ="+user.getCards_id();
        }
        sql += " limit ?,?";
        List<User> list = null;
        try {
            list = runner.query(sql,new BeanListHandler<User>(User.class),
                    (pageBean.getCurrentPage() - 1)*pageBean.getPageSize(),pageBean.getPageSize());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(User user) {
        String sql = "insert into user values (null,?,?,?,null,?)";
        Object[] params = {user.getUser_num(),user.getUser_name(),user.getUser_addr(),
        user.getCards_id()};
        try {
            runner.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Serializable id) {
        String sql = "delete from user where user_id=?";
        try {
            runner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String sql = "update user set user_name=?,user_addr=?,cards_id=? where user_id=?";
        Object[] params = {user.getUser_name(),user.getUser_addr(),user.getCards_id(),user.getUser_id()};
        try {
            runner.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(Serializable id) {
        String sql = "select * from user where user_id =?";
        User user = null;
        try {
            user = runner.query(sql,new BeanHandler<User>(User.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
