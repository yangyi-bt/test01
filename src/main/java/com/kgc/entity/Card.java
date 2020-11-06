package com.kgc.entity;

public class Card {
    private Integer card_id;
    private String card_name;

    public Card() {
    }

    public Card(Integer card_id, String card_name) {
        this.card_id = card_id;
        this.card_name = card_name;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", card_name='" + card_name + '\'' +
                '}';
    }
}
