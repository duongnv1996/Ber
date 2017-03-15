package com.umberapp.umber.models;

public class Day {
    int id;
    boolean isCheck;
    String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public void setCheck(boolean check) {
        this.isCheck = check;
    }
}
