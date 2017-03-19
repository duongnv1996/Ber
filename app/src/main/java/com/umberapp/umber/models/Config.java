package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;

public class Config
{
  @SerializedName("cancelFee")
  public int cancelFee;
  @SerializedName("chargeFee")
  public int chargeFee;
  @SerializedName("currency")
  public String currency;
  @SerializedName("language")
  public String language;
  
  public int getCancelFee()
  {
    return this.cancelFee;
  }
  
  public int getChargeFee()
  {
    return this.chargeFee;
  }
  
  public String getCurrency()
  {
    return this.currency;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public void setCancelFee(int paramInt)
  {
    this.cancelFee = paramInt;
  }
  
  public void setChargeFee(int paramInt)
  {
    this.chargeFee = paramInt;
  }
  
  public void setCurrency(String paramString)
  {
    this.currency = paramString;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
}

