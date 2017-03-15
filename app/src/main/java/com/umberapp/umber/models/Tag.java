package com.umberapp.umber.models;

public class Tag {
    String id;
    String text;

    public Tag(String tag) {
        this.text = tag;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
