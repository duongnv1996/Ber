.class public Lcom/umberapp/umber/models/Config;
.super Ljava/lang/Object;
.source "Config.java"


# instance fields
.field public cancelFee:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "cancelFee"
    .end annotation
.end field

.field public chargeFee:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "chargeFee"
    .end annotation
.end field

.field public currency:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "currency"
    .end annotation
.end field

.field public language:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "language"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCancelFee()I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/umberapp/umber/models/Config;->cancelFee:I

    return v0
.end method

.method public getChargeFee()I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/umberapp/umber/models/Config;->chargeFee:I

    return v0
.end method

.method public getCurrency()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/umberapp/umber/models/Config;->currency:Ljava/lang/String;

    return-object v0
.end method

.method public getLanguage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/umberapp/umber/models/Config;->language:Ljava/lang/String;

    return-object v0
.end method

.method public setCancelFee(I)V
    .locals 0
    .param p1, "cancelFee"    # I

    .prologue
    .line 28
    iput p1, p0, Lcom/umberapp/umber/models/Config;->cancelFee:I

    .line 29
    return-void
.end method

.method public setChargeFee(I)V
    .locals 0
    .param p1, "chargeFee"    # I

    .prologue
    .line 36
    iput p1, p0, Lcom/umberapp/umber/models/Config;->chargeFee:I

    .line 37
    return-void
.end method

.method public setCurrency(Ljava/lang/String;)V
    .locals 0
    .param p1, "currency"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/umberapp/umber/models/Config;->currency:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setLanguage(Ljava/lang/String;)V
    .locals 0
    .param p1, "language"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/umberapp/umber/models/Config;->language:Ljava/lang/String;

    .line 53
    return-void
.end method
