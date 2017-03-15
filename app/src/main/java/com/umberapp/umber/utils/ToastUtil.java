package com.umberapp.umber.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast mToast;

    public static void showToast(Context context, String message) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, message, 1);
        mToast.show();
    }

    public static void showToast(Context context, int messageResID) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, context.getResources().getString(messageResID), 1);
        mToast.show();
    }
}
