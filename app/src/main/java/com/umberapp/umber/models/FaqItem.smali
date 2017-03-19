.class public Lcom/umberapp/umber/models/FaqItem;
.super Ljava/lang/Object;
.source "FaqItem.java"


# instance fields
.field public content:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getContent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/umberapp/umber/models/FaqItem;->content:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/umberapp/umber/models/FaqItem;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setContent(Ljava/lang/String;)V
    .locals 0
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    .line 22
    iput-object p1, p0, Lcom/umberapp/umber/models/FaqItem;->content:Ljava/lang/String;

    .line 23
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/umberapp/umber/models/FaqItem;->title:Ljava/lang/String;

    .line 32
    return-void
.end method
