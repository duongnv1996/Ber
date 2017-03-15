package com.umberapp.umber.socket;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.models.AckSocket;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.utils.SharedPref;

import org.json.JSONException;
import org.json.JSONObject;

import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.IO.Options;
import io.socket.client.Socket;
import io.socket.emitter.Emitter.Listener;
import io.socket.engineio.client.transports.PollingXHR.Request;
import io.socket.engineio.client.transports.WebSocket;
import io.socket.engineio.parser.Packet;
import me.zhanghai.android.materialprogressbar.BuildConfig;

public class UmberSocketClient extends Service {
    IBinder mBinder;
    OnListenResponse onListenRespone;
    Socket socket;

    public interface OnListenResponse {
        void onResponse(String str);
    }

    /* renamed from: com.umberapp.umber.socket.UmberSocketClient.10 */
    class AnonymousClass10 implements Listener {
        final /* synthetic */ Socket val$finalSocket;
        final /* synthetic */ String val$token;

        /* renamed from: com.umberapp.umber.socket.UmberSocketClient.10.1 */
        class C14401 implements Ack {
            C14401() {
            }

            public void call(Object... args) {
                JSONObject json = (JSONObject) args[0];
                RLog.m86e("notification = " + json.toString());
                try {
                    AckSocket ack = (AckSocket) new Gson().fromJson(json.toString(), AckSocket.class);
                    if (ack != null && ack.getBody() != null && ack.getBody().getNotificationUnRead() != 0) {
                        Intent intent = new Intent();
                        intent.setAction(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                        intent.putExtra(Constant.KEY_UNREAD, ack.getBody().getNotificationUnRead());
                        UmberSocketClient.this.sendBroadcast(intent);
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        }

        AnonymousClass10(String str, Socket socket) {
            this.val$token = str;
            this.val$finalSocket = socket;
        }

        public void call(Object... args) {
            Intent intent = new Intent();
            intent.setAction(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            intent.putExtra(Constant.KEY_STATUS_CONNECTION, UmberSocketClient.this.getString(R.string.connected));
            UmberSocketClient.this.sendBroadcast(intent);
            JSONObject obj = new JSONObject();
            try {
                obj.put(PlusShare.KEY_CALL_TO_ACTION_URL, String.format("/v1/user-access/join/?token=%s&room=notification_%s", new Object[]{this.val$token, SharedPref.getInstance(UmberSocketClient.this.getApplicationContext()).getString(Constant.KEY_ID, BuildConfig.FLAVOR)}));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.val$finalSocket.emit("get", obj, new C14401());
            Log.i("Make Emit", "Emit");
        }
    }

    /* renamed from: com.umberapp.umber.socket.UmberSocketClient.1 */
    class C14411 implements Ack {
        C14411() {
        }

        public void call(Object... args) {
            RLog.m86e(args[0]);
        }
    }

    /* renamed from: com.umberapp.umber.socket.UmberSocketClient.2 */
    class C14422 implements Ack {
        final /* synthetic */ String val$idOrder;

        C14422(String str) {
            this.val$idOrder = str;
        }

        public void call(Object... args) {
            RLog.m86e("join order room - " + args[0].toString());
            UmberSocketClient.this.listenNotiFromRoom(this.val$idOrder);
            SharedPref.getInstance(UmberSocketClient.this.getApplicationContext()).putString(Constant.KEY_ORDER_ID, AppController.getInstance().getIdOrder());
        }
    }

    /* renamed from: com.umberapp.umber.socket.UmberSocketClient.3 */
    class C14433 implements Ack {
        C14433() {
        }

        public void call(Object... args) {
            RLog.m86e(args[0]);
        }
    }

    /* renamed from: com.umberapp.umber.socket.UmberSocketClient.4 */
    class C14444 implements Ack {
        C14444() {
        }

        public void call(Object... args) {
            RLog.m86e("estimate job = " + args[0]);
        }
    }

    /* renamed from: com.umberapp.umber.socket.UmberSocketClient.5 */
    class C14455 implements Ack {
        C14455() {
        }

        public void call(Object... args) {
            RLog.m86e("Cancel order -" + args[0]);
            SharedPref.getInstance(UmberSocketClient.this.getApplicationContext()).putString(Constant.KEY_ORDER_ID, BuildConfig.FLAVOR);
        }
    }

    /* renamed from: com.umberapp.umber.socket.UmberSocketClient.6 */
    class C14466 implements Listener {
        C14466() {
        }

        public void call(Object... args) {
            JSONObject json = (JSONObject) args[0];
            RLog.m86e("Noti from order Expert sent = " + json.toString());
            Intent intent = new Intent();
            intent.setAction(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            intent.putExtra(Constant.KEY_MSG, json.toString());
            LocalBroadcastManager.getInstance(UmberSocketClient.this.getApplicationContext()).sendBroadcast(intent);
            UmberSocketClient.this.sendBroadcast(intent);
        }
    }

    /* renamed from: com.umberapp.umber.socket.UmberSocketClient.7 */
    class C14477 implements Listener {
        C14477() {
        }

        public void call(Object... args) {
            RLog.m86e("trackig order_listener = " + args[0].toString());
            Intent intent = new Intent();
            intent.setAction(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            intent.putExtra(Constant.KEY_LATLNG, args[0].toString());
            LocalBroadcastManager.getInstance(UmberSocketClient.this.getApplicationContext()).sendBroadcast(intent);
            UmberSocketClient.this.sendBroadcast(intent);
            RLog.m86e("Expert location = " + args[0].toString());
        }
    }

    /* renamed from: com.umberapp.umber.socket.UmberSocketClient.8 */
    class C14488 implements Ack {
        final /* synthetic */ String val$idex;

        C14488(String str) {
            this.val$idex = str;
        }

        public void call(Object... args) {
            RLog.m86e("tracking order room - " + args[0].toString());
            UmberSocketClient.this.listenTrackingLocation(this.val$idex);
            SharedPref.getInstance(UmberSocketClient.this.getApplicationContext()).putString(Constant.KEY_ORDER_ID, AppController.getInstance().getIdOrder());
        }
    }

    /* renamed from: com.umberapp.umber.socket.UmberSocketClient.9 */
    class C14499 implements Listener {
        C14499() {
        }

        public void call(Object... args) {
            Log.i("Event", Constant.KEY_NOTIFCATION);
            JSONObject json = (JSONObject) args[0];
            RLog.m86e("Noti tu he thong ---- " + json.toString());
            Intent intent = new Intent();
            intent.setAction(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            intent.putExtra(Constant.KEY_NOTIFCATION, json.toString());
            UmberSocketClient.this.sendBroadcast(intent);
        }
    }

    public class LocalBinder extends Binder {
        public UmberSocketClient getServerInstance() {
            return UmberSocketClient.this;
        }
    }

    public UmberSocketClient() {
        this.socket = null;
        this.mBinder = new LocalBinder();
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    public void notiToExpert(String idOrder) {
        if (!SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR).isEmpty()) {
            JSONObject obj = new JSONObject();
            try {
                obj.put(PlusShare.KEY_CALL_TO_ACTION_URL, String.format("/v1/user-access/order/?token=%s&id=%s",SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR), idOrder));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.socket.emit("get", obj, new C14411());
        }
    }

    public void joinIntoRoom(String idOrder) {
        if (!SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR).isEmpty()) {
            JSONObject objJoin = new JSONObject();
            try {
                objJoin.put(PlusShare.KEY_CALL_TO_ACTION_URL, String.format("/v1/user-access/join/?room=order_%s&token=%s", idOrder, SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.socket.emit("get", objJoin, new C14422(idOrder));
        }
    }

    public void selectExpert(String id, String orderId) {
        if (!SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR).isEmpty()) {
            JSONObject objJoin = new JSONObject();
            JSONObject objData = new JSONObject();
            try {
                objData.put("expertId", id);
                objData.put(ApiConstants.KEY_ORDER_ID, orderId);
                objData.put("payment", "cash");
                objJoin.put(Request.EVENT_DATA, objData);
                objJoin.put(PlusShare.KEY_CALL_TO_ACTION_URL, String.format("/v1/user-access/order/?type=selected-expert&token=%s",SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.socket.emit("post", objJoin, new C14433());
        }
    }

    public void estimatedExpert(String idEx, String idOrder) {
        if (!SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR).isEmpty()) {
            JSONObject objJoin = new JSONObject();
            JSONObject objData = new JSONObject();
            try {
                objData.put(Constant.KEY_ID, idOrder);
                objJoin.put(Request.EVENT_DATA, objData);
                objJoin.put(PlusShare.KEY_CALL_TO_ACTION_URL, String.format("/v1/user-access/order/?type=estimated&token=%s",SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            RLog.m86e(objJoin.toString());
            this.socket.emit("post", objJoin, new C14444());
        }
    }

    public void cancleOrder(String cause, String id, String orderId) {
        if (!SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR).isEmpty()) {
            JSONObject objJoin = new JSONObject();
            JSONObject objData = new JSONObject();
            try {
                objData.put("detailDecline", cause);
                objData.put(Constant.KEY_ID, orderId);
                objData.put(ApiConstants.KEY_ORDER_ID, orderId);
                objData.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, SocketConstants.STATUS_ORDER_DECLINE);
                objData.put(ApiConstants.KEY_TYPE, SocketConstants.STATUS_ORDER_DECLINE);
                objJoin.put(Request.EVENT_DATA, objData);
                objJoin.put(PlusShare.KEY_CALL_TO_ACTION_URL, String.format("/v1/user-access/order/?type=decline&token=%s", SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.socket.emit("post", objJoin, new C14455());
        }
    }

    private void listenNotiFromRoom(String idOrder) {
        RLog.m86e("listened order room - " + idOrder);
        this.socket.on("order_" + idOrder, new C14466());
    }

    public void onDestroy() {
        super.onDestroy();
        this.socket.disconnect();
    }

    private void listenTrackingLocation(String idex) {
        RLog.m86e("listened order room - " + idex);
        this.socket.on("tracking_" + idex, new C14477());
    }

    public void trackingExpert(String idex) {
        if (!SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR).isEmpty()) {
            JSONObject objJoin = new JSONObject();
            try {
                objJoin.put(PlusShare.KEY_CALL_TO_ACTION_URL, String.format("/v1/user-access/join/?room=tracking_%s&token=%s", idex, SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.socket.emit("get", objJoin, new C14488(idex));
        }
    }

    public void onCreate() {
        super.onCreate();
        RLog.m86e("onCreate");
        try {
            Options options = new Options();
            options.transports = new String[]{WebSocket.NAME};
            this.socket = IO.socket("http://umberex.com:1337/", options);
            this.socket.connect();
            Log.i("Set Socket IO", "Socket IO Seting");
            this.socket.on("notification_" + SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_ID, BuildConfig.FLAVOR), new C14499());
        } catch (Exception e) {
            Log.e("Socket Problem", "Try cath", e);
        }
        Socket finalSocket = this.socket;
        if (AppController.getInstance().getUser() != null) {
            String token = SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
            if (!token.isEmpty()) {
                this.socket.on(Socket.EVENT_CONNECT, new AnonymousClass10(token, finalSocket));
            } else {
                return;
            }
        }
        this.socket.on(Socket.EVENT_DISCONNECT, new Listener() {
            public void call(Object... args) {
                Log.i("desc", "error desc");
                Intent intent = new Intent();
                intent.setAction(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                intent.putExtra(Constant.KEY_STATUS_CONNECTION, UmberSocketClient.this.getString(R.string.disconnect));
                UmberSocketClient.this.sendBroadcast(intent);
                if (SharedPref.getInstance(UmberSocketClient.this.getApplicationContext()).getString(Constant.KEY_ORDER_ID, BuildConfig.FLAVOR).isEmpty()) {
                    SharedPref.getInstance(UmberSocketClient.this.getApplicationContext()).putBoolean(Constant.KEY_RECONNECTED, false);
                } else {
                    SharedPref.getInstance(UmberSocketClient.this.getApplicationContext()).putBoolean(Constant.KEY_RECONNECTED, true);
                }
            }
        });
        this.socket.on(Socket.EVENT_CONNECT_ERROR, new Listener() {
            public void call(Object... args) {
                Log.i("Error", args[0].toString());
            }
        });
        this.socket.on(Packet.ERROR, new Listener() {
            public void call(Object... args) {
                Log.i("Error", "Event Error");
                RLog.m86e(args[0].toString());
            }
        });
        this.socket.on(Socket.EVENT_RECONNECTING, new Listener() {
            public void call(Object... args) {
                Intent intent = new Intent();
                intent.setAction(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                intent.putExtra(Constant.KEY_STATUS_CONNECTION, UmberSocketClient.this.getString(R.string.reconnect));
                UmberSocketClient.this.sendBroadcast(intent);
                Log.i("Error", "Event reconectiong Error");
            }
        });
        this.socket.on("*", new Listener() {
            public void call(Object... args) {
                RLog.m86e("alllll" + args[0].toString());
            }
        });
        this.socket.on(Packet.MESSAGE, new Listener() {
            public void call(Object... args) {
                RLog.m86e(Packet.MESSAGE + args[0].toString());
            }
        });
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
