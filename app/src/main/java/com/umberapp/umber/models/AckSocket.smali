.class public Lcom/umberapp/umber/models/AckSocket;
.super Ljava/lang/Object;
.source "AckSocket.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/umberapp/umber/models/AckSocket$Headers;,
        Lcom/umberapp/umber/models/AckSocket$Body;
    }
.end annotation


# instance fields
.field public body:Lcom/umberapp/umber/models/AckSocket$Body;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "body"
    .end annotation
.end field

.field public headers:Lcom/umberapp/umber/models/AckSocket$Headers;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "headers"
    .end annotation
.end field

.field public statusCode:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "statusCode"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBody()Lcom/umberapp/umber/models/AckSocket$Body;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/umberapp/umber/models/AckSocket;->body:Lcom/umberapp/umber/models/AckSocket$Body;

    return-object v0
.end method

.method public getHeaders()Lcom/umberapp/umber/models/AckSocket$Headers;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/umberapp/umber/models/AckSocket;->headers:Lcom/umberapp/umber/models/AckSocket$Headers;

    return-object v0
.end method

.method public getStatusCode()I
    .locals 1

    .prologue
    .line 35
    iget v0, p0, Lcom/umberapp/umber/models/AckSocket;->statusCode:I

    return v0
.end method

.method public setBody(Lcom/umberapp/umber/models/AckSocket$Body;)V
    .locals 0
    .param p1, "body"    # Lcom/umberapp/umber/models/AckSocket$Body;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/umberapp/umber/models/AckSocket;->body:Lcom/umberapp/umber/models/AckSocket$Body;

    .line 24
    return-void
.end method

.method public setHeaders(Lcom/umberapp/umber/models/AckSocket$Headers;)V
    .locals 0
    .param p1, "headers"    # Lcom/umberapp/umber/models/AckSocket$Headers;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/umberapp/umber/models/AckSocket;->headers:Lcom/umberapp/umber/models/AckSocket$Headers;

    .line 32
    return-void
.end method

.method public setStatusCode(I)V
    .locals 0
    .param p1, "statusCode"    # I

    .prologue
    .line 39
    iput p1, p0, Lcom/umberapp/umber/models/AckSocket;->statusCode:I

    .line 40
    return-void
.end method
