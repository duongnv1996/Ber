.class public Lcom/umberapp/umber/models/Content;
.super Ljava/lang/Object;
.source "Content.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/umberapp/umber/models/Content;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field fields:Lcom/umberapp/umber/models/Fields;

.field message:Ljava/lang/String;

.field title:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    new-instance v0, Lcom/umberapp/umber/models/Content$1;

    invoke-direct {v0}, Lcom/umberapp/umber/models/Content$1;-><init>()V

    sput-object v0, Lcom/umberapp/umber/models/Content;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/Content;->message:Ljava/lang/String;

    .line 19
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/Content;->title:Ljava/lang/String;

    .line 20
    const-class v0, Lcom/umberapp/umber/models/Fields;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/umberapp/umber/models/Fields;

    iput-object v0, p0, Lcom/umberapp/umber/models/Content;->fields:Lcom/umberapp/umber/models/Fields;

    .line 21
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 61
    const/4 v0, 0x0

    return v0
.end method

.method public getFields()Lcom/umberapp/umber/models/Fields;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/umberapp/umber/models/Content;->fields:Lcom/umberapp/umber/models/Fields;

    return-object v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/umberapp/umber/models/Content;->message:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/umberapp/umber/models/Content;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setFields(Lcom/umberapp/umber/models/Fields;)V
    .locals 0
    .param p1, "fields"    # Lcom/umberapp/umber/models/Fields;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/umberapp/umber/models/Content;->fields:Lcom/umberapp/umber/models/Fields;

    .line 41
    return-void
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/umberapp/umber/models/Content;->message:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/umberapp/umber/models/Content;->title:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "parcel"    # Landroid/os/Parcel;
    .param p2, "i"    # I

    .prologue
    .line 66
    iget-object v0, p0, Lcom/umberapp/umber/models/Content;->message:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 67
    iget-object v0, p0, Lcom/umberapp/umber/models/Content;->title:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 68
    iget-object v0, p0, Lcom/umberapp/umber/models/Content;->fields:Lcom/umberapp/umber/models/Fields;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 69
    return-void
.end method
