package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;

public class NotificationItem implements Parcelable {
    public static final Creator<NotificationItem> CREATOR;
    Content content;
    String from;
    int seen;
    String to;
    String type;

    /* renamed from: com.umberapp.umber.models.NotificationItem.1 */
    static class C14361 implements Creator<NotificationItem> {
        C14361() {
        }

        public NotificationItem createFromParcel(Parcel in) {
            return new NotificationItem(in);
        }

        public NotificationItem[] newArray(int size) {
            return new NotificationItem[size];
        }
    }

    protected NotificationItem(Parcel in) {
        this.type = in.readString();
        this.to = in.readString();
        this.from = in.readString();
        this.seen = in.readInt();
        this.content = (Content) in.readParcelable(Content.class.getClassLoader());
    }

    static {
        CREATOR = new C14361();
    }

    public Content getContent() {
        return this.content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getSeen() {
        return this.seen;
    }

    public void setSeen(int seen) {
        this.seen = seen;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
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
        parcel.writeString(this.type);
        parcel.writeString(this.to);
        parcel.writeString(this.from);
        parcel.writeInt(this.seen);
        parcel.writeParcelable(this.content, i);
    }
}
