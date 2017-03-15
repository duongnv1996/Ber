package com.umberapp.umber.models;

public class DataResponse {
    public static final int STATE_CANCEL = -1;
    public static final int STATE_CHANGE = -3;
    public static final int STATE_CONNECT = 1;
    public static final int STATE_DEFAULT = 3;
    private int state;

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
