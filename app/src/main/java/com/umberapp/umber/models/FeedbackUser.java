package com.umberapp.umber.models;

public class FeedbackUser
{
  String comment;
  String id;
  String orderId;
  double star;
  String user;
  
  public String getComment()
  {
    return this.comment;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getOrderId()
  {
    return this.orderId;
  }
  
  public double getStar()
  {
    return this.star;
  }
  
  public String getUser()
  {
    return this.user;
  }
  
  public void setComment(String paramString)
  {
    this.comment = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setOrderId(String paramString)
  {
    this.orderId = paramString;
  }
  
  public void setStar(double paramDouble)
  {
    this.star = paramDouble;
  }
  
  public void setUser(String paramString)
  {
    this.user = paramString;
  }
}

