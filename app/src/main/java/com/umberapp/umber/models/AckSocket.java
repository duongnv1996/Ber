package com.umberapp.umber.models;

import com.google.gson.annotations.SerializedName;

public class AckSocket
{
  @SerializedName("body")
  public Body body;
  @SerializedName("headers")
  public Headers headers;
  @SerializedName("statusCode")
  public int statusCode;
  
  public Body getBody()
  {
    return this.body;
  }
  
  public Headers getHeaders()
  {
    return this.headers;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public void setBody(Body paramBody)
  {
    this.body = paramBody;
  }
  
  public void setHeaders(Headers paramHeaders)
  {
    this.headers = paramHeaders;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public static class Body
  {
    @SerializedName("message")
    public String message;
    @SerializedName("notificationUnRead")
    public int notificationUnRead;
    
    public String getMessage()
    {
      return this.message;
    }
    
    public int getNotificationUnRead()
    {
      return this.notificationUnRead;
    }
    
    public void setMessage(String paramString)
    {
      this.message = paramString;
    }
    
    public void setNotificationUnRead(int paramInt)
    {
      this.notificationUnRead = paramInt;
    }
  }
  
  public static class Headers {}
}

