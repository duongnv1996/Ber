package com.umberapp.umber.activities;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;
import com.onesignal.OneSignal.IdsAvailableHandler;
import com.onesignal.OneSignal.NotificationOpenedHandler;
import com.onesignal.OneSignal.NotificationReceivedHandler;
import com.onesignal.OneSignal.OSInFocusDisplayOption;
import com.sromku.simple.fb.SimpleFacebook;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.models.ExpertBit;
import com.umberapp.umber.models.FeedbackUser;
import com.umberapp.umber.models.NotificationItem;
import com.umberapp.umber.models.OnsignalItem;
import com.umberapp.umber.socket.SocketConstants;
import com.umberapp.umber.socket.UmberSocketClient;
import com.umberapp.umber.socket.UmberSocketClient.LocalBinder;
import com.umberapp.umber.socket.UmberSocketClient.OnListenResponse;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.utils.SharedPref;
import com.umberapp.umber.views.AlertDialogCustom;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import de.keyboardsurfer.android.widget.crouton.Style.Builder;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseActivity extends AppCompatActivity implements OnListenResponse, OnRespone<String> {
    static Dialog dialog;
    static boolean isShowDialogCost;
    static boolean isShowDialogFeedback;
    public static HashMap<String, Boolean> mapOrderEstimated;
    int count;
    Dialog dialogConfirmCost;
    boolean isInBackground;
    String jsonNotification;
    String jsonResponse;
    List<Dialog> listDialog;
    List<NotificationItem> listNotifications;
    boolean mBounded;
    ServiceConnection mConnection;
    protected UmberSocketClient mUmberSocket;
    private UmberService mservice;
    NotificationItem notificationItem;
    BroadcastReceiver receiver;
    String registrationId;
    SimpleFacebook simpleFacebook;
    ViewGroup view;

    /* renamed from: com.umberapp.umber.activities.BaseActivity.1 */
    class C13111 extends BroadcastReceiver {

        /* renamed from: com.umberapp.umber.activities.BaseActivity.1.1 */
        class C13101 implements OnRespone<FeedbackUser> {

            /* renamed from: com.umberapp.umber.activities.BaseActivity.1.1.1 */
            class C13091 implements Callback<ResponseBody> {
                C13091() {
                }

                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        Crouton.makeText(BaseActivity.this, BaseActivity.this.getString(R.string.thank_feedback), Style.INFO, BaseActivity.this.view).show();
                        SharedPref.getInstance(BaseActivity.this).putString(Constant.KEY_ORDER_ID, BuildConfig.FLAVOR);
                    } else {
                        RLog.m86e(Integer.valueOf(response.code()));
                    }
                    BaseActivity.this.removeAllTab();
                    BaseActivity.this.finishOrder();
                }

                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    BaseActivity.this.removeAllTab();
                    BaseActivity.this.finishOrder();
                    RLog.m86e(t.getMessage());
                }
            }

            C13101() {
            }

            public void onRespone(FeedbackUser object) {
                object.setOrderId(AppController.getInstance().getIdOrder());
                BaseActivity.this.mservice.feedbackExpert(AppController.getInstance().getUser().getToken(), object.getComment(), object.getOrderId(), object.getStar()).enqueue(new C13091());
            }
        }

        C13111() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                BaseActivity.this.jsonResponse = intent.getStringExtra(Constant.KEY_MSG);
                RLog.m86e("Base" + BaseActivity.this.jsonResponse);
                if (BaseActivity.this.jsonResponse != null) {
                    try {
                        JSONObject obj = new JSONObject(BaseActivity.this.jsonResponse);
                        if (obj.has(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) && obj.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS).equals("ServerDecline")) {
                            Crouton.makeText(BaseActivity.this, BaseActivity.this.getString(R.string.job_was_declined), Style.INFO, BaseActivity.this.view).show();
                            if (!BaseActivity.this.isInBackground) {
                                BaseActivity.this.removeAllTab();
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                BaseActivity.this.count = intent.getIntExtra(Constant.KEY_UNREAD, -1);
                BaseActivity.this.unreadNotification(BaseActivity.this.count);
                BaseActivity.this.jsonNotification = intent.getStringExtra(Constant.KEY_NOTIFCATION);
                if (!(BaseActivity.this.jsonNotification == null || BaseActivity.this.jsonNotification.isEmpty())) {
                    BaseActivity.this.notificationItem = (NotificationItem) new Gson().fromJson(BaseActivity.this.jsonNotification, NotificationItem.class);
                    if (!(BaseActivity.this.notificationItem == null || AppController.getInstance().getUser() == null || BaseActivity.this.notificationItem.getTo() == null || !BaseActivity.this.notificationItem.getTo().equals(AppController.getInstance().getUser().getId()))) {
                        BaseActivity.this.listNotifications.add(BaseActivity.this.notificationItem);
                        Style styel = new Builder().setBackgroundColor(Color.parseColor("#39c2d7")).setTextColor(Color.parseColor("#39c2d7")).build();
                        Crouton.cancelAllCroutons();
                        Crouton.makeText(BaseActivity.this, BaseActivity.this.notificationItem.getContent().getMessage(), Style.INFO, BaseActivity.this.view).show();
                        if (BaseActivity.this.notificationItem.getContent().getFields().getStatusOrder() != null && BaseActivity.this.notificationItem.getContent().getFields().getStatusOrder().equals(SocketConstants.STATUS_ORDER_ESTIMATED) && BaseActivity.this.notificationItem.getTo().equals(AppController.getInstance().getUser().getId()) && BaseActivity.mapOrderEstimated.get(BaseActivity.this.notificationItem.getContent().getFields().getOrderId()) == null) {
                            BaseActivity.this.estimatedCostOrder(BaseActivity.this.notificationItem);
                        } else if (BaseActivity.this.notificationItem.getContent().getFields().getStatusOrder() != null && BaseActivity.this.notificationItem.getContent().getFields().getStatusOrder().equals(Constant.KEY_FINISH)) {
                            Dialog dialogFeedback = AlertDialogCustom.dialogfeedBack(BaseActivity.this, new C13101(), BaseActivity.this.simpleFacebook);
                            RLog.m86e("dialog shown feedback: " + BaseActivity.isShowDialogFeedback);
                            if (BaseActivity.isShowDialogFeedback) {
                                BaseActivity.isShowDialogFeedback = false;
                            } else {
                                dialogFeedback.show();
                                BaseActivity.isShowDialogFeedback = true;
                            }
                            BaseActivity.this.listDialog.add(dialogFeedback);
                            BaseActivity.isShowDialogCost = false;
                        } else if (BaseActivity.this.notificationItem.getContent() == null || !BaseActivity.this.notificationItem.getContent().getFields().getStatusOrder().equals(SocketConstants.KEY_ON_MY_WAY)) {
                            if (BaseActivity.this.notificationItem.getContent().getFields().getStatusOrder() != null && BaseActivity.this.notificationItem.getContent().getFields().getStatusOrder().equals(SocketConstants.STATUS_ORDER_DECLINE)) {
                                BaseActivity.this.finishOrder();
                            }
                        } else if (BaseActivity.this.mUmberSocket != null) {
                            BaseActivity.this.mUmberSocket.trackingExpert(BaseActivity.this.notificationItem.getFrom());
                        }
                    }
                }
                CharSequence statusConnection = intent.getStringExtra(Constant.KEY_STATUS_CONNECTION);
                if (statusConnection != null) {
                    if (statusConnection.equals(BaseActivity.this.getString(R.string.connected))) {
                        Crouton.makeText(BaseActivity.this, statusConnection, Style.CONFIRM, BaseActivity.this.view).show();
                    } else if (statusConnection.equals(BaseActivity.this.getString(R.string.disconnect))) {
                        Crouton.makeText(BaseActivity.this, statusConnection, Style.ALERT, BaseActivity.this.view).show();
                    } else {
                        Crouton.makeText(BaseActivity.this, statusConnection, Style.INFO, BaseActivity.this.view).show();
                    }
                }
                String latlng = intent.getStringExtra(Constant.KEY_LATLNG);
                if (latlng != null && !latlng.isEmpty()) {
                    String[] p = latlng.replace("[", BuildConfig.FLAVOR).replace("]", BuildConfig.FLAVOR).split(",");
                    LatLng l = new LatLng(Double.parseDouble(p[0]), Double.parseDouble(p[1]));
                    BaseActivity.this.trackExpert(p[1], p[0]);
                }
            }
        }
    }

    /* renamed from: com.umberapp.umber.activities.BaseActivity.2 */
    class C13122 implements OnRespone {
        final /* synthetic */ NotificationItem val$notificationItem;

        C13122(NotificationItem notificationItem) {
            this.val$notificationItem = notificationItem;
        }

        public void onRespone(Object object) {
            BaseActivity.this.mUmberSocket.estimatedExpert(this.val$notificationItem.getFrom(), this.val$notificationItem.getContent().getFields().getOrderId());
            if (BaseActivity.this.listDialog.size() > 0) {
                for (Dialog dialog : BaseActivity.this.listDialog) {
                    if (dialog != null && dialog.isShowing()) {
                        dialog.cancel();
                    }
                }
            }
            BaseActivity.this.dialogConfirmCost = null;
        }
    }

    /* renamed from: com.umberapp.umber.activities.BaseActivity.3 */
    class C13133 implements OnRespone {
        C13133() {
        }

        public void onRespone(Object object) {
            BaseActivity.dialog = AlertDialogCustom.dialogConfirmCancle(BaseActivity.this, BaseActivity.this);
            BaseActivity.dialog.show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.BaseActivity.4 */
    class C13144 implements ServiceConnection {
        C13144() {
        }

        public void onServiceDisconnected(ComponentName name) {
            RLog.m86e("disconnect umbersk");
            BaseActivity.this.mBounded = false;
            BaseActivity.this.mUmberSocket = null;
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            RLog.m86e("connected umbersk");
            BaseActivity.this.mBounded = true;
            LocalBinder mLocalBinder = (LocalBinder) service;
            BaseActivity.this.mUmberSocket = mLocalBinder.getServerInstance();
        }
    }

    /* renamed from: com.umberapp.umber.activities.BaseActivity.5 */
    class C13155 implements Callback<ResponseBody> {
        C13155() {
        }

        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful()) {
                try {
                    RLog.m86e("success " + ((ResponseBody) response.body()).string().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void onFailure(Call<ResponseBody> call, Throwable t) {
            RLog.m86e(t.getMessage());
        }
    }

    /* renamed from: com.umberapp.umber.activities.BaseActivity.6 */
    class C13166 implements NotificationOpenedHandler {
        C13166() {
        }

        public void notificationOpened(OSNotificationOpenResult result) {
            RLog.m86e("NotificationOpenedHandler ");
            JSONObject data = result.notification.payload.additionalData;
            RLog.m86e(Boolean.valueOf(result.notification.isAppInFocus));
            RLog.m86e("NotificationReceivedHandler " + data.toString());
            if (data != null) {
                OnsignalItem item = (OnsignalItem) new Gson().fromJson(data.toString(), OnsignalItem.class);
                Intent i = new Intent(BaseActivity.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putParcelable(Constant.KEY_MSG, item);
                i.putExtra(Constant.KEY_BUNDLE, b);
                i.addFlags(67108864);
                BaseActivity.this.startActivity(i);
            }
        }
    }

    /* renamed from: com.umberapp.umber.activities.BaseActivity.7 */
    class C13177 implements NotificationReceivedHandler {
        C13177() {
        }

        public void notificationReceived(OSNotification notification) {
            JSONObject data = notification.payload.additionalData;
            RLog.m86e(Boolean.valueOf(notification.isAppInFocus));
            RLog.m86e("NotificationReceivedHandler " + data.toString());
        }
    }

    /* renamed from: com.umberapp.umber.activities.BaseActivity.8 */
    class C13188 implements IdsAvailableHandler {
        C13188() {
        }

        public void idsAvailable(String userId, String registrationId) {
            Log.d("debug", "User:" + userId);
            BaseActivity.this.registerOnsignal(userId);
            BaseActivity.this.registrationId = userId;
            if (registrationId != null) {
                Log.d("debug", "registrationId:" + registrationId);
            }
        }
    }

    abstract void finishOrder();

    abstract void startToFragment(ExpertBit expertBit);

    abstract void trackExpert(String str, String str2);

    abstract void unreadNotification(int i);

    public BaseActivity() {
        this.listDialog = new ArrayList();
        this.receiver = new C13111();
        this.mConnection = new C13144();
    }

    static {
        isShowDialogCost = false;
        isShowDialogFeedback = false;
        mapOrderEstimated = new HashMap();
    }

    public void estimatedCostOrder(NotificationItem notificationItem) {
        this.dialogConfirmCost = AlertDialogCustom.dialogConfirmCost((Context) this, new C13122(notificationItem), new C13133(), notificationItem);
        RLog.m86e("dialog shown Cost: " + isShowDialogCost);
        if (isShowDialogCost) {
            isShowDialogCost = false;
        } else {
            this.dialogConfirmCost.show();
            isShowDialogCost = true;
        }
        this.listDialog.add(this.dialogConfirmCost);
    }

    public void removeAllTab() {
        for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
            getSupportFragmentManager().popBackStack();
        }
        onResume();
    }

    void registerOnsignal(String idUSer) {
        String uuid = CommonUtils.getImei(this);
        RLog.m86e("uuid = " + uuid);
        String token = SharedPref.getInstance(this).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
        if (!token.isEmpty()) {
            this.mservice.registerOnsignal(token, uuid, idUSer, BuildConfig.FLAVOR, "device").enqueue(new C13155());
        }
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mservice = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        this.listNotifications = new ArrayList();
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
        if (listPermissions.size() <= 0) {
            OneSignal.startInit(this).autoPromptLocation(true).inFocusDisplaying(OSInFocusDisplayOption.None).setNotificationReceivedHandler(new C13177()).setNotificationOpenedHandler(new C13166()).init();
            OneSignal.idsAvailable(new C13188());
//            try {
//                for (Signature signature : getPackageManager().getPackageInfo(getPackageName(), 64).signatures) {
//                    MessageDigest md = MessageDigest.getInstance("SHA");
//                    md.update(signature.toByteArray());
//                    Log.e("hash key", new String(Base64.encode(md.digest(), 0)));
//                }
//            } catch (NameNotFoundException e1) {
//                Log.e("name not found", e1.toString());
//            } catch (NoSuchAlgorithmException e) {
//                Log.e("no such an algorithm", e.toString());
//            } catch (Exception e2) {
//                Log.e("exception", e2.toString());
//            }
        } else if (VERSION.SDK_INT >= 23) {
            requestPermissions((String[]) listPermissions.toArray(new String[listPermissions.size()]), 100);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        int i = 0;
        while (i < grantResults.length) {
            if (requestCode != 100 || grantResults[i] != 0) {
                Toast.makeText(this, R.string.right, 1).show();
            } else if (permissions[i].equals("android.permission.READ_PHONE_STATE") && this.registrationId != null) {
                registerOnsignal(this.registrationId);
            }
            i++;
        }
    }

    protected void onResume() {
        super.onResume();
        this.simpleFacebook = SimpleFacebook.getInstance(this);
        this.isInBackground = false;
        if (this.dialogConfirmCost != null && this.dialogConfirmCost.isShowing() && this.notificationItem != null && mapOrderEstimated.get(this.notificationItem.getContent().getFields().getOrderId()) != null) {
            this.dialogConfirmCost.cancel();
        }
    }

    protected void onStop() {
        super.onStop();
        this.isInBackground = true;
    }

    protected void onStart() {
        super.onStart();
        Intent mIntent = new Intent(this, UmberSocketClient.class);
        startService(mIntent);
        bindService(mIntent, this.mConnection,BIND_IMPORTANT);
        IntentFilter i = new IntentFilter();
        i.addAction(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        registerReceiver(this.receiver, i);
    }

    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, UmberSocketClient.class));
        unregisterReceiver(this.receiver);
        if (this.mBounded) {
            unbindService(this.mConnection);
            this.mBounded = false;
        }
    }

    public void onResponse(String response) {
    }

    public UmberSocketClient getmUmberSocket() {
        return this.mUmberSocket;
    }

    public void setmUmberSocket(UmberSocketClient mUmberSocket) {
        this.mUmberSocket = mUmberSocket;
    }

    public void onRespone(String object) {
        if (this.dialogConfirmCost.isShowing()) {
            this.dialogConfirmCost.cancel();
        }
        this.mUmberSocket.cancleOrder(object, this.notificationItem.getFrom(), this.notificationItem.getContent().getFields().getOrderId());
        mapOrderEstimated.put(this.notificationItem.getContent().getFields().getOrderId(), Boolean.valueOf(true));
        finishOrder();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.simpleFacebook.onActivityResult(requestCode, resultCode, data);
    }

    public UmberService getMservice() {
        return this.mservice;
    }

    public void setMservice(UmberService mservice) {
        this.mservice = mservice;
    }
}
