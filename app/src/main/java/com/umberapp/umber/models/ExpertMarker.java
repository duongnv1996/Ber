package com.umberapp.umber.models;

import java.util.List;

public class ExpertMarker
  extends User
{
  String cashPayment;
  List<Category> category;
  double costHour;
  int dateBooking;
  int jobsDone;
  double[] location;
  double maxFeeToPaid;
  RangeTime timeRange;
  int totalOrderSuccess;
  
  public String getCashPayment()
  {
    return this.cashPayment;
  }
  
  public List<Category> getCategory()
  {
    return this.category;
  }
  
  public double getCostHour()
  {
    return this.costHour;
  }
  
  public int getDateBooking()
  {
    return this.dateBooking;
  }
  
  public int getJobsDone()
  {
    return this.jobsDone;
  }
  
  public double[] getLocation()
  {
    return this.location;
  }
  
  public double getMaxFeeToPaid()
  {
    return this.maxFeeToPaid;
  }
  
  public RangeTime getTimeRange()
  {
    return this.timeRange;
  }
  
  public int getTotalOrderSuccess()
  {
    return this.totalOrderSuccess;
  }
  
  public void setCashPayment(String paramString)
  {
    this.cashPayment = paramString;
  }
  
  public void setCategory(List<Category> paramList)
  {
    this.category = paramList;
  }
  
  public void setCostHour(double paramDouble)
  {
    this.costHour = paramDouble;
  }
  
  public void setDateBooking(int paramInt)
  {
    this.dateBooking = paramInt;
  }
  
  public void setJobsDone(int paramInt)
  {
    this.jobsDone = paramInt;
  }
  
  public void setLocation(double[] paramArrayOfDouble)
  {
    this.location = paramArrayOfDouble;
  }
  
  public void setMaxFeeToPaid(double paramDouble)
  {
    this.maxFeeToPaid = paramDouble;
  }
  
  public void setTimeRange(RangeTime paramRangeTime)
  {
    this.timeRange = paramRangeTime;
  }
  
  public void setTotalOrderSuccess(int paramInt)
  {
    this.totalOrderSuccess = paramInt;
  }
}

