package com.houseofcode.abdulg.login.ui.adapters.models;

/**
 * Created by Abdullah on 14-09-2016.
 */
public class UserInfoDataObject {
    private String title;
    private String text;

    public UserInfoDataObject(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
