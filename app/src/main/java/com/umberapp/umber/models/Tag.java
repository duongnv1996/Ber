package com.umberapp.umber.models;

public class Tag
{
  String id;
  String text;
  
  public Tag() {}
  
  public Tag(String paramString)
  {
    this.text = paramString;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
}


