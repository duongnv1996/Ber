.class final Lcom/umberapp/umber/models/Content$1;
.super Ljava/lang/Object;
.source "Content.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/umberapp/umber/models/Content;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/umberapp/umber/models/Content;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/umberapp/umber/models/Content;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 26
    new-instance v0, Lcom/umberapp/umber/models/Content;

    invoke-direct {v0, p1}, Lcom/umberapp/umber/models/Content;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0, p1}, Lcom/umberapp/umber/models/Content$1;->createFromParcel(Landroid/os/Parcel;)Lcom/umberapp/umber/models/Content;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/umberapp/umber/models/Content;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 31
    new-array v0, p1, [Lcom/umberapp/umber/models/Content;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0, p1}, Lcom/umberapp/umber/models/Content$1;->newArray(I)[Lcom/umberapp/umber/models/Content;

    move-result-object v0

    return-object v0
.end method
