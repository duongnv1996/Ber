.class public Lcom/umberapp/umber/models/User;
.super Ljava/lang/Object;
.source "User.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/umberapp/umber/models/User;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field accessToken:Ljava/lang/String;

.field address:Ljava/lang/String;

.field avatar:Ljava/lang/String;

.field balance:J
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "balance"
    .end annotation
.end field

.field birthday:Ljava/lang/String;

.field braintreeCustomerId:Ljava/lang/String;

.field email:Ljava/lang/String;

.field expiresln:Ljava/lang/String;

.field facebookId:Ljava/lang/String;

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
    new-instance v0, Lcom/umberapp/umber/models/User$1;

    invoke-direct {v0}, Lcom/umberapp/umber/models/User$1;-><init>()V

    sput-object v0, Lcom/umberapp/umber/models/User;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->token:Ljava/lang/String;

    .line 41
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->accessToken:Ljava/lang/String;

    .line 42
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->expiresln:Ljava/lang/String;

    .line 43
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->username:Ljava/lang/String;

    .line 44
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->email:Ljava/lang/String;

    .line 45
    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/umberapp/umber/models/User;->isCustomer:Z

    .line 46
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/umberapp/umber/models/User;->status:I

    .line 47
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/umberapp/umber/models/User;->balance:J

    .line 48
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->id:Ljava/lang/String;

    .line 49
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->braintreeCustomerId:Ljava/lang/String;

    .line 50
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/umberapp/umber/models/User;->rating:I

    .line 51
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/umberapp/umber/models/User;->smsCode:I

    .line 52
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/umberapp/umber/models/User;->timeSendSMS:J

    .line 53
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->first_name:Ljava/lang/String;

    .line 54
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->last_name:Ljava/lang/String;

    .line 55
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->address:Ljava/lang/String;

    .line 56
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->gender:Ljava/lang/String;

    .line 57
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->avatar:Ljava/lang/String;

    .line 58
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->phone:Ljava/lang/String;

    .line 59
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->birthday:Ljava/lang/String;

    .line 60
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->ref:Ljava/lang/String;

    .line 61
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->password:Ljava/lang/String;

    .line 62
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/umberapp/umber/models/User;->ready:Ljava/lang/String;

    .line 63
    return-void

    .line 45
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 265
    const/4 v0, 0x0

    return v0
.end method

.method public getAccessToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->accessToken:Ljava/lang/String;

    return-object v0
.end method

.method public getAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->address:Ljava/lang/String;

    return-object v0
.end method

.method public getAvatar()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->avatar:Ljava/lang/String;

    return-object v0
.end method

.method public getBalance()J
    .locals 2

    .prologue
    .line 119
    iget-wide v0, p0, Lcom/umberapp/umber/models/User;->balance:J

    return-wide v0
.end method

.method public getBirthday()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->birthday:Ljava/lang/String;

    return-object v0
.end method

.method public getBraintreeCustomerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->braintreeCustomerId:Ljava/lang/String;

    return-object v0
.end method

.method public getEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->email:Ljava/lang/String;

    return-object v0
.end method

.method public getExpiresln()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->expiresln:Ljava/lang/String;

    return-object v0
.end method

.method public getFirst_name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->first_name:Ljava/lang/String;

    return-object v0
.end method

.method public getGender()Ljava/lang/String;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->gender:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLast_name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->last_name:Ljava/lang/String;

    return-object v0
.end method

.method public getPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->password:Ljava/lang/String;

    return-object v0
.end method

.method public getPhone()Ljava/lang/String;
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->phone:Ljava/lang/String;

    return-object v0
.end method

.method public getRating()I
    .locals 1

    .prologue
    .line 207
    iget v0, p0, Lcom/umberapp/umber/models/User;->rating:I

    return v0
.end method

.method public getReady()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->ready:Ljava/lang/String;

    return-object v0
.end method

.method public getRef()Ljava/lang/String;
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->ref:Ljava/lang/String;

    return-object v0
.end method

.method public getSmsCode()I
    .locals 1

    .prologue
    .line 223
    iget v0, p0, Lcom/umberapp/umber/models/User;->smsCode:I

    return v0
.end method

.method public getStatus()I
    .locals 1

    .prologue
    .line 231
    iget v0, p0, Lcom/umberapp/umber/models/User;->status:I

    return v0
.end method

.method public getTimeSendSMS()J
    .locals 2

    .prologue
    .line 239
    iget-wide v0, p0, Lcom/umberapp/umber/models/User;->timeSendSMS:J

    return-wide v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 247
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->token:Ljava/lang/String;

    return-object v0
.end method

.method public getUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->username:Ljava/lang/String;

    return-object v0
.end method

.method public isCustomer()Z
    .locals 1

    .prologue
    .line 183
    iget-boolean v0, p0, Lcom/umberapp/umber/models/User;->isCustomer:Z

    return v0
.end method

.method public setAccessToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "accessToken"    # Ljava/lang/String;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->accessToken:Ljava/lang/String;

    .line 83
    return-void
.end method

.method public setAddress(Ljava/lang/String;)V
    .locals 0
    .param p1, "address"    # Ljava/lang/String;

    .prologue
    .line 107
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->address:Ljava/lang/String;

    .line 108
    return-void
.end method

.method public setAvatar(Ljava/lang/String;)V
    .locals 0
    .param p1, "avatar"    # Ljava/lang/String;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->avatar:Ljava/lang/String;

    .line 116
    return-void
.end method

.method public setBalance(J)V
    .locals 1
    .param p1, "balance"    # J

    .prologue
    .line 123
    iput-wide p1, p0, Lcom/umberapp/umber/models/User;->balance:J

    .line 124
    return-void
