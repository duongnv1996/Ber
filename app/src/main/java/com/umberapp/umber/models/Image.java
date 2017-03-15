package com.umberapp.umber.models;

import android.graphics.Bitmap;

public class Image {
    int id;
    String path;
    Bitmap photo;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Bitmap getPhoto() {
        return this.photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}
