package com.kgc.service.impl;

import com.kgc.dao.CardDao;
import com.kgc.dao.impl.CardDaoImpl;
import com.kgc.entity.Card;
import com.kgc.service.CardService;

import java.io.Serializable;
import java.util.List;

public class CardServiceImpl implements CardService {
    private CardDao cardDao = new CardDaoImpl();
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
        return cardDao.findAll();
    }
}
