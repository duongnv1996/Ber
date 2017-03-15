package com.umberapp.umber.application;

import android.content.Context;
import android.location.Location;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;

import com.facebook.FacebookSdk;
import com.onesignal.OneSignal;
import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.SimpleFacebookConfiguration;
import com.umberapp.umber.R;
import com.umberapp.umber.models.Config;
import com.umberapp.umber.models.OrderItem;
import com.umberapp.umber.models.User;

import java.net.Socket;

public class AppController extends MultiDexApplication {
    static AppController instance;
    Config appConfig;
    String idOrder;
    private int listenCount;
    Location location;

    OrderItem order;
    User user;

    public AppController() {
        this.listenCount = 0;
    }

    public void onCreate() {
        super.onCreate();
        instance = this;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        FacebookSdk.sdkInitialize(this);
        SimpleFacebook.setConfiguration(new SimpleFacebookConfiguration.Builder().setAppId(getString(R.string.app_id)).setNamespace("umberex").setPermissions(new Permission[]{Permission.USER_PHOTOS, Permission.EMAIL, Permission.PUBLISH_ACTION}).build());
        OneSignal.startInit(this).init();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void getHashesKey(Context r14) {
        /*
        r13 = this;
        r8 = 0;
        r2 = 0;
        r9 = r14.getApplicationContext();	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        r6 = r9.getPackageName();	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        r9 = r14.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        r10 = 64;
        r5 = r9.getPackageInfo(r6, r10);	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        r9 = r5.signatures;	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        r10 = r9.length;	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        r3 = r2;
    L_0x0018:
        if (r8 >= r10) goto L_0x0053;
    L_0x001a:
        r7 = r9[r8];	 Catch:{ NameNotFoundException -> 0x00b2, NoSuchAlgorithmException -> 0x00af, Exception -> 0x00ac }
        r11 = "SHA";
        r4 = java.security.MessageDigest.getInstance(r11);	 Catch:{ NameNotFoundException -> 0x00b2, NoSuchAlgorithmException -> 0x00af, Exception -> 0x00ac }
        r11 = r7.toByteArray();	 Catch:{ NameNotFoundException -> 0x00b2, NoSuchAlgorithmException -> 0x00af, Exception -> 0x00ac }
        r4.update(r11);	 Catch:{ NameNotFoundException -> 0x00b2, NoSuchAlgorithmException -> 0x00af, Exception -> 0x00ac }
        r2 = new java.lang.String;	 Catch:{ NameNotFoundException -> 0x00b2, NoSuchAlgorithmException -> 0x00af, Exception -> 0x00ac }
        r11 = r4.digest();	 Catch:{ NameNotFoundException -> 0x00b2, NoSuchAlgorithmException -> 0x00af, Exception -> 0x00ac }
        r12 = 0;
        r11 = android.util.Base64.encode(r11, r12);	 Catch:{ NameNotFoundException -> 0x00b2, NoSuchAlgorithmException -> 0x00af, Exception -> 0x00ac }
        r2.<init>(r11);	 Catch:{ NameNotFoundException -> 0x00b2, NoSuchAlgorithmException -> 0x00af, Exception -> 0x00ac }
        r11 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        r11.<init>();	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        r12 = "Key Hash=";
        r11 = r11.append(r12);	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        r11 = r11.append(r2);	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        r11 = r11.toString();	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        com.umberapp.umber.utils.RLog.m86e(r11);	 Catch:{ NameNotFoundException -> 0x0055, NoSuchAlgorithmException -> 0x0072, Exception -> 0x008f }
        r8 = r8 + 1;
        r3 = r2;
        goto L_0x0018;
    L_0x0053:
        r2 = r3;
    L_0x0054:
        return;
    L_0x0055:
        r1 = move-exception;
    L_0x0056:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Name not found";
        r8 = r8.append(r9);
        r9 = r1.toString();
        r8 = r8.append(r9);
        r8 = r8.toString();
        com.umberapp.umber.utils.RLog.m86e(r8);
        goto L_0x0054;
    L_0x0072:
        r0 = move-exception;
    L_0x0073:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "No such an algorithm";
        r8 = r8.append(r9);
        r9 = r0.toString();
        r8 = r8.append(r9);
        r8 = r8.toString();
        com.umberapp.umber.utils.RLog.m86e(r8);
        goto L_0x0054;
    L_0x008f:
        r0 = move-exception;
    L_0x0090:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Exception";
        r8 = r8.append(r9);
        r9 = r0.toString();
        r8 = r8.append(r9);
        r8 = r8.toString();
        com.umberapp.umber.utils.RLog.m86e(r8);
        goto L_0x0054;
    L_0x00ac:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0090;
    L_0x00af:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0073;
    L_0x00b2:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umberapp.umber.application.AppController.getHashesKey(android.content.Context):void");
    }

    public Config getAppConfig() {
        return this.appConfig;
    }

    public void setAppConfig(Config appConfig) {
        this.appConfig = appConfig;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public OrderItem getOrder() {
        return this.order;
    }

    public void setOrder(OrderItem order) {
        this.order = order;
    }



    public String getIdOrder() {
        return this.idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static synchronized AppController getInstance() {
        AppController appController;
        synchronized (AppController.class) {
            if (instance == null) {
                instance = new AppController();
            }
            appController = instance;
        }
        return appController;
    }

    public void addListen() {
        this.listenCount++;
    }

    public void removeListen() {
        this.listenCount--;
    }
}
