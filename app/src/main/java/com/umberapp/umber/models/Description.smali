.class public Lcom/umberapp/umber/models/Description;
.super Ljava/lang/Object;
.source "Description.java"


# instance fields
.field description:Ljava/lang/String;

.field label:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/umberapp/umber/models/Description;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/umberapp/umber/models/Description;->label:Ljava/lang/String;

    return-object v0
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 17
    iput-object p1, p0, Lcom/umberapp/umber/models/Description;->description:Ljava/lang/String;

    .line 18
    return-void
.end method

.method public setLabel(Ljava/lang/String;)V
    .locals 0
    .param p1, "label"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/umberapp/umber/models/Description;->label:Ljava/lang/String;

    .line 26
    return-void
.end method
