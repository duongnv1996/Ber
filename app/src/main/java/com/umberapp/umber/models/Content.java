package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Content
  implements Parcelable
{
  public static final Creator<Content> CREATOR = new Creator()
  {
    public Content createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Content(paramAnonymousParcel);
    }
    
    public Content[] newArray(int paramAnonymousInt)
    {
      return new Content[paramAnonymousInt];
    }
  };
  Fields fields;
  String message;
  String title;
  
  public Content() {}
  
  protected Content(Parcel paramParcel)
  {
    this.message = paramParcel.readString();
    this.title = paramParcel.readString();
    this.fields = ((Fields)paramParcel.readParcelable(Fields.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Fields getFields()
  {
    return this.fields;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setFields(Fields paramFields)
  {
    this.fields = paramFields;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.message);
    paramParcel.writeString(this.title);
    paramParcel.writeParcelable(this.fields, paramInt);
  }
}

