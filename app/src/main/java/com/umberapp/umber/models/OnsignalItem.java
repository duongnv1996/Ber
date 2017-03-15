package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class OnsignalItem implements Parcelable {
    public static final Creator<OnsignalItem> CREATOR;
    String expertId;
    Fields fields;
    @SerializedName("orderId")
    public String orderId;
    @SerializedName("status")
    public String status;
    @SerializedName("type")
    public String type;

    /* renamed from: com.umberapp.umber.models.OnsignalItem.1 */
    static class C14371 implements Creator<OnsignalItem> {
        C14371() {
        }

        public OnsignalItem createFromParcel(Parcel in) {
            return new OnsignalItem(in);
        }

        public OnsignalItem[] newArray(int size) {
            return new OnsignalItem[size];
        }
    }

    protected OnsignalItem(Parcel in) {
        this.orderId = in.readString();
        this.type = in.readString();
        this.status = in.readString();
        this.fields = (Fields) in.readParcelable(Fields.class.getClassLoader());
        this.expertId = in.readString();
    }

    static {
        CREATOR = new C14371();
    }

    public String getExpertId() {
        return this.expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public Fields getFields() {
        return this.fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.orderId);
        parcel.writeString(this.type);
        parcel.writeString(this.status);
        parcel.writeParcelable(this.fields, i);
        parcel.writeString(this.expertId);
    }
}
