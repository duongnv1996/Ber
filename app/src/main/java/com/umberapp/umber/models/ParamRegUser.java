package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class ParamRegUser
  implements Parcelable
{
  public static final Creator<ParamRegUser> CREATOR = new Creator()
  {
    public ParamRegUser createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ParamRegUser(paramAnonymousParcel);
    }
    
    public ParamRegUser[] newArray(int paramAnonymousInt)
    {
      return new ParamRegUser[paramAnonymousInt];
    }
  };
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
  
  public ParamRegUser() {}
  
  protected ParamRegUser(Parcel paramParcel)
  {
    this.token = paramParcel.readString();
    this.expiresln = paramParcel.readString();
    this.username = paramParcel.readString();
    this.email = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isCustomer = bool;
      this.status = paramParcel.readInt();
      this.balance = paramParcel.readDouble();
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
      this.ready = paramParcel.readString();
      this.coordinates = paramParcel.readString();
      this.password = paramParcel.readString();
      return;
    }
  }
  
  public ParamRegUser(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    this.address = paramString1;
    this.birthday = paramString2;
    this.email = paramString3;
    this.first_name = paramString4;
    this.gender = paramString5;
    this.isCustomer = paramBoolean;
    this.last_name = paramString6;
    this.phone = paramString7;
    this.ref = paramString8;
    this.username = paramString9;
    this.password = paramString10;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public double getBalance()
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
  
  public List<Category> getCategories()
  {
    return this.categories;
  }
  
  public String getCoordinates()
  {
    return this.coordinates;
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
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public void setBalance(double paramDouble)
  {
    this.balance = paramDouble;
  }
  
  public void setBirthday(String paramString)
  {
    this.birthday = paramString;
  }
  
  public void setBraintreeCustomerId(String paramString)
  {
    this.braintreeCustomerId = paramString;
  }
  
  public void setCategories(List<Category> paramList)
  {
    this.categories = paramList;
  }
  
  public void setCoordinates(String paramString)
  {
    this.coordinates = paramString;
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
    paramParcel.writeString(this.expiresln);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.email);
    if (this.isCustomer) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.status);
      paramParcel.writeDouble(this.balance);
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
      paramParcel.writeString(this.ready);
      paramParcel.writeString(this.coordinates);
      paramParcel.writeString(this.password);
      return;
    }
  }
}

