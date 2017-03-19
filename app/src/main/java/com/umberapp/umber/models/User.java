package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class User
  implements Parcelable
{
  public static final Creator<User> CREATOR = new Creator()
  {
    public User createFromParcel(Parcel paramAnonymousParcel)
    {
      return new User(paramAnonymousParcel);
    }
    
    public User[] newArray(int paramAnonymousInt)
    {
      return new User[paramAnonymousInt];
    }
  };
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
  
  public User() {}
  
  protected User(Parcel paramParcel)
  {
    this.token = paramParcel.readString();
    this.accessToken = paramParcel.readString();
    this.expiresln = paramParcel.readString();
    this.username = paramParcel.readString();
    this.email = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isCustomer = bool;
      this.status = paramParcel.readInt();
      this.balance = paramParcel.readLong();
      this.id = paramParcel.readString();
      this.braintreeCustomerId = paramParcel.readString();
      this.rating = paramParcel.readInt();
      this.smsCode = paramParcel.readInt();
      this.timeSendSMS = paramParcel.readLong();
      this.first_name = paramParcel.readString();
      this.last_name = paramParcel.readString();
      this.address = paramParcel.readString();
      this.gender = paramParcel.readString();
      this.avatar = paramParcel.readString();
      this.phone = paramParcel.readString();
      this.birthday = paramParcel.readString();
      this.ref = paramParcel.readString();
      this.password = paramParcel.readString();
      this.ready = paramParcel.readString();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccessToken()
  {
    return this.accessToken;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public long getBalance()
  {
    return this.balance;
  }
  
  public String getBirthday()
  {
    return this.birthday;
  }
  
  public String getBraintreeCustomerId()
  {
    return this.braintreeCustomerId;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public String getExpiresln()
  {
    return this.expiresln;
  }
  
  public String getFirst_name()
  {
    return this.first_name;
  }
  
  public String getGender()
  {
    return this.gender;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getLast_name()
  {
    return this.last_name;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public int getRating()
  {
    return this.rating;
  }
  
  public String getReady()
  {
    return this.ready;
  }
  
  public String getRef()
  {
    return this.ref;
  }
  
  public int getSmsCode()
  {
    return this.smsCode;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public long getTimeSendSMS()
  {
    return this.timeSendSMS;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public boolean isCustomer()
  {
    return this.isCustomer;
  }
  
  public void setAccessToken(String paramString)
  {
    this.accessToken = paramString;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public void setBalance(long paramLong)
  {
    this.balance = paramLong;
  }
  
  public void setBirthday(String paramString)
  {
    this.birthday = paramString;
  }
  
  public void setBraintreeCustomerId(String paramString)
  {
    this.braintreeCustomerId = paramString;
  }
  
  public void setCustomer(boolean paramBoolean)
  {
    this.isCustomer = paramBoolean;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setExpiresln(String paramString)
  {
    this.expiresln = paramString;
  }
  
  public void setFirst_name(String paramString)
  {
    this.first_name = paramString;
  }
  
  public void setGender(String paramString)
  {
    this.gender = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setLast_name(String paramString)
  {
    this.last_name = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setRating(int paramInt)
  {
    this.rating = paramInt;
  }
  
  public void setReady(String paramString)
  {
    this.ready = paramString;
  }
  
  public void setRef(String paramString)
  {
    this.ref = paramString;
  }
  
  public void setSmsCode(int paramInt)
  {
    this.smsCode = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setTimeSendSMS(long paramLong)
  {
    this.timeSendSMS = paramLong;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.token);
    paramParcel.writeString(this.accessToken);
    paramParcel.writeString(this.expiresln);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.email);
    if (this.isCustomer) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.status);
      paramParcel.writeLong(this.balance);
      paramParcel.writeString(this.id);
      paramParcel.writeString(this.braintreeCustomerId);
      paramParcel.writeInt(this.rating);
      paramParcel.writeInt(this.smsCode);
      paramParcel.writeLong(this.timeSendSMS);
      paramParcel.writeString(this.first_name);
      paramParcel.writeString(this.last_name);
      paramParcel.writeString(this.address);
      paramParcel.writeString(this.gender);
      paramParcel.writeString(this.avatar);
      paramParcel.writeString(this.phone);
      paramParcel.writeString(this.birthday);
      paramParcel.writeString(this.ref);
      paramParcel.writeString(this.password);
      paramParcel.writeString(this.ready);
      return;
    }
  }
}


