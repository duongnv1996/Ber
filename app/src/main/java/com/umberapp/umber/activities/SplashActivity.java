package com.umberapp.umber.activities;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

import com.crittercism.app.Crittercism;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.models.Config;
import com.umberapp.umber.models.User;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.utils.SharedPref;
import com.umberapp.umber.views.AlertDialogCustom;

import java.util.Locale;

import me.zhanghai.android.materialprogressbar.BuildConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private Socket mSocket;
    private CountDownTimer mTimer;
    UmberService umberService;

    /* renamed from: com.umberapp.umber.activities.SplashActivity.1 */
    class C13771 extends CountDownTimer {

        /* renamed from: com.umberapp.umber.activities.SplashActivity.1.1 */
        class C13761 implements Callback<ApiResponse<User>> {
            final /* synthetic */ String val$userString;

            C13761(String str) {
                this.val$userString = str;
            }

            public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
                if (response.isSuccessful()) {
                    User user = (User) ((ApiResponse) response.body()).getData();
                    user.setToken(this.val$userString);
                    AppController.getInstance().setUser(user);
                    SplashActivity.this.saveUserInfor(user);
                    SplashActivity.this.getAppConfig();
                    return;
                }
                RLog.m86e(Integer.valueOf(response.code()));
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                SplashActivity.this.finish();
            }

            public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
                RLog.m86e(t.getMessage());
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                SplashActivity.this.finish();
            }
        }

        C13771(long x0, long x1) {
            super(x0, x1);
        }

        public void onTick(long l) {
        }

        public void onFinish() {
            String userString = SharedPref.getInstance(SplashActivity.this.getBaseContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
            if (userString.equals(BuildConfig.FLAVOR)) {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                SplashActivity.this.finish();
                return;
            }
            RLog.m85d("token = " + userString);
            SplashActivity.this.umberService.getInfor(userString).enqueue(new C13761(userString));
        }
    }

    /* renamed from: com.umberapp.umber.activities.SplashActivity.2 */
    class C13782 implements Callback<ApiResponse<Config>> {
        C13782() {
        }

        public void onResponse(Call<ApiResponse<Config>> call, Response<ApiResponse<Config>> response) {
            if (response.isSuccessful()) {
                Config config = (Config) ((ApiResponse) response.body()).getData();
                if (config != null) {
                    AppController.getInstance().setAppConfig(config);
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    SplashActivity.this.finish();
                    return;
                }
                AlertDialogCustom.dialogMsg(SplashActivity.this, SplashActivity.this.getString(R.string.unknow_error)).show();
                return;
            }
            RLog.m86e(Integer.valueOf(response.code()));
            AlertDialogCustom.dialogMsg(SplashActivity.this, SplashActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<Config>> call, Throwable t) {
            RLog.m86e(t.getMessage());
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            String intentAction = intent.getAction();
            if (intent.hasCategory("android.intent.category.LAUNCHER") && intentAction != null && intentAction.equals("android.intent.action.MAIN")) {
                finish();
                return;
            }
        }
        setContentView((int) R.layout.activity_slash);
        Configuration configLang = getBaseContext().getResources().getConfiguration();
        String lang = SharedPref.getInstance(this).getString("lang", getResources().getConfiguration().locale.getLanguage());
        RLog.m86e(lang + "------");
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        configLang.locale = locale;
        getBaseContext().getResources().updateConfiguration(configLang, getBaseContext().getResources().getDisplayMetrics());
        Crittercism.initialize(getApplicationContext(), "f983c29a81d9481aa6c82e4b473257be00555300");
        this.umberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        this.mTimer = new C13771(1000, 1000);
        this.mTimer.start();
    }

    private void saveUserInfor(User data) {
        SharedPref.getInstance(this).putString(Constant.KEY_USER, new Gson().toJson((Object) data));
        SharedPref.getInstance(this).putString(Constant.KEY_TOKEN, data.getToken());
        SharedPref.getInstance(this).putString(Constant.KEY_ID, data.getId());
    }

    private void getAppConfig() {
        this.umberService.getAppConfig().enqueue(new C13782());
    }
}
