.class public Lcom/umberapp/umber/models/OrderItem;
.super Ljava/lang/Object;
.source "OrderItem.java"


# instance fields
.field address:Ljava/lang/String;

.field audio:Ljava/lang/String;

.field category:Ljava/lang/String;

.field coordinates:[D

.field createdAt:Ljava/lang/String;

.field customer:Ljava/lang/String;

.field dateBooking:J

.field experts:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field expertsFinding:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field hasSend:Ljava/lang/String;

.field id:Ljava/lang/String;

.field invoice:Ljava/lang/String;

.field payment:Ljava/lang/String;

.field pictures:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Picture;",
            ">;"
        }
    .end annotation
.end field

.field promotion:Ljava/lang/String;

.field rangeTime:Lcom/umberapp/umber/models/RangeTime;

.field status:Ljava/lang/String;

.field tags:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Tag;",
            ">;"
        }
    .end annotation
.end field

.field updatedAt:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->address:Ljava/lang/String;

    return-object v0
.end method

.method public getAudio()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->audio:Ljava/lang/String;

    return-object v0
.end method

.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->category:Ljava/lang/String;

    return-object v0
.end method

.method public getCoordinates()[D
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->coordinates:[D

    return-object v0
.end method

.method public getCreatedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->createdAt:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->customer:Ljava/lang/String;

    return-object v0
.end method

.method public getDateBooking()J
    .locals 2

    .prologue
    .line 145
    iget-wide v0, p0, Lcom/umberapp/umber/models/OrderItem;->dateBooking:J

    return-wide v0
.end method

.method public getExperts()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 153
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->experts:Ljava/util/List;

    return-object v0
.end method

.method public getExpertsFinding()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 81
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->expertsFinding:Ljava/util/List;

    return-object v0
.end method

.method public getHasSend()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->hasSend:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getInvoice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->invoice:Ljava/lang/String;

    return-object v0
.end method

.method public getPayment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->payment:Ljava/lang/String;

    return-object v0
.end method

.method public getPictures()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Picture;",
            ">;"
        }
    .end annotation

    .prologue
    .line 162
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->pictures:Ljava/util/List;

    return-object v0
.end method

.method public getPromotion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->promotion:Ljava/lang/String;

    return-object v0
.end method

.method public getRangeTime()Lcom/umberapp/umber/models/RangeTime;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->rangeTime:Lcom/umberapp/umber/models/RangeTime;

    return-object v0
.end method

.method public getStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->status:Ljava/lang/String;

    return-object v0
.end method

.method public getTags()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Tag;",
            ">;"
        }
    .end annotation

    .prologue
    .line 178
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->tags:Ljava/util/List;

    return-object v0
.end method

.method public getUpdatedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/umberapp/umber/models/OrderItem;->updatedAt:Ljava/lang/String;

    return-object v0
.end method

.method public setAddress(Ljava/lang/String;)V
    .locals 0
    .param p1, "address"    # Ljava/lang/String;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->address:Ljava/lang/String;

    .line 126
    return-void
.end method

.method public setAudio(Ljava/lang/String;)V
    .locals 0
    .param p1, "audio"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->audio:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setCategory(Ljava/lang/String;)V
    .locals 0
    .param p1, "category"    # Ljava/lang/String;

    .prologue
    .line 133
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->category:Ljava/lang/String;

    .line 134
    return-void
.end method

.method public setCoordinates([D)V
    .locals 0
    .param p1, "coordinates"    # [D

    .prologue
    .line 45
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->coordinates:[D

    .line 46
    return-void
.end method

.method public setCreatedAt(Ljava/lang/String;)V
    .locals 0
    .param p1, "createAt"    # Ljava/lang/String;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->createdAt:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public setCustomer(Ljava/lang/String;)V
    .locals 0
    .param p1, "customer"    # Ljava/lang/String;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->customer:Ljava/lang/String;

    .line 142
    return-void
.end method

.method public setDateBooking(J)V
    .locals 1
    .param p1, "dateBooking"    # J

    .prologue
    .line 149
    iput-wide p1, p0, Lcom/umberapp/umber/models/OrderItem;->dateBooking:J

    .line 150
    return-void
.end method

.method public setExperts(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 157
    .local p1, "experts":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->experts:Ljava/util/List;

    .line 158
    return-void
.end method

.method public setExpertsFinding(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 85
    .local p1, "expertsFinding":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->expertsFinding:Ljava/util/List;

    .line 86
    return-void
.end method

.method public setHasSend(Ljava/lang/String;)V
    .locals 0
    .param p1, "hasSend"    # Ljava/lang/String;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->hasSend:Ljava/lang/String;

    .line 94
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->id:Ljava/lang/String;

    .line 118
    return-void
.end method

.method public setInvoice(Ljava/lang/String;)V
    .locals 0
    .param p1, "invoice"    # Ljava/lang/String;

    .prologue
    .line 101
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->invoice:Ljava/lang/String;

    .line 102
    return-void
.end method

.method public setPayment(Ljava/lang/String;)V
    .locals 0
    .param p1, "payment"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->payment:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public setPictures(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Picture;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 166
    .local p1, "pictures":Ljava/util/List;, "Ljava/util/List<Lcom/umberapp/umber/models/Picture;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->pictures:Ljava/util/List;

    .line 167
    return-void
.end method

.method public setPromotion(Ljava/lang/String;)V
    .locals 0
    .param p1, "promotion"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->promotion:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public setRangeTime(Lcom/umberapp/umber/models/RangeTime;)V
    .locals 0
    .param p1, "rangeTime"    # Lcom/umberapp/umber/models/RangeTime;

    .prologue
    .line 174
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->rangeTime:Lcom/umberapp/umber/models/RangeTime;

    .line 175
    return-void
.end method

.method public setStatus(Ljava/lang/String;)V
    .locals 0
    .param p1, "status"    # Ljava/lang/String;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->status:Ljava/lang/String;

    .line 110
    return-void
.end method

.method public setTags(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Tag;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 182
    .local p1, "tags":Ljava/util/List;, "Ljava/util/List<Lcom/umberapp/umber/models/Tag;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->tags:Ljava/util/List;

    .line 183
    return-void
.end method

.method public setUpdatedAt(Ljava/lang/String;)V
    .locals 0
    .param p1, "updatedAt"    # Ljava/lang/String;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/umberapp/umber/models/OrderItem;->updatedAt:Ljava/lang/String;

    .line 70
    return-void
.end method
