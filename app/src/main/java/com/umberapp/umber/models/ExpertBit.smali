.class public Lcom/umberapp/umber/models/ExpertBit;
.super Lcom/umberapp/umber/models/User;
.source "ExpertBit.java"


# instance fields
.field cashPayment:Ljava/lang/String;

.field category:Ljava/lang/String;

.field costHour:D

.field dateBooking:J

.field distance:D

.field infoExpert:Ljava/lang/String;

.field timeRange:Lcom/umberapp/umber/models/RangeTime;

.field totalOrderSuccess:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/umberapp/umber/models/User;-><init>()V

    return-void
.end method


# virtual methods
.method public getCashPayment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/umberapp/umber/models/ExpertBit;->cashPayment:Ljava/lang/String;

    return-object v0
.end method

.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/umberapp/umber/models/ExpertBit;->category:Ljava/lang/String;

    return-object v0
.end method

.method public getCostHour()D
    .locals 2

    .prologue
    .line 69
    iget-wide v0, p0, Lcom/umberapp/umber/models/ExpertBit;->costHour:D

    return-wide v0
.end method

.method public getDateBooking()J
    .locals 2

    .prologue
    .line 77
    iget-wide v0, p0, Lcom/umberapp/umber/models/ExpertBit;->dateBooking:J

    return-wide v0
.end method

.method public getDistance()D
    .locals 2

    .prologue
    .line 21
    iget-wide v0, p0, Lcom/umberapp/umber/models/ExpertBit;->distance:D

    return-wide v0
.end method

.method public getInfoExpert()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/umberapp/umber/models/ExpertBit;->infoExpert:Ljava/lang/String;

    return-object v0
.end method

.method public getTimeRange()Lcom/umberapp/umber/models/RangeTime;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/umberapp/umber/models/ExpertBit;->timeRange:Lcom/umberapp/umber/models/RangeTime;

    return-object v0
.end method

.method public getTotalOrderSuccess()I
    .locals 1

    .prologue
    .line 93
    iget v0, p0, Lcom/umberapp/umber/models/ExpertBit;->totalOrderSuccess:I

    return v0
.end method

.method public setCashPayment(Ljava/lang/String;)V
    .locals 0
    .param p1, "cashPayment"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/umberapp/umber/models/ExpertBit;->cashPayment:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setCategory(Ljava/lang/String;)V
    .locals 0
    .param p1, "category"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/umberapp/umber/models/ExpertBit;->category:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setCostHour(D)V
    .locals 1
    .param p1, "costHour"    # D

    .prologue
    .line 73
    iput-wide p1, p0, Lcom/umberapp/umber/models/ExpertBit;->costHour:D

    .line 74
    return-void
.end method

.method public setDateBooking(J)V
    .locals 1
    .param p1, "dateBooking"    # J

    .prologue
    .line 81
    iput-wide p1, p0, Lcom/umberapp/umber/models/ExpertBit;->dateBooking:J

    .line 82
    return-void
.end method

.method public setDistance(D)V
    .locals 1
    .param p1, "distance"    # D

    .prologue
    .line 25
    iput-wide p1, p0, Lcom/umberapp/umber/models/ExpertBit;->distance:D

    .line 26
    return-void
.end method

.method public setInfoExpert(Ljava/lang/String;)V
    .locals 0
    .param p1, "infoExpert"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/umberapp/umber/models/ExpertBit;->infoExpert:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setTimeRange(Lcom/umberapp/umber/models/RangeTime;)V
    .locals 0
    .param p1, "timeRange"    # Lcom/umberapp/umber/models/RangeTime;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/umberapp/umber/models/ExpertBit;->timeRange:Lcom/umberapp/umber/models/RangeTime;

    .line 90
    return-void
.end method

.method public setTotalOrderSuccess(I)V
    .locals 0
    .param p1, "totalOrderSuccess"    # I

    .prologue
    .line 97
    iput p1, p0, Lcom/umberapp/umber/models/ExpertBit;->totalOrderSuccess:I

    .line 98
    return-void
.end method
