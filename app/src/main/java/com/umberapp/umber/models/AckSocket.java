package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;

public class AckSocket {
    @SerializedName("body")
    public Body body;
    @SerializedName("headers")
    public Headers headers;
    @SerializedName("statusCode")
    public int statusCode;

    public static class Body {
        @SerializedName("message")
        public String message;
        @SerializedName("notificationUnRead")
        public int notificationUnRead;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getNotificationUnRead() {
            return this.notificationUnRead;
        }

        public void setNotificationUnRead(int notificationUnRead) {
            this.notificationUnRead = notificationUnRead;
        }
    }

    public static class Headers {
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Headers getHeaders() {
        return this.headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
