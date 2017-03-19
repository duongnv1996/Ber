.class public Lcom/umberapp/umber/models/NotificationItemPage;
.super Ljava/lang/Object;
.source "NotificationItemPage.java"


# instance fields
.field content:Lcom/umberapp/umber/models/Content;

.field createdAt:Ljava/lang/String;

.field from:Lcom/umberapp/umber/models/Expert;

.field id:Ljava/lang/String;

.field seen:I

.field seenAt:Ljava/lang/String;

.field to:Ljava/lang/String;

.field type:Ljava/lang/String;

.field updatedAt:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method


# virtual methods
.method public getContent()Lcom/umberapp/umber/models/Content;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItemPage;->content:Lcom/umberapp/umber/models/Content;

    return-object v0
.end method

.method public getCreatedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItemPage;->createdAt:Ljava/lang/String;

    return-object v0
.end method

.method public getFrom()Lcom/umberapp/umber/models/Expert;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItemPage;->from:Lcom/umberapp/umber/models/Expert;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItemPage;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getSeen()I
    .locals 1

    .prologue
    .line 76
    iget v0, p0, Lcom/umberapp/umber/models/NotificationItemPage;->seen:I

    return v0
.end method

.method public getSeenAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItemPage;->seenAt:Ljava/lang/String;

    return-object v0
.end method

.method public getTo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItemPage;->to:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItemPage;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getUpdatedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/umberapp/umber/models/NotificationItemPage;->updatedAt:Ljava/lang/String;

    return-object v0
.end method

.method public setContent(Lcom/umberapp/umber/models/Content;)V
    .locals 0
    .param p1, "content"    # Lcom/umberapp/umber/models/Content;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItemPage;->content:Lcom/umberapp/umber/models/Content;

    .line 32
    return-void
.end method

.method public setCreatedAt(Ljava/lang/String;)V
    .locals 0
    .param p1, "createdAt"    # Ljava/lang/String;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItemPage;->createdAt:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setFrom(Lcom/umberapp/umber/models/Expert;)V
    .locals 0
    .param p1, "from"    # Lcom/umberapp/umber/models/Expert;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItemPage;->from:Lcom/umberapp/umber/models/Expert;

    .line 41
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItemPage;->id:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setSeen(I)V
    .locals 0
    .param p1, "seen"    # I

    .prologue
    .line 80
    iput p1, p0, Lcom/umberapp/umber/models/NotificationItemPage;->seen:I

    .line 81
    return-void
.end method

.method public setSeenAt(Ljava/lang/String;)V
    .locals 0
    .param p1, "seenAt"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItemPage;->seenAt:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public setTo(Ljava/lang/String;)V
    .locals 0
    .param p1, "to"    # Ljava/lang/String;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItemPage;->to:Ljava/lang/String;

    .line 89
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 96
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItemPage;->type:Ljava/lang/String;

    .line 97
    return-void
.end method

.method public setUpdatedAt(Ljava/lang/String;)V
    .locals 0
    .param p1, "updatedAt"    # Ljava/lang/String;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/umberapp/umber/models/NotificationItemPage;->updatedAt:Ljava/lang/String;

    .line 73
    return-void
.end method
