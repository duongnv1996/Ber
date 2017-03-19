.class public Lcom/umberapp/umber/models/Day;
.super Ljava/lang/Object;
.source "Day.java"


# instance fields
.field id:I

.field isCheck:Z

.field title:Ljava/lang/String;


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
    .line 21
    iget v0, p0, Lcom/umberapp/umber/models/Day;->id:I

    return v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/umberapp/umber/models/Day;->title:Ljava/lang/String;

    return-object v0
.end method

.method public isCheck()Z
    .locals 1

    .prologue
    .line 29
    iget-boolean v0, p0, Lcom/umberapp/umber/models/Day;->isCheck:Z

    return v0
.end method

.method public setCheck(Z)V
    .locals 0
    .param p1, "check"    # Z

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/umberapp/umber/models/Day;->isCheck:Z

    .line 34
    return-void
.end method

.method public setId(I)V
    .locals 0
    .param p1, "id"    # I

    .prologue
    .line 25
    iput p1, p0, Lcom/umberapp/umber/models/Day;->id:I

    .line 26
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 17
    iput-object p1, p0, Lcom/umberapp/umber/models/Day;->title:Ljava/lang/String;

    .line 18
    return-void
.end method
