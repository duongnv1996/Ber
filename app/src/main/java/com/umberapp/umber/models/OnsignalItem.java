package com.umberapp.umber.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class OnsignalItem
  implements Parcelable
{
  public static final Creator<OnsignalItem> CREATOR = new Creator()
  {
    public OnsignalItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new OnsignalItem(paramAnonymousParcel);
    }
    
    public OnsignalItem[] newArray(int paramAnonymousInt)
    {
      return new OnsignalItem[paramAnonymousInt];
    }
  };
  String expertId;
  Fields fields;
  @SerializedName("orderId")
  public String orderId;
  @SerializedName("status")
  public String status;
  @SerializedName("type")
  public String type;
  
  public OnsignalItem() {}
  
  protected OnsignalItem(Parcel paramParcel)
  {
    this.orderId = paramParcel.readString();
    this.type = paramParcel.readString();
    this.status = paramParcel.readString();
    this.fields = ((Fields)paramParcel.readParcelable(Fields.class.getClassLoader()));
    this.expertId = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getExpertId()
  {
    return this.expertId;
  }
  
  public Fields getFields()
  {
    return this.fields;
  }
  
  public String getOrderId()
  {
    return this.orderId;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setExpertId(String paramString)
  {
    this.expertId = paramString;
  }
  
  public void setFields(Fields paramFields)
  {
    this.fields = paramFields;
  }
  
  public void setOrderId(String paramString)
  {
    this.orderId = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.orderId);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.status);
    paramParcel.writeParcelable(this.fields, paramInt);
    paramParcel.writeString(this.expertId);
  }
}

