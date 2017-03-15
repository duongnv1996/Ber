package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;

public class Config {
    @SerializedName("cancelFee")
    public int cancelFee;
    @SerializedName("chargeFee")
    public int chargeFee;
    @SerializedName("currency")
    public String currency;
    @SerializedName("language")
    public String language;

    public int getCancelFee() {
        return this.cancelFee;
    }

    public void setCancelFee(int cancelFee) {
        this.cancelFee = cancelFee;
    }

    public int getChargeFee() {
        return this.chargeFee;
    }

    public void setChargeFee(int chargeFee) {
        this.chargeFee = chargeFee;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
