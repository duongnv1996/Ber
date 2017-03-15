package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {
    public static final Creator<User> CREATOR;
    String accessToken;
    String address;
    String avatar;
    @SerializedName("balance")
    long balance;
    String birthday;
    String braintreeCustomerId;
    String email;
    String expiresln;
    String facebookId;
    String first_name;
    String gender;
    String id;
    boolean isCustomer;
    String last_name;
    String password;
    String phone;
    int rating;
    String ready;
    String ref;
    int smsCode;
    int status;
    long timeSendSMS;
    String token;
    String username;

    /* renamed from: com.umberapp.umber.models.User.1 */
    static class C14391 implements Creator<User> {
        C14391() {
        }

        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    }

    protected User(Parcel in) {
        this.token = in.readString();
        this.accessToken = in.readString();
        this.expiresln = in.readString();
        this.username = in.readString();
        this.email = in.readString();
        this.isCustomer = in.readByte() != null;
        this.status = in.readInt();
        this.balance = in.readLong();
        this.id = in.readString();
        this.braintreeCustomerId = in.readString();
        this.rating = in.readInt();
        this.smsCode = in.readInt();
        this.timeSendSMS = in.readLong();
        this.first_name = in.readString();
        this.last_name = in.readString();
        this.address = in.readString();
        this.gender = in.readString();
        this.avatar = in.readString();
        this.phone = in.readString();
        this.birthday = in.readString();
        this.ref = in.readString();
        this.password = in.readString();
        this.ready = in.readString();
    }

    static {
        CREATOR = new C14391();
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getReady() {
        return this.ready;
    }

    public void setReady(String ready) {
        this.ready = ready;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public long getBalance() {
        return this.balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBraintreeCustomerId() {
        return this.braintreeCustomerId;
    }

    public void setBraintreeCustomerId(String braintreeCustomerId) {
        this.braintreeCustomerId = braintreeCustomerId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpiresln() {
        return this.expiresln;
    }

    public void setExpiresln(String expiresln) {
        this.expiresln = expiresln;
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

    public boolean isCustomer() {
        return this.isCustomer;
    }

    public void setCustomer(boolean customer) {
        this.isCustomer = customer;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getSmsCode() {
        return this.smsCode;
    }

    public void setSmsCode(int smsCode) {
        this.smsCode = smsCode;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimeSendSMS() {
        return this.timeSendSMS;
    }

    public void setTimeSendSMS(long timeSendSMS) {
        this.timeSendSMS = timeSendSMS;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.token);
        parcel.writeString(this.accessToken);
        parcel.writeString(this.expiresln);
        parcel.writeString(this.username);
        parcel.writeString(this.email);
        parcel.writeByte((byte) (this.isCustomer ? 1 : 0));
        parcel.writeInt(this.status);
        parcel.writeLong(this.balance);
        parcel.writeString(this.id);
        parcel.writeString(this.braintreeCustomerId);
        parcel.writeInt(this.rating);
        parcel.writeInt(this.smsCode);
        parcel.writeLong(this.timeSendSMS);
        parcel.writeString(this.first_name);
        parcel.writeString(this.last_name);
        parcel.writeString(this.address);
        parcel.writeString(this.gender);
        parcel.writeString(this.avatar);
        parcel.writeString(this.phone);
        parcel.writeString(this.birthday);
        parcel.writeString(this.ref);
        parcel.writeString(this.password);
        parcel.writeString(this.ready);
    }
}
