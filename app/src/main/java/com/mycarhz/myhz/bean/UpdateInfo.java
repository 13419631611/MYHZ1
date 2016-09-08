package com.mycarhz.myhz.bean;

/**
 * Created by Administrator on 2016/8/30.
 */
public class UpdateInfo {

    String Version;
    String Url;
    String Description;

    public UpdateInfo() {
    }

    public UpdateInfo(String version, String url, String description) {
        Version = version;
        Url = url;
        Description = description;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
