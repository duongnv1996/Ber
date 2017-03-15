package com.umberapp.umber.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.StrictMode.VmPolicy;

import com.facebook.internal.NativeProtocol;

public class SdkUtils {
    private SdkUtils() {
        throw new AssertionError();
    }

    @TargetApi(19)
    public static boolean enableSystemTranslucent(Activity activity) {
        if (activity == null || VERSION.SDK_INT != 19) {
            return false;
        }
        int id = activity.getResources().getIdentifier("config_enableTranslucentDecor", "bool", AccountKitGraphConstants.SDK_TYPE_ANDROID);
        if (id == 0 || !activity.getResources().getBoolean(id)) {
            return false;
        }
        activity.getWindow().addFlags(134217728);
        activity.getWindow().addFlags(67108864);
        return true;
    }

    public static boolean hasTranslucentSystemConfig(Context context) {
        if (context == null || VERSION.SDK_INT != 19) {
            return false;
        }
        int id = context.getResources().getIdentifier("config_enableTranslucentDecor", "bool", AccountKitGraphConstants.SDK_TYPE_ANDROID);
        if (id == 0 || !context.getResources().getBoolean(id)) {
            return false;
        }
        return true;
    }

    public static boolean isDownloadManagerAvailable(Context context) {
        try {
            if (VERSION.SDK_INT < 9) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setClassName("com.android.providers.downloads.ui", "com.android.providers.downloads.ui.DownloadList");
            if (context.getPackageManager().queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST).size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @TargetApi(11)
    public static void enableStrictMode(Class<?> target) {
        if (hasGingerbread()) {
            Builder threadPolicyBuilder = new Builder().detectAll().penaltyLog();
            VmPolicy.Builder vmPolicyBuilder = new VmPolicy.Builder().detectAll().penaltyLog();
            if (hasHoneycomb()) {
                threadPolicyBuilder.penaltyFlashScreen();
                vmPolicyBuilder.setClassInstanceLimit(target, 1);
            }
            StrictMode.setThreadPolicy(threadPolicyBuilder.build());
            StrictMode.setVmPolicy(vmPolicyBuilder.build());
        }
    }

    public static boolean hasFroyo() {
        return VERSION.SDK_INT >= 8;
    }

    public static boolean hasGingerbread() {
        return VERSION.SDK_INT >= 9;
    }

    public static boolean hasHoneycomb() {
        return VERSION.SDK_INT >= 11;
    }

    public static boolean hasHoneycombMR1() {
        return VERSION.SDK_INT >= 12;
    }

    public static boolean hasHoneycombMR2() {
        return VERSION.SDK_INT >= 13;
    }

    public static boolean hasICS() {
        return VERSION.SDK_INT >= 14;
    }

    public static boolean hasJellyBean() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean hasJellyBeanMR1() {
        return VERSION.SDK_INT >= 17;
    }

    public static boolean hasJellyBeanMR2() {
        return VERSION.SDK_INT >= 18;
    }

    public static boolean hasKitKat() {
        return VERSION.SDK_INT >= 19;
    }
}
