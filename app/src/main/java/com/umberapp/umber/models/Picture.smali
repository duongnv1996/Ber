.class public Lcom/umberapp/umber/models/Picture;
.super Ljava/lang/Object;
.source "Picture.java"


# instance fields
.field link:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/umberapp/umber/models/Picture;->link:Ljava/lang/String;

    return-object v0
.end method

.method public setLink(Ljava/lang/String;)V
    .locals 0
    .param p1, "link"    # Ljava/lang/String;

    .prologue
    .line 17
    iput-object p1, p0, Lcom/umberapp/umber/models/Picture;->link:Ljava/lang/String;

    .line 18
    return-void
.end method
