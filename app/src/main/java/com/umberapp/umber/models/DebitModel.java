package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;

public class DebitModel {
    @SerializedName("amount")
    private int amount;
    @SerializedName("callBackUrl")
    private String callBackUrl;
    @SerializedName("currency")
    private String currency;
    @SerializedName("customerCountry")
    private String customerCountry;
    @SerializedName("customerEmail")
    private String customerEmail;
    @SerializedName("customerFullName")
    private String customerFullName;
    @SerializedName("customerPhoneNumber")
    private String customerPhoneNumber;
    @SerializedName("expirationTime")
    private String expirationTime;
    @SerializedName("invoiceCode")
    private String invoiceCode;
    @SerializedName("languageVer")
    private String languageVer;
    @SerializedName("merchantCode")
    private String merchantCode;
    @SerializedName("merchantPass")
    private String merchantPass;
    @SerializedName("merchantReturnUrl")
    private String merchantReturnUrl;
    @SerializedName("padipaySignature")
    private String padipaySignature;
    @SerializedName("transactionTime")
    private String transactionTime;
    @SerializedName("url")
    private String url;

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMerchantCode() {
        return this.merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getMerchantPass() {
        return this.merchantPass;
    }

    public void setMerchantPass(String merchantPass) {
        this.merchantPass = merchantPass;
    }

    public String getInvoiceCode() {
        return this.invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTransactionTime() {
        return this.transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getExpirationTime() {
        return this.expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getMerchantReturnUrl() {
        return this.merchantReturnUrl;
    }

    public void setMerchantReturnUrl(String merchantReturnUrl) {
        this.merchantReturnUrl = merchantReturnUrl;
    }

    public String getLanguageVer() {
        return this.languageVer;
    }

    public void setLanguageVer(String languageVer) {
        this.languageVer = languageVer;
    }

    public String getCustomerFullName() {
        return this.customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return this.customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerCountry() {
        return this.customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCallBackUrl() {
        return this.callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public String getPadipaySignature() {
        return this.padipaySignature;
    }

    public void setPadipaySignature(String padipaySignature) {
        this.padipaySignature = padipaySignature;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
