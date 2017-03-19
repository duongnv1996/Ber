package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class HICItem
{
  @SerializedName("address")
  public String address;
  @SerializedName("cashPayment")
  public String cashPayment;
  @SerializedName("category")
  public List<Category> category;
  @SerializedName("categoryForHci")
  public String categoryForHci;
  @SerializedName("costHci")
  public String costHci;
  @SerializedName("createdAt")
  public String createdAt;
  @SerializedName("email")
  public String email;
  @SerializedName("first_name")
  public String first_name;
  @SerializedName("gender")
  public String gender;
  @SerializedName("id")
  public String id;
  @SerializedName("inPatient")
  public String inPatient;
  @SerializedName("infoExpert")
  public String infoExpert;
  @SerializedName("isExpert")
  public boolean isExpert;
  @SerializedName("isHci")
  public boolean isHci;
  @SerializedName("last_name")
  public String last_name;
  @SerializedName("location")
  double[] location;
  @SerializedName("maxFeeToPaid")
  public int maxFeeToPaid;
  @SerializedName("outPatient")
  public String outPatient;
  @SerializedName("password")
  public String password;
  @SerializedName("phone")
  public String phone;
  @SerializedName("phoneHci")
  public String phoneHci;
  @SerializedName("rating")
  public int rating;
  @SerializedName("ready")
  public String ready;
  @SerializedName("specialities")
  public String specialities;
  @SerializedName("status")
  public int status;
  @SerializedName("timeSendSMS")
  public int timeSendSMS;
  @SerializedName("updatedAt")
  public String updatedAt;
  @SerializedName("user")
  public List<User> user;
  @SerializedName("username")
  public String username;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getCashPayment()
  {
    return this.cashPayment;
  }
  
  public List<Category> getCategory()
  {
    return this.category;
  }
  
  public String getCategoryForHci()
  {
    return this.categoryForHci;
  }
  
  public String getCostHci()
  {
    return this.costHci;
  }
  
  public String getCreatedAt()
  {
    return this.createdAt;
  }
  
  public String getEmail()
  {
    return this.email;
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
  
  public String getInPatient()
  {
    return this.inPatient;
  }
  
  public String getInfoExpert()
  {
    return this.infoExpert;
  }
  
  public String getLast_name()
  {
    return this.last_name;
  }
  
  public double[] getLocation()
  {
    return this.location;
  }
  
  public int getMaxFeeToPaid()
  {
    return this.maxFeeToPaid;
  }
  
  public String getOutPatient()
  {
    return this.outPatient;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getPhoneHci()
  {
    return this.phoneHci;
  }
  
  public int getRating()
  {
    return this.rating;
  }
  
  public String getReady()
  {
    return this.ready;
  }
  
  public String getSpecialities()
  {
    return this.specialities;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public int getTimeSendSMS()
  {
    return this.timeSendSMS;
  }
  
  public String getUpdatedAt()
  {
    return this.updatedAt;
  }
  
  public List<User> getUser()
  {
    return this.user;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public boolean isExpert()
  {
    return this.isExpert;
  }
  
  public boolean isHci()
  {
    return this.isHci;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setCashPayment(String paramString)
  {
    this.cashPayment = paramString;
  }
  
  public void setCategory(List<Category> paramList)
  {
    this.category = paramList;
  }
  
  public void setCategoryForHci(String paramString)
  {
    this.categoryForHci = paramString;
  }
  
  public void setCostHci(String paramString)
  {
    this.costHci = paramString;
  }
  
  public void setCreatedAt(String paramString)
  {
    this.createdAt = paramString;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setExpert(boolean paramBoolean)
  {
    this.isExpert = paramBoolean;
  }
  
  public void setFirst_name(String paramString)
  {
    this.first_name = paramString;
  }
  
  public void setGender(String paramString)
  {
    this.gender = paramString;
  }
  
  public void setHci(boolean paramBoolean)
  {
    this.isHci = paramBoolean;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setInPatient(String paramString)
  {
    this.inPatient = paramString;
  }
  
  public void setInfoExpert(String paramString)
  {
    this.infoExpert = paramString;
  }
  
  public void setLast_name(String paramString)
  {
    this.last_name = paramString;
  }
  
  public void setLocation(double[] paramArrayOfDouble)
  {
    this.location = paramArrayOfDouble;
  }
  
  public void setMaxFeeToPaid(int paramInt)
  {
    this.maxFeeToPaid = paramInt;
  }
  
  public void setOutPatient(String paramString)
  {
    this.outPatient = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setPhoneHci(String paramString)
  {
    this.phoneHci = paramString;
  }
  
  public void setRating(int paramInt)
  {
    this.rating = paramInt;
  }
  
  public void setReady(String paramString)
  {
    this.ready = paramString;
  }
  
  public void setSpecialities(String paramString)
  {
    this.specialities = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setTimeSendSMS(int paramInt)
  {
    this.timeSendSMS = paramInt;
  }
  
  public void setUpdatedAt(String paramString)
  {
    this.updatedAt = paramString;
  }
  
  public void setUser(List<User> paramList)
  {
    this.user = paramList;
  }
  
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
  
  public static class Category
  {
    @SerializedName("createdAt")
    public String createdAt;
    @SerializedName("icon")
    public String icon;
    @SerializedName("id")
    public String id;
    @SerializedName("infoExperts")
    public List<InfoExperts> infoExperts;
    @SerializedName("marker")
    public String marker;
    @SerializedName("name")
    public String name;
    @SerializedName("orders")
    public List<Orders> orders;
    @SerializedName("status")
    public int status;
    @SerializedName("tags")
    public List<Tags> tags;
    @SerializedName("updatedAt")
    public String updatedAt;
  }
  
  public static class InfoExperts {}
  
  public static class Orders {}
  
  public static class Tags {}
  
  public static class User {}
}


