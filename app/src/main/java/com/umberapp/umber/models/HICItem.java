package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HICItem {
    @SerializedName("address")
    public String address;
    @SerializedName("cashPayment")
    public String cashPayment;
    @SerializedName("category")
    public List<Category> category;
    @SerializedName("categoryForHci")
    public String categoryForHci;
    @SerializedName("costHci")
    public String costHci;
    @SerializedName("createdAt")
    public String createdAt;
    @SerializedName("email")
    public String email;
    @SerializedName("first_name")
    public String first_name;
    @SerializedName("gender")
    public String gender;
    @SerializedName("id")
    public String id;
    @SerializedName("inPatient")
    public String inPatient;
    @SerializedName("infoExpert")
    public String infoExpert;
    @SerializedName("isExpert")
    public boolean isExpert;
    @SerializedName("isHci")
    public boolean isHci;
    @SerializedName("last_name")
    public String last_name;
    @SerializedName("location")
    double[] location;
    @SerializedName("maxFeeToPaid")
    public int maxFeeToPaid;
    @SerializedName("outPatient")
    public String outPatient;
    @SerializedName("password")
    public String password;
    @SerializedName("phone")
    public String phone;
    @SerializedName("phoneHci")
    public String phoneHci;
    @SerializedName("rating")
    public int rating;
    @SerializedName("ready")
    public String ready;
    @SerializedName("specialities")
    public String specialities;
    @SerializedName("status")
    public int status;
    @SerializedName("timeSendSMS")
    public int timeSendSMS;
    @SerializedName("updatedAt")
    public String updatedAt;
    @SerializedName("user")
    public List<User> user;
    @SerializedName("username")
    public String username;

    public static class Category {
        @SerializedName("createdAt")
        public String createdAt;
        @SerializedName("icon")
        public String icon;
        @SerializedName("id")
        public String id;
        @SerializedName("infoExperts")
        public List<InfoExperts> infoExperts;
        @SerializedName("marker")
        public String marker;
        @SerializedName("name")
        public String name;
        @SerializedName("orders")
        public List<Orders> orders;
        @SerializedName("status")
        public int status;
        @SerializedName("tags")
        public List<Tags> tags;
        @SerializedName("updatedAt")
        public String updatedAt;
    }

    public static class InfoExperts {
    }

    public static class Orders {
    }

    public static class Tags {
    }

    public static class User {
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCashPayment() {
        return this.cashPayment;
    }

    public void setCashPayment(String cashPayment) {
        this.cashPayment = cashPayment;
    }

    public List<Category> getCategory() {
        return this.category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public String getCategoryForHci() {
        return this.categoryForHci;
    }

    public void setCategoryForHci(String categoryForHci) {
        this.categoryForHci = categoryForHci;
    }

    public String getCostHci() {
        return this.costHci;
    }

    public void setCostHci(String costHci) {
        this.costHci = costHci;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfoExpert() {
        return this.infoExpert;
    }

    public void setInfoExpert(String infoExpert) {
        this.infoExpert = infoExpert;
    }

    public String getInPatient() {
        return this.inPatient;
    }

    public void setInPatient(String inPatient) {
        this.inPatient = inPatient;
    }

    public boolean isExpert() {
        return this.isExpert;
    }

    public void setExpert(boolean expert) {
        this.isExpert = expert;
    }

    public boolean isHci() {
        return this.isHci;
    }

    public void setHci(boolean hci) {
        this.isHci = hci;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double[] getLocation() {
        return this.location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    public int getMaxFeeToPaid() {
        return this.maxFeeToPaid;
    }

    public void setMaxFeeToPaid(int maxFeeToPaid) {
        this.maxFeeToPaid = maxFeeToPaid;
    }

    public String getOutPatient() {
        return this.outPatient;
    }

    public void setOutPatient(String outPatient) {
        this.outPatient = outPatient;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneHci() {
        return this.phoneHci;
    }

    public void setPhoneHci(String phoneHci) {
        this.phoneHci = phoneHci;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReady() {
        return this.ready;
    }

    public void setReady(String ready) {
        this.ready = ready;
    }

    public String getSpecialities() {
        return this.specialities;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTimeSendSMS() {
        return this.timeSendSMS;
    }

    public void setTimeSendSMS(int timeSendSMS) {
        this.timeSendSMS = timeSendSMS;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<User> getUser() {
        return this.user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
