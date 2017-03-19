.class public Lcom/umberapp/umber/models/HICItem;
.super Ljava/lang/Object;
.source "HICItem.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/umberapp/umber/models/HICItem$Category;,
        Lcom/umberapp/umber/models/HICItem$InfoExperts;,
        Lcom/umberapp/umber/models/HICItem$Tags;,
        Lcom/umberapp/umber/models/HICItem$Orders;,
        Lcom/umberapp/umber/models/HICItem$User;
    }
.end annotation


# instance fields
.field public address:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "address"
    .end annotation
.end field

.field public cashPayment:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "cashPayment"
    .end annotation
.end field

.field public category:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "category"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/HICItem$Category;",
            ">;"
        }
    .end annotation
.end field

.field public categoryForHci:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "categoryForHci"
    .end annotation
.end field

.field public costHci:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "costHci"
    .end annotation
.end field

.field public createdAt:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "createdAt"
    .end annotation
.end field

.field public email:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "email"
    .end annotation
.end field

.field public first_name:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "first_name"
    .end annotation
.end field

.field public gender:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "gender"
    .end annotation
.end field

.field public id:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "id"
    .end annotation
.end field

.field public inPatient:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "inPatient"
    .end annotation
.end field

.field public infoExpert:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "infoExpert"
    .end annotation
.end field

.field public isExpert:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "isExpert"
    .end annotation
.end field

.field public isHci:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "isHci"
    .end annotation
.end field

.field public last_name:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "last_name"
    .end annotation
.end field

.field location:[D
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "location"
    .end annotation
.end field

.field public maxFeeToPaid:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "maxFeeToPaid"
    .end annotation
.end field

.field public outPatient:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "outPatient"
    .end annotation
.end field

.field public password:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "password"
    .end annotation
.end field

.field public phone:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "phone"
    .end annotation
.end field

.field public phoneHci:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "phoneHci"
    .end annotation
.end field

.field public rating:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "rating"
    .end annotation
.end field

.field public ready:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "ready"
    .end annotation
.end field

.field public specialities:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "specialities"
    .end annotation
.end field

.field public status:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "status"
    .end annotation
.end field

.field public timeSendSMS:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "timeSendSMS"
    .end annotation
.end field

.field public updatedAt:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "updatedAt"
    .end annotation
.end field

.field public user:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "user"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/HICItem$User;",
            ">;"
        }
    .end annotation
.end field

.field public username:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "username"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->address:Ljava/lang/String;

    return-object v0
.end method

.method public getCashPayment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->cashPayment:Ljava/lang/String;

    return-object v0
.end method

.method public getCategory()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/HICItem$Category;",
            ">;"
        }
    .end annotation

    .prologue
    .line 126
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->category:Ljava/util/List;

    return-object v0
.end method

.method public getCategoryForHci()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->categoryForHci:Ljava/lang/String;

    return-object v0
.end method

.method public getCostHci()Ljava/lang/String;
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->costHci:Ljava/lang/String;

    return-object v0
.end method

.method public getCreatedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->createdAt:Ljava/lang/String;

    return-object v0
.end method

.method public getEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->email:Ljava/lang/String;

    return-object v0
.end method

.method public getFirst_name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->first_name:Ljava/lang/String;

    return-object v0
.end method

.method public getGender()Ljava/lang/String;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->gender:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getInPatient()Ljava/lang/String;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->inPatient:Ljava/lang/String;

    return-object v0
.end method

.method public getInfoExpert()Ljava/lang/String;
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->infoExpert:Ljava/lang/String;

    return-object v0
.end method

.method public getLast_name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->last_name:Ljava/lang/String;

    return-object v0
.end method

