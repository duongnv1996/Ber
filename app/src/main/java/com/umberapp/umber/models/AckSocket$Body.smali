.class public Lcom/umberapp/umber/models/AckSocket$Body;
.super Ljava/lang/Object;
.source "AckSocket.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/umberapp/umber/models/AckSocket;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Body"
.end annotation


# instance fields
.field public message:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "message"
    .end annotation
.end field

.field public notificationUnRead:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "notificationUnRead"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/umberapp/umber/models/AckSocket$Body;->message:Ljava/lang/String;

    return-object v0
.end method

.method public getNotificationUnRead()I
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lcom/umberapp/umber/models/AckSocket$Body;->notificationUnRead:I

    return v0
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/umberapp/umber/models/AckSocket$Body;->message:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public setNotificationUnRead(I)V
    .locals 0
    .param p1, "notificationUnRead"    # I

    .prologue
    .line 61
    iput p1, p0, Lcom/umberapp/umber/models/AckSocket$Body;->notificationUnRead:I

    .line 62
    return-void
.end method
