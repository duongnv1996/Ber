package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailOrderItem {
    @SerializedName("address")
    private String address;
    @SerializedName("audio")
    private String audio;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("category")
    private Category category;
    @SerializedName("costHour")
    private int costHour;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("customer")
    private User customer;
    @SerializedName("dateBooking")
    private long dateBooking;
    @SerializedName("decline")
    private User decline;
    @SerializedName("detailDecline")
    private String detailDecline;
    @SerializedName("expertsJoined")
    private List<ExpertBit> exoertsJoined;
    @SerializedName("expert")
    private Expert expert;
    @SerializedName("expertsFinding")
    private List<String> expertsFinding;
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("hasSend")
    private String hasSend;
    @SerializedName("id")
    private String id;
    @SerializedName("invoice")
    private String invoice;
    @SerializedName("jobsDone")
    private int jobsDone;
    @SerializedName("last_name")
    private String last_name;
    @SerializedName("payment")
    private String payment;
    @SerializedName("rangeTime")
    private RangeTime rangeTime;
    @SerializedName("rating")
    private String rating;
    @SerializedName("status")
    private String status;
    @SerializedName("tags")
    private List<Tag> tags;
    @SerializedName("totalOrderSuccess")
    private int totalOrderSuccess;
    @SerializedName("transaction")
    private String transaction;
    @SerializedName("updatedAt")
    private String updatedAt;

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ExpertBit> getExoertsJoined() {
        return this.exoertsJoined;
    }

    public void setExoertsJoined(List<ExpertBit> exoertsJoined) {
        this.exoertsJoined = exoertsJoined;
    }

    public Expert getExpert() {
        return this.expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public RangeTime getRangeTime() {
        return this.rangeTime;
    }

    public void setRangeTime(RangeTime rangeTime) {
        this.rangeTime = rangeTime;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAudio() {
        return this.audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public long getDateBooking() {
        return this.dateBooking;
    }

    public void setDateBooking(long dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getTotalOrderSuccess() {
        return this.totalOrderSuccess;
    }

    public void setTotalOrderSuccess(int totalOrderSuccess) {
        this.totalOrderSuccess = totalOrderSuccess;
    }

    public int getCostHour() {
        return this.costHour;
    }

    public void setCostHour(int costHour) {
        this.costHour = costHour;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPayment() {
        return this.payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDetailDecline() {
        return this.detailDecline;
    }

    public void setDetailDecline(String detailDecline) {
        this.detailDecline = detailDecline;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getJobsDone() {
        return this.jobsDone;
    }

    public void setJobsDone(int jobsDone) {
        this.jobsDone = jobsDone;
    }

    public User getCustomer() {
        return this.customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getDecline() {
        return this.decline;
    }

    public void setDecline(User decline) {
        this.decline = decline;
    }

    public List<String> getExpertsFinding() {
        return this.expertsFinding;
    }

    public void setExpertsFinding(List<String> expertsFinding) {
        this.expertsFinding = expertsFinding;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
