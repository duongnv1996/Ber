.class public Lcom/umberapp/umber/models/Event;
.super Ljava/lang/Object;
.source "Event.java"


# instance fields
.field content:Ljava/lang/String;

.field status:I

.field title:Ljava/lang/String;

.field user:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getContent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/umberapp/umber/models/Event;->content:Ljava/lang/String;

    return-object v0
.end method

.method public getStatus()I
    .locals 1

    .prologue
    .line 21
    iget v0, p0, Lcom/umberapp/umber/models/Event;->status:I

    return v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/umberapp/umber/models/Event;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getUser()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/umberapp/umber/models/Event;->user:Ljava/lang/String;

    return-object v0
.end method

.method public setContent(Ljava/lang/String;)V
    .locals 0
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    .line 17
    iput-object p1, p0, Lcom/umberapp/umber/models/Event;->content:Ljava/lang/String;

    .line 18
    return-void
.end method

.method public setStatus(I)V
    .locals 0
    .param p1, "status"    # I

    .prologue
    .line 25
    iput p1, p0, Lcom/umberapp/umber/models/Event;->status:I

    .line 26
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/umberapp/umber/models/Event;->title:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setUser(Ljava/lang/String;)V
    .locals 0
    .param p1, "user"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/umberapp/umber/models/Event;->user:Ljava/lang/String;

    .line 42
    return-void
.end method
