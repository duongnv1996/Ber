package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;

public class AuthResponse
{
  @SerializedName("code")
  public String code;
  @SerializedName("data")
  public Data data;
  @SerializedName("error_message")
  public String error_message;
  @SerializedName("phone")
  public String phone;
  
  public String getCode()
  {
    return this.code;
  }
  
  public Data getData()
  {
    return this.data;
  }
  
  public String getError_message()
  {
    return this.error_message;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
  }
  
  public void setData(Data paramData)
  {
    this.data = paramData;
  }
  
  public void setError_message(String paramString)
  {
    this.error_message = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public String toString()
  {
    return "AuthResponse{code='" + this.code + '\'' + ", error_message='" + this.error_message + '\'' + ", data=" + this.data + '}';
  }
  
  public static class Data
  {
    @SerializedName("email")
    public String email;
    @SerializedName("name")
    public String name;
    @SerializedName("phone")
    public String phone;
    
    public String getEmail()
    {
      return this.email;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public String getPhone()
    {
      return this.phone;
    }
    
    public void setEmail(String paramString)
    {
      this.email = paramString;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setPhone(String paramString)
    {
      this.phone = paramString;
    }
  }
}

