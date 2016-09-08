package com.mycarhz.myhz.bean;

/**
 * Created by Administrator on 2016/9/2.
 */
public class ClientJJInfo {
    String name;
    String price;
    String money;
    String profit;
    String time;

    public ClientJJInfo() {
    }

    public ClientJJInfo(String name, String price, String money, String profit, String time) {
        this.time = time;
        this.name = name;
        this.price = price;
        this.money = money;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ClientJJInfo{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", money='" + money + '\'' +
                ", profit='" + profit + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
