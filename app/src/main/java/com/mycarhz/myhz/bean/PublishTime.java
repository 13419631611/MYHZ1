package com.mycarhz.myhz.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/6.
 */
public class PublishTime implements Serializable{
    private int date;

    private int day;

    private int hours;

    private int minutes;

    private int month;

    private int nanos;

    private int seconds;

    private long time;

    private int timezoneOffset;

    private int year;

    public void setDate(int date){
        this.date = date;
    }
    public int getDate(){
        return this.date;
    }
    public void setDay(int day){
        this.day = day;
    }
    public int getDay(){
        return this.day;
    }
    public void setHours(int hours){
        this.hours = hours;
    }
    public int getHours(){
        return this.hours;
    }
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }
    public int getMinutes(){
        return this.minutes;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public int getMonth(){
        return this.month;
    }
    public void setNanos(int nanos){
        this.nanos = nanos;
    }
    public int getNanos(){
        return this.nanos;
    }
    public void setSeconds(int seconds){
        this.seconds = seconds;
    }
    public int getSeconds(){
        return this.seconds;
    }
    public void setTime(int time){
        this.time = time;
    }
    public long getTime(){
        return this.time;
    }
    public void setTimezoneOffset(int timezoneOffset){
        this.timezoneOffset = timezoneOffset;
    }
    public int getTimezoneOffset(){
        return this.timezoneOffset;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return this.year;
    }

}