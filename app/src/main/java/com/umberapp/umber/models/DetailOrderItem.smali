.class public Lcom/umberapp/umber/models/DetailOrderItem;
.super Ljava/lang/Object;
.source "DetailOrderItem.java"


# instance fields
.field private address:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "address"
    .end annotation
.end field

.field private audio:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "audio"
    .end annotation
.end field

.field private avatar:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "avatar"
    .end annotation
.end field

.field private category:Lcom/umberapp/umber/models/Category;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "category"
    .end annotation
.end field

.field private costHour:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "costHour"
    .end annotation
.end field

.field private createdAt:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "createdAt"
    .end annotation
.end field

.field private customer:Lcom/umberapp/umber/models/User;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "customer"
    .end annotation
.end field

.field private dateBooking:J
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "dateBooking"
    .end annotation
.end field

.field private decline:Lcom/umberapp/umber/models/User;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "decline"
    .end annotation
.end field

.field private detailDecline:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "detailDecline"
    .end annotation
.end field

.field private exoertsJoined:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "expertsJoined"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/ExpertBit;",
            ">;"
        }
    .end annotation
.end field

.field private expert:Lcom/umberapp/umber/models/Expert;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "expert"
    .end annotation
.end field

.field private expertsFinding:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "expertsFinding"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private first_name:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "first_name"
    .end annotation
.end field

.field private hasSend:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "hasSend"
    .end annotation
.end field

.field private id:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "id"
    .end annotation
.end field

.field private invoice:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "invoice"
    .end annotation
.end field

.field private jobsDone:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "jobsDone"
    .end annotation
.end field

.field private last_name:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "last_name"
    .end annotation
.end field

.field private payment:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "payment"
    .end annotation
.end field

.field private rangeTime:Lcom/umberapp/umber/models/RangeTime;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "rangeTime"
    .end annotation
.end field

.field private rating:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "rating"
    .end annotation
.end field

.field private status:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "status"
    .end annotation
.end field

.field private tags:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "tags"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Tag;",
            ">;"
        }
    .end annotation
.end field

.field private totalOrderSuccess:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "totalOrderSuccess"
    .end annotation
.end field

.field private transaction:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "transaction"
    .end annotation
.end field

.field private updatedAt:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "updatedAt"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->address:Ljava/lang/String;

    return-object v0
.end method

.method public getAudio()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->audio:Ljava/lang/String;

    return-object v0
.end method

.method public getAvatar()Ljava/lang/String;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->avatar:Ljava/lang/String;

    return-object v0
.end method

.method public getCategory()Lcom/umberapp/umber/models/Category;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->category:Lcom/umberapp/umber/models/Category;

    return-object v0
.end method

.method public getCostHour()I
    .locals 1

    .prologue
    .line 211
    iget v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->costHour:I

    return v0
.end method

.method public getCreatedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->createdAt:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomer()Lcom/umberapp/umber/models/User;
    .locals 1

    .prologue
    .line 260
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->customer:Lcom/umberapp/umber/models/User;

    return-object v0
.end method

.method public getDateBooking()J
    .locals 2

    .prologue
    .line 139
    iget-wide v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->dateBooking:J

    return-wide v0
.end method

.method public getDecline()Lcom/umberapp/umber/models/User;
    .locals 1

    .prologue
    .line 268
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->decline:Lcom/umberapp/umber/models/User;

    return-object v0
.end method

.method public getDetailDecline()Ljava/lang/String;
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->detailDecline:Ljava/lang/String;

    return-object v0
.end method

.method public getExoertsJoined()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/ExpertBit;",
            ">;"
        }
    .end annotation

    .prologue
    .line 81
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->exoertsJoined:Ljava/util/List;

    return-object v0
.end method

.method public getExpert()Lcom/umberapp/umber/models/Expert;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->expert:Lcom/umberapp/umber/models/Expert;

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
    .line 276
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->expertsFinding:Ljava/util/List;

    return-object v0
