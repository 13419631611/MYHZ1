package com.mycarhz.myhz.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/6.
 */
public class HomeLunBo implements Serializable{
    private int id;

    private PublishTime publishTime;

    private String companyURL;

    private int ordershort;

    private int serialCount;

    private int type;

    private String companyImg;

    private String companyName;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setPublishTime(PublishTime publishTime){
        this.publishTime = publishTime;
    }
    public PublishTime getPublishTime(){
        return this.publishTime;
    }
    public void setCompanyURL(String companyURL){
        this.companyURL = companyURL;
    }
    public String getCompanyURL(){
        return this.companyURL;
    }
    public void setOrdershort(int ordershort){
        this.ordershort = ordershort;
    }
    public int getOrdershort(){
        return this.ordershort;
    }
    public void setSerialCount(int serialCount){
        this.serialCount = serialCount;
    }
    public int getSerialCount(){
        return this.serialCount;
    }
    public void setType(int type){
        this.type = type;
    }
    public int getType(){
        return this.type;
    }
    public void setCompanyImg(String companyImg){
        this.companyImg = companyImg;
    }
    public String getCompanyImg(){
        return this.companyImg;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    public String getCompanyName(){
        return this.companyName;
    }

}