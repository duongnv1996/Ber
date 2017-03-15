package com.umberapp.umber.models;

import java.util.List;

public class ExpertMarker extends User {
    String cashPayment;
    List<Category> category;
    double costHour;
    int dateBooking;
    int jobsDone;
    double[] location;
    double maxFeeToPaid;
    RangeTime timeRange;
    int totalOrderSuccess;

    public int getJobsDone() {
        return this.jobsDone;
    }

    public void setJobsDone(int jobsDone) {
        this.jobsDone = jobsDone;
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

    public double[] getLocation() {
        return this.location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    public double getMaxFeeToPaid() {
        return this.maxFeeToPaid;
    }

    public void setMaxFeeToPaid(double maxFeeToPaid) {
        this.maxFeeToPaid = maxFeeToPaid;
    }

    public double getCostHour() {
        return this.costHour;
    }

    public void setCostHour(double costHour) {
        this.costHour = costHour;
    }

    public int getDateBooking() {
        return this.dateBooking;
    }

    public void setDateBooking(int dateBooking) {
        this.dateBooking = dateBooking;
    }

    public RangeTime getTimeRange() {
        return this.timeRange;
    }

    public void setTimeRange(RangeTime timeRange) {
        this.timeRange = timeRange;
    }

    public int getTotalOrderSuccess() {
        return this.totalOrderSuccess;
    }

    public void setTotalOrderSuccess(int totalOrderSuccess) {
        this.totalOrderSuccess = totalOrderSuccess;
    }
}
