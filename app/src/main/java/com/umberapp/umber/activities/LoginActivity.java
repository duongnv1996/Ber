package com.umberapp.umber.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.FacebookSdk;
import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitActivity.ResponseType;
import com.facebook.accountkit.ui.AccountKitConfiguration.AccountKitConfigurationBuilder;
import com.facebook.accountkit.ui.LoginType;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.plus.Plus;
import com.google.gson.Gson;
import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.entities.Profile;
import com.sromku.simple.fb.entities.Profile.Properties;
import com.sromku.simple.fb.entities.Profile.Properties.Builder;
import com.sromku.simple.fb.listeners.OnLoginListener;
import com.sromku.simple.fb.listeners.OnProfileListener;
import com.sromku.simple.fb.utils.Attributes;
import com.sromku.simple.fb.utils.PictureAttributes;
import com.sromku.simple.fb.utils.PictureAttributes.PictureType;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.instagram.InstagramApp;
import com.umberapp.umber.instagram.InstagramApp.OAuthAuthenticationListener;
import com.umberapp.umber.interfaces.CallbackDialog;
import com.umberapp.umber.models.Config;
import com.umberapp.umber.models.User;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.utils.SharedPref;
import com.umberapp.umber.views.AlertDialogCustom;
import com.umberapp.umber.views.ProgressDialogCustom;
import com.wang.avi.indicators.LineScalePartyIndicator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements OnClickListener, OnConnectionFailedListener, CallbackDialog {
    public static int APP_REQUEST_CODE = 0;
    public static final int CODE_ACTIVE = 1;
    public static final int CODE_RESET_PASS = 0;
    private static final int CODE_UPDATE = 111;
    private static final int RC_SIGN_IN = 1002;
    String birthdaySocial;
    int codeSignIn;
    ProgressDialogCustom dialogProgress;
    String email;
    private NetworkStateReceiver internetReceiver;
    private boolean isLoginFirst;
    OAuthAuthenticationListener listener;
    @Bind({2131689681})
    CoordinatorLayout llRoot;
    @Bind({2131689682})
    LinearLayout llSigInNomal;
    @Bind({2131689689})
    LinearLayout llSignInOption;
    InstagramApp mApp;
    @Bind({2131689678})
    Button mBtnResetPass;
    @Bind({2131689683})
    EditText mEdtEmail;
    @Bind({2131689685})
    EditText mEdtPassword;
    GoogleApiClient mGoogleApiClient;
    @Bind({2131689676})
    ImageView mImgLogo;
    @Bind({2131689680})
    ProgressBar mProgress;
    private OnProfileListener onProfileListener;
    String phone;
    private boolean requestSignInFb;
    SimpleFacebook simpleFacebook;
    String tokenAK;
    UmberService umberService;
    String urlAvatarSocial;

    /* renamed from: com.umberapp.umber.activities.LoginActivity.11 */
    class AnonymousClass11 implements Callback<ApiResponse<User>> {
        final /* synthetic */ String val$userString;

        AnonymousClass11(String str) {
            this.val$userString = str;
        }

        public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
            LoginActivity.this.dialogProgress.hideDialog();
            if (response.isSuccessful()) {
                User user = (User) ((ApiResponse) response.body()).getData();
                if (user != null) {
                    user.setToken(this.val$userString);
                    if (user.getPhone() == null || user.getPhone().isEmpty() || user.getEmail() == null || user.getEmail().isEmpty()) {
                        if (LoginActivity.this.urlAvatarSocial != null) {
                            user.setAvatar(LoginActivity.this.urlAvatarSocial);
                        }
                        if (LoginActivity.this.birthdaySocial != null) {
                            user.setBirthday(LoginActivity.this.birthdaySocial);
                        }
                        if (LoginActivity.this.phone != null) {
                            user.setPhone(LoginActivity.this.phone);
                        }
                        if (LoginActivity.this.email != null) {
                            user.setEmail(LoginActivity.this.email);
                        }
                        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                        Bundle b = new Bundle();
                        b.putParcelable(Constant.KEY_USER, user);
                        i.putExtra(Constant.KEY_BUNDLE, b);
                        LoginActivity.this.tokenAK = user.getToken();
                        LoginActivity.this.startActivityForResult(i, LoginActivity.CODE_ACTIVE);
                        return;
                    }
                    AppController.getInstance().setUser(user);
                    LoginActivity.this.saveUserInfor((User) ((ApiResponse) response.body()).getData());
                    LoginActivity.this.getAppConfig();
                }
            } else if (LoginActivity.this.isLoginFirst && LoginActivity.this.requestSignInFb) {
                LoginActivity.this.signInFacebook();
                LoginActivity.this.isLoginFirst = false;
                LoginActivity.this.requestSignInFb = false;
            } else {
                RLog.m86e(Integer.valueOf(response.code()));
                AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.auth_failt)).show();
            }
        }

        public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
            LoginActivity.this.dialogProgress.hideDialog();
            RLog.m86e(t.getMessage());
            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.LoginActivity.13 */
    class AnonymousClass13 implements Callback<ApiResponse<List<User>>> {
        final /* synthetic */ ProgressDialogCustom val$dialogCustom;

        AnonymousClass13(ProgressDialogCustom progressDialogCustom) {
            this.val$dialogCustom = progressDialogCustom;
        }

        public void onResponse(Call<ApiResponse<List<User>>> call, Response<ApiResponse<List<User>>> response) {
            this.val$dialogCustom.hideDialog();
            if (response.isSuccessful()) {
                ApiResponse<List<User>> apiResponse = (ApiResponse) response.body();
                if (apiResponse != null && apiResponse.getStatus() == ApiConstants.CODE_SUCESS) {
                    AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.check_mail_mess)).show();
                    return;
                } else if (apiResponse != null && apiResponse.getStatus() == ApiConstants.CODE_ERROR_NO_EXIST_ACC) {
                    AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.exist_auth)).show();
                    return;
                } else if (apiResponse != null && apiResponse.getStatus() == 100) {
                    AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.already_active)).show();
                    return;
                } else if (apiResponse == null || apiResponse.getStatus() != R.styleable.AppCompatTheme_autoCompleteTextViewStyle) {
                    AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
                    return;
                } else {
                    AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.lock_acc)).show();
                    return;
                }
            }
            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<List<User>>> call, Throwable t) {
            this.val$dialogCustom.hideDialog();
            RLog.m86e(t.getMessage());
            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.LoginActivity.1 */
    class C13261 extends OnProfileListener {
        C13261() {
        }

        public void onComplete(Profile response) {
            super.onComplete(response);
            if (response != null) {
                if (!(response.getPicture() == null || response.getPicture().isEmpty())) {
                    LoginActivity.this.urlAvatarSocial = response.getPicture();
                }
                if (response.getBirthday() != null && !response.getBirthday().isEmpty()) {
                    LoginActivity.this.birthdaySocial = response.getBirthday();
                }
            }
        }
    }

    /* renamed from: com.umberapp.umber.activities.LoginActivity.2 */
    class C13272 implements OAuthAuthenticationListener {
        C13272() {
        }

        public void onSuccess() {
            if (LoginActivity.this.mApp.hasAccessToken()) {
                LoginActivity.this.signInWithInstagramToken(LoginActivity.this.mApp.getmAccessToken());
                if (LoginActivity.this.mApp.getAvt() != null && !LoginActivity.this.mApp.getAvt().isEmpty()) {
                    LoginActivity.this.urlAvatarSocial = LoginActivity.this.mApp.getAvt();
                    return;
                }
                return;
            }
            Toast.makeText(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error), LoginActivity.CODE_RESET_PASS).show();
        }

        public void onFail(String error) {
            Toast.makeText(LoginActivity.this, error, LoginActivity.CODE_RESET_PASS).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.LoginActivity.3 */
    class C13283 implements ConnectionCallbacks {
        C13283() {
        }

        public void onConnected(@Nullable Bundle bundle) {
            RLog.m86e("onConnected");
        }

        public void onConnectionSuspended(int i) {
            RLog.m86e("onConnectionSuspended");
        }
    }

    /* renamed from: com.umberapp.umber.activities.LoginActivity.4 */
    class C13294 implements AccountKitCallback<Account> {
        C13294() {
        }

        public void onSuccess(Account account) {
            LoginActivity.this.phone = account.getPhoneNumber().getRawPhoneNumber();
        }

        public void onError(AccountKitError accountKitError) {
            RLog.m86e("Error get phone AK " + accountKitError.getUserFacingMessage());
        }
    }

    /* renamed from: com.umberapp.umber.activities.LoginActivity.5 */
    class C13305 implements Callback<ApiResponse<User>> {
        C13305() {
        }

        public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
            LoginActivity.this.dialogProgress.hideDialog();
            if (response.isSuccessful()) {
                User user = (User) ((ApiResponse) response.body()).getData();
                if (user != null) {
                    LoginActivity.this.requestSignInFb = false;
                    LoginActivity.this.getProfile(user.getToken());
                    return;
                }
                AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
                return;
            }
            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
            LoginActivity.this.dialogProgress.hideDialog();
            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
            RLog.m86e(t.getMessage());
        }
    }

    /* renamed from: com.umberapp.umber.activities.LoginActivity.6 */
    class C13316 implements Callback<ApiResponse<User>> {
        C13316() {
        }

        public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
            LoginActivity.this.dialogProgress.hideDialog();
            if (response.isSuccessful()) {
                User user = (User) ((ApiResponse) response.body()).getData();
                if (user != null) {
                    LoginActivity.this.getProfile(user.getToken());
                    return;
                } else {
                    AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
                    return;
                }
            }
            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
            LoginActivity.this.dialogProgress.hideDialog();
            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
            RLog.m86e(t.getMessage());
        }
    }

    /* renamed from: com.umberapp.umber.activities.LoginActivity.7 */
    class C13327 implements OnLoginListener {
        C13327() {
        }

        public void onLogin(String accessToken, List<Permission> list, List<Permission> list2) {
            if (accessToken != null && !accessToken.isEmpty()) {
                PictureAttributes pictureAttributes = Attributes.createPictureAttributes();
                pictureAttributes.setHeight(ApiConstants.CODE_ERROR_SERVER);
                pictureAttributes.setWidth(ApiConstants.CODE_ERROR_SERVER);
                pictureAttributes.setType(PictureType.SQUARE);
                LoginActivity.this.simpleFacebook.getProfile(new Builder().add(Properties.PICTURE, pictureAttributes).add(ApiConstants.KEY_BIRTH).build(), LoginActivity.this.onProfileListener);
                LoginActivity.this.signInWithFacebookToken(accessToken);
            }
        }

        public void onCancel() {
        }

        public void onException(Throwable throwable) {
        }

        public void onFail(String reason) {
        }
    }

    /* renamed from: com.umberapp.umber.activities.LoginActivity.8 */
    class C13338 implements Callback<ApiResponse<User>> {
        C13338() {
        }

        public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
            LoginActivity.this.dialogProgress.hideDialog();
            if (response.isSuccessful()) {
                User user = (User) ((ApiResponse) response.body()).getData();
                if (user != null) {
                    LoginActivity.this.requestSignInFb = true;
                    LoginActivity.this.getProfile(user.getToken());
                    return;
                }
                AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
                return;
            }
            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
            LoginActivity.this.dialogProgress.hideDialog();
            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
            RLog.m86e(t.getMessage());
        }
    }

    /* renamed from: com.umberapp.umber.activities.LoginActivity.9 */
    class C13349 implements Callback<ApiResponse<User>> {
        C13349() {
        }

        public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
            LoginActivity.this.dialogProgress.hideDialog();
            if (response.isSuccessful()) {
                User user = (User) ((ApiResponse) response.body()).getData();
                if (user != null) {
                    LoginActivity.this.codeSignIn = 3;
                    LoginActivity.this.getProfile(user.getToken());
                    return;
                }
                AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
                return;
            }
            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
            LoginActivity.this.dialogProgress.hideDialog();
            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
            RLog.m86e(t.getMessage());
        }
    }

    class GetTokenTask extends AsyncTask<Void, Void, String> {
        public GetTokenTask() {
            LoginActivity.this.dialogProgress.showDialog();
        }

        protected String doInBackground(Void... voids) {
            String ace = BuildConfig.FLAVOR;
            String SCOPES = "https://www.googleapis.com/auth/userinfo.profile";
            try {
                if (ContextCompat.checkSelfPermission(LoginActivity.this, "android.permission.GET_ACCOUNTS") != 0) {
                    Toast.makeText(LoginActivity.this, LoginActivity.this.getString(R.string.permission_message),Toast.LENGTH_SHORT).show();
                    return null;
                }
                ace = GoogleAuthUtil.getToken(LoginActivity.this.getApplicationContext(), Plus.AccountApi.getAccountName(LoginActivity.this.mGoogleApiClient), "oauth2:https://www.googleapis.com/auth/userinfo.profile");
                Log.i(BuildConfig.FLAVOR, "mustafa olll " + ace);
                return ace;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GoogleAuthException e2) {
                e2.printStackTrace();
            }
        }

        protected void onPostExecute(String s) {
            LoginActivity.this.dialogProgress.hideDialog();
            super.onPostExecute(s);
            String tokenAccess = s;
            RLog.m86e("Token access GG =" + tokenAccess);
            if (tokenAccess == null || tokenAccess.isEmpty()) {
                AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unable_access_google)).show();
            } else {
                LoginActivity.this.signInWithGoogleToken(tokenAccess);
            }
        }
    }

    class NetworkStateReceiver extends BroadcastReceiver {
        NetworkStateReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            int i;
            Log.d("app", "Network connectivity change");
            if (intent.getExtras() != null) {
                NetworkInfo ni = (NetworkInfo) intent.getExtras().get("networkInfo");
                if (ni != null && ni.getState() == State.CONNECTED) {
                    Log.i("app", "Network " + ni.getTypeName() + " connected");
                    Crouton.cancelAllCroutons();
                    Crouton.makeText(LoginActivity.this, LoginActivity.this.getString(R.string.connected), Style.INFO, LoginActivity.this.llRoot).show();
                    for (i = LoginActivity.CODE_RESET_PASS; i < LoginActivity.this.llRoot.getChildCount(); i += LoginActivity.CODE_ACTIVE) {
                        LoginActivity.this.llRoot.getChildAt(i).setEnabled(true);
                        LoginActivity.this.llRoot.getChildAt(i).setAlpha(LineScalePartyIndicator.SCALE);
                        LoginActivity.this.llRoot.getChildAt(i).setClickable(true);
                    }
                    CommonUtils.enable(LoginActivity.this.llRoot);
                }
            }
            if (intent.getExtras().getBoolean("noConnectivity", Boolean.FALSE.booleanValue())) {
                Log.d("app", "There's no network connectivity");
                Crouton.makeText(LoginActivity.this, LoginActivity.this.getString(R.string.no_internet), Style.ALERT, LoginActivity.this.llRoot).setConfiguration(new Configuration.Builder().setDuration(-1).build()).show();
                for (i = LoginActivity.CODE_RESET_PASS; i < LoginActivity.this.llRoot.getChildCount(); i += LoginActivity.CODE_ACTIVE) {
                    LoginActivity.this.llRoot.getChildAt(i).setEnabled(false);
                    LoginActivity.this.llRoot.getChildAt(i).setAlpha(0.5f);
                    LoginActivity.this.llRoot.getChildAt(i).setClickable(false);
                }
                CommonUtils.disable(LoginActivity.this.llRoot);
            }
        }
    }

    public LoginActivity() {
        this.codeSignIn = CODE_RESET_PASS;
        this.internetReceiver = new NetworkStateReceiver();
        this.onProfileListener = new C13261();
        this.listener = new C13272();
        this.isLoginFirst = false;
        this.requestSignInFb = false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> listPermissions = new ArrayList();
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            listPermissions.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            listPermissions.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            listPermissions.add("android.permission.READ_EXTERNAL_STORAGE");
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            listPermissions.add("android.permission.RECORD_AUDIO");
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") != 0) {
            listPermissions.add("android.permission.READ_PHONE_STATE");
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.GET_ACCOUNTS") != 0) {
            listPermissions.add("android.permission.GET_ACCOUNTS");
        }
        if (listPermissions.size() > 0 && VERSION.SDK_INT >= 23) {
            requestPermissions((String[]) listPermissions.toArray(new String[listPermissions.size()]), 100);
        }
        setContentView((int) R.layout.activity_login);
        this.umberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        FacebookSdk.sdkInitialize(this);
        AccountKit.initialize(getApplicationContext());
        AppEventsLogger.newLogger(getApplicationContext(), getString(R.string.app_id));
        ButterKnife.bind((Activity) this);
        this.dialogProgress = new ProgressDialogCustom(this);
        this.mApp = new InstagramApp(this, "904159d085f0415aaf6d8bd6a996d6d6", "1c574942ea664a1095f903251f7c414f", "https://umberus.com", getSupportFragmentManager());
        this.mApp.setListener(this.listener);
        this.mGoogleApiClient = new GoogleApiClient.Builder(this).addApi(Plus.API).addConnectionCallbacks(new C13283()).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestServerAuthCode(getString(R.string.key_api_gplus)).requestScopes(new Scope(Scopes.PLUS_LOGIN), new Scope[CODE_RESET_PASS]).requestProfile().requestIdToken(getString(R.string.key_api_gplus)).build()).build();
        registerReceiver(this.internetReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        getWindow().setSoftInputMode(3);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.simpleFacebook.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_ACTIVE && resultCode == -1 && data != null) {
            String email = data.getStringExtra(Constant.KEY_EMAIL);
            String pass = data.getStringExtra(Constant.KEY_PASS);
            this.mEdtEmail.setText(email);
            this.mEdtPassword.setText(pass);
            signIn();
        }
        if (requestCode == CODE_ACTIVE && resultCode == CODE_ACTIVE) {
            switch (this.codeSignIn) {
                case CODE_RESET_PASS /*0*/:
                    signInFacebook();
                    break;
                case CODE_ACTIVE /*1*/:
                    if (!this.mApp.hasAccessToken()) {
                        this.mApp.authorize();
                        break;
                    }
                    this.codeSignIn = CODE_ACTIVE;
                    RLog.m89w("token - inst = " + this.mApp.getmAccessToken());
                    signInWithInstagramToken(this.mApp.getmAccessToken());
                    break;
                case 2 /*2*/:
                    signInGoogle();
                    break;
                case 3 /*3*/:
                    if (this.tokenAK == null) {
                        this.tokenAK = data.getStringExtra(Constant.KEY_MSG);
                    }
                    getProfile(this.tokenAK);
                    break;
            }
        }
        if (requestCode == 2 && resultCode == -1) {
            new MaterialDialog.Builder(this).title((int) R.string.success).content((int) R.string.sent_email).show();
        }
        if (requestCode == CODE_UPDATE && resultCode == -1) {
            signIn();
        }
        if (requestCode == 0 && resultCode == -1) {
            AlertDialogCustom.dialogMsg(this, getString(R.string.sent_email)).show();
        }
        if (requestCode == RC_SIGN_IN) {
            handleSignInResult(Auth.GoogleSignInApi.getSignInResultFromIntent(data));
        }
        if (requestCode == APP_REQUEST_CODE) {
            AccountKitLoginResult loginResult = (AccountKitLoginResult) data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            String message;
            if (loginResult.getError() != null) {
                message = loginResult.getError().getErrorType().getMessage();
            } else if (loginResult.wasCancelled()) {
                message = "Login Cancelled";
            } else if (loginResult.getAccessToken() != null) {
                message = "Success:" + loginResult.getAccessToken().getAccountId();
                AccountKit.getCurrentAccount(new C13294());
                signInWithAKToken(loginResult.getAccessToken().getToken());
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb /*2131689673*/:
                this.codeSignIn = CODE_RESET_PASS;
                signInFacebook();
            case R.id.ins /*2131689674*/:
                if (this.mApp.hasAccessToken()) {
                    this.codeSignIn = CODE_ACTIVE;
                    RLog.m89w("token - inst = " + this.mApp.getmAccessToken());
                    signInWithInstagramToken(this.mApp.getmAccessToken());
                    return;
                }
                this.mApp.authorize();
            case R.id.gg /*2131689675*/:
                this.codeSignIn = 2;
                signInGoogle();
            case R.id.btn_resetpass /*2131689678*/:
                startActivityForResult(new Intent(this, ForgotPasswordActivity.class), CODE_RESET_PASS);
            case R.id.btn_goto_register /*2131689686*/:
                startActivityForResult(new Intent(this, RegisterActivity.class), CODE_ACTIVE);
            case R.id.btn_login /*2131689688*/:
                signIn();
            case R.id.btn_login_by_phone /*2131689690*/:
                this.codeSignIn = 3;
                onLoginPhone();
            case R.id.btn_login_by_username /*2131689691*/:
                this.llSignInOption.setVisibility(8);
                this.llSigInNomal.setVisibility(CODE_RESET_PASS);
            default:
        }
    }

    private void signInWithGoogleToken(String tokenFacebook) {
        this.dialogProgress.showDialog();
        this.umberService.getProfileWithGG(tokenFacebook).enqueue(new C13305());
    }

    private void signInWithInstagramToken(String tokenInst) {
        this.dialogProgress.showDialog();
        this.umberService.getProfileWithInsta(tokenInst).enqueue(new C13316());
    }

    private void signInFacebook() {
        this.simpleFacebook.login(new C13327());
    }

    private void signInWithFacebookToken(String tokenFacebook) {
        this.dialogProgress.showDialog();
        this.umberService.getProfileWithFb(tokenFacebook).enqueue(new C13338());
    }

    private void signInWithAKToken(String tokenAccess) {
        this.dialogProgress.showDialog();
        this.umberService.getProfileWithAK(tokenAccess).enqueue(new C13349());
    }

    private void signIn() {
        CommonUtils.hideKeyBroad(this, this.mEdtPassword);
        String email = this.mEdtEmail.getText().toString();
        String pass = this.mEdtPassword.getText().toString();
        if (email.isEmpty()) {
            AlertDialogCustom.dialogMsg(this, getString(R.string.please_enter_email)).show();
        } else if (pass.isEmpty()) {
            AlertDialogCustom.dialogMsg(this, getString(R.string.enter_pass)).show();
        } else if (pass.length() < 6) {
            AlertDialogCustom.dialogMsg(this, getString(R.string.pass_incorrectly)).show();
        } else {
            this.dialogProgress.showDialog();
            this.umberService.login(email, pass).enqueue(new Callback<ApiResponse<User>>() {
                public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
                    LoginActivity.this.dialogProgress.hideDialog();
                    if (response.isSuccessful()) {
                        ApiResponse<User> apiResponse = (ApiResponse) response.body();
                        if (apiResponse == null || apiResponse.getData() == null) {
                            AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.auth_failt)).show();
                            return;
                        }
                        LoginActivity.this.getProfile(((User) apiResponse.getData()).getToken());
                        return;
                    }
                    AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.auth_failt)).show();
                }

                public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
                    LoginActivity.this.dialogProgress.hideDialog();
                    AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
                    RLog.m86e(t.getMessage());
                }
            });
        }
    }

    void getProfile(String userString) {
        if (!(this.dialogProgress == null || this.dialogProgress.isShowing())) {
            this.dialogProgress.showDialog();
        }
        this.isLoginFirst = true;
        RLog.m85d("token = " + userString);
        this.umberService.getInfor(userString).enqueue(new AnonymousClass11(userString));
    }

    private void getAppConfig() {
        this.umberService.getAppConfig().enqueue(new Callback<ApiResponse<Config>>() {
            public void onResponse(Call<ApiResponse<Config>> call, Response<ApiResponse<Config>> response) {
                LoginActivity.this.dialogProgress.hideDialog();
                if (response.isSuccessful()) {
                    Config config = (Config) ((ApiResponse) response.body()).getData();
                    if (config != null) {
                        Toast.makeText(LoginActivity.this, LoginActivity.this.getString(R.string.login_success), Toast.LENGTH_LONG).show();
                        AppController.getInstance().setAppConfig(config);
                        LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        LoginActivity.this.finish();
                        return;
                    }
                    AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
                    return;
                }
                RLog.m86e(Integer.valueOf(response.code()));
                AlertDialogCustom.dialogMsg(LoginActivity.this, LoginActivity.this.getString(R.string.unknow_error)).show();
            }

            public void onFailure(Call<ApiResponse<Config>> call, Throwable t) {
                LoginActivity.this.dialogProgress.hideDialog();
                RLog.m86e(t.getMessage());
            }
        });
    }

    private void saveUserInfor(User data) {
        SharedPref.getInstance(this).putString(Constant.KEY_USER, new Gson().toJson((Object) data));
        SharedPref.getInstance(this).putString(Constant.KEY_TOKEN, data.getToken());
        SharedPref.getInstance(this).putString(Constant.KEY_ID, data.getId());
    }

    protected void onResume() {
        super.onResume();
        this.mProgress.setVisibility(8);
        this.simpleFacebook = SimpleFacebook.getInstance(this);
    }

    protected void onStop() {
        super.onStop();
        try {
            unregisterReceiver(this.internetReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickDialogEdt(String edt, int code) {
        Call<ApiResponse<List<User>>> callback;
        ProgressDialogCustom dialogCustom = new ProgressDialogCustom(this);
        dialogCustom.showDialog();
        if (code == 0) {
            callback = this.umberService.forgotPassword(edt);
        } else {
            callback = this.umberService.activeAcc(edt);
        }
        callback.enqueue(new AnonymousClass13(dialogCustom));
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        RLog.m86e("No connection gg");
    }

    private void signInGoogle() {
        startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(this.mGoogleApiClient), RC_SIGN_IN);
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d("Login GG Result", "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            String token = acct.getIdToken();
            String auth = acct.getServerAuthCode();
            this.email = acct.getEmail();
            this.urlAvatarSocial = acct.getPhotoUrl().toString();
            RLog.m86e(auth);
            new GetTokenTask().execute(new Void[CODE_RESET_PASS]);
            return;
        }
        RLog.m86e("loginResult unsuccess!" + result.getStatus());
        result.getStatus();
        AlertDialogCustom.dialogMsg(this, getString(R.string.unknow_error)).show();
    }

    protected void onStart() {
        super.onStart();
    }

    public void onBackPressed() {
        if (this.llSignInOption.getVisibility() == View.GONE) {
            this.llSignInOption.setVisibility(View.VISIBLE);
            this.llSigInNomal.setVisibility(View.GONE);
            return;
        }
        super.onBackPressed();
    }

    static {
        APP_REQUEST_CODE = 99;
    }

    public void onLoginPhone() {
        try {
            Intent intent = new Intent(this, AccountKitActivity.class);
            AccountKitConfigurationBuilder configurationBuilder = new AccountKitConfigurationBuilder(LoginType.PHONE, ResponseType.TOKEN);
            configurationBuilder.setDefaultCountryCode("ID");
            intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION, configurationBuilder.build());
            startActivityForResult(intent, APP_REQUEST_CODE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
