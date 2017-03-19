package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Fields
  implements Parcelable
{
  public static final Creator<Fields> CREATOR = new Creator()
  {
    public Fields createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Fields(paramAnonymousParcel);
    }
    
    public Fields[] newArray(int paramAnonymousInt)
    {
      return new Fields[paramAnonymousInt];
    }
  };
  double costForTime;
  double costHour;
  double materialCost;
  String orderId;
  String statusOrder;
  double times;
  double totalCost;
  
  public Fields() {}
  
  protected Fields(Parcel paramParcel)
  {
    this.orderId = paramParcel.readString();
    this.costForTime = paramParcel.readDouble();
    this.costHour = paramParcel.readDouble();
    this.materialCost = paramParcel.readDouble();
    this.statusOrder = paramParcel.readString();
    this.times = paramParcel.readDouble();
    this.totalCost = paramParcel.readDouble();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public double getCostForTime()
  {
    return this.costForTime;
  }
  
  public double getCostHour()
  {
    return this.costHour;
  }
  
  public double getMaterialCost()
  {
    return this.materialCost;
  }
  
  public String getOrderId()
  {
    return this.orderId;
  }
  
  public String getStatusOrder()
  {
    return this.statusOrder;
  }
  
  public double getTimes()
  {
    return this.times;
  }
  
  public double getTotalCost()
  {
    return this.totalCost;
  }
  
  public void setCostForTime(double paramDouble)
  {
    this.costForTime = paramDouble;
  }
  
  public void setCostHour(double paramDouble)
  {
    this.costHour = paramDouble;
  }
  
  public void setMaterialCost(double paramDouble)
  {
    this.materialCost = paramDouble;
  }
  
  public void setOrderId(String paramString)
  {
    this.orderId = paramString;
  }
  
  public void setStatusOrder(String paramString)
  {
    this.statusOrder = paramString;
  }
  
  public void setTimes(double paramDouble)
  {
    this.times = paramDouble;
  }
  
  public void setTotalCost(double paramDouble)
  {
    this.totalCost = paramDouble;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.orderId);
    paramParcel.writeDouble(this.costForTime);
    paramParcel.writeDouble(this.costHour);
    paramParcel.writeDouble(this.materialCost);
    paramParcel.writeString(this.statusOrder);
    paramParcel.writeDouble(this.times);
    paramParcel.writeDouble(this.totalCost);
  }
}

