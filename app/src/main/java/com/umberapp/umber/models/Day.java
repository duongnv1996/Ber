package com.umberapp.umber.models;

public class Day
{
  int id;
  boolean isCheck;
  String title;
  
  public int getId()
  {
    return this.id;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public boolean isCheck()
  {
    return this.isCheck;
  }
  
  public void setCheck(boolean paramBoolean)
  {
    this.isCheck = paramBoolean;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}

