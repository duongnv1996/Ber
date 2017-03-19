package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NotificationItem
  implements Parcelable
{
  public static final Creator<NotificationItem> CREATOR = new Creator()
  {
    public NotificationItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new NotificationItem(paramAnonymousParcel);
    }
    
    public NotificationItem[] newArray(int paramAnonymousInt)
    {
      return new NotificationItem[paramAnonymousInt];
    }
  };
  Content content;
  String from;
  int seen;
  String to;
  String type;
  
  public NotificationItem() {}
  
  protected NotificationItem(Parcel paramParcel)
  {
    this.type = paramParcel.readString();
    this.to = paramParcel.readString();
    this.from = paramParcel.readString();
    this.seen = paramParcel.readInt();
    this.content = ((Content)paramParcel.readParcelable(Content.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Content getContent()
  {
    return this.content;
  }
  
  public String getFrom()
  {
    return this.from;
  }
  
  public int getSeen()
  {
    return this.seen;
  }
  
  public String getTo()
  {
    return this.to;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setContent(Content paramContent)
  {
    this.content = paramContent;
  }
  
  public void setFrom(String paramString)
  {
    this.from = paramString;
  }
  
  public void setSeen(int paramInt)
  {
    this.seen = paramInt;
  }
  
  public void setTo(String paramString)
  {
    this.to = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.to);
    paramParcel.writeString(this.from);
    paramParcel.writeInt(this.seen);
    paramParcel.writeParcelable(this.content, paramInt);
  }
}


