.class public Lcom/umberapp/umber/models/Tag;
.super Ljava/lang/Object;
.source "Tag.java"


# instance fields
.field id:Ljava/lang/String;

.field text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/umberapp/umber/models/Tag;->text:Ljava/lang/String;

    .line 14
    return-void
.end method


# virtual methods
.method public getText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/umberapp/umber/models/Tag;->text:Ljava/lang/String;

    return-object v0
.end method

.method public setText(Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/umberapp/umber/models/Tag;->text:Ljava/lang/String;

    .line 21
    return-void
.end method
