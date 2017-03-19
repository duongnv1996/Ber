package com.umberapp.umber.application;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.location.Location;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;
import android.util.Base64;

import com.facebook.FacebookSdk;
import com.github.nkzawa.socketio.client.Socket;
import com.onesignal.OneSignal;
import com.onesignal.OneSignal.Builder;
import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.SimpleFacebookConfiguration;
import com.umberapp.umber.models.Config;
import com.umberapp.umber.models.OrderItem;
import com.umberapp.umber.models.User;
import com.umberapp.umber.utils.RLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AppController
        extends MultiDexApplication {
    static AppController instance;
    Config appConfig;
    String idOrder;
    private int listenCount = 0;
    Location location;
    private Socket mSocket;
    OrderItem order;
    User user;

    public static AppController getInstance() {
        try {
            if (instance == null) {
                instance = new AppController();
            }
            AppController localAppController = instance;
            return localAppController;
        } finally {
        }
    }

    public void addListen() {
        this.listenCount += 1;
    }

    protected void attachBaseContext(Context paramContext) {
        super.attachBaseContext(paramContext);
        MultiDex.install(this);
    }

    public Config getAppConfig() {
        return this.appConfig;
    }

    public String getIdOrder() {
        return this.idOrder;
    }

    public Location getLocation() {
        return this.location;
    }

    public OrderItem getOrder() {
        return this.order;
    }

    public User getUser() {
        return this.user;
    }

    public Socket getmSocket() {
        return this.mSocket;
    }

    public void onCreate() {
        super.onCreate();
        instance = this;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        FacebookSdk.sdkInitialize(this);
        Permission localPermission1 = Permission.USER_PHOTOS;
        Permission localPermission2 = Permission.EMAIL;
        Permission localPermission3 = Permission.PUBLISH_ACTION;
        SimpleFacebook.setConfiguration(new SimpleFacebookConfiguration.Builder().setAppId("650769278430011").setNamespace("umberex").setPermissions(new Permission[]{localPermission1, localPermission2, localPermission3}).build());
        OneSignal.startInit(this).init();
    }

    public void removeListen() {
        this.listenCount -= 1;
    }

    public void setAppConfig(Config paramConfig) {
        this.appConfig = paramConfig;
    }

    public void setIdOrder(String paramString) {
        this.idOrder = paramString;
    }

    public void setLocation(Location paramLocation) {
        this.location = paramLocation;
    }

    public void setOrder(OrderItem paramOrderItem) {
        this.order = paramOrderItem;
    }

    public void setUser(User paramUser) {
        this.user = paramUser;
    }

    public void setmSocket(Socket paramSocket) {
        this.mSocket = paramSocket;
    }
}