.class public Lcom/umberapp/umber/models/AuthResponse;
.super Ljava/lang/Object;
.source "AuthResponse.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/umberapp/umber/models/AuthResponse$Data;
    }
.end annotation


# instance fields
.field public code:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "code"
    .end annotation
.end field

.field public data:Lcom/umberapp/umber/models/AuthResponse$Data;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "data"
    .end annotation
.end field

.field public error_message:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "error_message"
    .end annotation
.end field

.field public phone:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "phone"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/umberapp/umber/models/AuthResponse;->code:Ljava/lang/String;

    return-object v0
.end method

.method public getData()Lcom/umberapp/umber/models/AuthResponse$Data;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/umberapp/umber/models/AuthResponse;->data:Lcom/umberapp/umber/models/AuthResponse$Data;

    return-object v0
.end method

.method public getError_message()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/umberapp/umber/models/AuthResponse;->error_message:Ljava/lang/String;

    return-object v0
.end method

.method public getPhone()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/umberapp/umber/models/AuthResponse;->phone:Ljava/lang/String;

    return-object v0
.end method

.method public setCode(Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/umberapp/umber/models/AuthResponse;->code:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public setData(Lcom/umberapp/umber/models/AuthResponse$Data;)V
    .locals 0
    .param p1, "data"    # Lcom/umberapp/umber/models/AuthResponse$Data;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/umberapp/umber/models/AuthResponse;->data:Lcom/umberapp/umber/models/AuthResponse$Data;

    .line 75
    return-void
.end method

.method public setError_message(Ljava/lang/String;)V
    .locals 0
    .param p1, "error_message"    # Ljava/lang/String;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/umberapp/umber/models/AuthResponse;->error_message:Ljava/lang/String;

    .line 83
    return-void
.end method

.method public setPhone(Ljava/lang/String;)V
    .locals 0
    .param p1, "phone"    # Ljava/lang/String;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/umberapp/umber/models/AuthResponse;->phone:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    const/16 v2, 0x27

    .line 87
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "AuthResponse{code=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/umberapp/umber/models/AuthResponse;->code:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", error_message=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/umberapp/umber/models/AuthResponse;->error_message:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", data="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/umberapp/umber/models/AuthResponse;->data:Lcom/umberapp/umber/models/AuthResponse$Data;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
