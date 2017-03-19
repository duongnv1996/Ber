.class public Lcom/umberapp/umber/models/ParamRegUser;
.super Ljava/lang/Object;
.source "ParamRegUser.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/umberapp/umber/models/ParamRegUser;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field address:Ljava/lang/String;

.field avatar:Ljava/lang/String;

.field balance:D

.field birthday:Ljava/lang/String;

.field braintreeCustomerId:Ljava/lang/String;

.field categories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/umberapp/umber/models/Category;",
            ">;"
        }
    .end annotation
.end field

.field coordinates:Ljava/lang/String;

.field email:Ljava/lang/String;

.field expiresln:Ljava/lang/String;

.field first_name:Ljava/lang/String;

.field gender:Ljava/lang/String;

.field id:Ljava/lang/String;

.field isCustomer:Z

.field last_name:Ljava/lang/String;

.field password:Ljava/lang/String;

.field phone:Ljava/lang/String;

.field rating:I

.field ready:Ljava/lang/String;

.field ref:Ljava/lang/String;

.field smsCode:I

.field status:I

.field timeSendSMS:J

.field token:Ljava/lang/String;

.field username:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 65
    new-instance v0, Lcom/umberapp/umber/models/ParamRegUser$1;

    invoke-direct {v0}, Lcom/umberapp/umber/models/ParamRegUser$1;-><init>()V

    sput-object v0, Lcom/umberapp/umber/models/ParamRegUser;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->token:Ljava/lang/String;

    .line 40
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->expiresln:Ljava/lang/String;

    .line 41
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->username:Ljava/lang/String;

    .line 42
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->email:Ljava/lang/String;

    .line 43
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->isCustomer:Z

    .line 44
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->status:I

    .line 45
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->balance:D

    .line 46
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->id:Ljava/lang/String;

    .line 47
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->braintreeCustomerId:Ljava/lang/String;

    .line 48
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->rating:I

    .line 49
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->smsCode:I

    .line 50
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->timeSendSMS:J

    .line 51
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->first_name:Ljava/lang/String;

    .line 52
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->last_name:Ljava/lang/String;

    .line 53
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->address:Ljava/lang/String;

    .line 54
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->gender:Ljava/lang/String;

    .line 55
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->avatar:Ljava/lang/String;

    .line 56
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->phone:Ljava/lang/String;

    .line 57
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->birthday:Ljava/lang/String;

    .line 58
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->ref:Ljava/lang/String;

    .line 59
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->ready:Ljava/lang/String;

    .line 60
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->coordinates:Ljava/lang/String;

    .line 61
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->password:Ljava/lang/String;

    .line 62
    return-void

    .line 43
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "address"    # Ljava/lang/String;
    .param p2, "birthday"    # Ljava/lang/String;
    .param p3, "email"    # Ljava/lang/String;
    .param p4, "first_name"    # Ljava/lang/String;
    .param p5, "gender"    # Ljava/lang/String;
    .param p6, "isCustomer"    # Z
    .param p7, "last_name"    # Ljava/lang/String;
    .param p8, "phone"    # Ljava/lang/String;
    .param p9, "ref"    # Ljava/lang/String;
    .param p10, "username"    # Ljava/lang/String;
    .param p11, "pass"    # Ljava/lang/String;

    .prologue
    .line 104
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 105
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->address:Ljava/lang/String;

    .line 106
    iput-object p2, p0, Lcom/umberapp/umber/models/ParamRegUser;->birthday:Ljava/lang/String;

    .line 107
    iput-object p3, p0, Lcom/umberapp/umber/models/ParamRegUser;->email:Ljava/lang/String;

    .line 108
    iput-object p4, p0, Lcom/umberapp/umber/models/ParamRegUser;->first_name:Ljava/lang/String;

    .line 109
    iput-object p5, p0, Lcom/umberapp/umber/models/ParamRegUser;->gender:Ljava/lang/String;

    .line 110
    iput-boolean p6, p0, Lcom/umberapp/umber/models/ParamRegUser;->isCustomer:Z

    .line 111
    iput-object p7, p0, Lcom/umberapp/umber/models/ParamRegUser;->last_name:Ljava/lang/String;

    .line 112
    iput-object p8, p0, Lcom/umberapp/umber/models/ParamRegUser;->phone:Ljava/lang/String;

    .line 113
    iput-object p9, p0, Lcom/umberapp/umber/models/ParamRegUser;->ref:Ljava/lang/String;

    .line 114
    iput-object p10, p0, Lcom/umberapp/umber/models/ParamRegUser;->username:Ljava/lang/String;

    .line 115
    iput-object p11, p0, Lcom/umberapp/umber/models/ParamRegUser;->password:Ljava/lang/String;

    .line 116
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 289
    const/4 v0, 0x0

    return v0