.method public getLocation()[D
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->location:[D

    return-object v0
.end method

.method public getMaxFeeToPaid()I
    .locals 1

    .prologue
    .line 239
    iget v0, p0, Lcom/umberapp/umber/models/HICItem;->maxFeeToPaid:I

    return v0
.end method

.method public getOutPatient()Ljava/lang/String;
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->outPatient:Ljava/lang/String;

    return-object v0
.end method

.method public getPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->password:Ljava/lang/String;

    return-object v0
.end method

.method public getPhone()Ljava/lang/String;
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->phone:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneHci()Ljava/lang/String;
    .locals 1

    .prologue
    .line 271
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->phoneHci:Ljava/lang/String;

    return-object v0
.end method

.method public getRating()I
    .locals 1

    .prologue
    .line 279
    iget v0, p0, Lcom/umberapp/umber/models/HICItem;->rating:I

    return v0
.end method

.method public getReady()Ljava/lang/String;
    .locals 1

    .prologue
    .line 287
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->ready:Ljava/lang/String;

    return-object v0
.end method

.method public getSpecialities()Ljava/lang/String;
    .locals 1

    .prologue
    .line 295
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->specialities:Ljava/lang/String;

    return-object v0
.end method

.method public getStatus()I
    .locals 1

    .prologue
    .line 303
    iget v0, p0, Lcom/umberapp/umber/models/HICItem;->status:I

    return v0
.end method

.method public getTimeSendSMS()I
    .locals 1

    .prologue
    .line 311
    iget v0, p0, Lcom/umberapp/umber/models/HICItem;->timeSendSMS:I

    return v0
.end method

.method public getUpdatedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 319
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->updatedAt:Ljava/lang/String;

    return-object v0
.end method

.method public getUser()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/HICItem$User;",
            ">;"
        }
    .end annotation

    .prologue
    .line 327
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->user:Ljava/util/List;

    return-object v0
.end method

.method public getUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 335
    iget-object v0, p0, Lcom/umberapp/umber/models/HICItem;->username:Ljava/lang/String;

    return-object v0
.end method

.method public isExpert()Z
    .locals 1

    .prologue
    .line 206
    iget-boolean v0, p0, Lcom/umberapp/umber/models/HICItem;->isExpert:Z

    return v0
.end method

.method public isHci()Z
    .locals 1

    .prologue
    .line 214
    iget-boolean v0, p0, Lcom/umberapp/umber/models/HICItem;->isHci:Z

    return v0
.end method

.method public setAddress(Ljava/lang/String;)V
    .locals 0
    .param p1, "address"    # Ljava/lang/String;

    .prologue
    .line 114
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->address:Ljava/lang/String;

    .line 115
    return-void
.end method

.method public setCashPayment(Ljava/lang/String;)V
    .locals 0
    .param p1, "cashPayment"    # Ljava/lang/String;

    .prologue
    .line 122
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->cashPayment:Ljava/lang/String;

    .line 123
    return-void
.end method

.method public setCategory(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/HICItem$Category;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 130
    .local p1, "category":Ljava/util/List;, "Ljava/util/List<Lcom/umberapp/umber/models/HICItem$Category;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->category:Ljava/util/List;

    .line 131
    return-void
.end method

.method public setCategoryForHci(Ljava/lang/String;)V
    .locals 0
    .param p1, "categoryForHci"    # Ljava/lang/String;

    .prologue
    .line 138
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->categoryForHci:Ljava/lang/String;

    .line 139
    return-void
.end method

.method public setCostHci(Ljava/lang/String;)V
    .locals 0
    .param p1, "costHci"    # Ljava/lang/String;

    .prologue
    .line 146
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->costHci:Ljava/lang/String;

    .line 147
    return-void
.end method

.method public setCreatedAt(Ljava/lang/String;)V
    .locals 0
    .param p1, "createdAt"    # Ljava/lang/String;

    .prologue
    .line 154
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->createdAt:Ljava/lang/String;

    .line 155
    return-void
.end method

.method public setEmail(Ljava/lang/String;)V
    .locals 0
    .param p1, "email"    # Ljava/lang/String;

    .prologue
    .line 162
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->email:Ljava/lang/String;

    .line 163
    return-void
.end method

.method public setExpert(Z)V
    .locals 0
    .param p1, "expert"    # Z

    .prologue
    .line 210
    iput-boolean p1, p0, Lcom/umberapp/umber/models/HICItem;->isExpert:Z

    .line 211
    return-void
.end method

.method public setFirst_name(Ljava/lang/String;)V
    .locals 0
    .param p1, "first_name"    # Ljava/lang/String;

    .prologue
    .line 170
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->first_name:Ljava/lang/String;

    .line 171
    return-void
.end method

.method public setGender(Ljava/lang/String;)V
    .locals 0
    .param p1, "gender"    # Ljava/lang/String;

    .prologue
    .line 178
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->gender:Ljava/lang/String;

    .line 179
    return-void
.end method

.method public setHci(Z)V
    .locals 0
    .param p1, "hci"    # Z

    .prologue
    .line 218
    iput-boolean p1, p0, Lcom/umberapp/umber/models/HICItem;->isHci:Z

    .line 219
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 186
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->id:Ljava/lang/String;

    .line 187
    return-void
.end method

.method public setInPatient(Ljava/lang/String;)V
    .locals 0
    .param p1, "inPatient"    # Ljava/lang/String;

    .prologue
    .line 202
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->inPatient:Ljava/lang/String;

    .line 203
    return-void
.end method

.method public setInfoExpert(Ljava/lang/String;)V
    .locals 0
    .param p1, "infoExpert"    # Ljava/lang/String;

    .prologue
    .line 194
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->infoExpert:Ljava/lang/String;

    .line 195
    return-void
.end method

.method public setLast_name(Ljava/lang/String;)V
    .locals 0
    .param p1, "last_name"    # Ljava/lang/String;

    .prologue
    .line 226
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->last_name:Ljava/lang/String;

    .line 227
    return-void
.end method

.method public setLocation([D)V
    .locals 0
    .param p1, "location"    # [D

    .prologue
    .line 235
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->location:[D

    .line 236
    return-void
.end method

.method public setMaxFeeToPaid(I)V
    .locals 0
    .param p1, "maxFeeToPaid"    # I

    .prologue
    .line 243
    iput p1, p0, Lcom/umberapp/umber/models/HICItem;->maxFeeToPaid:I

    .line 244
    return-void
.end method

.method public setOutPatient(Ljava/lang/String;)V
    .locals 0
    .param p1, "outPatient"    # Ljava/lang/String;

    .prologue
    .line 251
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->outPatient:Ljava/lang/String;

    .line 252
    return-void
.end method

.method public setPassword(Ljava/lang/String;)V
    .locals 0
    .param p1, "password"    # Ljava/lang/String;

    .prologue
    .line 259
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->password:Ljava/lang/String;

    .line 260
    return-void
.end method

.method public setPhone(Ljava/lang/String;)V
    .locals 0
    .param p1, "phone"    # Ljava/lang/String;

    .prologue
    .line 267
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->phone:Ljava/lang/String;

    .line 268
    return-void
.end method

.method public setPhoneHci(Ljava/lang/String;)V
    .locals 0
    .param p1, "phoneHci"    # Ljava/lang/String;

    .prologue
    .line 275
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->phoneHci:Ljava/lang/String;

    .line 276
    return-void
.end method

.method public setRating(I)V
    .locals 0
    .param p1, "rating"    # I

    .prologue
    .line 283
    iput p1, p0, Lcom/umberapp/umber/models/HICItem;->rating:I

    .line 284
    return-void
.end method

.method public setReady(Ljava/lang/String;)V
    .locals 0
    .param p1, "ready"    # Ljava/lang/String;

    .prologue
    .line 291
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->ready:Ljava/lang/String;

    .line 292
    return-void
.end method

.method public setSpecialities(Ljava/lang/String;)V
    .locals 0
    .param p1, "specialities"    # Ljava/lang/String;

    .prologue
    .line 299
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->specialities:Ljava/lang/String;

    .line 300
    return-void
.end method

.method public setStatus(I)V
    .locals 0
    .param p1, "status"    # I

    .prologue
    .line 307
    iput p1, p0, Lcom/umberapp/umber/models/HICItem;->status:I

    .line 308
    return-void
.end method

.method public setTimeSendSMS(I)V
    .locals 0
    .param p1, "timeSendSMS"    # I

    .prologue
    .line 315
    iput p1, p0, Lcom/umberapp/umber/models/HICItem;->timeSendSMS:I

    .line 316
    return-void
.end method

.method public setUpdatedAt(Ljava/lang/String;)V
    .locals 0
    .param p1, "updatedAt"    # Ljava/lang/String;

    .prologue
    .line 323
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->updatedAt:Ljava/lang/String;

    .line 324
    return-void
.end method

.method public setUser(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/HICItem$User;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 331
    .local p1, "user":Ljava/util/List;, "Ljava/util/List<Lcom/umberapp/umber/models/HICItem$User;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->user:Ljava/util/List;

    .line 332
    return-void
.end method

.method public setUsername(Ljava/lang/String;)V
    .locals 0
    .param p1, "username"    # Ljava/lang/String;

    .prologue
    .line 339
    iput-object p1, p0, Lcom/umberapp/umber/models/HICItem;->username:Ljava/lang/String;

    .line 340
    return-void
.end method