.end method

.method public setBirthday(Ljava/lang/String;)V
    .locals 0
    .param p1, "birthday"    # Ljava/lang/String;

    .prologue
    .line 131
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->birthday:Ljava/lang/String;

    .line 132
    return-void
.end method

.method public setBraintreeCustomerId(Ljava/lang/String;)V
    .locals 0
    .param p1, "braintreeCustomerId"    # Ljava/lang/String;

    .prologue
    .line 139
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->braintreeCustomerId:Ljava/lang/String;

    .line 140
    return-void
.end method

.method public setCustomer(Z)V
    .locals 0
    .param p1, "customer"    # Z

    .prologue
    .line 187
    iput-boolean p1, p0, Lcom/umberapp/umber/models/User;->isCustomer:Z

    .line 188
    return-void
.end method

.method public setEmail(Ljava/lang/String;)V
    .locals 0
    .param p1, "email"    # Ljava/lang/String;

    .prologue
    .line 147
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->email:Ljava/lang/String;

    .line 148
    return-void
.end method

.method public setExpiresln(Ljava/lang/String;)V
    .locals 0
    .param p1, "expiresln"    # Ljava/lang/String;

    .prologue
    .line 155
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->expiresln:Ljava/lang/String;

    .line 156
    return-void
.end method

.method public setFirst_name(Ljava/lang/String;)V
    .locals 0
    .param p1, "first_name"    # Ljava/lang/String;

    .prologue
    .line 163
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->first_name:Ljava/lang/String;

    .line 164
    return-void
.end method

.method public setGender(Ljava/lang/String;)V
    .locals 0
    .param p1, "gender"    # Ljava/lang/String;

    .prologue
    .line 171
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->gender:Ljava/lang/String;

    .line 172
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 179
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->id:Ljava/lang/String;

    .line 180
    return-void
.end method

.method public setLast_name(Ljava/lang/String;)V
    .locals 0
    .param p1, "last_name"    # Ljava/lang/String;

    .prologue
    .line 195
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->last_name:Ljava/lang/String;

    .line 196
    return-void
.end method

.method public setPassword(Ljava/lang/String;)V
    .locals 0
    .param p1, "password"    # Ljava/lang/String;

    .prologue
    .line 98
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->password:Ljava/lang/String;

    .line 99
    return-void
.end method

.method public setPhone(Ljava/lang/String;)V
    .locals 0
    .param p1, "phone"    # Ljava/lang/String;

    .prologue
    .line 203
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->phone:Ljava/lang/String;

    .line 204
    return-void
.end method

.method public setRating(I)V
    .locals 0
    .param p1, "rating"    # I

    .prologue
    .line 211
    iput p1, p0, Lcom/umberapp/umber/models/User;->rating:I

    .line 212
    return-void
.end method

.method public setReady(Ljava/lang/String;)V
    .locals 0
    .param p1, "ready"    # Ljava/lang/String;

    .prologue
    .line 90
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->ready:Ljava/lang/String;

    .line 91
    return-void
.end method

.method public setRef(Ljava/lang/String;)V
    .locals 0
    .param p1, "ref"    # Ljava/lang/String;

    .prologue
    .line 219
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->ref:Ljava/lang/String;

    .line 220
    return-void
.end method

.method public setSmsCode(I)V
    .locals 0
    .param p1, "smsCode"    # I

    .prologue
    .line 227
    iput p1, p0, Lcom/umberapp/umber/models/User;->smsCode:I

    .line 228
    return-void
.end method

.method public setStatus(I)V
    .locals 0
    .param p1, "status"    # I

    .prologue
    .line 235
    iput p1, p0, Lcom/umberapp/umber/models/User;->status:I

    .line 236
    return-void
.end method

.method public setTimeSendSMS(J)V
    .locals 1
    .param p1, "timeSendSMS"    # J

    .prologue
    .line 243
    iput-wide p1, p0, Lcom/umberapp/umber/models/User;->timeSendSMS:J

    .line 244
    return-void
.end method

.method public setToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 251
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->token:Ljava/lang/String;

    .line 252
    return-void
.end method

.method public setUsername(Ljava/lang/String;)V
    .locals 0
    .param p1, "username"    # Ljava/lang/String;

    .prologue
    .line 259
    iput-object p1, p0, Lcom/umberapp/umber/models/User;->username:Ljava/lang/String;

    .line 260
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "parcel"    # Landroid/os/Parcel;
    .param p2, "i"    # I

    .prologue
    .line 270
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->token:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 271
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->accessToken:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 272
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->expiresln:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 273
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->username:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 274
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->email:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 275
    iget-boolean v0, p0, Lcom/umberapp/umber/models/User;->isCustomer:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    .line 276
    iget v0, p0, Lcom/umberapp/umber/models/User;->status:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 277
    iget-wide v0, p0, Lcom/umberapp/umber/models/User;->balance:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 278
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->id:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 279
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->braintreeCustomerId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 280
    iget v0, p0, Lcom/umberapp/umber/models/User;->rating:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 281
    iget v0, p0, Lcom/umberapp/umber/models/User;->smsCode:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 282
    iget-wide v0, p0, Lcom/umberapp/umber/models/User;->timeSendSMS:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 283
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->first_name:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 284
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->last_name:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 285
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->address:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 286
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->gender:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 287
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->avatar:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 288
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->phone:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 289
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->birthday:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 290
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->ref:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 291
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->password:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 292
    iget-object v0, p0, Lcom/umberapp/umber/models/User;->ready:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 293
    return-void

    .line 275
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
