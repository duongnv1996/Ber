package com.umberapp.umber.instagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.facebook.internal.ServerProtocol;
import com.sromku.simple.fb.entities.Profile.Properties;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.fragments.WebFragment;
import com.umberapp.umber.fragments.WebFragment.OAuthDialogListener;
import com.umberapp.umber.utils.Constant;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import io.socket.engineio.client.transports.PollingXHR.Request;
import me.zhanghai.android.materialprogressbar.BuildConfig;

public class InstagramApp {
    private static final String API_URL = "https://api.instagram.com/v1";
    private static final String AUTH_URL = "https://api.instagram.com/oauth/authorize/";
    private static final String TAG = "InstagramAPI";
    private static final String TOKEN_URL = "https://api.instagram.com/oauth/access_token";
    private static int WHAT_ERROR;
    private static int WHAT_FETCH_INFO;
    private static int WHAT_FINALIZE;
    public static String mCallbackUrl;
    OAuthDialogListener listener;
    private String mAccessToken;
    private String mAuthUrl;
    private String mClientId;
    private String mClientSecret;
    private Context mCtx;
    private InstagramDialog mDialog;
    private Handler mHandler;
    private OAuthAuthenticationListener mListener;
    private ProgressDialog mProgress;
    private InstagramSession mSession;
    private String mTokenUrl;
    FragmentManager manager;

    public interface OAuthAuthenticationListener {
        void onFail(String str);

        void onSuccess();
    }

    /* renamed from: com.umberapp.umber.instagram.InstagramApp.1 */
    class C14281 implements OAuthDialogListener {
        C14281() {
        }

        public void onComplete(String code) {
            InstagramApp.this.getAccessToken(code);
        }

        public void onError(String error) {
            InstagramApp.this.mListener.onFail("Authorization failed");
        }
    }

    /* renamed from: com.umberapp.umber.instagram.InstagramApp.2 */
    class C14292 extends Thread {
        final /* synthetic */ String val$code;

        C14292(String str) {
            this.val$code = str;
        }

        public void run() {
            Log.i(InstagramApp.TAG, "Getting access token");
            int what = InstagramApp.WHAT_FETCH_INFO;
            try {
                URL url = new URL(InstagramApp.TOKEN_URL);
                Log.i(InstagramApp.TAG, "Opening Token URL " + url.toString());
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
                writer.write("client_id=" + InstagramApp.this.mClientId + "&client_secret=" + InstagramApp.this.mClientSecret + "&grant_type=authorization_code" + "&redirect_uri=" + InstagramApp.mCallbackUrl + "&code=" + this.val$code);
                writer.flush();
                String response = InstagramApp.this.streamToString(urlConnection.getInputStream());
                Log.i(InstagramApp.TAG, "response " + response);
                JSONObject jsonObj = (JSONObject) new JSONTokener(response).nextValue();
                InstagramApp.this.mAccessToken = jsonObj.getString(ServerProtocol.DIALOG_PARAM_ACCESS_TOKEN);
                Log.i(InstagramApp.TAG, "Got access token: " + InstagramApp.this.mAccessToken);
                InstagramApp.this.mSession.storeAccessToken(InstagramApp.this.mAccessToken, jsonObj.getJSONObject(Constant.KEY_USER).getString(Constant.KEY_ID), jsonObj.getJSONObject(Constant.KEY_USER).getString(ApiConstants.KEY_USER_NAME), jsonObj.getJSONObject(Constant.KEY_USER).getString("full_name"), jsonObj.getJSONObject(Constant.KEY_USER).getString("profile_picture"));
            } catch (Exception ex) {
                what = InstagramApp.WHAT_ERROR;
                ex.printStackTrace();
            }
            InstagramApp.this.mHandler.sendMessage(InstagramApp.this.mHandler.obtainMessage(what, 1, 0));
        }
    }

    /* renamed from: com.umberapp.umber.instagram.InstagramApp.3 */
    class C14303 extends Thread {
        C14303() {
        }