.end method

.method public getAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->address:Ljava/lang/String;

    return-object v0
.end method

.method public getAvatar()Ljava/lang/String;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->avatar:Ljava/lang/String;

    return-object v0
.end method

.method public getBalance()D
    .locals 2

    .prologue
    .line 136
    iget-wide v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->balance:D

    return-wide v0
.end method

.method public getBirthday()Ljava/lang/String;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->birthday:Ljava/lang/String;

    return-object v0
.end method

.method public getBraintreeCustomerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->braintreeCustomerId:Ljava/lang/String;

    return-object v0
.end method

.method public getCategories()Ljava/util/List;
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
    .line 78
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->categories:Ljava/util/List;

    return-object v0
.end method

.method public getCoordinates()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->coordinates:Ljava/lang/String;

    return-object v0
.end method

.method public getEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->email:Ljava/lang/String;

    return-object v0
.end method

.method public getExpiresln()Ljava/lang/String;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->expiresln:Ljava/lang/String;

    return-object v0
.end method

.method public getFirst_name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->first_name:Ljava/lang/String;

    return-object v0
.end method

.method public getGender()Ljava/lang/String;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->gender:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLast_name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->last_name:Ljava/lang/String;

    return-object v0
.end method

.method public getPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 280
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->password:Ljava/lang/String;

    return-object v0
.end method

.method public getPhone()Ljava/lang/String;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->phone:Ljava/lang/String;

    return-object v0
.end method

.method public getRating()I
    .locals 1

    .prologue
    .line 224
    iget v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->rating:I

    return v0
.end method

.method public getReady()Ljava/lang/String;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->ready:Ljava/lang/String;

    return-object v0
.end method

.method public getRef()Ljava/lang/String;
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->ref:Ljava/lang/String;

    return-object v0
.end method

.method public getSmsCode()I
    .locals 1

    .prologue
    .line 240
    iget v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->smsCode:I

    return v0
.end method

.method public getStatus()I
    .locals 1

    .prologue
    .line 248
    iget v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->status:I

    return v0
.end method

.method public getTimeSendSMS()J
    .locals 2

    .prologue
    .line 256
    iget-wide v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->timeSendSMS:J

    return-wide v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 264
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->token:Ljava/lang/String;

    return-object v0
.end method

.method public getUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->username:Ljava/lang/String;

    return-object v0
.end method

.method public isCustomer()Z
    .locals 1

    .prologue
    .line 200
    iget-boolean v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->isCustomer:Z

    return v0
.end method

.method public setAddress(Ljava/lang/String;)V
    .locals 0
    .param p1, "address"    # Ljava/lang/String;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->address:Ljava/lang/String;

    .line 125
    return-void
.end method

.method public setAvatar(Ljava/lang/String;)V
    .locals 0
    .param p1, "avatar"    # Ljava/lang/String;

    .prologue
    .line 132
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->avatar:Ljava/lang/String;

    .line 133
    return-void
.end method

.method public setBalance(D)V
    .locals 1
    .param p1, "balance"    # D

    .prologue
    .line 140
    iput-wide p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->balance:D

    .line 141
    return-void
.end method

.method public setBirthday(Ljava/lang/String;)V
    .locals 0
    .param p1, "birthday"    # Ljava/lang/String;

    .prologue
    .line 148
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->birthday:Ljava/lang/String;

    .line 149
    return-void
.end method

.method public setBraintreeCustomerId(Ljava/lang/String;)V
    .locals 0
    .param p1, "braintreeCustomerId"    # Ljava/lang/String;

    .prologue
    .line 156
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->braintreeCustomerId:Ljava/lang/String;

    .line 157
    return-void
.end method

.method public setCategories(Ljava/util/List;)V
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
    .line 82
    .local p1, "categories":Ljava/util/List;, "Ljava/util/List<Lcom/umberapp/umber/models/Category;>;"
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->categories:Ljava/util/List;

    .line 83
    return-void
.end method

.method public setCoordinates(Ljava/lang/String;)V
    .locals 0
    .param p1, "coordinates"    # Ljava/lang/String;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->coordinates:Ljava/lang/String;

    .line 92
    return-void
