.class public Lcom/umberapp/umber/models/Category;
.super Ljava/lang/Object;
.source "Category.java"


# instance fields
.field costHour:D

.field icon:Ljava/lang/String;

.field id:Ljava/lang/String;

.field marker:Ljava/lang/String;

.field name:Ljava/lang/String;

.field parent:Ljava/lang/String;

.field status:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCostHour()D
    .locals 2

    .prologue
    .line 20
    iget-wide v0, p0, Lcom/umberapp/umber/models/Category;->costHour:D

    return-wide v0
.end method

.method public getIcon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/umberapp/umber/models/Category;->icon:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/umberapp/umber/models/Category;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getMarker()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/umberapp/umber/models/Category;->marker:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/umberapp/umber/models/Category;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getParent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/umberapp/umber/models/Category;->parent:Ljava/lang/String;

    return-object v0
.end method

.method public getStatus()I
    .locals 1

    .prologue
    .line 68
    iget v0, p0, Lcom/umberapp/umber/models/Category;->status:I

    return v0
.end method

.method public setCostHour(D)V
    .locals 1
    .param p1, "costHour"    # D

    .prologue
    .line 24
    iput-wide p1, p0, Lcom/umberapp/umber/models/Category;->costHour:D

    .line 25
    return-void
.end method

.method public setIcon(Ljava/lang/String;)V
    .locals 0
    .param p1, "icon"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/umberapp/umber/models/Category;->icon:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/umberapp/umber/models/Category;->id:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setMarker(Ljava/lang/String;)V
    .locals 0
    .param p1, "marker"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/umberapp/umber/models/Category;->marker:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/umberapp/umber/models/Category;->name:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setParent(Ljava/lang/String;)V
    .locals 0
    .param p1, "parent"    # Ljava/lang/String;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/umberapp/umber/models/Category;->parent:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public setStatus(I)V
    .locals 0
    .param p1, "status"    # I

    .prologue
    .line 72
    iput p1, p0, Lcom/umberapp/umber/models/Category;->status:I

    .line 73
    return-void
.end method
