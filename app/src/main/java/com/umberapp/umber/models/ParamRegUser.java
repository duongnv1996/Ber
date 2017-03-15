package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ParamRegUser implements Parcelable {
    public static final Creator<ParamRegUser> CREATOR;
    String address;
    String avatar;
    double balance;
    String birthday;
    String braintreeCustomerId;
    List<Category> categories;
    String coordinates;
    String email;
    String expiresln;
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

    /* renamed from: com.umberapp.umber.models.ParamRegUser.1 */
    static class C14381 implements Creator<ParamRegUser> {
        C14381() {
        }

        public ParamRegUser createFromParcel(Parcel in) {
            return new ParamRegUser(in);
        }

        public ParamRegUser[] newArray(int size) {
            return new ParamRegUser[size];
        }
    }

    protected ParamRegUser(Parcel in) {
        this.token = in.readString();
        this.expiresln = in.readString();
        this.username = in.readString();
        this.email = in.readString();
        this.isCustomer = in.readByte() != null;
        this.status = in.readInt();
        this.balance = in.readDouble();
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
        this.ready = in.readString();
        this.coordinates = in.readString();
        this.password = in.readString();
    }

    static {
        CREATOR = new C14381();
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getReady() {
        return this.ready;
    }

    public void setReady(String ready) {
        this.ready = ready;
    }

    public ParamRegUser(String address, String birthday, String email, String first_name, String gender, boolean isCustomer, String last_name, String phone, String ref, String username, String pass) {
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.first_name = first_name;
        this.gender = gender;
        this.isCustomer = isCustomer;
        this.last_name = last_name;
        this.phone = phone;
        this.ref = ref;
        this.username = username;
        this.password = pass;
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

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.token);
        parcel.writeString(this.expiresln);
        parcel.writeString(this.username);
        parcel.writeString(this.email);
        parcel.writeByte((byte) (this.isCustomer ? 1 : 0));
        parcel.writeInt(this.status);
        parcel.writeDouble(this.balance);
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
        parcel.writeString(this.ready);
        parcel.writeString(this.coordinates);
        parcel.writeString(this.password);
    }
}
