package com.mycarhz.myhz.bean;

/**
 * Created by Administrator on 2016/8/26.
 */
public class RegisterData {
    private String error;

    private String recivePhone;

    private String randomCode;

    private String msg;

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    public void setRecivePhone(String recivePhone) {
        this.recivePhone = recivePhone;
    }

    public String getRecivePhone() {
        return this.recivePhone;
    }

    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }

    public String getRandomCode() {
        return this.randomCode;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
