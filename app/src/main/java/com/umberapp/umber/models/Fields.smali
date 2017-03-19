.class public Lcom/umberapp/umber/models/Fields;
.super Ljava/lang/Object;
.source "Fields.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/umberapp/umber/models/Fields;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field costForTime:D

.field costHour:D

.field materialCost:D

.field orderId:Ljava/lang/String;

.field statusOrder:Ljava/lang/String;

.field times:D

.field totalCost:D


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    new-instance v0, Lcom/umberapp/umber/models/Fields$1;

    invoke-direct {v0}, Lcom/umberapp/umber/models/Fields$1;-><init>()V

    sput-object v0, Lcom/umberapp/umber/models/Fields;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/Fields;->orderId:Ljava/lang/String;

    .line 22
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/umberapp/umber/models/Fields;->costForTime:D

    .line 23
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/umberapp/umber/models/Fields;->costHour:D

    .line 24
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/umberapp/umber/models/Fields;->materialCost:D

    .line 25
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/Fields;->statusOrder:Ljava/lang/String;

    .line 26
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/umberapp/umber/models/Fields;->times:D

    .line 27
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/umberapp/umber/models/Fields;->totalCost:D

    .line 28
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 100
    const/4 v0, 0x0

    return v0
.end method

.method public getCostForTime()D
    .locals 2

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/umberapp/umber/models/Fields;->costForTime:D

    return-wide v0
.end method

.method public getCostHour()D
    .locals 2

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/umberapp/umber/models/Fields;->costHour:D

    return-wide v0
.end method

.method public getMaterialCost()D
    .locals 2

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/umberapp/umber/models/Fields;->materialCost:D

    return-wide v0
.end method

.method public getOrderId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/umberapp/umber/models/Fields;->orderId:Ljava/lang/String;

    return-object v0
.end method

.method public getStatusOrder()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/umberapp/umber/models/Fields;->statusOrder:Ljava/lang/String;

    return-object v0
.end method

.method public getTimes()D
    .locals 2

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/umberapp/umber/models/Fields;->times:D

    return-wide v0
.end method

.method public getTotalCost()D
    .locals 2

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/umberapp/umber/models/Fields;->totalCost:D

    return-wide v0
.end method

.method public setCostForTime(D)V
    .locals 1
    .param p1, "costForTime"    # D

    .prologue
    .line 47
    iput-wide p1, p0, Lcom/umberapp/umber/models/Fields;->costForTime:D

    .line 48
    return-void
.end method

.method public setCostHour(D)V
    .locals 1
    .param p1, "costHour"    # D

    .prologue
    .line 55
    iput-wide p1, p0, Lcom/umberapp/umber/models/Fields;->costHour:D

    .line 56
    return-void
.end method

.method public setMaterialCost(D)V
    .locals 1
    .param p1, "materialCost"    # D

    .prologue
    .line 63
    iput-wide p1, p0, Lcom/umberapp/umber/models/Fields;->materialCost:D

    .line 64
    return-void
.end method

.method public setOrderId(Ljava/lang/String;)V
    .locals 0
    .param p1, "orderId"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lcom/umberapp/umber/models/Fields;->orderId:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setStatusOrder(Ljava/lang/String;)V
    .locals 0
    .param p1, "statusOrder"    # Ljava/lang/String;

    .prologue
    .line 95
    iput-object p1, p0, Lcom/umberapp/umber/models/Fields;->statusOrder:Ljava/lang/String;

    .line 96
    return-void
.end method

.method public setTimes(D)V
    .locals 1
    .param p1, "times"    # D

    .prologue
    .line 71
    iput-wide p1, p0, Lcom/umberapp/umber/models/Fields;->times:D

    .line 72
    return-void
.end method

.method public setTotalCost(D)V
    .locals 1
    .param p1, "totalCost"    # D

    .prologue
    .line 79
    iput-wide p1, p0, Lcom/umberapp/umber/models/Fields;->totalCost:D

    .line 80
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "parcel"    # Landroid/os/Parcel;
    .param p2, "i"    # I

    .prologue
    .line 105
    iget-object v0, p0, Lcom/umberapp/umber/models/Fields;->orderId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 106
    iget-wide v0, p0, Lcom/umberapp/umber/models/Fields;->costForTime:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 107
    iget-wide v0, p0, Lcom/umberapp/umber/models/Fields;->costHour:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 108
    iget-wide v0, p0, Lcom/umberapp/umber/models/Fields;->materialCost:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 109
    iget-object v0, p0, Lcom/umberapp/umber/models/Fields;->statusOrder:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 110
    iget-wide v0, p0, Lcom/umberapp/umber/models/Fields;->times:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 111
    iget-wide v0, p0, Lcom/umberapp/umber/models/Fields;->totalCost:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 112
    return-void
.end method
