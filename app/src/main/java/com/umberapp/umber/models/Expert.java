package com.umberapp.umber.models;

import java.util.List;

public class Expert
  extends User
{
  String cashPayment;
  List<Category> category;
  String[] coordinates;
  double costHour;
  int dateBooking;
  int jobsDone;
  double[] location;
  double maxFeeToPaid;
  List<Description> selfDescriptions;
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
  
  public String[] getCoordinates()
  {
    return this.coordinates;
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
  
  public List<Description> getSelfDescriptions()
  {
    return this.selfDescriptions;
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
  
  public void setCoordinates(String[] paramArrayOfString)
  {
    this.coordinates = paramArrayOfString;
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
  
  public void setSelfDescriptions(List<Description> paramList)
  {
    this.selfDescriptions = paramList;
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

