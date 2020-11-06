package com.kgc.entity;

import java.util.Date;

public class User {
    private Integer user_id;
    private String user_num;
    private String user_name;
    private String user_addr;
    private Date create_date;
    private Integer cards_id;

    private String card_name;

    public User() {
    }

    public User(Integer user_id, String user_num, String user_name, String user_addr, Date create_date, Integer cards_id) {
        this.user_id = user_id;
        this.user_num = user_num;
        this.user_name = user_name;
        this.user_addr = user_addr;
        this.create_date = create_date;
        this.cards_id = cards_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_num() {
        return user_num;
    }

    public void setUser_num(String user_num) {
        this.user_num = user_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_addr() {
        return user_addr;
    }

    public void setUser_addr(String user_addr) {
        this.user_addr = user_addr;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Integer getCards_id() {
        return cards_id;
    }

    public void setCards_id(Integer cards_id) {
        this.cards_id = cards_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_num='" + user_num + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_addr='" + user_addr + '\'' +
                ", create_date=" + create_date +
                ", cards_id=" + cards_id +
                '}';
    }
}
