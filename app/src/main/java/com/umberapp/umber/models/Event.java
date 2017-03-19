package com.umberapp.umber.models;

public class Event
{
  String content;
  int status;
  String title;
  String user;
  
  public String getContent()
  {
    return this.content;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getUser()
  {
    return this.user;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setUser(String paramString)
  {
    this.user = paramString;
  }
}


