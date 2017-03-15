package com.umberapp.umber.models;

import java.util.List;

public class UpcommingItem {
    String address;
    String audio;
    Category category;
    double[] coordinates;
    String createdAt;
    String customer;
    long dateBooking;
    List<String> experts;
    List<String> expertsFinding;
    String hasSend;
    String id;
    String invoice;
    String promotion;
    RangeTime rangeTime;
    String status;
    String updatedAt;

    public double[] getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getPromotion() {
        return this.promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createAt) {
        this.createdAt = createAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAudio() {
        return this.audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public List<String> getExpertsFinding() {
        return this.expertsFinding;
    }

    public void setExpertsFinding(List<String> expertsFinding) {
        this.expertsFinding = expertsFinding;
    }

    public String getHasSend() {
        return this.hasSend;
    }

    public void setHasSend(String hasSend) {
        this.hasSend = hasSend;
    }

    public String getInvoice() {
        return this.invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public long getDateBooking() {
        return this.dateBooking;
    }

    public void setDateBooking(long dateBooking) {
        this.dateBooking = dateBooking;
    }

    public List<String> getExperts() {
        return this.experts;
    }

    public void setExperts(List<String> experts) {
        this.experts = experts;
    }

    public RangeTime getRangeTime() {
        return this.rangeTime;
    }

    public void setRangeTime(RangeTime rangeTime) {
        this.rangeTime = rangeTime;
    }
}
