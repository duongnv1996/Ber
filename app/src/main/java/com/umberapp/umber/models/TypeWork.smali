.class public Lcom/umberapp/umber/models/TypeWork;
.super Ljava/lang/Object;
.source "TypeWork.java"


# instance fields
.field id:I

.field name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getId()I
    .locals 1

    .prologue
    .line 12
    iget v0, p0, Lcom/umberapp/umber/models/TypeWork;->id:I

    return v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/umberapp/umber/models/TypeWork;->name:Ljava/lang/String;

    return-object v0
.end method

.method public setId(I)V
    .locals 0
    .param p1, "id"    # I

    .prologue
    .line 16
    iput p1, p0, Lcom/umberapp/umber/models/TypeWork;->id:I

    .line 17
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/umberapp/umber/models/TypeWork;->name:Ljava/lang/String;

    .line 25
    return-void
.end method
