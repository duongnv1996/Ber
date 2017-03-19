.class public Lcom/umberapp/umber/models/Expert;
.super Lcom/umberapp/umber/models/User;
.source "Expert.java"


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

.field coordinates:[Ljava/lang/String;

.field costHour:D

.field dateBooking:I

.field jobsDone:I

.field location:[D

.field maxFeeToPaid:D

.field selfDescriptions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Description;",
            ">;"
        }
    .end annotation
.end field

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
    .line 48
    iget-object v0, p0, Lcom/umberapp/umber/models/Expert;->cashPayment:Ljava/lang/String;

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
    .line 56
    iget-object v0, p0, Lcom/umberapp/umber/models/Expert;->category:Ljava/util/List;

    return-object v0
.end method

.method public getCoordinates()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/umberapp/umber/models/Expert;->coordinates:[Ljava/lang/String;

    return-object v0
.end method

.method public getCostHour()D
    .locals 2

    .prologue
    .line 88
    iget-wide v0, p0, Lcom/umberapp/umber/models/Expert;->costHour:D

    return-wide v0
.end method

.method public getDateBooking()I
    .locals 1

    .prologue
    .line 96
    iget v0, p0, Lcom/umberapp/umber/models/Expert;->dateBooking:I

    return v0
.end method

.method public getJobsDone()I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/umberapp/umber/models/Expert;->jobsDone:I

    return v0
.end method

.method public getLocation()[D
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/umberapp/umber/models/Expert;->location:[D

    return-object v0
.end method

.method public getMaxFeeToPaid()D
    .locals 2

    .prologue
    .line 80
    iget-wide v0, p0, Lcom/umberapp/umber/models/Expert;->maxFeeToPaid:D

    return-wide v0
.end method

.method public getSelfDescriptions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Description;",
            ">;"
        }
    .end annotation

    .prologue
    .line 24
    iget-object v0, p0, Lcom/umberapp/umber/models/Expert;->selfDescriptions:Ljava/util/List;

    return-object v0
.end method

.method public getTimeRange()Lcom/umberapp/umber/models/RangeTime;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/umberapp/umber/models/Expert;->timeRange:Lcom/umberapp/umber/models/RangeTime;

    return-object v0
.end method

.method public getTotalOrderSuccess()I
    .locals 1

    .prologue
    .line 112
    iget v0, p0, Lcom/umberapp/umber/models/Expert;->totalOrderSuccess:I

    return v0
.end method

.method public setCashPayment(Ljava/lang/String;)V
    .locals 0
    .param p1, "cashPayment"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/umberapp/umber/models/Expert;->cashPayment:Ljava/lang/String;

    .line 53
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
    .line 60
    .local p1, "category":Ljava/util/List;, "Ljava/util/List<Lcom/umberapp/umber/models/Category;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/Expert;->category:Ljava/util/List;

    .line 61
    return-void
.end method

.method public setCoordinates([Ljava/lang/String;)V
    .locals 0
    .param p1, "coordinates"    # [Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/umberapp/umber/models/Expert;->coordinates:[Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setCostHour(D)V
    .locals 1
    .param p1, "costHour"    # D

    .prologue
    .line 92
    iput-wide p1, p0, Lcom/umberapp/umber/models/Expert;->costHour:D

    .line 93
    return-void
.end method

.method public setDateBooking(I)V
    .locals 0
    .param p1, "dateBooking"    # I

    .prologue
    .line 100
    iput p1, p0, Lcom/umberapp/umber/models/Expert;->dateBooking:I

    .line 101
    return-void
.end method

.method public setJobsDone(I)V
    .locals 0
    .param p1, "jobsDone"    # I

    .prologue
    .line 44
    iput p1, p0, Lcom/umberapp/umber/models/Expert;->jobsDone:I

    .line 45
    return-void
.end method

.method public setLocation([D)V
    .locals 0
    .param p1, "location"    # [D

    .prologue
    .line 76
    iput-object p1, p0, Lcom/umberapp/umber/models/Expert;->location:[D

    .line 77
    return-void
.end method

.method public setMaxFeeToPaid(D)V
    .locals 1
    .param p1, "maxFeeToPaid"    # D

    .prologue
    .line 84
    iput-wide p1, p0, Lcom/umberapp/umber/models/Expert;->maxFeeToPaid:D

    .line 85
    return-void
.end method

.method public setSelfDescriptions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Description;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p1, "selfDescriptions":Ljava/util/List;, "Ljava/util/List<Lcom/umberapp/umber/models/Description;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/Expert;->selfDescriptions:Ljava/util/List;

    .line 29
    return-void
.end method

.method public setTimeRange(Lcom/umberapp/umber/models/RangeTime;)V
    .locals 0
    .param p1, "timeRange"    # Lcom/umberapp/umber/models/RangeTime;

    .prologue
    .line 108
    iput-object p1, p0, Lcom/umberapp/umber/models/Expert;->timeRange:Lcom/umberapp/umber/models/RangeTime;

    .line 109
    return-void
.end method

.method public setTotalOrderSuccess(I)V
    .locals 0
    .param p1, "totalOrderSuccess"    # I

    .prologue
    .line 116
    iput p1, p0, Lcom/umberapp/umber/models/Expert;->totalOrderSuccess:I

    .line 117
    return-void
.end method
