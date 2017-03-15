package com.umberapp.umber.models;

public class FeedbackUser {
    String comment;
    String id;
    String orderId;
    double star;
    String user;

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getStar() {
        return this.star;
    }

    public void setStar(double star) {
        this.star = star;
    }
}
