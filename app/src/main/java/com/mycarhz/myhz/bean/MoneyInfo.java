package com.mycarhz.myhz.bean;

/**
 * Created by Administrator on 2016/9/2.
 */
public class MoneyInfo {
    String date;
    String type;
    String money;
    String shuoming;

    public MoneyInfo() {
    }

    public MoneyInfo(String date, String type, String money, String shuoming) {
        this.date = date;
        this.type = type;
        this.money = money;
        this.shuoming = shuoming;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getShuoming() {
        return shuoming;
    }

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming;
    }

    @Override
    public String toString() {
        return "MoneyInfo{" +
                "date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", money='" + money + '\'' +
                ", shuoming='" + shuoming + '\'' +
                '}';
    }
}
