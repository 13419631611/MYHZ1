package com.mycarhz.myhz.bean;

/**
 * Created by Administrator on 2016/9/5.
 */
public class MyAllInfo {
    String title;
    int money;
    int pb;
    int people;
    int no_money;
    int type;

    public MyAllInfo() {
    }

    public MyAllInfo(String title, int money, int pb, int people, int no_money, int type) {
        this.title = title;
        this.money = money;
        this.pb = pb;
        this.people = people;
        this.no_money = no_money;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPb() {
        return pb;
    }

    public void setPb(int pb) {
        this.pb = pb;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getNo_money() {
        return no_money;
    }

    public void setNo_money(int no_money) {
        this.no_money = no_money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Raise{" +
                "title='" + title + '\'' +
                ", money=" + money +
                ", pb=" + pb +
                ", people=" + people +
                ", no_money=" + no_money +
                '}';
    }
}
