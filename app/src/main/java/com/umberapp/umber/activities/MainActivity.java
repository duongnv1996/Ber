package com.umberapp.umber.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.MaterialDialog.ListCallbackSingleChoice;
import com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback;
import com.andexert.library.RippleView;
import com.github.brunodles.compressor.BitmapCompressor;
import com.github.brunodles.pic_picker.PicPicker;
import com.github.brunodles.pic_picker.listener.CantFindCameraAppErrorListener;
import com.github.brunodles.pic_picker.listener.ErrorCreatingTempFileForCameraListener;
import com.github.brunodles.pic_picker.listener.NeedWritePermissionErrorListener;
import com.github.brunodles.pic_picker.listener.PicResultListener;
import com.github.nkzawa.socketio.client.Socket;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlacePicker.IntentBuilder;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;
import com.sromku.simple.fb.entities.Feed.Builder.Parameters;
import com.tokenautocomplete.FilteredArrayAdapter;
import com.tokenautocomplete.TokenCompleteTextView.TokenClickStyle;
import com.tokenautocomplete.TokenCompleteTextView.TokenListener;
import com.tooltip.OnDismissListener;
import com.tooltip.Tooltip;

import com.umberapp.umber.adapters.ImageAdapter;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.fragments.BlockFragment;
import com.umberapp.umber.fragments.FaqFragment;
import com.umberapp.umber.fragments.ListExpertFragment;
import com.umberapp.umber.fragments.NotificationFragment;
import com.umberapp.umber.interfaces.CallbackDialog;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.interfaces.UploadList;
import com.umberapp.umber.maputils.PlacesAutoCompleteAdapter;
import com.umberapp.umber.models.Category;
import com.umberapp.umber.models.DebitModel;
import com.umberapp.umber.models.DetailOrderItem;
import com.umberapp.umber.models.Event;
import com.umberapp.umber.models.ExpertBit;
import com.umberapp.umber.models.ExpertMarker;
import com.umberapp.umber.models.HICItem;
import com.umberapp.umber.models.Image;
import com.umberapp.umber.models.OnsignalItem;
import com.umberapp.umber.models.OrderItem;
import com.umberapp.umber.models.Picture;
import com.umberapp.umber.models.RangeTime;
import com.umberapp.umber.models.Tag;
import com.umberapp.umber.models.UpcommingItem;
import com.umberapp.umber.models.User;
import com.umberapp.umber.socket.SocketConstants;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.FileUtils;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.utils.SharedPref;
import com.umberapp.umber.utils.StringUtil;
import com.umberapp.umber.views.AlertDialogCustom;
import com.umberapp.umber.views.ProgressDialogCustom;
import com.umberapp.umber.views.TagCompleteTextView;
import com.umberapp.umber.views.Visualizer;
import com.umberapp.umber.webview.DialogWebView;
import com.umberapp.umber.webview.DialogWebView.OAuthDialogListener;
import com.wang.avi.indicators.LineScalePartyIndicator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import io.socket.emitter.Emitter.Listener;
import me.iwf.photopicker.R;
import me.iwf.photopicker.PhotoPicker;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements OnNavigationItemSelectedListener, OnClickListener, OnMapReadyCallback, UploadList {
    private static final LatLngBounds BOUNDS_GREATER_SYDNEY;
    private static final String LOG_TAG = "AudioRecordTest";
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    public static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 100;
    private static final int PLACE_PICKER_FLAG = 1;
    public static final int STATE_NOMAL = 0;
    public static final int STATE_SHOW_CATEGORY = 1;
    public static final int STATE_SHOW_HCI = 2;
    private static final String TAG;
    private static String mFileName;
    private HashMap<Marker, HICItem> HICHashMap;
    @Bind({2131689696})
    CardView btnLocation;
    @Bind({2131689815})
    ImageView btnPannic;
    private IntentBuilder builder;
    private CantFindCameraAppErrorListener cameraAppErrorListener;
    private ProgressDialogCustom dialogProgrees;
    DrawerLayout drawer;
    @Bind({2131689818})
    TextView edtCategory;
    private ErrorCreatingTempFileForCameraListener fileForCameraListener;
    ImageAdapter imgAdapter;
    @Bind({2131689812})
    ImageView imgCategory;
    @Bind({2131689810})
    ImageView imgImage;
    @Bind({2131689809})
    ImageView imgRecord;
    private boolean isCameraChange;
    private boolean isClicked;
    boolean isEnable;
    private boolean isNotPayment;
    private boolean isRecord;
    private boolean isSent;
    boolean isShownScheldule;
    private boolean isTimeToFocus;
    TextView itemMessagesBadgeTextView;
    private List<String> listCash;
    private List<Category> listCategories;
    private List<Image> listImages;
    private List<Category> listRecentlyCategories;
    @Bind({2131689799})
    CardView llBottom;
    @Bind({2131689819})
    CardView llBottomBack;
    @Bind({2131689801})
    LinearLayout llForm;
    private LinearLayout llRootNav;
    @Bind({2131689681})
    RelativeLayout llroot;
    private String mAddress;
    private OnItemClickListener mAutocompleteClickListener;
    private CircleImageView mAvt;
    private Category mCategory;
    private LatLng mCurrentLatlng;
    private long mDateBooking;
    private String mDateString;
    private DebitModel mDebitModel;
    private FragmentManager mFragmentManager;
    protected GoogleApiClient mGoogleApiClient;
    private LatLng mLatlng;
    private List<ExpertMarker> mListExpert;
    private List<HICItem> mListHCI;
    private GoogleMap mMap;
    private File mPinFileCategory;
    File mPinHIC;
    private Place mPlace;
    private PlacesAutoCompleteAdapter mPlacesAdapter;
    private MediaRecorder mRecorder;
    private Socket mSocket;
    private long mTimeEnd;
    private long mTimeStart;
    private TextView mTvName;
    private UmberService mUmberService;
    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallback;
    private String msgForm;
    private TextView myLocation;
    private Listener onEventNotification;
    private Listener onEventOrder;
    private PicPicker picPicker;
    private PicResultListener picResultListener;
    private ImageView pickerBtn;
    private int posCard;
    @Bind({2131689798})
    public ProgressBar progressBarAddress;
    private String promotion;
    Queue<MaterialDialog> queueEvent;
    RecyclerView rcv;
    @Bind({2131689816})
    RippleView ripple;
    @Bind({2131689805})
    AppCompatSpinner spCash;
    List<Tag> stringTag;
    @Bind({2131689620})
    Toolbar toolbar;
    @Bind({2131689813})
    TextView tvCategory;
    ImageView tvCountNoti;
    @Bind({2131689742})
    TextView tvCountNotification;
    @Bind({2131689808})
    TextView tvRequiredTextForm;
    VisualTask vs;

    /* renamed from: com.umberapp.umber.activities.MainActivity.1 */
    class C13351 extends ActionBarDrawerToggle {
        C13351(Activity arg0, DrawerLayout arg1, Toolbar arg2, int arg3, int arg4) {
            super(arg0, arg1, arg2, arg3, arg4);
        }

        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
        }

        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.22 */
    class AnonymousClass22 implements Callback<ApiResponse<List<Category>>> {
        final /* synthetic */ ProgressDialogCustom val$dialogCustom;

        /* renamed from: com.umberapp.umber.activities.MainActivity.22.1 */
        class C13361 implements OnRespone<Category> {
            C13361() {
            }

            public void onRespone(Category object) {
                MainActivity.this.HandleCategory(object);
            }
        }

        AnonymousClass22(ProgressDialogCustom progressDialogCustom) {
            this.val$dialogCustom = progressDialogCustom;
        }

        public void onResponse(Call<ApiResponse<List<Category>>> call, Response<ApiResponse<List<Category>>> response) {
            this.val$dialogCustom.hideDialog();
            if (response.isSuccessful()) {
                ApiResponse<List<Category>> apiResponse = (ApiResponse) response.body();
                MainActivity.this.listCategories = (List) apiResponse.getData();
                Dialog dialogCate = AlertDialogCustom.dialogCategory(MainActivity.this, (List) apiResponse.getData(), MainActivity.this.mUmberService, new C13361());
                dialogCate.show();
                MainActivity.this.listDialog.add(dialogCate);
                return;
            }
            RLog.m86e(Integer.valueOf(response.code()));
            if (response.code() == ApiConstants.CODE_ERROR_FORBIDDEN) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                MainActivity.this.finish();
            }
        }

        public void onFailure(Call<ApiResponse<List<Category>>> call, Throwable t) {
            this.val$dialogCustom.hideDialog();
            RLog.m86e(t.getMessage());
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.2 */
    class C13372 implements OnFocusChangeListener {
        C13372() {
        }

        public void onFocusChange(View view, boolean b) {
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.32 */
    class AnonymousClass32 implements Callback<ApiResponse<String>> {
        final /* synthetic */ OrderItem val$order;

        AnonymousClass32(OrderItem orderItem) {
            this.val$order = orderItem;
        }

        public void onResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {
            if (!response.isSuccessful()) {
                RLog.m86e(Integer.valueOf(response.code()));
                MainActivity.this.uploadPhoto(this.val$order);
                Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.unknow_error_upload), Toast.LENGTH_SHORT).show();
            } else if (((ApiResponse) response.body()).getData() != null) {
                this.val$order.setAudio((String) ((ApiResponse) response.body()).getData());
                MainActivity.this.uploadPhoto(this.val$order);
            } else {
                MainActivity.this.uploadPhoto(this.val$order);
                Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.unknow_error_upload), Toast.LENGTH_SHORT).show();
            }
        }

        public void onFailure(Call<ApiResponse<String>> call, Throwable t) {
            RLog.m86e("error upload audio" + t.getMessage());
            MainActivity.this.uploadPhoto(this.val$order);
            Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.unknow_error_upload),Toast.LENGTH_SHORT).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.33 */
    class AnonymousClass33 implements Callback<ApiResponse<String>> {
        final /* synthetic */ List val$listStrPathServer;
        final /* synthetic */ OrderItem val$order;

        AnonymousClass33(List list, OrderItem orderItem) {
            this.val$listStrPathServer = list;
            this.val$order = orderItem;
        }

        public void onResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {
            try {
                if (!response.isSuccessful()) {
                    RLog.m86e(Integer.valueOf(response.code()));
                    Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.unknow_error_upload),Toast.LENGTH_SHORT).show();
                    MainActivity.this.sendOrder(this.val$order);
                } else if (((ApiResponse) response.body()).getData() != null) {
                    Picture pic = new Picture();
                    pic.setLink((String) ((ApiResponse) response.body()).getData());
                    this.val$listStrPathServer.add(pic);
                    if (this.val$listStrPathServer.size() == MainActivity.this.listImages.size()) {
                        this.val$order.setPictures(this.val$listStrPathServer);
                        MainActivity.this.sendOrder(this.val$order);
                    }
                } else {
                    Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.unknow_error_upload), Toast.LENGTH_SHORT).show();
                    MainActivity.this.sendOrder(this.val$order);
                }
            } catch (Exception e) {
                MainActivity.this.sendOrder(this.val$order);
                Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.unknow_error_upload), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }

        public void onFailure(Call<ApiResponse<String>> call, Throwable t) {
            RLog.m86e("error upload image" + t.getMessage());
            Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.unknow_error_upload), Toast.LENGTH_SHORT).show();
            MainActivity.this.sendOrder(this.val$order);
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.3 */
    class C13413 implements OnClickListener {
        C13413() {
        }

        public void onClick(View v) {
            try {
                MainActivity.this.builder = new IntentBuilder();
                MainActivity.this.startActivityForResult(MainActivity.this.builder.build(MainActivity.this), MainActivity.STATE_SHOW_CATEGORY);
            } catch (GooglePlayServicesRepairableException e) {
                GooglePlayServicesUtil.getErrorDialog(e.getConnectionStatusCode(), MainActivity.this, MainActivity.STATE_NOMAL);
            } catch (GooglePlayServicesNotAvailableException e2) {
                Toast.makeText(MainActivity.this, "Google Play Services is not available.",Toast.LENGTH_SHORT).show();
            }
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.43 */
    class AnonymousClass43 implements OnClickListener {
        final /* synthetic */ ImageView val$btnCamera;
        final /* synthetic */ LinearLayout val$btnStartRecord;
        final /* synthetic */ Button val$btnStopRecord;
        final /* synthetic */ Activity val$context;
        final /* synthetic */ LinearLayout val$llMedia;
        final /* synthetic */ Visualizer val$visualizerView;

        AnonymousClass43(LinearLayout linearLayout, Button button, ImageView imageView, Activity activity, Visualizer visualizer, LinearLayout linearLayout2) {
            this.val$btnStartRecord = linearLayout;
            this.val$btnStopRecord = button;
            this.val$btnCamera = imageView;
            this.val$context = activity;
            this.val$visualizerView = visualizer;
            this.val$llMedia = linearLayout2;
        }

        public void onClick(View view) {
            MainActivity.this.onRecord(true);
            this.val$btnStartRecord.setEnabled(false);
            this.val$btnStopRecord.setEnabled(true);
            this.val$btnCamera.setEnabled(false);
            this.val$btnCamera.setAlpha(0.3f);
            MainActivity.this.vs = new VisualTask(this.val$context, this.val$visualizerView);
            MainActivity.this.vs.execute(new Void[MainActivity.STATE_NOMAL]);
            this.val$llMedia.setVisibility(View.INVISIBLE);
            this.val$visualizerView.setVisibility(View.VISIBLE);
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.44 */
    class AnonymousClass44 implements OnClickListener {
        final /* synthetic */ LinearLayout val$btnStartRecord;
        final /* synthetic */ Button val$btnStopRecord;
        final /* synthetic */ LinearLayout val$llMedia;
        final /* synthetic */ Visualizer val$visualizerView;

        AnonymousClass44(LinearLayout linearLayout, Button button, LinearLayout linearLayout2, Visualizer visualizer) {
            this.val$llMedia = linearLayout;
            this.val$btnStopRecord = button;
            this.val$btnStartRecord = linearLayout2;
            this.val$visualizerView = visualizer;
        }

        public void onClick(View view) {
            this.val$llMedia.setVisibility(4);
            this.val$btnStopRecord.setEnabled(false);
            this.val$btnStartRecord.setEnabled(true);
            MainActivity.mFileName = null;
            this.val$visualizerView.clear();
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.45 */
    class AnonymousClass45 implements OnClickListener {
        final /* synthetic */ ImageView val$btnCamera;
        final /* synthetic */ LinearLayout val$btnStartRecord;
        final /* synthetic */ Button val$btnStopRecord;
        final /* synthetic */ LinearLayout val$llMedia;
        final /* synthetic */ Visualizer val$visualizerView;

        AnonymousClass45(Visualizer visualizer, Button button, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView) {
            this.val$visualizerView = visualizer;
            this.val$btnStopRecord = button;
            this.val$btnStartRecord = linearLayout;
            this.val$llMedia = linearLayout2;
            this.val$btnCamera = imageView;
        }

        public void onClick(View view) {
            MainActivity.this.onRecord(false);
            this.val$visualizerView.setVisibility(View.GONE);
            this.val$btnStopRecord.setEnabled(false);
            this.val$btnStartRecord.setEnabled(true);
            if (MainActivity.this.isEnable) {
                this.val$llMedia.setVisibility(View.VISIBLE);
                this.val$btnCamera.setEnabled(true);
                this.val$btnCamera.setAlpha(LineScalePartyIndicator.SCALE);
                this.val$visualizerView.clear();
            }
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.48 */
    class AnonymousClass48 implements TextWatcher {
        final /* synthetic */ TagCompleteTextView val$edt;

        /* renamed from: com.umberapp.umber.activities.MainActivity.48.1 */
        class C13461 implements Callback<ApiResponse<List<Tag>>> {
            final /* synthetic */ String val$search;

            /* renamed from: com.umberapp.umber.activities.MainActivity.48.1.1 */
            class C13431 extends FilteredArrayAdapter<Tag> {
                C13431(Context x0, int x1, List x2) {
                    super(x0, x1, x2);
                }

                public View getView(int position, View convertView, ViewGroup parent) {
                    if (convertView == null) {
                        convertView = ((LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.person_layout, parent, false);
                    }
                    ((TextView) convertView.findViewById(R.id.name)).setText(((Tag) getItem(position)).getText());
                    return convertView;
                }

                protected boolean keepObject(Tag person, String mask) {
                    mask = mask.toLowerCase();
                    return person.getText().toLowerCase().startsWith(mask) || person.getText().toLowerCase().startsWith(mask);
                }
            }

            /* renamed from: com.umberapp.umber.activities.MainActivity.48.1.2 */
            class C13442 implements TokenListener<Tag> {
                C13442() {
                }

                public void onTokenAdded(Tag token) {
                    MainActivity.this.postTag(token.getText());
                }

                public void onTokenRemoved(Tag token) {
                }
            }

            /* renamed from: com.umberapp.umber.activities.MainActivity.48.1.3 */
            class C13453 extends FilteredArrayAdapter<Tag> {
                C13453(Context x0, int x1, List x2) {
                    super(x0, x1, x2);
                }

                public View getView(int position, View convertView, ViewGroup parent) {
                    if (convertView == null) {
                        convertView = ((LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.person_layout, parent, false);
                    }
                    ((TextView) convertView.findViewById(R.id.name)).setText(((Tag) getItem(position)).getText());
                    return convertView;
                }

                protected boolean keepObject(Tag person, String mask) {
                    mask = mask.toLowerCase();
                    return person.getText().toLowerCase().startsWith(mask) || person.getText().toLowerCase().startsWith(mask);
                }
            }

            C13461(String str) {
                this.val$search = str;
            }

            public void onResponse(Call<ApiResponse<List<Tag>>> call, Response<ApiResponse<List<Tag>>> response) {
                if (response.isSuccessful()) {
                    List<Tag> listTags = (List) ((ApiResponse) response.body()).getData();
                    listTags.add(MainActivity.STATE_NOMAL, new Tag(this.val$search));
                    if (listTags != null && listTags.size() > 0) {
                        ArrayAdapter<Tag> adapter = new C13431(MainActivity.this, R.layout.person_layout, listTags);
                        adapter.setDropDownViewResource(17367050);
                        AnonymousClass48.this.val$edt.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        AnonymousClass48.this.val$edt.setTokenClickStyle(TokenClickStyle.None);
                        AnonymousClass48.this.val$edt.allowCollapse(false);
                        AnonymousClass48.this.val$edt.setTokenListener(new C13442());
                    }
                }
            }

            public void onFailure(Call<ApiResponse<List<Tag>>> call, Throwable t) {
                RLog.m86e("error " + t.getMessage());
                List<Tag> listTags = new ArrayList();
                listTags.add(MainActivity.STATE_NOMAL, new Tag(this.val$search));
                if (listTags != null && listTags.size() > 0) {
                    ArrayAdapter<Tag> adapter = new C13453(MainActivity.this, R.layout.person_layout, listTags);
                    adapter.setDropDownViewResource(17367050);
                    AnonymousClass48.this.val$edt.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    AnonymousClass48.this.val$edt.setTokenClickStyle(TokenClickStyle.None);
                    AnonymousClass48.this.val$edt.allowCollapse(false);
                }
            }
        }

        AnonymousClass48(TagCompleteTextView tagCompleteTextView) {
            this.val$edt = tagCompleteTextView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence.length() > 0) {
                String search;
                String[] strings = charSequence.toString().split(",");
                if (strings.length == 0) {
                    search = " " + charSequence.toString();
                } else {
                    search = " " + strings[strings.length - 1].trim();
                }
                RLog.m86e("will search " + search);
                MainActivity.this.mUmberService.getTags(AppController.getInstance().getUser().getToken(), search, MainActivity.this.mCategory != null ? MainActivity.this.mCategory.getId() : BuildConfig.FLAVOR).enqueue(new C13461(search));
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.49 */
    class AnonymousClass49 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ TagCompleteTextView val$edt;

        AnonymousClass49(TagCompleteTextView tagCompleteTextView, Dialog dialog) {
            this.val$edt = tagCompleteTextView;
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            MainActivity.this.stringTag.clear();
            MainActivity.this.stringTag.addAll(this.val$edt.getObjects());
            MainActivity.this.msgForm = BuildConfig.FLAVOR;
            for (Tag tag : MainActivity.this.stringTag) {
                MainActivity.this.msgForm = MainActivity.this.msgForm + tag.getText() + ",";
            }
            if (MainActivity.this.msgForm.isEmpty()) {
                MainActivity.this.tvRequiredTextForm.setText(MainActivity.this.getString(R.string.your_text_requirements_texts_images_audios));
            } else {
                MainActivity.this.tvRequiredTextForm.setText(MainActivity.this.msgForm);
            }
            if (!(MainActivity.mFileName == null || MainActivity.mFileName.isEmpty())) {
                MainActivity.this.imgRecord.setVisibility(View.VISIBLE);
            }
            if (MainActivity.this.listImages != null && MainActivity.this.listImages.size() > 0) {
                MainActivity.this.imgImage.setVisibility(View.VISIBLE);
            }
            MainActivity.this.onRecord(false);
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.4 */
    class C13474 implements NeedWritePermissionErrorListener {
        C13474() {
        }

        public void needWritePermission() {
            Toast.makeText(MainActivity.this, R.string.permission_message, MainActivity.STATE_NOMAL).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.51 */
    class AnonymousClass51 implements OnRespone {
        final /* synthetic */ ExpertBit val$exBit;
        final /* synthetic */ String val$orderId;

        /* renamed from: com.umberapp.umber.activities.MainActivity.51.1 */
        class C13481 implements OnRespone<String> {
            C13481() {
            }

            public void onRespone(String object) {
                MainActivity.this.cancleOrder(object, AnonymousClass51.this.val$exBit.getId(), AnonymousClass51.this.val$orderId);
            }
        }

        AnonymousClass51(ExpertBit expertBit, String str) {
            this.val$exBit = expertBit;
            this.val$orderId = str;
        }

        public void onRespone(Object object) {
            AlertDialogCustom.dialogConfirmCancle(MainActivity.this, new C13481()).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.57 */
    class AnonymousClass57 implements ListCallbackSingleChoice {
        final /* synthetic */ Context val$context;

        AnonymousClass57(Context context) {
            this.val$context = context;
        }

        public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
            String langval;
            if (which == 0) {
                langval = "en";
            } else {
                langval = "in";
            }
            SharedPref.getInstance(this.val$context).putString("lang", langval);
            Configuration config = this.val$context.getResources().getConfiguration();
            Locale locale = new Locale(langval);
            Locale.setDefault(locale);
            config.locale = locale;
            this.val$context.getResources().updateConfiguration(config, this.val$context.getResources().getDisplayMetrics());
            MainActivity.this.startActivity(new Intent(MainActivity.this, SplashActivity.class));
            MainActivity.this.finish();
            return true;
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.5 */
    class C13495 implements Callback<ApiResponse<List<UpcommingItem>>> {
        C13495() {
        }

        public void onResponse(Call<ApiResponse<List<UpcommingItem>>> call, Response<ApiResponse<List<UpcommingItem>>> response) {
            if (response.isSuccessful()) {
                List<UpcommingItem> listUpcoming = (List) ((ApiResponse) response.body()).getData();
                if (listUpcoming != null && listUpcoming.size() > 0) {
                    for (UpcommingItem up : listUpcoming) {
                        if (MainActivity.this.mUmberSocket != null) {
                            MainActivity.this.mUmberSocket.joinIntoRoom(up.getId());
                        }
                    }
                }
            }
        }

        public void onFailure(Call<ApiResponse<List<UpcommingItem>>> call, Throwable t) {
            RLog.m86e(t.getMessage());
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.6 */
    class C13506 implements Callback<ApiResponse<List<Category>>> {
        C13506() {
        }

        public void onResponse(Call<ApiResponse<List<Category>>> call, Response<ApiResponse<List<Category>>> response) {
            if (response.isSuccessful()) {
                MainActivity.this.listCategories = (List) ((ApiResponse) response.body()).getData();
                return;
            }
            RLog.m86e(Integer.valueOf(response.code()));
        }

        public void onFailure(Call<ApiResponse<List<Category>>> call, Throwable t) {
            RLog.m86e(t.getMessage());
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.7 */
    class C13517 implements OnRespone {
        final /* synthetic */ OnsignalItem val$item;

        C13517(OnsignalItem onsignalItem) {
            this.val$item = onsignalItem;
        }

        public void onRespone(Object object) {
            MainActivity.this.mUmberSocket.estimatedExpert(this.val$item.getExpertId(), this.val$item.getOrderId());
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.8 */
    class C13538 implements OnRespone {
        final /* synthetic */ OnsignalItem val$item;

        /* renamed from: com.umberapp.umber.activities.MainActivity.8.1 */
        class C13521 implements OnRespone<String> {
            C13521() {
            }

            public void onRespone(String object) {
                if (MainActivity.this.dialogConfirmCost.isShowing()) {
                    MainActivity.this.dialogConfirmCost.cancel();
                }
                MainActivity.this.mUmberSocket.cancleOrder(object, C13538.this.val$item.getExpertId(), C13538.this.val$item.getOrderId());
                MainActivity.this.finishOrder();
            }
        }

        C13538(OnsignalItem onsignalItem) {
            this.val$item = onsignalItem;
        }

        public void onRespone(Object object) {
            BaseActivity.dialog = AlertDialogCustom.dialogConfirmCancle(MainActivity.this, new C13521());
            BaseActivity.dialog.show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.MainActivity.9 */
    class C13549 implements OnDismissListener {
        C13549() {
        }

        public void onDismiss() {
            SharedPref.getInstance(MainActivity.this.getApplicationContext()).putBoolean(Constant.ISFIRTTIME, false);
        }
    }

    class GeoTask extends AsyncTask<LatLng, Void, String> {
        LatLng lt;

        public GeoTask() {
            MainActivity.this.progressBarAddress.setVisibility(View.VISIBLE);
        }

        protected String doInBackground(LatLng... latLngs) {
            LatLng latLng = latLngs[MainActivity.STATE_NOMAL];
            this.lt = latLng;
            return CommonUtils.getCompleteAddressString(MainActivity.this.getApplicationContext(), latLng.latitude, latLng.longitude);
        }

        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            MainActivity.this.progressBarAddress.setVisibility(View.GONE);
            if (!s.isEmpty()) {
                MainActivity.this.mAddress = s;
                MainActivity.this.myLocation.setText(MainActivity.this.mAddress);
            }
        }
    }

    class VisualTask extends AsyncTask<Void, Integer, Void> {
        Context context;
        Visualizer vis;

        public VisualTask(Context context, Visualizer vis) {
            this.vis = vis;
            this.context = context;
            this.vis.setVisibility(View.VISIBLE);
        }

        protected Void doInBackground(Void... voids) {
            while (MainActivity.this.isRecord && !isCancelled()) {
                try {
                    Integer[] numArr = new Integer[MainActivity.STATE_SHOW_CATEGORY];
                    numArr[MainActivity.STATE_NOMAL] = Integer.valueOf(MainActivity.this.mRecorder.getMaxAmplitude());
                    publishProgress(numArr);
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                    cancel(false);
                }
            }
            return null;
        }

        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            this.vis.addAmplitude((float) values[MainActivity.STATE_NOMAL].intValue());
            this.vis.invalidate();
        }
    }

    public MainActivity() {
        this.isTimeToFocus = true;
        this.stringTag = new ArrayList();
        this.msgForm = BuildConfig.FLAVOR;
        this.listCash = new ArrayList();
        this.mAutocompleteClickListener = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String placeId = String.valueOf(MainActivity.this.mPlacesAdapter.getItem(position).placeId);
                GeoDataApi geoDataApi = Places.GeoDataApi;
                GoogleApiClient googleApiClient = MainActivity.this.mGoogleApiClient;
                String[] strArr = new String[MainActivity.STATE_SHOW_CATEGORY];
                strArr[MainActivity.STATE_NOMAL] = placeId;
                geoDataApi.getPlaceById(googleApiClient, strArr).setResultCallback(MainActivity.this.mUpdatePlaceDetailsCallback);
            }
        };
        this.mUpdatePlaceDetailsCallback = new ResultCallback<PlaceBuffer>() {
            public void onResult(PlaceBuffer places) {
                if (places.getStatus().isSuccess()) {
                    Place place = places.get((int) MainActivity.STATE_NOMAL);
                    MainActivity.this.mCurrentLatlng = place.getLatLng();
                    MainActivity.this.mPlace = place;
                    MainActivity.this.mAddress = place.getAddress().toString();
                    MainActivity.this.isCameraChange = false;
                    CommonUtils.focusCurrentLocation(place.getLatLng(), 13.0f, MainActivity.this.mMap);
                    return;
                }
                Log.e(Parameters.PLACE, "Place query did not complete. Error: " + places.getStatus().toString());
            }
        };
        this.isShownScheldule = false;
        this.onEventOrder = new Listener() {

            /* renamed from: com.umberapp.umber.activities.MainActivity.35.1 */
            class C13381 implements Runnable {
                final /* synthetic */ Object[] val$args;

                C13381(Object[] objArr) {
                    this.val$args = objArr;
                }

                public void run() {
                    RLog.m86e("Respone->>>>>>>>>>>>>>>>>>>>>>>>>" + this.val$args[MainActivity.STATE_NOMAL].toString());
                }
            }

            public void call(Object... args) {
                MainActivity.this.runOnUiThread(new C13381(args));
            }
        };
        this.onEventNotification = new Listener() {

            /* renamed from: com.umberapp.umber.activities.MainActivity.39.1 */
            class C13401 implements Runnable {
                final /* synthetic */ Object[] val$args;

                C13401(Object[] objArr) {
                    this.val$args = objArr;
                }

                public void run() {
                    RLog.m86e("Respone->>>>>>>>>>>>>>>>>>>>>>>>>" + this.val$args[MainActivity.STATE_NOMAL].toString());
                }
            }

            public void call(Object... args) {
                MainActivity.this.runOnUiThread(new C13401(args));
            }
        };
        this.picResultListener = new PicResultListener() {

            /* renamed from: com.umberapp.umber.activities.MainActivity.40.1 */
            class C13421 extends BitmapCompressor {
                C13421(int x0) {
                    super(x0);
                }

                protected void onPostExecute(Bitmap[] bitmaps) {
                    File img = FileUtils.SaveImage(MainActivity.this, bitmaps[MainActivity.STATE_NOMAL]);
                    Image image = new Image();
                    image.setPhoto(Bitmap.createScaledBitmap(bitmaps[MainActivity.STATE_NOMAL], MainActivity.PLACE_AUTOCOMPLETE_REQUEST_CODE, MainActivity.PLACE_AUTOCOMPLETE_REQUEST_CODE, false));
                    if (img != null) {
                        image.setPath(img.getPath());
                    }
                    MainActivity.this.listImages.add(image);
                    MainActivity.this.imgAdapter.notifyDataSetChanged();
                }
            }

            public void onPictureResult(Bitmap bitmap) {
                RLog.m86e("recieve photo");
                C13421 c13421 = new C13421(ApiConstants.CODE_ERROR_LOGIN_PARAM);
                Bitmap[] bitmapArr = new Bitmap[MainActivity.STATE_SHOW_CATEGORY];
                bitmapArr[MainActivity.STATE_NOMAL] = bitmap;
                c13421.execute(bitmapArr);
            }
        };
        this.cameraAppErrorListener = new CantFindCameraAppErrorListener() {
            public void cantFindCameraApp() {
                Toast.makeText(MainActivity.this, "Can't find the camera app", Toast.LENGTH_SHORT).show();
            }
        };
        this.fileForCameraListener = new ErrorCreatingTempFileForCameraListener() {
            public void errorCreatingTempFileForCamera() {
                Log.e(MainActivity.TAG, "errorCreatingTempFileForCamera: ");
                Toast.makeText(MainActivity.this, "Error starting camera", Toast.LENGTH_SHORT).show();
            }
        };
        this.mRecorder = null;
        this.isEnable = false;
        this.isSent = false;
        this.queueEvent = new ArrayDeque();
        this.isNotPayment = false;
    }

    static {
        TAG = MainActivity.class.getSimpleName();
        BOUNDS_GREATER_SYDNEY = new LatLngBounds(new LatLng(-34.041458d, 150.7901d), new LatLng(-33.682247d, 151.383362d));
        mFileName = null;
    }

    void startToFragment(ExpertBit expertBit) {
        trantoTab(new ListExpertFragment(expertBit));
    }

    void finishOrder() {
        if (this.listDialog.size() > 0) {
            for (Dialog dialog : this.listDialog) {
                if (dialog != null && dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        }
        AppController.getInstance().setIdOrder(null);
        AppController.getInstance().setOrder(null);
        SharedPref.getInstance(this).putString(Constant.KEY_ORDER_ID, BuildConfig.FLAVOR);
        SharedPref.getInstance(this).putBoolean(Constant.KEY_RECONNECTED, false);
        clearData();
        isShowDialogFeedback = false;
        isShowDialogCost = false;
    }

    void unreadNotification(int count) {
        RLog.m86e("Noification count =  " + count);
        if (count > 0) {
            this.tvCountNoti.setVisibility(View.VISIBLE);
        } else if (count == 0) {
            this.tvCountNoti.setVisibility(8);
        }
    }

    public void readAllNotify() {
        this.tvCountNotification.setVisibility(8);
        this.tvCountNoti.setVisibility(8);
    }

    void trackExpert(String s, String s1) {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar.setTitle(BuildConfig.FLAVOR);
        this.toolbar.setPadding(STATE_NOMAL, STATE_NOMAL, STATE_NOMAL, STATE_NOMAL);
        this.toolbar.setContentInsetsAbsolute(STATE_NOMAL, STATE_NOMAL);
        ButterKnife.bind((Activity) this);
        this.mUmberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        setSupportActionBar(this.toolbar);
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new C13351(this, this.drawer, this.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        this.drawer.setDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_left_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(STATE_NOMAL);
        this.mTvName = (TextView) header.findViewById(R.id.tv_name);
        this.mAvt = (CircleImageView) header.findViewById(R.id.img_avt);
        this.llRootNav = (LinearLayout) header.findViewById(R.id.ll_root_nav);
        this.mFragmentManager = getSupportFragmentManager();
        this.mGoogleApiClient = new Builder(this).addApi(Places.GEO_DATA_API).build();
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
        this.builder = new IntentBuilder();
        this.myLocation = (TextView) findViewById(R.id.myLocation);
        this.mPlacesAdapter = new PlacesAutoCompleteAdapter(this, 17367043, this.mGoogleApiClient, BOUNDS_GREATER_SYDNEY, null);
        this.myLocation.setOnFocusChangeListener(new C13372());
        this.pickerBtn = (ImageView) findViewById(R.id.btn_search);
        this.pickerBtn.setOnClickListener(new C13413());
        this.tvCountNoti = (ImageView) MenuItemCompat.getActionView(navigationView.getMenu().findItem(R.id.nav_notifi));
        LayoutParams p = new LayoutParams(-2, -2);
        p.gravity = 16;
        p.setMargins(STATE_NOMAL, 50, STATE_NOMAL, STATE_NOMAL);
        this.tvCountNoti.setPadding(STATE_NOMAL, 50, STATE_NOMAL, STATE_NOMAL);
        this.tvCountNoti.setImageResource(R.drawable.bg_txt_notification);
        this.tvCountNoti.setLayoutParams(p);
        this.tvCountNoti.setVisibility(8);
        initControl();
    }

    private void initControl() {
        this.view = this.llroot;
        this.HICHashMap = new HashMap();
        this.listImages = new ArrayList();
        this.imgAdapter = new ImageAdapter(this, this.listImages);
        this.picPicker = new PicPicker(this, this.picResultListener).setFileForCameraListener(this.fileForCameraListener).setCameraAppErrorListener(this.cameraAppErrorListener).setPermissionErrorListener(new C13474());
        this.dialogProgrees = new ProgressDialogCustom(this);
        if (AppController.getInstance().getUser() != null) {
            this.mUmberService.getUpcoming(AppController.getInstance().getUser().getToken(), "upcomming").enqueue(new C13495());
        }
        this.listCash.add(getString(R.string.cash));
        this.listCash.add(getString(R.string.atm));
        this.listCash.add(getString(R.string.credit));
        SpinnerAdapter adapterCash = new ArrayAdapter(this, R.layout.item_cash, this.listCash);
        adapterCash.setDropDownViewResource(17367050);
        this.spCash.setAdapter(adapterCash);
        String token = SharedPref.getInstance(this).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
        String lang = SharedPref.getInstance(this).getString("lang", "en");
        if (lang.equals("in")) {
            lang = Constant.KEY_ID;
        }
        this.mUmberService.getCategory(token, lang).enqueue(new C13506());
        this.spCash.setSelection(STATE_NOMAL);
        updateInforView();
        getEvents();
        getWindow().setSoftInputMode(3);
        Intent i = getIntent();
        if (i != null) {
            Bundle b = i.getBundleExtra(Constant.KEY_BUNDLE);
            if (b != null) {
                OnsignalItem item = (OnsignalItem) b.getParcelable(Constant.KEY_MSG);
                if (item != null) {
                    if (item.getStatus().equals("expertJoined")) {
                        trantoTab(new ListExpertFragment(item.getOrderId()));
                    } else if (item.getStatus().equals(SocketConstants.STATUS_ORDER_ESTIMATED) && item.getFields() != null) {
                        this.dialogConfirmCost = AlertDialogCustom.dialogConfirmCost((Context) this, new C13517(item), new C13538(item), item);
                        if (this.dialogConfirmCost.isShowing()) {
                            this.dialogConfirmCost.cancel();
                        }
                        this.dialogConfirmCost.show();
                        this.listDialog.add(dialog);
                    }
                }
            }
        }
        updateViewMapState(STATE_NOMAL);
        if (SharedPref.getInstance(getApplicationContext()).getBoolean(Constant.ISFIRTTIME, true)) {
            new Tooltip.Builder(this.btnPannic).setCancelable(true).setText((int) R.string.panic_buton).setDismissOnClick(true).setTextColor(-1).setGravity(48).setOnDismissListener(new C13549()).show();
        }
    }

    private void updateInforView() {
        if (AppController.getInstance().getUser() != null) {
            this.mTvName.setText(AppController.getInstance().getUser().getFirst_name() + " " + AppController.getInstance().getUser().getLast_name());
            if (!(AppController.getInstance().getUser().getAvatar() == null || AppController.getInstance().getUser().getAvatar().isEmpty())) {
                Picasso.with(this).load(ApiConstants.API_MEDIA_ROOT + AppController.getInstance().getUser().getAvatar()).skipMemoryCache().error(getResources().getDrawable(R.drawable.ic_stat_onesignal_default)).resize(PLACE_AUTOCOMPLETE_REQUEST_CODE, PLACE_AUTOCOMPLETE_REQUEST_CODE).into(this.mAvt);
            }
            this.llRootNav.setOnClickListener(this);
        }
    }

    public void reconnectBookingOrder(String idOrder) {
        if (!idOrder.isEmpty() && AppController.getInstance().getUser() != null) {
            this.mUmberService.getDetailOrder(AppController.getInstance().getUser().getToken(), idOrder).enqueue(new Callback<ApiResponse<DetailOrderItem>>() {
                public void onResponse(Call<ApiResponse<DetailOrderItem>> call, Response<ApiResponse<DetailOrderItem>> response) {
                    if (response.isSuccessful()) {
                        DetailOrderItem orderItem = (DetailOrderItem) ((ApiResponse) response.body()).getData();
                        if (orderItem != null && orderItem.getStatus() != null && orderItem.getStatus().equals(SocketConstants.KEY_FINDING)) {
                            MainActivity.this.mUmberSocket.joinIntoRoom(orderItem.getId());
                            MainActivity.this.trantoTab(new ListExpertFragment(orderItem.getId()));
                        }
                    }
                }

                public void onFailure(Call<ApiResponse<DetailOrderItem>> call, Throwable t) {
                    RLog.m86e(t.getMessage());
                }
            });
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != PLACE_AUTOCOMPLETE_REQUEST_CODE || grantResults[STATE_NOMAL] != 0 || this.mMap == null) {
            return;
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.mMap.setMyLocationEnabled(true);
            this.mMap.getUiSettings().setMyLocationButtonEnabled(false);
            this.mMap.setOnMyLocationChangeListener(new OnMyLocationChangeListener() {
                public void onMyLocationChange(Location location) {
                    MainActivity.this.mLatlng = new LatLng(location.getLatitude(), location.getLongitude());
                    AppController.getInstance().setLocation(location);
                    if (MainActivity.this.isTimeToFocus) {
                        CommonUtils.focusCurrentLocation(new LatLng(location.getLatitude(), location.getLongitude()), 13.0f, MainActivity.this.mMap);
                        MainActivity.this.isTimeToFocus = false;
                    }
                }
            });
            this.mMap.setOnCameraChangeListener(new OnCameraChangeListener() {
                public void onCameraChange(CameraPosition cameraPosition) {
                    MainActivity.this.mCurrentLatlng = cameraPosition.target;
                    if (MainActivity.this.isCameraChange) {
                        GeoTask geoTask = new GeoTask();
                        LatLng[] latLngArr = new LatLng[MainActivity.STATE_SHOW_CATEGORY];
                        latLngArr[MainActivity.STATE_NOMAL] = cameraPosition.target;
                        geoTask.execute(latLngArr);
                    } else {
                        MainActivity.this.isCameraChange = true;
                    }
                    if (MainActivity.this.mCategory != null) {
                        MainActivity.this.findExpert();
                    }
                }
            });
        }
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        if (this.mMap == null) {
            return;
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.mMap.setMyLocationEnabled(true);
            this.mMap.getUiSettings().setMyLocationButtonEnabled(false);
            this.mMap.setOnMyLocationChangeListener(new OnMyLocationChangeListener() {
                public void onMyLocationChange(Location location) {
                    MainActivity.this.mLatlng = new LatLng(location.getLatitude(), location.getLongitude());
                    AppController.getInstance().setLocation(location);
                    if (MainActivity.this.isTimeToFocus) {
                        CommonUtils.focusCurrentLocation(new LatLng(location.getLatitude(), location.getLongitude()), 13.0f, MainActivity.this.mMap);
                        MainActivity.this.isTimeToFocus = false;
                    }
                }
            });
            this.mMap.setOnMarkerClickListener(new OnMarkerClickListener() {
                public boolean onMarkerClick(Marker marker) {
                    HICItem hic = (HICItem) MainActivity.this.HICHashMap.get(marker);
                    if (hic != null) {
                        AlertDialogCustom.dialogDetailHIC(MainActivity.this, hic).show();
                    }
                    return true;
                }
            });
            this.mMap.setOnCameraChangeListener(new OnCameraChangeListener() {
                public void onCameraChange(CameraPosition cameraPosition) {
                    MainActivity.this.mCurrentLatlng = cameraPosition.target;
                    if (MainActivity.this.isCameraChange) {
                        GeoTask geoTask = new GeoTask();
                        LatLng[] latLngArr = new LatLng[MainActivity.STATE_SHOW_CATEGORY];
                        latLngArr[MainActivity.STATE_NOMAL] = cameraPosition.target;
                        geoTask.execute(latLngArr);
                    } else {
                        MainActivity.this.isCameraChange = true;
                    }
                    if (MainActivity.this.mCategory != null) {
                        MainActivity.this.findExpert();
                    }
                }
            });
            return;
        }
        ArrayList<String> listPermissions = new ArrayList();
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            listPermissions.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if (listPermissions.size() > 0 && VERSION.SDK_INT >= 23) {
            requestPermissions((String[]) listPermissions.toArray(new String[listPermissions.size()]), PLACE_AUTOCOMPLETE_REQUEST_CODE);
        }
    }

    protected void onResume() {
        super.onResume();
        checkDebit();
        if (this.queueEvent.size() > 0) {
            ((MaterialDialog) this.queueEvent.poll()).show();
        }
        verifyAccount();
    }

    protected void onStart() {
        super.onStart();
        this.mGoogleApiClient.connect();
    }

    protected void onStop() {
        this.mGoogleApiClient.disconnect();
        if (this.vs != null) {
            this.vs.cancel(true);
        }
        stopRecording();
        super.onStop();
    }

    public void onBackPressed() {
        if (this.drawer.isDrawerOpen((int) GravityCompat.START)) {
            this.drawer.closeDrawer((int) GravityCompat.START);
        } else if (this.drawer.isDrawerOpen((int) GravityCompat.END)) {
            this.drawer.closeDrawer((int) GravityCompat.END);
        } else {
            if (this.llForm.getVisibility() == 0 || this.btnPannic.getVisibility() == 8) {
                updateViewMapState(STATE_NOMAL);
            } else {
                super.onBackPressed();
            }
            onResume();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void trantoTab(Fragment tab) {
        this.mFragmentManager.beginTransaction().replace(R.id.contentview, tab).addToBackStack(null).commit();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            this.drawer.openDrawer((int) GravityCompat.END);
            return true;
        }
        if (id == 16908332) {
            this.drawer.openDrawer((int) GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        switch (item.getItemId()) {
            case R.id.nav_upcoming /*2131690046*/:
                startActivityForResult(new Intent(this, UpcomingActivity.class), Constant.UPCOMING_CODE);
                break;
            case R.id.nv_history /*2131690047*/:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
            case R.id.nav_promotion /*2131690048*/:
                AlertDialogCustom.dialogPromotion(this, this.mUmberService, new OnRespone<String>() {
                    public void onRespone(String object) {
                        MainActivity.this.promotion = object;
                    }
                }).show();
                break;
            case R.id.nav_notifi /*2131690049*/:
                trantoTab(new NotificationFragment());
                break;
            case R.id.nav_change /*2131690050*/:
                String token = SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
                if (!token.isEmpty()) {
                    this.dialogProgrees.showDialog();
                    this.mUmberService.becomeUser(token, "become-to-expert").enqueue(new Callback<ResponseBody>() {
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            MainActivity.this.dialogProgrees.hideDialog();
                            if (response.isSuccessful()) {
                                try {
                                    CommonUtils.launchApp(MainActivity.this, "com.umberapp.umberex");
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    CommonUtils.launchMarket(MainActivity.this, "com.umberapp.umberex");
                                    return;
                                }
                            }
                            AlertDialogCustom.dialogMsg(MainActivity.this, MainActivity.this.getString(R.string.unknow_error)).show();
                        }

                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            MainActivity.this.dialogProgrees.hideDialog();
                            AlertDialogCustom.dialogMsg(MainActivity.this, MainActivity.this.getString(R.string.unknow_error)).show();
                        }
                    });
                    break;
                }
                break;
            case R.id.nav_lang /*2131690051*/:
                saveLang(this);
                break;
            case R.id.nav_about /*2131690052*/:
                startActivity(new Intent(this, AboutActivity.class));
                break;
            case R.id.nav_faq /*2131690053*/:
                trantoTab(new FaqFragment());
                break;
            case R.id.nav_logout /*2131690054*/:
                logOut();
                break;
        }
        drawer.closeDrawer((int) GravityCompat.END);
        return true;
    }

    private void logOut() {
        Call<ResponseBody> call = this.mUmberService.logOut(SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR));
        this.dialogProgrees.showDialog();
        call.enqueue(new Callback<ResponseBody>() {
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                MainActivity.this.dialogProgrees.hideDialog();
                if (response.isSuccessful()) {
                    AppController.getInstance().setUser(null);
                    SharedPref.getInstance(MainActivity.this.getApplicationContext()).putString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
                    MainActivity.this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    MainActivity.this.finish();
                    MainActivity.this.clearData();
                    return;
                }
                AlertDialogCustom.dialogMsg(MainActivity.this, MainActivity.this.getString(R.string.unknow_error)).show();
                RLog.m86e(Integer.valueOf(response.code()));
            }

            public void onFailure(Call<ResponseBody> call, Throwable t) {
                MainActivity.this.dialogProgrees.hideDialog();
                AlertDialogCustom.dialogMsg(MainActivity.this, MainActivity.this.getString(R.string.unknow_error)).show();
                RLog.m86e(t.getMessage());
            }
        });
    }

    private void showListExpert() {
        if (this.isNotPayment) {
            try {
                Dialog dialog = new DialogWebView(this, this.mDebitModel, new OAuthDialogListener() {
                    public void onComplete(String accessToken) {
                    }

                    public void onError(String error) {
                    }
                });
                dialog.getWindow().setFlags(Place.TYPE_SUBLOCALITY_LEVEL_2, Place.TYPE_SUBLOCALITY_LEVEL_2);
                dialog.show();
            } catch (Exception e) {
            }
        } else if (this.listCategories == null) {
            ProgressDialogCustom dialogCustom = new ProgressDialogCustom(this);
            dialogCustom.showDialog();
            String token = SharedPref.getInstance(getApplicationContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
            String lang = SharedPref.getInstance(this).getString("lang", "en");
            if (lang.equals("in")) {
                lang = Constant.KEY_ID;
            }
            this.mUmberService.getCategory(token, lang).enqueue(new AnonymousClass22(dialogCustom));
        } else {
            AlertDialogCustom.dialogCategory(this, this.listCategories, this.mUmberService, new OnRespone<Category>() {
                public void onRespone(Category object) {
                    MainActivity.this.HandleCategory(object);
                }
            }).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!this.picPicker.onActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == -1) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                RLog.m86e(place.toString());
                if (this.mMap != null) {
                    CommonUtils.focusLocations(place.getViewport(), this.mMap);
                }
                this.mCurrentLatlng = new LatLng(place.getLatLng().latitude, place.getLatLng().longitude);
                this.mAddress = place.getAddress().toString();
                this.myLocation.setText(place.getAddress());
                if (this.mLatlng == null) {
                    this.mLatlng = new LatLng(place.getLatLng().latitude, place.getLatLng().longitude);
                }
            } else if (resultCode == STATE_SHOW_HCI) {
                RLog.m86e(PlaceAutocomplete.getStatus(this, data).getStatusMessage());
            } else if (resultCode == 0) {
            }
        }
        if (requestCode == Constant.UPCOMING_CODE && resultCode == -1 && data != null) {
            String id = data.getStringExtra(Constant.KEY_ID);
            if (id != null) {
                reconnectBookingOrder(id);
            }
        }
        if (requestCode == Constant.CODE_UPDATE && resultCode == -1) {
            updateInforView();
        }
        if (resultCode == -1 && requestCode == PhotoPicker.REQUEST_CODE && data != null) {
            ArrayList<String> photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
            if (photos != null && photos.size() > 0) {
                Iterator it = photos.iterator();
                while (it.hasNext()) {
                    String path = (String) it.next();
                    if (path != null) {
                        Image image = new Image();
                        image.setPath(path);
                        this.imgAdapter.add(image);
                    }
                }
            }
        }
    }

    public void updateViewMapState(int state) {
        RelativeLayout.LayoutParams p;
        switch (state) {
            case STATE_NOMAL /*0*/:
                if (this.mMap != null) {
                    this.mMap.clear();
                }
                this.mPinFileCategory = null;
                this.mCategory = null;
                this.llBottom.setVisibility(View.VISIBLE);
                this.llForm.setVisibility(View.GONE);
                this.llBottomBack.setVisibility(View.GONE);
                this.btnPannic.setVisibility(View.VISIBLE);
                p = new RelativeLayout.LayoutParams(-2, -2);
                p.addRule(STATE_SHOW_HCI, R.id.ll_bottom_main);
                p.setMargins(30, 10, 10, 30);
                this.btnLocation.setContentPadding(10, 10, 10, 10);
                clearData();
                this.btnLocation.setLayoutParams(p);
            case STATE_SHOW_CATEGORY /*1*/:
                if (this.mMap != null) {
                    this.mMap.clear();
                }
                this.llBottomBack.setVisibility(8);
                this.llBottom.setVisibility(8);
                this.llForm.setVisibility(View.VISIBLE);
                this.btnPannic.setVisibility(8);
                p = new RelativeLayout.LayoutParams(-2, -2);
                p.addRule(STATE_SHOW_HCI, R.id.ll_form);
                p.setMargins(40, 10, 10, 30);
                this.btnLocation.setContentPadding(10, 10, 10, 10);
                this.btnLocation.setLayoutParams(p);
            case STATE_SHOW_HCI /*2*/:
                if (this.mMap != null) {
                    this.mMap.clear();
                }
                this.llBottomBack.setVisibility(View.VISIBLE);
                this.llBottom.setVisibility(8);
                this.llForm.setVisibility(8);
                this.btnPannic.setVisibility(8);
                p = new RelativeLayout.LayoutParams(-2, -2);
                p.addRule(STATE_SHOW_HCI, R.id.ll_bottom_back);
                p.setMargins(40, 10, 10, 30);
                this.btnLocation.setContentPadding(10, 10, 10, 10);
                this.btnLocation.setLayoutParams(p);
            default:
        }
    }

    public void onClick(View view) {
        Date mDate;
        Date toDate;
        Dialog dialogTime;
        switch (view.getId()) {
            case R.id.btn_location /*2131689696*/:
                if (this.mLatlng != null) {
                    CommonUtils.focusCurrentLocation(this.mLatlng, 13.0f, this.mMap);
                }
            case R.id.ll_cancel /*2131689699*/:
                updateViewMapState(STATE_NOMAL);
            case R.id.toolbar_title /*2131689732*/:
                removeAllTab();
                refreshView();
                onResume();
            case R.id.menu /*2131689734*/:
                this.drawer.openDrawer((int) GravityCompat.END);
            case R.id.badge_icon_button /*2131689741*/:
                startActivityForResult(new Intent(this, UpcomingActivity.class), Constant.UPCOMING_CODE);
            case R.id.myLocation /*2131689797*/:
                try {
                    startActivityForResult(new PlaceAutocomplete.IntentBuilder(STATE_SHOW_CATEGORY).build(this), PLACE_AUTOCOMPLETE_REQUEST_CODE);
                } catch (GooglePlayServicesRepairableException e) {
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            case R.id.ll_bottom_main /*2131689799*/:
                showListExpert();
            case R.id.schedule /*2131689802*/:
                mDate = StringUtil.getCurrentDate();
                mDate.setYear(mDate.getYear() + 1900);
                this.mDateString = CommonUtils.getCurrentTimeByFormat(StringUtil.DATE_FORMAT_7);
                toDate = new Date(mDate.getYear(), mDate.getMonth(), mDate.getDate(), mDate.getHours() + STATE_SHOW_CATEGORY, mDate.getMinutes());
                if (this.mTimeStart != 0) {
                    mDate = CommonUtils.convertTimeToDate(this.mTimeStart);
                }
                if (this.mTimeEnd != 0) {
                    toDate = CommonUtils.convertTimeToDate(this.mTimeEnd);
                }
                dialogTime = AlertDialogCustom.dialogTime(this, getFragmentManager(), new OnRespone<String>() {
                    public void onRespone(String object) {
                        MainActivity.this.mDateString = object;
                        MainActivity.this.mDateBooking = CommonUtils.convertToSec2(MainActivity.this.mDateString, StringUtil.DATE_FORMAT_7);
                        RLog.m86e(Long.valueOf(MainActivity.this.mDateBooking));
                    }
                }, new OnRespone<String>() {
                    public void onRespone(String object) {
                        MainActivity.this.mTimeStart = CommonUtils.convertToSec2(MainActivity.this.mDateString + " " + object, "MM/dd/yyyy HH:mm");
                        RLog.m86e(Long.valueOf(MainActivity.this.mTimeStart));
                    }
                }, new OnRespone<String>() {
                    public void onRespone(String object) {
                        MainActivity.this.mTimeEnd = CommonUtils.convertToSec2(MainActivity.this.mDateString + " " + object, "MM/dd/yyyy HH:mm");
                        RLog.m86e(Long.valueOf(MainActivity.this.mTimeEnd));
                    }
                }, mDate, toDate);
                dialogTime.show();
                this.listDialog.add(dialogTime);
                this.isShownScheldule = true;
            case R.id.cash /*2131689804*/:
                this.spCash.performClick();
            case R.id.promo /*2131689806*/:
                AlertDialogCustom.dialogPromotion(this, this.mUmberService, new OnRespone<String>() {
                    public void onRespone(String object) {
                        MainActivity.this.promotion = object;
                    }
                }).show();
            case R.id.edt_txt /*2131689807*/:
                try {
                    Dialog dialogText = dialogTextForm(this, new CallbackDialog() {
                        public void onClickDialogEdt(String edt, int code) {
                        }
                    }, STATE_NOMAL);
                    dialogText.show();
                    this.listDialog.add(dialogText);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            case R.id.ll_category /*2131689811*/:
                showListExpert();
            case R.id.ll_book_now /*2131689814*/:
                if (this.isShownScheldule) {
                    prepareOrder();
                    return;
                }
                mDate = new Date(System.currentTimeMillis());
                this.mDateString = CommonUtils.getCurrentTimeByFormat(StringUtil.DATE_FORMAT_7);
                toDate = new Date(mDate.getYear(), mDate.getMonth(), mDate.getDate(), mDate.getHours() + STATE_SHOW_CATEGORY, mDate.getMinutes());
                if (this.mTimeStart != 0) {
                    mDate = CommonUtils.convertTimeToDate(this.mTimeStart);
                }
                if (this.mTimeEnd != 0) {
                    toDate = CommonUtils.convertTimeToDate(this.mTimeEnd);
                }
                dialogTime = AlertDialogCustom.dialogTime(this, getFragmentManager(), new OnRespone<String>() {
                    public void onRespone(String object) {
                        MainActivity.this.mDateString = object;
                        MainActivity.this.mDateBooking = CommonUtils.convertToSec2(MainActivity.this.mDateString, StringUtil.DATE_FORMAT_7);
                        RLog.m86e(Long.valueOf(MainActivity.this.mDateBooking));
                    }
                }, new OnRespone<String>() {
                    public void onRespone(String object) {
                        MainActivity.this.mTimeStart = CommonUtils.convertToSec2(MainActivity.this.mDateString + " " + object, "MM/dd/yyyy HH:mm");
                        RLog.m86e(Long.valueOf(MainActivity.this.mTimeStart));
                    }
                }, new OnRespone<String>() {
                    public void onRespone(String object) {
                        MainActivity.this.mTimeEnd = CommonUtils.convertToSec2(MainActivity.this.mDateString + " " + object, "MM/dd/yyyy HH:mm");
                        RLog.m86e(Long.valueOf(MainActivity.this.mTimeEnd));
                    }
                }, mDate, toDate);
                dialogTime.show();
                this.listDialog.add(dialogTime);
                this.isShownScheldule = true;
            case R.id.btn_pannic /*2131689815*/:
                findHCI();
                this.btnPannic.setVisibility(8);
                updateViewMapState(STATE_SHOW_HCI);
            case R.id.linear_bottom_main /*2131689817*/:
                showListExpert();
            case R.id.edt_catelogy /*2131689818*/:
                showListExpert();
            case R.id.linear_bottom_back /*2131689820*/:
                updateViewMapState(STATE_NOMAL);
            case R.id.ll_root_nav /*2131690013*/:
                startActivityForResult(new Intent(this, SettingActivity.class), Constant.CODE_UPDATE);
            default:
        }
    }

    private void prepareOrder() {
        OrderItem order = new OrderItem();
        if (this.mAddress == null || this.mAddress.isEmpty()) {
            Crouton.makeText((Activity) this, (int) R.string.unable_to_get_address, Style.ALERT, this.view).show();
            return;
        }
        order.setAddress(this.mAddress);
        order.setCategory(this.mCategory.getId());
        if (this.mDateBooking == 0) {
            this.mDateString = CommonUtils.getCurrentTimeByFormat(StringUtil.DATE_FORMAT_7);
            this.mDateBooking = CommonUtils.convertToSec2(this.mDateString, StringUtil.DATE_FORMAT_7);
        }
        order.setDateBooking(this.mDateBooking);
        RangeTime time = new RangeTime();
        if (this.mTimeStart == 0) {
            this.mTimeStart = System.currentTimeMillis();
        }
        time.setStart(String.valueOf(this.mTimeStart));
        if (this.mTimeEnd == 0) {
            this.mTimeEnd = this.mTimeStart + 3600000;
        }
        time.setEnd(String.valueOf(this.mTimeEnd));
        order.setCustomer(AppController.getInstance().getUser().getId());
        order.setRangeTime(time);
        if (this.promotion != null) {
            order.setPromotion(this.promotion);
        }
        double[] coor = new double[STATE_SHOW_HCI];
        coor[STATE_NOMAL] = this.mCurrentLatlng.longitude;
        coor[STATE_SHOW_CATEGORY] = this.mCurrentLatlng.latitude;
        order.setCoordinates(coor);
        order.setTags(this.stringTag);
        if (this.mListExpert != null && this.mListExpert.size() > 0) {
            List<String> listEx = new ArrayList();
            for (ExpertMarker ex : this.mListExpert) {
                listEx.add(ex.getId());
            }
            order.setExperts(listEx);
        }
        order.setPayment(((String) this.listCash.get(this.spCash.getSelectedItemPosition())).toLowerCase().replace(" ", BuildConfig.FLAVOR));
        this.dialogProgrees.showDialog();
        if (mFileName == null || mFileName.isEmpty()) {
            uploadPhoto(order);
            return;
        }
        File file = new File(mFileName);
        if (file.exists()) {
            this.mUmberService.uploadAudio(Part.createFormData(ApiConstants.KEY_FILE, file.getName(), RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file))).enqueue(new AnonymousClass32(order));
            return;
        }
        uploadPhoto(order);
    }

    private void uploadPhoto(OrderItem order) {
        this.listImages = this.imgAdapter.getList();
        if (this.listImages.size() > 0) {
            List<Picture> listStrPathServer = new ArrayList();
            for (Image img : this.listImages) {
                this.mUmberService.uploadPhotos(prepareFilePart(ApiConstants.KEY_FILE, img.getPath())).enqueue(new AnonymousClass33(listStrPathServer, order));
            }
            return;
        }
        sendOrder(order);
    }

    @NonNull
    private Part prepareFilePart(String partName, String filename) {
        File file = new File(filename);
        return Part.createFormData(partName, file.getName(), RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file));
    }

    private void sendOrder(OrderItem order) {
        this.mUmberService.order(AppController.getInstance().getUser().getToken(), order).enqueue(new Callback<ApiResponse<OrderItem>>() {
            public void onResponse(Call<ApiResponse<OrderItem>> call, Response<ApiResponse<OrderItem>> response) {
                if (response.isSuccessful()) {
                    MainActivity.this.dialogProgrees.hideDialog();
                    RLog.m86e(response.toString());
                    AppController.getInstance().setIdOrder(((OrderItem) ((ApiResponse) response.body()).getData()).getId());
                    AppController.getInstance().setOrder((OrderItem) ((ApiResponse) response.body()).getData());
                    RLog.m86e(((OrderItem) ((ApiResponse) response.body()).getData()).getId());
                    MainActivity.this.mUmberSocket.notiToExpert(((OrderItem) ((ApiResponse) response.body()).getData()).getId());
                    MainActivity.this.mUmberSocket.joinIntoRoom(((OrderItem) ((ApiResponse) response.body()).getData()).getId());
                    MainActivity.this.clearData();
                    MainActivity.this.refreshView();
                    MainActivity.this.trantoTab(new ListExpertFragment(((OrderItem) ((ApiResponse) response.body()).getData()).getId()));
                    return;
                }
                MainActivity.this.dialogProgrees.hideDialog();
                Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.unknow_error), MainActivity.STATE_NOMAL).show();
                RLog.m86e(Integer.valueOf(response.code()));
            }

            public void onFailure(Call<ApiResponse<OrderItem>> call, Throwable t) {
                MainActivity.this.dialogProgrees.hideDialog();
                Toast.makeText(MainActivity.this, MainActivity.this.getString(R.string.unknow_error), Toast.LENGTH_SHORT).show();
                RLog.m86e("error upload order " + t.getMessage());
            }
        });
    }

    private void clearData() {
        this.isShownScheldule = false;
        this.listImages.clear();
        if (this.imgAdapter != null) {
            this.imgAdapter.removeAll();
        }
        if (this.rcv != null) {
            this.rcv.removeAllViews();
        }
        mFileName = BuildConfig.FLAVOR;
        this.stringTag.clear();
        isShowDialogCost = false;
        isShowDialogFeedback = false;
    }

    private void HandleCategory(Category object) {
        if (object.getName().equals("HCI")) {
            findHCI();
            updateViewMapState(STATE_SHOW_HCI);
            return;
        }
        this.mCategory = object;
        this.mUmberService.downloadFilePin(ApiConstants.API_MEDIA_ROOT + object.getMarker()).enqueue(new Callback<ResponseBody>() {
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    MainActivity.this.mPinFileCategory = ApiUtils.writeResponseBodyToDisk((ResponseBody) response.body(), MainActivity.this, "pin.png");
                } else {
                    RLog.m86e(Integer.valueOf(response.code()));
                }
            }

            public void onFailure(Call<ResponseBody> call, Throwable t) {
                RLog.m86e(t.getMessage());
            }
        });
        this.tvCategory.setHint(object.getName());
        Picasso.with(this).load(ApiConstants.API_MEDIA_ROOT + object.getIcon()).into(this.imgCategory);
        updateViewMapState(STATE_SHOW_CATEGORY);
        if (this.mMap != null) {
            CommonUtils.focuseLocation(this.mMap.getCameraPosition().target, 12.0f, this.mMap);
        }
        findExpert();
    }

    private void findExpert() {
        if (this.mCurrentLatlng != null) {
            this.mUmberService.findExpert(AppController.getInstance().getUser().getToken(), this.mCategory.getId(), this.mCurrentLatlng.latitude, this.mCurrentLatlng.longitude, 10000).enqueue(new Callback<ApiResponse<List<ExpertMarker>>>() {
                public void onResponse(Call<ApiResponse<List<ExpertMarker>>> call, Response<ApiResponse<List<ExpertMarker>>> response) {
                    if (response.isSuccessful()) {
                        MainActivity.this.mListExpert = (List) ((ApiResponse) response.body()).getData();
                        if (MainActivity.this.mMap != null) {
                            MainActivity.this.mMap.clear();
                            for (ExpertMarker ex : (List) ((ApiResponse) response.body()).getData()) {
                                LatLng latlng = new LatLng(ex.getLocation()[MainActivity.STATE_SHOW_CATEGORY], ex.getLocation()[MainActivity.STATE_NOMAL]);
                                if (MainActivity.this.mPinFileCategory != null) {
                                    CommonUtils.addMarkerFromFile(MainActivity.this.mPinFileCategory, MainActivity.this.mMap, latlng);
                                } else {
                                    CommonUtils.addMarker(MainActivity.this.mMap, latlng);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    RLog.m86e(Integer.valueOf(response.code()));
                }

                public void onFailure(Call<ApiResponse<List<ExpertMarker>>> call, Throwable t) {
                    RLog.m86e(t.getMessage());
                }
            });
        }
    }

    private void findHCI() {
        if (!(this.mMap == null || this.mMap == null)) {
            CommonUtils.focuseLocation(this.mMap.getCameraPosition().target, 12.0f, this.mMap);
        }
        if (this.mCurrentLatlng != null) {
            RLog.m86e("Lat - " + this.mCurrentLatlng.latitude + " - lng - " + this.mCurrentLatlng.longitude);
            this.mUmberService.findHCI(AppController.getInstance().getUser().getToken(), this.mCurrentLatlng.latitude, this.mCurrentLatlng.longitude, 10000).enqueue(new Callback<ApiResponse<List<HICItem>>>() {

                /* renamed from: com.umberapp.umber.activities.MainActivity.38.1 */
                class C13391 implements Callback<ResponseBody> {
                    final /* synthetic */ HICItem val$ex;

                    C13391(HICItem hICItem) {
                        this.val$ex = hICItem;
                    }

                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Marker marker;
                            MainActivity.this.mPinHIC = ApiUtils.writeResponseBodyToDisk((ResponseBody) response.body(), MainActivity.this, ((HICItem.Category) this.val$ex.getCategory().get(MainActivity.STATE_NOMAL)).marker.substring(((HICItem.Category) this.val$ex.getCategory().get(MainActivity.STATE_NOMAL)).marker.lastIndexOf(47) + MainActivity.STATE_SHOW_CATEGORY, ((HICItem.Category) this.val$ex.getCategory().get(MainActivity.STATE_NOMAL)).marker.length()));
                            LatLng latlng = new LatLng(this.val$ex.getLocation()[MainActivity.STATE_SHOW_CATEGORY], this.val$ex.getLocation()[MainActivity.STATE_NOMAL]);
                            if (MainActivity.this.mPinHIC != null) {
                                marker = CommonUtils.addMarkerFromFile(MainActivity.this.mPinHIC, MainActivity.this.mMap, latlng);
                            } else {
                                marker = CommonUtils.addMarker(MainActivity.this.mMap, latlng);
                            }
                            MainActivity.this.HICHashMap.put(marker, this.val$ex);
                            MainActivity.this.mCategory = null;
                            return;
                        }
                        RLog.m86e(Integer.valueOf(response.code()));
                    }

                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        RLog.m86e(t.getMessage());
                    }
                }

                public void onResponse(Call<ApiResponse<List<HICItem>>> call, Response<ApiResponse<List<HICItem>>> response) {
                    if (response.isSuccessful()) {
                        MainActivity.this.mListHCI = (List) ((ApiResponse) response.body()).getData();
                        if (MainActivity.this.mMap != null) {
                            MainActivity.this.mMap.clear();
                            for (HICItem ex : (List) ((ApiResponse) response.body()).getData()) {
                                if (ex.getCategory() != null && ex.getCategory().size() > 0) {
                                    MainActivity.this.mUmberService.downloadFilePin(ApiConstants.API_MEDIA_ROOT + ((HICItem.Category) ex.getCategory().get(MainActivity.STATE_NOMAL)).marker).enqueue(new C13391(ex));
                                }
                            }
                            return;
                        }
                        return;
                    }
                    RLog.m86e(Integer.valueOf(response.code()));
                }

                public void onFailure(Call<ApiResponse<List<HICItem>>> call, Throwable t) {
                    RLog.m86e(t.getMessage());
                }
            });
        }
    }

    private void onRecord(boolean start) {
        if (start) {
            startRecording();
            return;
        }
        stopRecording();
        this.isRecord = false;
    }

    public void onPause() {
        super.onPause();
        if (this.mRecorder != null) {
            this.mRecorder.release();
            this.mRecorder = null;
        }
    }

    public void AudioRecordTest() {
        mFileName = FileUtils.getFolder(this);
        mFileName += "audio.wav";
    }

    private void startRecording() {
        getWindow().setSoftInputMode(3);
        AudioRecordTest();
        this.mRecorder = new MediaRecorder();
        this.mRecorder.setAudioSource(STATE_SHOW_CATEGORY);
        this.mRecorder.setOutputFormat(STATE_SHOW_CATEGORY);
        this.mRecorder.setOutputFile(mFileName);
        this.mRecorder.setAudioEncoder(3);
        try {
            this.mRecorder.prepare();
            this.isEnable = true;
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
            Toast.makeText(this, "Unable to record from device!", Toast.LENGTH_SHORT).show();
        }
        if (this.isEnable) {
            this.mRecorder.start();
            this.isRecord = true;
        }
    }

    private void stopRecording() {
        if (this.isRecord) {
            try {
                this.mRecorder.stop();
                this.mRecorder.reset();
                this.mRecorder.release();
                this.mRecorder = null;
                this.isRecord = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void refreshView() {
        if (this.mMap != null) {
            this.mMap.clear();
        }
        this.llForm.setVisibility(8);
        this.llBottom.setVisibility(View.VISIBLE);
        this.btnPannic.setVisibility(View.VISIBLE);
        this.mDateBooking = 0;
        this.mDateString = BuildConfig.FLAVOR;
        this.mTimeStart = 0;
        this.mTimeEnd = 0;
        this.tvRequiredTextForm.setText(getString(R.string.your_text_requirements_texts_images_audios));
        this.imgRecord.setVisibility(8);
        this.imgImage.setVisibility(8);
        this.stringTag.clear();
        this.promotion = BuildConfig.FLAVOR;
        if (this.rcv != null) {
            this.rcv.removeAllViews();
        }
        if (this.imgAdapter != null) {
            this.imgAdapter.removeAll();
        }
        updateViewMapState(STATE_NOMAL);
    }

    public Dialog dialogTextForm(Activity context, CallbackDialog callbackDialog, int code) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        View view = factory.inflate(R.layout.dialog_text_form, null, false);
        Button button = (Button) view.findViewById(R.id.btn_ok);
        ImageView btnCamera = (ImageView) view.findViewById(R.id.btn_add_img);
        LinearLayout btnStartRecord = (LinearLayout) view.findViewById(R.id.start);
        Button btnStopRecord = (Button) view.findViewById(R.id.stop);
        TagCompleteTextView edt = (TagCompleteTextView) view.findViewById(R.id.edt_message);

        edt.setSplitChar(',');
        if (this.stringTag.size() > 0) {
            for (Tag addObject : this.stringTag) {
                edt.addObject(addObject);
            }
        }
        this.rcv = (RecyclerView) view.findViewById(R.id.rcv_image);
        this.rcv.setLayoutManager(new LinearLayoutManager(this, STATE_NOMAL, false));
        this.rcv.setHasFixedSize(true);
        this.rcv.setAdapter(this.imgAdapter);
        Visualizer visualizerView = (Visualizer) view.findViewById(R.id.visualizerView);
        LinearLayout llMedia = (LinearLayout) view.findViewById(R.id.ll_media);
        ImageView imgRemove = (ImageView) view.findViewById(R.id.img_remove);
        if (!(mFileName == null || mFileName.isEmpty())) {
            llMedia.setVisibility(View.VISIBLE);
        }
        btnStartRecord.setOnClickListener(new AnonymousClass43(btnStartRecord, btnStopRecord, btnCamera, context, visualizerView, llMedia));
        imgRemove.setOnClickListener(new AnonymousClass44(llMedia, btnStopRecord, btnStartRecord, visualizerView));
        btnStopRecord.setOnClickListener(new AnonymousClass45(visualizerView, btnStopRecord, btnStartRecord, llMedia, btnCamera));
        llMedia.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent viewIntent = new Intent("android.intent.action.VIEW");
                File file = new File(MainActivity.mFileName);
                if (file.exists()) {
                    viewIntent.setDataAndType(Uri.fromFile(file), "audio/*");
                    MainActivity.this.startActivity(Intent.createChooser(viewIntent, null));
                }
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(STATE_NOMAL));
        dialog.setContentView(view);
        btnCamera.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.this.listImages.size() >= 15) {
                    Toast.makeText(MainActivity.this, R.string.full_image, MainActivity.STATE_NOMAL).show();
                } else {
                    PhotoPicker.builder().setPhotoCount(15 - MainActivity.this.listImages.size()).setShowCamera(true).setShowGif(true).setPreviewEnabled(true).start(MainActivity.this, (int) PhotoPicker.REQUEST_CODE);
                }
            }
        });
        edt.addTextChangedListener(new AnonymousClass48(edt));
        button.setOnClickListener(new AnonymousClass49(edt, dialog));
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-2, -2);
        return dialog;
    }

    public void onSizeChange(int size) {
    }

    private void postTag(String tag) {
        this.mUmberService.postTag(AppController.getInstance().getUser().getToken(), tag, this.mCategory != null ? this.mCategory.getId() : BuildConfig.FLAVOR).enqueue(new Callback<ApiResponse<List<Tag>>>() {
            public void onResponse(Call<ApiResponse<List<Tag>>> call, Response<ApiResponse<List<Tag>>> response) {
                RLog.m86e(response.isSuccessful() ? "success post tag" : Integer.valueOf(response.code()));
            }

            public void onFailure(Call<ApiResponse<List<Tag>>> call, Throwable t) {
                RLog.m86e(t.getMessage());
            }
        });
    }

    public void cancleOrder(String cause, String id, String idOrder) {
        this.mUmberSocket.cancleOrder(cause, id, idOrder);
        finishOrder();
    }

    public void selectExpert(String id, String orderId) {
        this.mUmberSocket.selectExpert(id, orderId);
    }

    public void showDialogConfirm(ExpertBit exBit, String orderId) {
        removeAllTab();
        Dialog dialogConfirm = AlertDialogCustom.dialogConfirm(this, exBit, new AnonymousClass51(exBit, orderId), new OnRespone() {
            public void onRespone(Object object) {
                MainActivity.this.removeAllTab();
            }
        });
        dialogConfirm.show();
        this.listDialog.add(dialogConfirm);
    }

    private void verifyAccount() {
        if (AppController.getInstance().getUser() != null) {
            User mUser = AppController.getInstance().getUser();
            switch (AppController.getInstance().getUser().getStatus()) {
                case STATE_SHOW_HCI /*2*/:
                    new MaterialDialog.Builder(this).title((int) R.string.account_status).content((int) R.string.account_locked).positiveText((int) R.string.ok).onPositive(new SingleButtonCallback() {
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            dialog.cancel();
                            MainActivity.this.logOut();
                        }
                    }).cancelable(false).show();
                case R.styleable.View_paddingEnd /*3*/:
                    new MaterialDialog.Builder(this).title((int) R.string.account_status).content((int) R.string.accout_delete).positiveText((int) R.string.ok).onPositive(new SingleButtonCallback() {
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            dialog.cancel();
                            MainActivity.this.logOut();
                        }
                    }).cancelable(false).show();
                default:
                    if (mUser != null && mUser.getReady() != null && mUser.getReady().equals(ApiConstants.VAL_VERIFY)) {
                        trantoTab(new BlockFragment());
                    }
            }
        }
    }

    public void sendSms() {
        this.mUmberService.sendSMSVerify(AppController.getInstance().getUser().getToken()).enqueue(new Callback<ApiResponse<String>>() {
            public void onResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {
                if (!response.isSuccessful()) {
                }
            }

            public void onFailure(Call<ApiResponse<String>> call, Throwable t) {
            }
        });
    }

    private void getEvents() {
        String token = SharedPref.getInstance(this).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
        if (token != null) {
            this.dialogProgrees.showDialog();
            this.mUmberService.getEvents(token).enqueue(new Callback<ApiResponse<List<Event>>>() {
                public void onResponse(Call<ApiResponse<List<Event>>> call, Response<ApiResponse<List<Event>>> response) {
                    MainActivity.this.dialogProgrees.hideDialog();
                    if (response.isSuccessful()) {
                        for (Event e : response.body().getData()) {
                            MainActivity.this.queueEvent.add(new MaterialDialog.Builder(MainActivity.this).title(e.getTitle()).content(e.getContent()).autoDismiss(true).build());
                        }
                        if (MainActivity.this.queueEvent.size() > 0) {
                            ((MaterialDialog) MainActivity.this.queueEvent.poll()).show();
                        }
                    }
                }

                public void onFailure(Call<ApiResponse<List<Event>>> call, Throwable t) {
                    MainActivity.this.dialogProgrees.hideDialog();
                    RLog.m86e("getEvent error = " + t.getMessage());
                }
            });
        }
    }

    public void saveLang(Context context) {
        int pos;
        CharSequence[] lang = new CharSequence[STATE_SHOW_HCI];
        lang[STATE_NOMAL] = "English";
        lang[STATE_SHOW_CATEGORY] = "Indonesia";
        if (SharedPref.getInstance(this).getString("lang", "en").equals("en")) {
            pos = STATE_NOMAL;
        } else {
            pos = STATE_SHOW_CATEGORY;
        }
        MaterialDialog dialog = new MaterialDialog.Builder(context).title(context.getString(R.string.language)).items(lang).itemsCallbackSingleChoice(-1, new AnonymousClass57(context)).build();
        dialog.setSelectedIndex(pos);
        dialog.show();
    }

    public void checkDebit() {
        String token = SharedPref.getInstance(this).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
        if (!token.isEmpty()) {
            getMservice().checkDebit(token).enqueue(new Callback<ApiResponse<DebitModel>>() {
                public void onResponse(Call<ApiResponse<DebitModel>> call, Response<ApiResponse<DebitModel>> response) {
                    if (response.isSuccessful()) {
                        RLog.m86e(Integer.valueOf(((ApiResponse) response.body()).getStatus()));
                        DebitModel debitModel = (DebitModel) ((ApiResponse) response.body()).getData();
                        if (debitModel != null && debitModel.getAmount() != 0) {
                            MainActivity.this.edtCategory.setText("Please click here to payment your fee umber service");
                            MainActivity.this.isNotPayment = true;
                            MainActivity.this.mDebitModel = debitModel;
                        }
                    }
                }

                public void onFailure(Call<ApiResponse<DebitModel>> call, Throwable t) {
                    AlertDialogCustom.dialogMsg(MainActivity.this, MainActivity.this.getString(R.string.unknow_error) + "\n " + t.getMessage()).show();
                }
            });
        }
    }
}
