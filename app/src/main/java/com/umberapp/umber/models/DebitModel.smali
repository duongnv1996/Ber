.class public Lcom/umberapp/umber/models/DebitModel;
.super Ljava/lang/Object;
.source "DebitModel.java"


# instance fields
.field private amount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "amount"
    .end annotation
.end field

.field private callBackUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "callBackUrl"
    .end annotation
.end field

.field private currency:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "currency"
    .end annotation
.end field

.field private customerCountry:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "customerCountry"
    .end annotation
.end field

.field private customerEmail:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "customerEmail"
    .end annotation
.end field

.field private customerFullName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "customerFullName"
    .end annotation
.end field

.field private customerPhoneNumber:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "customerPhoneNumber"
    .end annotation
.end field

.field private expirationTime:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "expirationTime"
    .end annotation
.end field

.field private invoiceCode:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "invoiceCode"
    .end annotation
.end field

.field private languageVer:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "languageVer"
    .end annotation
.end field

.field private merchantCode:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "merchantCode"
    .end annotation
.end field

.field private merchantPass:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "merchantPass"
    .end annotation
.end field

.field private merchantReturnUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "merchantReturnUrl"
    .end annotation
.end field

.field private padipaySignature:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "padipaySignature"
    .end annotation
.end field

.field private transactionTime:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "transactionTime"
    .end annotation
.end field

.field private url:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "url"
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
.method public getAmount()I
    .locals 1

    .prologue
    .line 77
    iget v0, p0, Lcom/umberapp/umber/models/DebitModel;->amount:I

    return v0
.end method

.method public getCallBackUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->callBackUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getCurrency()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->currency:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomerCountry()Ljava/lang/String;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->customerCountry:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomerEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->customerEmail:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomerFullName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->customerFullName:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomerPhoneNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->customerPhoneNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getExpirationTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->expirationTime:Ljava/lang/String;

    return-object v0
.end method

.method public getInvoiceCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->invoiceCode:Ljava/lang/String;

    return-object v0
.end method

.method public getLanguageVer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->languageVer:Ljava/lang/String;

    return-object v0
.end method

.method public getMerchantCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->merchantCode:Ljava/lang/String;

    return-object v0
.end method

.method public getMerchantPass()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->merchantPass:Ljava/lang/String;

    return-object v0
.end method

.method public getMerchantReturnUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->merchantReturnUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getPadipaySignature()Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->padipaySignature:Ljava/lang/String;

    return-object v0
.end method

.method public getTransactionTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->transactionTime:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/umberapp/umber/models/DebitModel;->url:Ljava/lang/String;

    return-object v0
.end method

.method public setAmount(I)V
    .locals 0
    .param p1, "amount"    # I

    .prologue
    .line 81
    iput p1, p0, Lcom/umberapp/umber/models/DebitModel;->amount:I

    .line 82
    return-void
.end method

.method public setCallBackUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "callBackUrl"    # Ljava/lang/String;

    .prologue
    .line 153
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->callBackUrl:Ljava/lang/String;

    .line 154
    return-void
.end method

.method public setCurrency(Ljava/lang/String;)V
    .locals 0
    .param p1, "currency"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->currency:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setCustomerCountry(Ljava/lang/String;)V
    .locals 0
    .param p1, "customerCountry"    # Ljava/lang/String;

    .prologue
    .line 145
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->customerCountry:Ljava/lang/String;

    .line 146
    return-void
.end method

.method public setCustomerEmail(Ljava/lang/String;)V
    .locals 0
    .param p1, "customerEmail"    # Ljava/lang/String;

    .prologue
    .line 129
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->customerEmail:Ljava/lang/String;

    .line 130
    return-void
.end method

.method public setCustomerFullName(Ljava/lang/String;)V
    .locals 0
    .param p1, "customerFullName"    # Ljava/lang/String;

    .prologue
    .line 121
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->customerFullName:Ljava/lang/String;

    .line 122
    return-void
.end method

.method public setCustomerPhoneNumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "customerPhoneNumber"    # Ljava/lang/String;

    .prologue
    .line 137
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->customerPhoneNumber:Ljava/lang/String;

    .line 138
    return-void
.end method

.method public setExpirationTime(Ljava/lang/String;)V
    .locals 0
    .param p1, "expirationTime"    # Ljava/lang/String;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->expirationTime:Ljava/lang/String;

    .line 98
    return-void
.end method

.method public setInvoiceCode(Ljava/lang/String;)V
    .locals 0
    .param p1, "invoiceCode"    # Ljava/lang/String;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->invoiceCode:Ljava/lang/String;

    .line 74
    return-void
.end method

.method public setLanguageVer(Ljava/lang/String;)V
    .locals 0
    .param p1, "languageVer"    # Ljava/lang/String;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->languageVer:Ljava/lang/String;

    .line 114
    return-void
.end method

.method public setMerchantCode(Ljava/lang/String;)V
    .locals 0
    .param p1, "merchantCode"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->merchantCode:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setMerchantPass(Ljava/lang/String;)V
    .locals 0
    .param p1, "merchantPass"    # Ljava/lang/String;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->merchantPass:Ljava/lang/String;

    .line 66
    return-void
.end method

.method public setMerchantReturnUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "merchantReturnUrl"    # Ljava/lang/String;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->merchantReturnUrl:Ljava/lang/String;

    .line 106
    return-void
.end method

.method public setPadipaySignature(Ljava/lang/String;)V
    .locals 0
    .param p1, "padipaySignature"    # Ljava/lang/String;

    .prologue
    .line 161
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->padipaySignature:Ljava/lang/String;

    .line 162
    return-void
.end method

.method public setTransactionTime(Ljava/lang/String;)V
    .locals 0
    .param p1, "transactionTime"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->transactionTime:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 169
    iput-object p1, p0, Lcom/umberapp/umber/models/DebitModel;->url:Ljava/lang/String;

    .line 170
    return-void
.end method
