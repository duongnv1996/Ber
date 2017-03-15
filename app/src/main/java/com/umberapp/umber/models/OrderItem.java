package com.umberapp.umber.models;

import java.util.List;

public class OrderItem {
    String address;
    String audio;
    String category;
    double[] coordinates;
    String createdAt;
    String customer;
    long dateBooking;
    List<String> experts;
    List<String> expertsFinding;
    String hasSend;
    String id;
    String invoice;
    String payment;
    List<Picture> pictures;
    String promotion;
    RangeTime rangeTime;
    String status;
    List<Tag> tags;
    String updatedAt;

    public String getPayment() {
        return this.payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

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

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
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

    public List<Picture> getPictures() {
        return this.pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public RangeTime getRangeTime() {
        return this.rangeTime;
    }

    public void setRangeTime(RangeTime rangeTime) {
        this.rangeTime = rangeTime;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
