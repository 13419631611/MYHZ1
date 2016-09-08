package com.mycarhz.myhz.bean;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Register {
    private String id;

    private String error;

    private String msg;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setError(String error){
        this.error = error;
    }
    public String getError(){
        return this.error;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
}
