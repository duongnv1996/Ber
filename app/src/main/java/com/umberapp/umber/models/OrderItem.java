package com.umberapp.umber.models;

import java.util.List;

public class OrderItem
{
  String address;
  String audio;
  String category;
  double[] coordinates;
  String createdAt;
  String customer;
  long dateBooking;
  List<String> experts;
  List<String> expertsFinding;
  String hasSend;
  String id;
  String invoice;
  String payment;
  List<Picture> pictures;
  String promotion;
  RangeTime rangeTime;
  String status;
  List<Tag> tags;
  String updatedAt;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getAudio()
  {
    return this.audio;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public double[] getCoordinates()
  {
    return this.coordinates;
  }
  
  public String getCreatedAt()
  {
    return this.createdAt;
  }
  
  public String getCustomer()
  {
    return this.customer;
  }
  
  public long getDateBooking()
  {
    return this.dateBooking;
  }
  
  public List<String> getExperts()
  {
    return this.experts;
  }
  
  public List<String> getExpertsFinding()
  {
    return this.expertsFinding;
  }
  
  public String getHasSend()
  {
    return this.hasSend;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getInvoice()
  {
    return this.invoice;
  }
  
  public String getPayment()
  {
    return this.payment;
  }
  
  public List<Picture> getPictures()
  {
    return this.pictures;
  }
  
  public String getPromotion()
  {
    return this.promotion;
  }
  
  public RangeTime getRangeTime()
  {
    return this.rangeTime;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public List<Tag> getTags()
  {
    return this.tags;
  }
  
  public String getUpdatedAt()
  {
    return this.updatedAt;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setAudio(String paramString)
  {
    this.audio = paramString;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setCoordinates(double[] paramArrayOfDouble)
  {
    this.coordinates = paramArrayOfDouble;
  }
  
  public void setCreatedAt(String paramString)
  {
    this.createdAt = paramString;
  }
  
  public void setCustomer(String paramString)
  {
    this.customer = paramString;
  }
  
  public void setDateBooking(long paramLong)
  {
    this.dateBooking = paramLong;
  }
  
  public void setExperts(List<String> paramList)
  {
    this.experts = paramList;
  }
  
  public void setExpertsFinding(List<String> paramList)
  {
    this.expertsFinding = paramList;
  }
  
  public void setHasSend(String paramString)
  {
    this.hasSend = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setInvoice(String paramString)
  {
    this.invoice = paramString;
  }
  
  public void setPayment(String paramString)
  {
    this.payment = paramString;
  }
  
  public void setPictures(List<Picture> paramList)
  {
    this.pictures = paramList;
  }
  
  public void setPromotion(String paramString)
  {
    this.promotion = paramString;
  }
  
  public void setRangeTime(RangeTime paramRangeTime)
  {
    this.rangeTime = paramRangeTime;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setTags(List<Tag> paramList)
  {
    this.tags = paramList;
  }
  
  public void setUpdatedAt(String paramString)
  {
    this.updatedAt = paramString;
  }
}

