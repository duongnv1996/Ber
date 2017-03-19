package com.umberapp.umber.models;

public class NotificationItemPage
{
  Content content;
  String createdAt;
  Expert from;
  String id;
  int seen;
  String seenAt;
  String to;
  String type;
  String updatedAt;
  
  public Content getContent()
  {
    return this.content;
  }
  
  public String getCreatedAt()
  {
    return this.createdAt;
  }
  
  public Expert getFrom()
  {
    return this.from;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public int getSeen()
  {
    return this.seen;
  }
  
  public String getSeenAt()
  {
    return this.seenAt;
  }
  
  public String getTo()
  {
    return this.to;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getUpdatedAt()
  {
    return this.updatedAt;
  }
  
  public void setContent(Content paramContent)
  {
    this.content = paramContent;
  }
  
  public void setCreatedAt(String paramString)
  {
    this.createdAt = paramString;
  }
  
  public void setFrom(Expert paramExpert)
  {
    this.from = paramExpert;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setSeen(int paramInt)
  {
    this.seen = paramInt;
  }
  
  public void setSeenAt(String paramString)
  {
    this.seenAt = paramString;
  }
  
  public void setTo(String paramString)
  {
    this.to = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setUpdatedAt(String paramString)
  {
    this.updatedAt = paramString;
  }
}
