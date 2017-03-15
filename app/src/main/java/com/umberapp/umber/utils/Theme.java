package com.umberapp.umber.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

public enum Theme {
    INSTANCE;
    
    private static String TAG;
    private Context mContext;
    private Map<String, Typeface> mTypefaces;

    static {
        TAG = Theme.class.getName();
    }

    public static void init(Context context) {
        INSTANCE.mContext = context;
    }

    public Typeface getTypeface(String name) {
        if (this.mTypefaces == null) {
            this.mTypefaces = new HashMap();
        }
        Typeface typeface = (Typeface) this.mTypefaces.get(name);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(this.mContext.getAssets(), name);
        }
        if (typeface == null) {
            throw new IllegalArgumentException("No typeface with provided font name");
        }
        this.mTypefaces.put(name, typeface);
        return typeface;
    }
}
