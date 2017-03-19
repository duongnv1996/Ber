package com.umberapp.umber.models;

public class Category
{
  double costHour;
  String icon;
  String id;
  String marker;
  String name;
  String parent;
  int status;
  
  public double getCostHour()
  {
    return this.costHour;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getMarker()
  {
    return this.marker;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getParent()
  {
    return this.parent;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public void setCostHour(double paramDouble)
  {
    this.costHour = paramDouble;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMarker(String paramString)
  {
    this.marker = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setParent(String paramString)
  {
    this.parent = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
}

