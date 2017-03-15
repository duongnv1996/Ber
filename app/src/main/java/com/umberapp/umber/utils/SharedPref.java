package com.umberapp.umber.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPref {
    private static final String SHARED_PREF_KEY = "SHARED_PREF_KEY";
    private static SharedPref instance;
    private SharedPreferences preferences;

    public static void clearAllData(Context context) {
        context.getSharedPreferences(SHARED_PREF_KEY, 0).edit().clear().commit();
    }

    private SharedPref(Context context) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPref getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPref(context);
        }
        return instance;
    }

    public SharedPref putInt(String key, int value) {
        this.preferences.edit().putInt(key, value).commit();
        return instance;
    }

    public int getInt(String key, int defaultValue) {
        return this.preferences.getInt(key, defaultValue);
    }

    public SharedPref putLong(String key, long value) {
        this.preferences.edit().putLong(key, value).commit();
        return instance;
    }

    public long getLong(String key, long defaultValue) {
        return this.preferences.getLong(key, defaultValue);
    }

    public SharedPref putString(String key, String value) {
        this.preferences.edit().putString(key, value).commit();
        return instance;
    }

    public String getString(String key, String defaultValue) {
        return this.preferences.getString(key, defaultValue);
    }

    public SharedPref putBoolean(String key, boolean value) {
        this.preferences.edit().putBoolean(key, value).commit();
        return instance;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return this.preferences.getBoolean(key, defaultValue);
    }

    public SharedPref putFloat(String key, float value) {
        this.preferences.edit().putFloat(key, value).commit();
        return instance;
    }

    public float getFloat(String key, float defaultValue) {
        return this.preferences.getFloat(key, defaultValue);
    }

    public void clear() {
        this.preferences.edit().clear().commit();
    }
}