.end method

.method public setCustomer(Z)V
    .locals 0
    .param p1, "customer"    # Z

    .prologue
    .line 204
    iput-boolean p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->isCustomer:Z

    .line 205
    return-void
.end method

.method public setEmail(Ljava/lang/String;)V
    .locals 0
    .param p1, "email"    # Ljava/lang/String;

    .prologue
    .line 164
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->email:Ljava/lang/String;

    .line 165
    return-void
.end method

.method public setExpiresln(Ljava/lang/String;)V
    .locals 0
    .param p1, "expiresln"    # Ljava/lang/String;

    .prologue
    .line 172
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->expiresln:Ljava/lang/String;

    .line 173
    return-void
.end method

.method public setFirst_name(Ljava/lang/String;)V
    .locals 0
    .param p1, "first_name"    # Ljava/lang/String;

    .prologue
    .line 180
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->first_name:Ljava/lang/String;

    .line 181
    return-void
.end method

.method public setGender(Ljava/lang/String;)V
    .locals 0
    .param p1, "gender"    # Ljava/lang/String;

    .prologue
    .line 188
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->gender:Ljava/lang/String;

    .line 189
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 196
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->id:Ljava/lang/String;

    .line 197
    return-void
.end method

.method public setLast_name(Ljava/lang/String;)V
    .locals 0
    .param p1, "last_name"    # Ljava/lang/String;

    .prologue
    .line 212
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->last_name:Ljava/lang/String;

    .line 213
    return-void
.end method

.method public setPassword(Ljava/lang/String;)V
    .locals 0
    .param p1, "password"    # Ljava/lang/String;

    .prologue
    .line 284
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->password:Ljava/lang/String;

    .line 285
    return-void
.end method

.method public setPhone(Ljava/lang/String;)V
    .locals 0
    .param p1, "phone"    # Ljava/lang/String;

    .prologue
    .line 220
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->phone:Ljava/lang/String;

    .line 221
    return-void
.end method

.method public setRating(I)V
    .locals 0
    .param p1, "rating"    # I

    .prologue
    .line 228
    iput p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->rating:I

    .line 229
    return-void
.end method

.method public setReady(Ljava/lang/String;)V
    .locals 0
    .param p1, "ready"    # Ljava/lang/String;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->ready:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setRef(Ljava/lang/String;)V
    .locals 0
    .param p1, "ref"    # Ljava/lang/String;

    .prologue
    .line 236
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->ref:Ljava/lang/String;

    .line 237
    return-void
.end method

.method public setSmsCode(I)V
    .locals 0
    .param p1, "smsCode"    # I

    .prologue
    .line 244
    iput p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->smsCode:I

    .line 245
    return-void
.end method

.method public setStatus(I)V
    .locals 0
    .param p1, "status"    # I

    .prologue
    .line 252
    iput p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->status:I

    .line 253
    return-void
.end method

.method public setTimeSendSMS(J)V
    .locals 1
    .param p1, "timeSendSMS"    # J

    .prologue
    .line 260
    iput-wide p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->timeSendSMS:J

    .line 261
    return-void
.end method

.method public setToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 268
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->token:Ljava/lang/String;

    .line 269
    return-void
.end method

.method public setUsername(Ljava/lang/String;)V
    .locals 0
    .param p1, "username"    # Ljava/lang/String;

    .prologue
    .line 276
    iput-object p1, p0, Lcom/umberapp/umber/models/ParamRegUser;->username:Ljava/lang/String;

    .line 277
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "parcel"    # Landroid/os/Parcel;
    .param p2, "i"    # I

    .prologue
    .line 294
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->token:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 295
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->expiresln:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 296
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->username:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 297
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->email:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 298
    iget-boolean v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->isCustomer:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    .line 299
    iget v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->status:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 300
    iget-wide v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->balance:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 301
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->id:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 302
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->braintreeCustomerId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 303
    iget v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->rating:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 304
    iget v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->smsCode:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 305
    iget-wide v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->timeSendSMS:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 306
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->first_name:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 307
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->last_name:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 308
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->address:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 309
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->gender:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 310
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->avatar:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 311
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->phone:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 312
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->birthday:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 313
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->ref:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 314
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->ready:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 315
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->coordinates:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 316
    iget-object v0, p0, Lcom/umberapp/umber/models/ParamRegUser;->password:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 317
    return-void

    .line 298
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
