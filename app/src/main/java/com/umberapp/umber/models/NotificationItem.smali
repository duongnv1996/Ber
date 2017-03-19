.class public Lcom/umberapp/umber/models/NotificationItem;
.super Ljava/lang/Object;
.source "NotificationItem.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/umberapp/umber/models/NotificationItem;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field content:Lcom/umberapp/umber/models/Content;

.field from:Ljava/lang/String;

.field seen:I

.field to:Ljava/lang/String;

.field type:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    new-instance v0, Lcom/umberapp/umber/models/NotificationItem$1;

    invoke-direct {v0}, Lcom/umberapp/umber/models/NotificationItem$1;-><init>()V

    sput-object v0, Lcom/umberapp/umber/models/NotificationItem;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->type:Ljava/lang/String;

    .line 20
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->to:Ljava/lang/String;

    .line 21
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->from:Ljava/lang/String;

    .line 22
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/umberapp/umber/models/NotificationItem;->seen:I

    .line 23
    const-class v0, Lcom/umberapp/umber/models/Content;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/umberapp/umber/models/Content;

    iput-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->content:Lcom/umberapp/umber/models/Content;

    .line 24
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 82
    const/4 v0, 0x0

    return v0
.end method

.method public getContent()Lcom/umberapp/umber/models/Content;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->content:Lcom/umberapp/umber/models/Content;

    return-object v0
.end method

.method public getFrom()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->from:Ljava/lang/String;

    return-object v0
.end method

.method public getSeen()I
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lcom/umberapp/umber/models/NotificationItem;->seen:I

    return v0
.end method

.method public getTo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->to:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->type:Ljava/lang/String;

    return-object v0
.end method

.method public setContent(Lcom/umberapp/umber/models/Content;)V
    .locals 0
    .param p1, "content"    # Lcom/umberapp/umber/models/Content;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItem;->content:Lcom/umberapp/umber/models/Content;

    .line 46
    return-void
.end method

.method public setFrom(Ljava/lang/String;)V
    .locals 0
    .param p1, "from"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItem;->from:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public setSeen(I)V
    .locals 0
    .param p1, "seen"    # I

    .prologue
    .line 61
    iput p1, p0, Lcom/umberapp/umber/models/NotificationItem;->seen:I

    .line 62
    return-void
.end method

.method public setTo(Ljava/lang/String;)V
    .locals 0
    .param p1, "to"    # Ljava/lang/String;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItem;->to:Ljava/lang/String;

    .line 70
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItem;->type:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "parcel"    # Landroid/os/Parcel;
    .param p2, "i"    # I

    .prologue
    .line 87
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->type:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 88
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->to:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 89
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->from:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 90
    iget v0, p0, Lcom/umberapp/umber/models/NotificationItem;->seen:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 91
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItem;->content:Lcom/umberapp/umber/models/Content;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 92
    return-void
.end method