.end method

.method public getFirst_name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->first_name:Ljava/lang/String;

    return-object v0
.end method

.method public getHasSend()Ljava/lang/String;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->hasSend:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 244
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getInvoice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->invoice:Ljava/lang/String;

    return-object v0
.end method

.method public getJobsDone()I
    .locals 1

    .prologue
    .line 252
    iget v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->jobsDone:I

    return v0
.end method

.method public getLast_name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->last_name:Ljava/lang/String;

    return-object v0
.end method

.method public getPayment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 228
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->payment:Ljava/lang/String;

    return-object v0
.end method

.method public getRangeTime()Lcom/umberapp/umber/models/RangeTime;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->rangeTime:Lcom/umberapp/umber/models/RangeTime;

    return-object v0
.end method

.method public getRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->rating:Ljava/lang/String;

    return-object v0
.end method

.method public getStatus()Ljava/lang/String;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->status:Ljava/lang/String;

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
    .line 285
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->tags:Ljava/util/List;

    return-object v0
.end method

.method public getTotalOrderSuccess()I
    .locals 1

    .prologue
    .line 203
    iget v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->totalOrderSuccess:I

    return v0
.end method

.method public getTransaction()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->transaction:Ljava/lang/String;

    return-object v0
.end method

.method public getUpdatedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/umberapp/umber/models/DetailOrderItem;->updatedAt:Ljava/lang/String;

    return-object v0
.end method

.method public setAddress(Ljava/lang/String;)V
    .locals 0
    .param p1, "address"    # Ljava/lang/String;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->address:Ljava/lang/String;

    .line 127
    return-void
.end method

.method public setAudio(Ljava/lang/String;)V
    .locals 0
    .param p1, "audio"    # Ljava/lang/String;

    .prologue
    .line 135
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->audio:Ljava/lang/String;

    .line 136
    return-void
.end method

.method public setAvatar(Ljava/lang/String;)V
    .locals 0
    .param p1, "avatar"    # Ljava/lang/String;

    .prologue
    .line 223
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->avatar:Ljava/lang/String;

    .line 224
    return-void
.end method

.method public setCategory(Lcom/umberapp/umber/models/Category;)V
    .locals 0
    .param p1, "category"    # Lcom/umberapp/umber/models/Category;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->category:Lcom/umberapp/umber/models/Category;

    .line 78
    return-void
.end method

.method public setCostHour(I)V
    .locals 0
    .param p1, "costHour"    # I

    .prologue
    .line 215
    iput p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->costHour:I

    .line 216
    return-void
.end method

.method public setCreatedAt(Ljava/lang/String;)V
    .locals 0
    .param p1, "createdAt"    # Ljava/lang/String;

    .prologue
    .line 175
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->createdAt:Ljava/lang/String;

    .line 176
    return-void
.end method

.method public setCustomer(Lcom/umberapp/umber/models/User;)V
    .locals 0
    .param p1, "customer"    # Lcom/umberapp/umber/models/User;

    .prologue
    .line 264
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->customer:Lcom/umberapp/umber/models/User;

    .line 265
    return-void
.end method

.method public setDateBooking(J)V
    .locals 1
    .param p1, "dateBooking"    # J

    .prologue
    .line 143
    iput-wide p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->dateBooking:J

    .line 144
    return-void
.end method

.method public setDecline(Lcom/umberapp/umber/models/User;)V
    .locals 0
    .param p1, "decline"    # Lcom/umberapp/umber/models/User;

    .prologue
    .line 272
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->decline:Lcom/umberapp/umber/models/User;

    .line 273
    return-void
.end method

.method public setDetailDecline(Ljava/lang/String;)V
    .locals 0
    .param p1, "detailDecline"    # Ljava/lang/String;

    .prologue
    .line 240
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->detailDecline:Ljava/lang/String;

    .line 241
    return-void
.end method

