package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Content implements Parcelable {
    public static final Creator<Content> CREATOR;
    Fields fields;
    String message;
    String title;

    /* renamed from: com.umberapp.umber.models.Content.1 */
    static class C14341 implements Creator<Content> {
        C14341() {
        }

        public Content createFromParcel(Parcel in) {
            return new Content(in);
        }

        public Content[] newArray(int size) {
            return new Content[size];
        }
    }

    protected Content(Parcel in) {
        this.message = in.readString();
        this.title = in.readString();
        this.fields = (Fields) in.readParcelable(Fields.class.getClassLoader());
    }

    static {
        CREATOR = new C14341();
    }

    public Fields getFields() {
        return this.fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.message);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.fields, i);
    }
}
