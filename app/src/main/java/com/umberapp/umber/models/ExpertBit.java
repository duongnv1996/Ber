package com.umberapp.umber.models;

public class ExpertBit extends User {
    String cashPayment;
    String category;
    double costHour;
    long dateBooking;
    double distance;
    String infoExpert;
    RangeTime timeRange;
    int totalOrderSuccess;

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getCashPayment() {
        return this.cashPayment;
    }

    public void setCashPayment(String cashPayment) {
        this.cashPayment = cashPayment;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInfoExpert() {
        return this.infoExpert;
    }

    public void setInfoExpert(String infoExpert) {
        this.infoExpert = infoExpert;
    }

    public double getCostHour() {
        return this.costHour;
    }

    public void setCostHour(double costHour) {
        this.costHour = costHour;
    }

    public long getDateBooking() {
        return this.dateBooking;
    }

    public void setDateBooking(long dateBooking) {
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
