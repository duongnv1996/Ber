.class public Lcom/umberapp/umber/models/RangeTime;
.super Ljava/lang/Object;
.source "RangeTime.java"


# instance fields
.field end:Ljava/lang/String;

.field start:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getEnd()Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lcom/umberapp/umber/models/RangeTime;->end:Ljava/lang/String;

    return-object v0
.end method

.method public getStart()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/umberapp/umber/models/RangeTime;->start:Ljava/lang/String;

    return-object v0
.end method

.method public setEnd(Ljava/lang/String;)V
    .locals 0
    .param p1, "end"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/umberapp/umber/models/RangeTime;->end:Ljava/lang/String;

    .line 21
    return-void
.end method

.method public setStart(Ljava/lang/String;)V
    .locals 0
    .param p1, "start"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/umberapp/umber/models/RangeTime;->start:Ljava/lang/String;

    .line 29
    return-void
.end method