        public void run() {
            Log.i(InstagramApp.TAG, "Fetching user info");
            int what = InstagramApp.WHAT_FINALIZE;
            try {
                URL url = new URL("https://api.instagram.com/v1/users/" + InstagramApp.this.mSession.getId() + "/?access_token=" + InstagramApp.this.mAccessToken);
                Log.d(InstagramApp.TAG, "Opening URL " + url.toString());
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setDoInput(true);
                urlConnection.connect();
                String response = InstagramApp.this.streamToString(urlConnection.getInputStream());
                System.out.println(response);
                JSONObject jsonObj = (JSONObject) new JSONTokener(response).nextValue();
                String name = jsonObj.getJSONObject(Request.EVENT_DATA).getString("full_name");
                Log.i(InstagramApp.TAG, "Got name: " + name + ", bio [" + jsonObj.getJSONObject(Request.EVENT_DATA).getString(Properties.BIO) + "]");
            } catch (Exception ex) {
                what = InstagramApp.WHAT_ERROR;
                ex.printStackTrace();
            }
            InstagramApp.this.mHandler.sendMessage(InstagramApp.this.mHandler.obtainMessage(what, 2, 0));
        }
    }

    /* renamed from: com.umberapp.umber.instagram.InstagramApp.4 */
    class C14314 extends Handler {
        C14314() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == InstagramApp.WHAT_ERROR) {
                InstagramApp.this.mProgress.dismiss();
                if (msg.arg1 == 1) {
                    InstagramApp.this.mListener.onFail("Failed to get access token");
                } else if (msg.arg1 == 2) {
                    InstagramApp.this.mListener.onFail("Failed to get user information");
                }
            } else if (msg.what == InstagramApp.WHAT_FETCH_INFO) {
                InstagramApp.this.fetchUserName();
            } else {
                InstagramApp.this.mProgress.dismiss();
                InstagramApp.this.mListener.onSuccess();
            }
        }
    }

    static {
        WHAT_FINALIZE = 0;
        WHAT_ERROR = 1;
        WHAT_FETCH_INFO = 2;
        mCallbackUrl = BuildConfig.FLAVOR;
    }

    public InstagramApp(Context context, String clientId, String clientSecret, String callbackUrl, FragmentManager manager) {
        this.mHandler = new C14314();
        this.manager = manager;
        this.mClientId = clientId;
        this.mClientSecret = clientSecret;
        this.mCtx = context;
        this.mSession = new InstagramSession(context);
        this.mAccessToken = this.mSession.getAccessToken();
        mCallbackUrl = callbackUrl;
        this.mTokenUrl = "https://api.instagram.com/oauth/access_token?client_id=" + clientId + "&client_secret=" + clientSecret + "&redirect_uri=" + mCallbackUrl + "&grant_type=authorization_code";
        this.mAuthUrl = "https://api.instagram.com/oauth/authorize/?client_id=" + clientId + "&redirect_uri=" + mCallbackUrl + "&response_type=code&display=touch&scope=basic";
        this.listener = new C14281();
        this.mProgress = new ProgressDialog(context);
        this.mProgress.setCancelable(false);
    }

    private void getAccessToken(String code) {
        this.mProgress.setMessage("Getting access token ...");
        this.mProgress.show();
        new C14292(code).start();
    }

    private void fetchUserName() {
        this.mProgress.setMessage("Finalizing ...");
        new C14303().start();
    }

    public boolean hasAccessToken() {
        return this.mAccessToken != null;
    }

    public void setListener(OAuthAuthenticationListener listener) {
        this.mListener = listener;
    }

    public String getUserName() {
        return this.mSession.getUsername();
    }

    public String getId() {
        return this.mSession.getId();
    }

    public String getName() {
        return this.mSession.getName();
    }

    public String getAvt() {
        return this.mSession.getAvt();
    }

    public void authorize() {
        this.manager.beginTransaction().replace(R.id.contentview, new WebFragment(this.mAuthUrl, this.listener)).addToBackStack(null).commit();
    }

    private String streamToString(InputStream is) throws IOException {
        String str = BuildConfig.FLAVOR;
        if (is == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            reader.close();
            return sb.toString();
        } finally {
            is.close();
        }
    }

    public String getmAccessToken() {
        return this.mAccessToken;
    }

    public void setmAccessToken(String mAccessToken) {
        this.mAccessToken = mAccessToken;
    }

    public void resetAccessToken() {
        if (this.mAccessToken != null) {
            this.mSession.resetAccessToken();
            this.mAccessToken = null;
        }
    }
}
