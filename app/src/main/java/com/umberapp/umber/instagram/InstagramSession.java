package com.umberapp.umber.instagram;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class InstagramSession {
    private static final String API_ACCESS_TOKEN = "access_token";
    private static final String API_AVT = "profile_picture";
    private static final String API_ID = "id";
    private static final String API_NAME = "name";
    private static final String API_USERNAME = "username";
    private static final String SHARED = "Instagram_Preferences";
    private Editor editor;
    private SharedPreferences sharedPref;

    public static String getApiAvt() {
        return API_AVT;
    }

    public InstagramSession(Context context) {
        this.sharedPref = context.getSharedPreferences(SHARED, 0);
        this.editor = this.sharedPref.edit();
    }

    public void storeAccessToken(String accessToken, String id, String username, String name, String avt) {
        this.editor.putString(API_ID, id);
        this.editor.putString(API_NAME, name);
        this.editor.putString(API_ACCESS_TOKEN, accessToken);
        this.editor.putString(API_USERNAME, username);
        this.editor.putString(API_AVT, avt);
        this.editor.commit();
    }

    public void storeAccessToken(String accessToken) {
        this.editor.putString(API_ACCESS_TOKEN, accessToken);
        this.editor.commit();
    }

    public void resetAccessToken() {
        this.editor.putString(API_ID, null);
        this.editor.putString(API_NAME, null);
        this.editor.putString(API_ACCESS_TOKEN, null);
        this.editor.putString(API_USERNAME, null);
        this.editor.putString(API_AVT, null);
        this.editor.commit();
    }

    public String getUsername() {
        return this.sharedPref.getString(API_USERNAME, null);
    }

    public String getId() {
        return this.sharedPref.getString(API_ID, null);
    }

    public String getName() {
        return this.sharedPref.getString(API_NAME, null);
    }

    public String getAvt() {
        return this.sharedPref.getString(API_AVT, null);
    }

    public String getAccessToken() {
        return this.sharedPref.getString(API_ACCESS_TOKEN, null);
    }
}
