package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;

public class AuthResponse {
    @SerializedName("code")
    public String code;
    @SerializedName("data")
    public Data data;
    @SerializedName("error_message")
    public String error_message;
    @SerializedName("phone")
    public String phone;

    public static class Data {
        @SerializedName("email")
        public String email;
        @SerializedName("name")
        public String name;
        @SerializedName("phone")
        public String phone;

        public String getPhone() {
            return this.phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getError_message() {
        return this.error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String toString() {
        return "AuthResponse{code='" + this.code + '\'' + ", error_message='" + this.error_message + '\'' + ", data=" + this.data + '}';
    }
}
