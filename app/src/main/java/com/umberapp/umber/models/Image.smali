.class public Lcom/umberapp/umber/models/Image;
.super Ljava/lang/Object;
.source "Image.java"


# instance fields
.field id:I

.field path:Ljava/lang/String;

.field photo:Landroid/graphics/Bitmap;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getId()I
    .locals 1

    .prologue
    .line 15
    iget v0, p0, Lcom/umberapp/umber/models/Image;->id:I

    return v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/umberapp/umber/models/Image;->path:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoto()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/umberapp/umber/models/Image;->photo:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public setId(I)V
    .locals 0
    .param p1, "id"    # I

    .prologue
    .line 19
    iput p1, p0, Lcom/umberapp/umber/models/Image;->id:I

    .line 20
    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/umberapp/umber/models/Image;->path:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setPhoto(Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "photo"    # Landroid/graphics/Bitmap;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/umberapp/umber/models/Image;->photo:Landroid/graphics/Bitmap;

    .line 36
    return-void
.end method
