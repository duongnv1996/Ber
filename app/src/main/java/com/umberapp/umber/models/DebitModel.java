package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;

public class DebitModel
{
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
  
  public int getAmount()
  {
    return this.amount;
  }
  
  public String getCallBackUrl()
  {
    return this.callBackUrl;
  }
  
  public String getCurrency()
  {
    return this.currency;
  }
  
  public String getCustomerCountry()
  {
    return this.customerCountry;
  }
  
  public String getCustomerEmail()
  {
    return this.customerEmail;
  }
  
  public String getCustomerFullName()
  {
    return this.customerFullName;
  }
  
  public String getCustomerPhoneNumber()
  {
    return this.customerPhoneNumber;
  }
  
  public String getExpirationTime()
  {
    return this.expirationTime;
  }
  
  public String getInvoiceCode()
  {
    return this.invoiceCode;
  }
  
  public String getLanguageVer()
  {
    return this.languageVer;
  }
  
  public String getMerchantCode()
  {
    return this.merchantCode;
  }
  
  public String getMerchantPass()
  {
    return this.merchantPass;
  }
  
  public String getMerchantReturnUrl()
  {
    return this.merchantReturnUrl;
  }
  
  public String getPadipaySignature()
  {
    return this.padipaySignature;
  }
  
  public String getTransactionTime()
  {
    return this.transactionTime;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setAmount(int paramInt)
  {
    this.amount = paramInt;
  }
  
  public void setCallBackUrl(String paramString)
  {
    this.callBackUrl = paramString;
  }
  
  public void setCurrency(String paramString)
  {
    this.currency = paramString;
  }
  
  public void setCustomerCountry(String paramString)
  {
    this.customerCountry = paramString;
  }
  
  public void setCustomerEmail(String paramString)
  {
    this.customerEmail = paramString;
  }
  
  public void setCustomerFullName(String paramString)
  {
    this.customerFullName = paramString;
  }
  
  public void setCustomerPhoneNumber(String paramString)
  {
    this.customerPhoneNumber = paramString;
  }
  
  public void setExpirationTime(String paramString)
  {
    this.expirationTime = paramString;
  }
  
  public void setInvoiceCode(String paramString)
  {
    this.invoiceCode = paramString;
  }
  
  public void setLanguageVer(String paramString)
  {
    this.languageVer = paramString;
  }
  
  public void setMerchantCode(String paramString)
  {
    this.merchantCode = paramString;
  }
  
  public void setMerchantPass(String paramString)
  {
    this.merchantPass = paramString;
  }
  
  public void setMerchantReturnUrl(String paramString)
  {
    this.merchantReturnUrl = paramString;
  }
  
  public void setPadipaySignature(String paramString)
  {
    this.padipaySignature = paramString;
  }
  
  public void setTransactionTime(String paramString)
  {
    this.transactionTime = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}

