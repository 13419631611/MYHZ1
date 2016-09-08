package com.mycarhz.myhz.bean;

/**
 * Created by Administrator on 2016/9/1.
 */
public class ClientInfo {
    String imgPath;
    String userName;
    String num;
    String avgDay;
    String hasInterest;
    String phone;

    public ClientInfo(String imgPath, String userName, String num, String avgDay, String hasInterest, String phone) {
        this.imgPath = imgPath;
        this.userName = userName;
        this.num = num;
        this.avgDay = avgDay;
        this.hasInterest = hasInterest;
        this.phone = phone;
    }

    public ClientInfo() {
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAvgDay() {
        return avgDay;
    }

    public void setAvgDay(String avgDay) {
        this.avgDay = avgDay;
    }

    public String getHasInterest() {
        return hasInterest;
    }

    public void setHasInterest(String hasInterest) {
        this.hasInterest = hasInterest;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "imgPath='" + imgPath + '\'' +
                ", userName='" + userName + '\'' +
                ", num='" + num + '\'' +
                ", avgDay='" + avgDay + '\'' +
                ", hasInterest='" + hasInterest + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}


















