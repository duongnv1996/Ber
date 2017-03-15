package com.umberapp.umber.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.facebook.appevents.AppEventsConstants;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.RLog;

public class BaseFragment extends Fragment {
    String jsonResponse;
    BroadcastReceiver receiver;

    /* renamed from: com.umberapp.umber.fragments.BaseFragment.1 */
    class C13991 extends BroadcastReceiver {
        C13991() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                BaseFragment.this.jsonResponse = intent.getStringExtra(Constant.KEY_MSG);
                RLog.m86e("Base" + BaseFragment.this.jsonResponse);
            }
        }
    }

    public BaseFragment() {
        this.receiver = new C13991();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new IntentFilter().addAction(AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public String getJsonResponse() {
        return this.jsonResponse;
    }

    public void setJsonResponse(String jsonResponse) {
        this.jsonResponse = jsonResponse;
    }
}
