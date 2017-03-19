.class public Lcom/umberapp/umber/models/ExpertMarker;
.super Lcom/umberapp/umber/models/User;
.source "ExpertMarker.java"


# instance fields
.field cashPayment:Ljava/lang/String;

.field category:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Category;",
            ">;"
        }
    .end annotation
.end field

.field costHour:D

.field dateBooking:I

.field jobsDone:I

.field location:[D

.field maxFeeToPaid:D

.field timeRange:Lcom/umberapp/umber/models/RangeTime;

.field totalOrderSuccess:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/umberapp/umber/models/User;-><init>()V

    return-void
.end method


# virtual methods
.method public getCashPayment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/umberapp/umber/models/ExpertMarker;->cashPayment:Ljava/lang/String;

    return-object v0
.end method

.method public getCategory()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Category;",
            ">;"
        }
    .end annotation

    .prologue
    .line 48
    iget-object v0, p0, Lcom/umberapp/umber/models/ExpertMarker;->category:Ljava/util/List;

    return-object v0
.end method

.method public getCostHour()D
    .locals 2

    .prologue
    .line 80
    iget-wide v0, p0, Lcom/umberapp/umber/models/ExpertMarker;->costHour:D

    return-wide v0
.end method

.method public getDateBooking()I
    .locals 1

    .prologue
    .line 88
    iget v0, p0, Lcom/umberapp/umber/models/ExpertMarker;->dateBooking:I

    return v0
.end method

.method public getJobsDone()I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/umberapp/umber/models/ExpertMarker;->jobsDone:I

    return v0
.end method

.method public getLocation()[D
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/umberapp/umber/models/ExpertMarker;->location:[D

    return-object v0
.end method

.method public getMaxFeeToPaid()D
    .locals 2

    .prologue
    .line 72
    iget-wide v0, p0, Lcom/umberapp/umber/models/ExpertMarker;->maxFeeToPaid:D

    return-wide v0
.end method

.method public getTimeRange()Lcom/umberapp/umber/models/RangeTime;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/umberapp/umber/models/ExpertMarker;->timeRange:Lcom/umberapp/umber/models/RangeTime;

    return-object v0
.end method

.method public getTotalOrderSuccess()I
    .locals 1

    .prologue
    .line 104
    iget v0, p0, Lcom/umberapp/umber/models/ExpertMarker;->totalOrderSuccess:I

    return v0
.end method

.method public setCashPayment(Ljava/lang/String;)V
    .locals 0
    .param p1, "cashPayment"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/umberapp/umber/models/ExpertMarker;->cashPayment:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setCategory(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Category;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 52
    .local p1, "category":Ljava/util/List;, "Ljava/util/List<Lcom/umberapp/umber/models/Category;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/ExpertMarker;->category:Ljava/util/List;

    .line 53
    return-void
.end method

.method public setCostHour(D)V
    .locals 1
    .param p1, "costHour"    # D

    .prologue
    .line 84
    iput-wide p1, p0, Lcom/umberapp/umber/models/ExpertMarker;->costHour:D

    .line 85
    return-void
.end method

.method public setDateBooking(I)V
    .locals 0
    .param p1, "dateBooking"    # I

    .prologue
    .line 92
    iput p1, p0, Lcom/umberapp/umber/models/ExpertMarker;->dateBooking:I

    .line 93
    return-void
.end method

.method public setJobsDone(I)V
    .locals 0
    .param p1, "jobsDone"    # I

    .prologue
    .line 36
    iput p1, p0, Lcom/umberapp/umber/models/ExpertMarker;->jobsDone:I

    .line 37
    return-void
.end method

.method public setLocation([D)V
    .locals 0
    .param p1, "location"    # [D

    .prologue
    .line 68
    iput-object p1, p0, Lcom/umberapp/umber/models/ExpertMarker;->location:[D

    .line 69
    return-void
.end method

.method public setMaxFeeToPaid(D)V
    .locals 1
    .param p1, "maxFeeToPaid"    # D

    .prologue
    .line 76
    iput-wide p1, p0, Lcom/umberapp/umber/models/ExpertMarker;->maxFeeToPaid:D

    .line 77
    return-void
.end method

.method public setTimeRange(Lcom/umberapp/umber/models/RangeTime;)V
    .locals 0
    .param p1, "timeRange"    # Lcom/umberapp/umber/models/RangeTime;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/umberapp/umber/models/ExpertMarker;->timeRange:Lcom/umberapp/umber/models/RangeTime;

    .line 101
    return-void
.end method

.method public setTotalOrderSuccess(I)V
    .locals 0
    .param p1, "totalOrderSuccess"    # I

    .prologue
    .line 108
    iput p1, p0, Lcom/umberapp/umber/models/ExpertMarker;->totalOrderSuccess:I

    .line 109
    return-void
.end method