.method public setExoertsJoined(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/ExpertBit;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 85
    .local p1, "exoertsJoined":Ljava/util/List;, "Ljava/util/List<Lcom/umberapp/umber/models/ExpertBit;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->exoertsJoined:Ljava/util/List;

    .line 86
    return-void
.end method

.method public setExpert(Lcom/umberapp/umber/models/Expert;)V
    .locals 0
    .param p1, "expert"    # Lcom/umberapp/umber/models/Expert;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->expert:Lcom/umberapp/umber/models/Expert;

    .line 94
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
    .line 280
    .local p1, "expertsFinding":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->expertsFinding:Ljava/util/List;

    .line 281
    return-void
.end method

.method public setFirst_name(Ljava/lang/String;)V
    .locals 0
    .param p1, "first_name"    # Ljava/lang/String;

    .prologue
    .line 191
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->first_name:Ljava/lang/String;

    .line 192
    return-void
.end method

.method public setHasSend(Ljava/lang/String;)V
    .locals 0
    .param p1, "hasSend"    # Ljava/lang/String;

    .prologue
    .line 159
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->hasSend:Ljava/lang/String;

    .line 160
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 248
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->id:Ljava/lang/String;

    .line 249
    return-void
.end method

.method public setInvoice(Ljava/lang/String;)V
    .locals 0
    .param p1, "invoice"    # Ljava/lang/String;

    .prologue
    .line 167
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->invoice:Ljava/lang/String;

    .line 168
    return-void
.end method

.method public setJobsDone(I)V
    .locals 0
    .param p1, "jobsDone"    # I

    .prologue
    .line 256
    iput p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->jobsDone:I

    .line 257
    return-void
.end method

.method public setLast_name(Ljava/lang/String;)V
    .locals 0
    .param p1, "last_name"    # Ljava/lang/String;

    .prologue
    .line 199
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->last_name:Ljava/lang/String;

    .line 200
    return-void
.end method

.method public setPayment(Ljava/lang/String;)V
    .locals 0
    .param p1, "payment"    # Ljava/lang/String;

    .prologue
    .line 232
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->payment:Ljava/lang/String;

    .line 233
    return-void
.end method

.method public setRangeTime(Lcom/umberapp/umber/models/RangeTime;)V
    .locals 0
    .param p1, "rangeTime"    # Lcom/umberapp/umber/models/RangeTime;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->rangeTime:Lcom/umberapp/umber/models/RangeTime;

    .line 119
    return-void
.end method

.method public setRating(Ljava/lang/String;)V
    .locals 0
    .param p1, "rating"    # Ljava/lang/String;

    .prologue
    .line 101
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->rating:Ljava/lang/String;

    .line 102
    return-void
.end method

.method public setStatus(Ljava/lang/String;)V
    .locals 0
    .param p1, "status"    # Ljava/lang/String;

    .prologue
    .line 151
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->status:Ljava/lang/String;

    .line 152
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
    .line 289
    .local p1, "tags":Ljava/util/List;, "Ljava/util/List<Lcom/umberapp/umber/models/Tag;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->tags:Ljava/util/List;

    .line 290
    return-void
.end method

.method public setTotalOrderSuccess(I)V
    .locals 0
    .param p1, "totalOrderSuccess"    # I

    .prologue
    .line 207
    iput p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->totalOrderSuccess:I

    .line 208
    return-void
.end method

.method public setTransaction(Ljava/lang/String;)V
    .locals 0
    .param p1, "transaction"    # Ljava/lang/String;

    .prologue
    .line 110
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->transaction:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public setUpdatedAt(Ljava/lang/String;)V
    .locals 0
    .param p1, "updatedAt"    # Ljava/lang/String;

    .prologue
    .line 183
    iput-object p1, p0, Lcom/umberapp/umber/models/DetailOrderItem;->updatedAt:Ljava/lang/String;

    .line 184
    return-void
.end method
