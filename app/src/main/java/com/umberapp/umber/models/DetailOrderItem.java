package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DetailOrderItem
{
  @SerializedName("address")
  private String address;
  @SerializedName("audio")
  private String audio;
  @SerializedName("avatar")
  private String avatar;
  @SerializedName("category")
  private Category category;
  @SerializedName("costHour")
  private int costHour;
  @SerializedName("createdAt")
  private String createdAt;
  @SerializedName("customer")
  private User customer;
  @SerializedName("dateBooking")
  private long dateBooking;
  @SerializedName("decline")
  private User decline;
  @SerializedName("detailDecline")
  private String detailDecline;
  @SerializedName("expertsJoined")
  private List<ExpertBit> exoertsJoined;
  @SerializedName("expert")
  private Expert expert;
  @SerializedName("expertsFinding")
  private List<String> expertsFinding;
  @SerializedName("first_name")
  private String first_name;
  @SerializedName("hasSend")
  private String hasSend;
  @SerializedName("id")
  private String id;
  @SerializedName("invoice")
  private String invoice;
  @SerializedName("jobsDone")
  private int jobsDone;
  @SerializedName("last_name")
  private String last_name;
  @SerializedName("payment")
  private String payment;
  @SerializedName("rangeTime")
  private RangeTime rangeTime;
  @SerializedName("rating")
  private String rating;
  @SerializedName("status")
  private String status;
  @SerializedName("tags")
  private List<Tag> tags;
  @SerializedName("totalOrderSuccess")
  private int totalOrderSuccess;
  @SerializedName("transaction")
  private String transaction;
  @SerializedName("updatedAt")
  private String updatedAt;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getAudio()
  {
    return this.audio;
  }
  
  public String getAvatar()
  {
    return this.avatar;
  }
  
  public Category getCategory()
  {
    return this.category;
  }
  
  public int getCostHour()
  {
    return this.costHour;
  }
  
  public String getCreatedAt()
  {
    return this.createdAt;
  }
  
  public User getCustomer()
  {
    return this.customer;
  }
  
  public long getDateBooking()
  {
    return this.dateBooking;
  }
  
  public User getDecline()
  {
    return this.decline;
  }
  
  public String getDetailDecline()
  {
    return this.detailDecline;
  }
  
  public List<ExpertBit> getExoertsJoined()
  {
    return this.exoertsJoined;
  }
  
  public Expert getExpert()
  {
    return this.expert;
  }
  
  public List<String> getExpertsFinding()
  {
    return this.expertsFinding;
  }
  
  public String getFirst_name()
  {
    return this.first_name;
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
  
  public int getJobsDone()
  {
    return this.jobsDone;
  }
  
  public String getLast_name()
  {
    return this.last_name;
  }
  
  public String getPayment()
  {
    return this.payment;
  }
  
  public RangeTime getRangeTime()
  {
    return this.rangeTime;
  }
  
  public String getRating()
  {
    return this.rating;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public List<Tag> getTags()
  {
    return this.tags;
  }
  
  public int getTotalOrderSuccess()
  {
    return this.totalOrderSuccess;
  }
  
  public String getTransaction()
  {
    return this.transaction;
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
  
  public void setAvatar(String paramString)
  {
    this.avatar = paramString;
  }
  
  public void setCategory(Category paramCategory)
  {
    this.category = paramCategory;
  }
  
  public void setCostHour(int paramInt)
  {
    this.costHour = paramInt;
  }
  
  public void setCreatedAt(String paramString)
  {
    this.createdAt = paramString;
  }
  
  public void setCustomer(User paramUser)
  {
    this.customer = paramUser;
  }
  
  public void setDateBooking(long paramLong)
  {
    this.dateBooking = paramLong;
  }
  
  public void setDecline(User paramUser)
  {
    this.decline = paramUser;
  }
  
  public void setDetailDecline(String paramString)
  {
    this.detailDecline = paramString;
  }
  
  public void setExoertsJoined(List<ExpertBit> paramList)
  {
    this.exoertsJoined = paramList;
  }
  
  public void setExpert(Expert paramExpert)
  {
    this.expert = paramExpert;
  }
  
  public void setExpertsFinding(List<String> paramList)
  {
    this.expertsFinding = paramList;
  }
  
  public void setFirst_name(String paramString)
  {
    this.first_name = paramString;
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
  
  public void setJobsDone(int paramInt)
  {
    this.jobsDone = paramInt;
  }
  
  public void setLast_name(String paramString)
  {
    this.last_name = paramString;
  }
  
  public void setPayment(String paramString)
  {
    this.payment = paramString;
  }
  
  public void setRangeTime(RangeTime paramRangeTime)
  {
    this.rangeTime = paramRangeTime;
  }
  
  public void setRating(String paramString)
  {
    this.rating = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setTags(List<Tag> paramList)
  {
    this.tags = paramList;
  }
  
  public void setTotalOrderSuccess(int paramInt)
  {
    this.totalOrderSuccess = paramInt;
  }
  
  public void setTransaction(String paramString)
  {
    this.transaction = paramString;
  }
  
  public void setUpdatedAt(String paramString)
  {
    this.updatedAt = paramString;
  }
}

