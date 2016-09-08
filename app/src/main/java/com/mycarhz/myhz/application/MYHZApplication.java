package com.mycarhz.myhz.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/8/26.
 */
public class MYHZApplication  extends Application {


    public static String username;
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MYHZApplication.username = username;
    }

    public static String uid;

    public static String getUid() {
        return uid;
    }

    public static void setUid(String uid) {
        MYHZApplication.uid = uid;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

    }
}
