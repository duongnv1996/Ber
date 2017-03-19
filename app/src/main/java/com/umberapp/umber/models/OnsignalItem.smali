.class public Lcom/umberapp/umber/models/OnsignalItem;
.super Ljava/lang/Object;
.source "OnsignalItem.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/umberapp/umber/models/OnsignalItem;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field expertId:Ljava/lang/String;

.field fields:Lcom/umberapp/umber/models/Fields;

.field public orderId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "orderId"
    .end annotation
.end field

.field public status:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "status"
    .end annotation
.end field

.field public type:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "type"
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    new-instance v0, Lcom/umberapp/umber/models/OnsignalItem$1;

    invoke-direct {v0}, Lcom/umberapp/umber/models/OnsignalItem$1;-><init>()V

    sput-object v0, Lcom/umberapp/umber/models/OnsignalItem;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->orderId:Ljava/lang/String;

    .line 26
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->type:Ljava/lang/String;

    .line 27
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->status:Ljava/lang/String;

    .line 28
    const-class v0, Lcom/umberapp/umber/models/Fields;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/umberapp/umber/models/Fields;

    iput-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->fields:Lcom/umberapp/umber/models/Fields;

    .line 29
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->expertId:Ljava/lang/String;

    .line 30
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 87
    const/4 v0, 0x0

    return v0
.end method

.method public getExpertId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->expertId:Ljava/lang/String;

    return-object v0
.end method

.method public getFields()Lcom/umberapp/umber/models/Fields;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->fields:Lcom/umberapp/umber/models/Fields;

    return-object v0
.end method

.method public getOrderId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->orderId:Ljava/lang/String;

    return-object v0
.end method

.method public getStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->status:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->type:Ljava/lang/String;

    return-object v0
.end method

.method public setExpertId(Ljava/lang/String;)V
    .locals 0
    .param p1, "expertId"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/umberapp/umber/models/OnsignalItem;->expertId:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setFields(Lcom/umberapp/umber/models/Fields;)V
    .locals 0
    .param p1, "fields"    # Lcom/umberapp/umber/models/Fields;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/umberapp/umber/models/OnsignalItem;->fields:Lcom/umberapp/umber/models/Fields;

    .line 62
    return-void
.end method

.method public setOrderId(Ljava/lang/String;)V
    .locals 0
    .param p1, "orderId"    # Ljava/lang/String;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/umberapp/umber/models/OnsignalItem;->orderId:Ljava/lang/String;

    .line 66
    return-void
.end method

.method public setStatus(Ljava/lang/String;)V
    .locals 0
    .param p1, "status"    # Ljava/lang/String;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/umberapp/umber/models/OnsignalItem;->status:Ljava/lang/String;

    .line 74
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/umberapp/umber/models/OnsignalItem;->type:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "parcel"    # Landroid/os/Parcel;
    .param p2, "i"    # I

    .prologue
    .line 92
    iget-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->orderId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 93
    iget-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->type:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 94
    iget-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->status:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 95
    iget-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->fields:Lcom/umberapp/umber/models/Fields;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 96
    iget-object v0, p0, Lcom/umberapp/umber/models/OnsignalItem;->expertId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 97
    return-void
.end method
