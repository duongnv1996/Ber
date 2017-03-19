.class public Lcom/umberapp/umber/models/CheckResponse;
.super Ljava/lang/Object;
.source "CheckResponse.java"


# instance fields
.field code:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    iget-object v0, p0, Lcom/umberapp/umber/models/CheckResponse;->code:Ljava/lang/String;

    return-object v0
.end method

.method public setCode(Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;

    .prologue
    .line 16
    iput-object p1, p0, Lcom/umberapp/umber/models/CheckResponse;->code:Ljava/lang/String;

    .line 17
    return-void
.end method
