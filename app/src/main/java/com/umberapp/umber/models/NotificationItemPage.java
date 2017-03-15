package com.umberapp.umber.models;

public class NotificationItemPage {
    Content content;
    String createdAt;
    Expert from;
    String id;
    int seen;
    String seenAt;
    String to;
    String type;
    String updatedAt;

    public Content getContent() {
        return this.content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Expert getFrom() {
        return this.from;
    }

    public void setFrom(Expert from) {
        this.from = from;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeenAt() {
        return this.seenAt;
    }

    public void setSeenAt(String seenAt) {
        this.seenAt = seenAt;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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
}
