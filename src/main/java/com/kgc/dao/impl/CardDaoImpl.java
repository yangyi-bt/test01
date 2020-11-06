package com.kgc.dao.impl;

import com.kgc.dao.CardDao;
import com.kgc.entity.Card;
import com.kgc.utils.DataSourcePooled;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class CardDaoImpl implements CardDao {
    private QueryRunner runner = new QueryRunner(DataSourcePooled.getDataSource());
    @Override
    public void insert(Card card) {

    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public void update(Card card) {

    }

    @Override
    public Card findById(Serializable id) {
        return null;
    }

    @Override
    public List<Card> findAll() {
        String sql = "select * from card";
        List<Card> cards = null;
        try {
            cards = runner.query(sql,new BeanListHandler<Card>(Card.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }
}
