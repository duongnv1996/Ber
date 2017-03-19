.class public Lcom/umberapp/umber/models/FeedbackUser;
.super Ljava/lang/Object;
.source "FeedbackUser.java"


# instance fields
.field comment:Ljava/lang/String;

.field id:Ljava/lang/String;

.field orderId:Ljava/lang/String;

.field star:D

.field user:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getComment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/umberapp/umber/models/FeedbackUser;->comment:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/umberapp/umber/models/FeedbackUser;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getOrderId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/umberapp/umber/models/FeedbackUser;->orderId:Ljava/lang/String;

    return-object v0
.end method

.method public getStar()D
    .locals 2

    .prologue
    .line 48
    iget-wide v0, p0, Lcom/umberapp/umber/models/FeedbackUser;->star:D

    return-wide v0
.end method

.method public getUser()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/umberapp/umber/models/FeedbackUser;->user:Ljava/lang/String;

    return-object v0
.end method

.method public setComment(Ljava/lang/String;)V
    .locals 0
    .param p1, "comment"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/umberapp/umber/models/FeedbackUser;->comment:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/umberapp/umber/models/FeedbackUser;->id:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setOrderId(Ljava/lang/String;)V
    .locals 0
    .param p1, "orderId"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/umberapp/umber/models/FeedbackUser;->orderId:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setStar(D)V
    .locals 1
    .param p1, "star"    # D

    .prologue
    .line 52
    iput-wide p1, p0, Lcom/umberapp/umber/models/FeedbackUser;->star:D

    .line 53
    return-void
.end method

.method public setUser(Ljava/lang/String;)V
    .locals 0
    .param p1, "user"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/umberapp/umber/models/FeedbackUser;->user:Ljava/lang/String;

    .line 21
    return-void
.end method
