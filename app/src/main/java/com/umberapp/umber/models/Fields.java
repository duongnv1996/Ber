package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Fields implements Parcelable {
    public static final Creator<Fields> CREATOR;
    double costForTime;
    double costHour;
    double materialCost;
    String orderId;
    String statusOrder;
    double times;
    double totalCost;

    /* renamed from: com.umberapp.umber.models.Fields.1 */
    static class C14351 implements Creator<Fields> {
        C14351() {
        }

        public Fields createFromParcel(Parcel in) {
            return new Fields(in);
        }

        public Fields[] newArray(int size) {
            return new Fields[size];
        }
    }

    protected Fields(Parcel in) {
        this.orderId = in.readString();
        this.costForTime = in.readDouble();
        this.costHour = in.readDouble();
        this.materialCost = in.readDouble();
        this.statusOrder = in.readString();
        this.times = in.readDouble();
        this.totalCost = in.readDouble();
    }

    static {
        CREATOR = new C14351();
    }

    public double getCostForTime() {
        return this.costForTime;
    }

    public void setCostForTime(double costForTime) {
        this.costForTime = costForTime;
    }

    public double getCostHour() {
        return this.costHour;
    }

    public void setCostHour(double costHour) {
        this.costHour = costHour;
    }

    public double getMaterialCost() {
        return this.materialCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public double getTimes() {
        return this.times;
    }

    public void setTimes(double times) {
        this.times = times;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatusOrder() {
        return this.statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.orderId);
        parcel.writeDouble(this.costForTime);
        parcel.writeDouble(this.costHour);
        parcel.writeDouble(this.materialCost);
        parcel.writeString(this.statusOrder);
        parcel.writeDouble(this.times);
        parcel.writeDouble(this.totalCost);
    }
}
