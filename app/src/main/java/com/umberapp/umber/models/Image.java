package com.umberapp.umber.models;

import android.graphics.Bitmap;

public class Image
{
  int id;
  String path;
  Bitmap photo;
  
  public int getId()
  {
    return this.id;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public Bitmap getPhoto()
  {
    return this.photo;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setPhoto(Bitmap paramBitmap)
  {
    this.photo = paramBitmap;
  }
}

