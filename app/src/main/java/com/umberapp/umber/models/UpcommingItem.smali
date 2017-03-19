.class public Lcom/umberapp/umber/models/UpcommingItem;
.super Ljava/lang/Object;
.source "UpcommingItem.java"


# instance fields
.field address:Ljava/lang/String;

.field audio:Ljava/lang/String;

.field category:Lcom/umberapp/umber/models/Category;

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

.field promotion:Ljava/lang/String;

.field rangeTime:Lcom/umberapp/umber/models/RangeTime;

.field status:Ljava/lang/String;

.field updatedAt:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->address:Ljava/lang/String;

    return-object v0
.end method

.method public getAudio()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->audio:Ljava/lang/String;

    return-object v0
.end method

.method public getCategory()Lcom/umberapp/umber/models/Category;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->category:Lcom/umberapp/umber/models/Category;

    return-object v0
.end method

.method public getCoordinates()[D
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->coordinates:[D

    return-object v0
.end method

.method public getCreatedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->createdAt:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->customer:Ljava/lang/String;

    return-object v0
.end method

.method public getDateBooking()J
    .locals 2

    .prologue
    .line 135
    iget-wide v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->dateBooking:J

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
    .line 143
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->experts:Ljava/util/List;

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
    .line 71
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->expertsFinding:Ljava/util/List;

    return-object v0
.end method

.method public getHasSend()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->hasSend:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getInvoice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->invoice:Ljava/lang/String;

    return-object v0
.end method

.method public getPromotion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->promotion:Ljava/lang/String;

    return-object v0
.end method

.method public getRangeTime()Lcom/umberapp/umber/models/RangeTime;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->rangeTime:Lcom/umberapp/umber/models/RangeTime;

    return-object v0
.end method

.method public getStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->status:Ljava/lang/String;

    return-object v0
.end method

.method public getUpdatedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/umberapp/umber/models/UpcommingItem;->updatedAt:Ljava/lang/String;

    return-object v0
.end method

.method public setAddress(Ljava/lang/String;)V
    .locals 0
    .param p1, "address"    # Ljava/lang/String;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->address:Ljava/lang/String;

    .line 116
    return-void
.end method

.method public setAudio(Ljava/lang/String;)V
    .locals 0
    .param p1, "audio"    # Ljava/lang/String;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->audio:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setCategory(Lcom/umberapp/umber/models/Category;)V
    .locals 0
    .param p1, "category"    # Lcom/umberapp/umber/models/Category;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->category:Lcom/umberapp/umber/models/Category;

    .line 124
    return-void
.end method

.method public setCoordinates([D)V
    .locals 0
    .param p1, "coordinates"    # [D

    .prologue
    .line 35
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->coordinates:[D

    .line 36
    return-void
.end method

.method public setCreatedAt(Ljava/lang/String;)V
    .locals 0
    .param p1, "createAt"    # Ljava/lang/String;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->createdAt:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setCustomer(Ljava/lang/String;)V
    .locals 0
    .param p1, "customer"    # Ljava/lang/String;

    .prologue
    .line 131
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->customer:Ljava/lang/String;

    .line 132
    return-void
.end method

.method public setDateBooking(J)V
    .locals 1
    .param p1, "dateBooking"    # J

    .prologue
    .line 139
    iput-wide p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->dateBooking:J

    .line 140
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
    .line 147
    .local p1, "experts":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->experts:Ljava/util/List;

    .line 148
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
    .line 75
    .local p1, "expertsFinding":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->expertsFinding:Ljava/util/List;

    .line 76
    return-void
.end method

.method public setHasSend(Ljava/lang/String;)V
    .locals 0
    .param p1, "hasSend"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->hasSend:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 107
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->id:Ljava/lang/String;

    .line 108
    return-void
.end method

.method public setInvoice(Ljava/lang/String;)V
    .locals 0
    .param p1, "invoice"    # Ljava/lang/String;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->invoice:Ljava/lang/String;

    .line 92
    return-void
.end method

.method public setPromotion(Ljava/lang/String;)V
    .locals 0
    .param p1, "promotion"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->promotion:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setRangeTime(Lcom/umberapp/umber/models/RangeTime;)V
    .locals 0
    .param p1, "rangeTime"    # Lcom/umberapp/umber/models/RangeTime;

    .prologue
    .line 158
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->rangeTime:Lcom/umberapp/umber/models/RangeTime;

    .line 159
    return-void
.end method

.method public setStatus(Ljava/lang/String;)V
    .locals 0
    .param p1, "status"    # Ljava/lang/String;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->status:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setUpdatedAt(Ljava/lang/String;)V
    .locals 0
    .param p1, "updatedAt"    # Ljava/lang/String;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/umberapp/umber/models/UpcommingItem;->updatedAt:Ljava/lang/String;

    .line 60
    return-void
.end method
