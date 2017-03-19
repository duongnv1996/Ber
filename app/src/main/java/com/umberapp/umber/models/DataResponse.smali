.class public Lcom/umberapp/umber/models/DataResponse;
.super Ljava/lang/Object;
.source "DataResponse.java"


# static fields
.field public static final STATE_CANCEL:I = -0x1

.field public static final STATE_CHANGE:I = -0x3

.field public static final STATE_CONNECT:I = 0x1

.field public static final STATE_DEFAULT:I = 0x3


# instance fields
.field private state:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getState()I
    .locals 1

    .prologue
    .line 14
    iget v0, p0, Lcom/umberapp/umber/models/DataResponse;->state:I

    return v0
.end method

.method public setState(I)V
    .locals 0
    .param p1, "state"    # I

    .prologue
    .line 18
    iput p1, p0, Lcom/umberapp/umber/models/DataResponse;->state:I

    .line 19
    return-void
.end method
