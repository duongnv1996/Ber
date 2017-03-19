package com.umberapp.umber.models;

public class ExpertBit
  extends User
{
  String cashPayment;
  String category;
  double costHour;
  long dateBooking;
  double distance;
  String infoExpert;
  RangeTime timeRange;
  int totalOrderSuccess;
  
  public String getCashPayment()
  {
    return this.cashPayment;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public double getCostHour()
  {
    return this.costHour;
  }
  
  public long getDateBooking()
  {
    return this.dateBooking;
  }
  
  public double getDistance()
  {
    return this.distance;
  }
  
  public String getInfoExpert()
  {
    return this.infoExpert;
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
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setCostHour(double paramDouble)
  {
    this.costHour = paramDouble;
  }
  
  public void setDateBooking(long paramLong)
  {
    this.dateBooking = paramLong;
  }
  
  public void setDistance(double paramDouble)
  {
    this.distance = paramDouble;
  }
  
  public void setInfoExpert(String paramString)
  {
    this.infoExpert = paramString;
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


