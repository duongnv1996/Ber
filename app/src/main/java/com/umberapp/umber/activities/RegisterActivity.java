package com.umberapp.umber.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.PhoneNumber;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;
import com.github.brunodles.compressor.BitmapCompressor;
import com.github.brunodles.pic_picker.PicPicker;
import com.github.brunodles.pic_picker.listener.CantFindCameraAppErrorListener;
import com.github.brunodles.pic_picker.listener.ErrorCreatingTempFileForCameraListener;
import com.github.brunodles.pic_picker.listener.PicResultListener;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlacePicker.IntentBuilder;
import com.google.android.gms.maps.model.LatLng;
import com.hbb20.CountryCodePicker;
import com.hbb20.CountryCodePicker.OnCountryChangeListener;
import com.sromku.simple.fb.entities.Profile.Properties;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImage.ActivityResult;
import com.theartofdev.edmodo.cropper.CropImageView.Guidelines;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.EtaxiService;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.models.AuthResponse;
import com.umberapp.umber.models.CheckResponse;
import com.umberapp.umber.models.Image;
import com.umberapp.umber.models.ParamRegUser;
import com.umberapp.umber.models.User;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.FileUtils;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.utils.StringUtil;
import com.umberapp.umber.views.AlertDialogCustom;
import com.umberapp.umber.views.ProgressDialogCustom;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import me.iwf.photopicker.PhotoPicker;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements OnClickListener, OnDateSetListener, OnRespone<Integer> {
    public static int APP_REQUEST_CODE = 0;
    public static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 100;
    private static final int PLACE_PICKER_FLAG = 1;
    ArrayAdapter<String> adapter;
    final String[] arrGender;
    @Bind({2131689729})
    Button btnReg;
    @Bind({2131689725})
    Button btnRemovePhoto;
    @Bind({2131689726})
    Button btnTakePhoto;
    private IntentBuilder builder;
    private CantFindCameraAppErrorListener cameraAppErrorListener;
    @Bind({2131689704})
    CountryCodePicker contryCode;
    String[] coordinates;
    private ProgressDialogCustom dialogProgress;
    private ErrorCreatingTempFileForCameraListener fileForCameraListener;
    @Bind({2131689724})
    CircleImageView imgAvt;
    private boolean isFixed;
    private boolean isUpdateAKProfile;
    private boolean isUpdateFacebook;
    @Bind({2131689707})
    LinearLayout llPass;
    @Bind({2131689709})
    LinearLayout llRepass;
    @Bind({2131689723})
    RelativeLayout llRootImage;
    @Bind({2131689703})
    LinearLayout llRootPhone;
    Location location;
    @Bind({2131689727})
    AppCompatCheckBox mCb;
    @Bind({2131689716})
    EditText mEdtAddress;
    @Bind({2131689720})
    EditText mEdtBirth;
    @Bind({2131689683})
    EditText mEdtEmail;
    @Bind({2131689712})
    EditText mEdtFirstName;
    @Bind({2131689714})
    EditText mEdtLastName;
    @Bind({2131689685})
    EditText mEdtPassword;
    @Bind({2131689705})
    EditText mEdtPhone;
    @Bind({2131689710})
    EditText mEdtRePassword;
    @Bind({2131689721})
    EditText mEdtRef;
    File mFileAvata;
    protected GoogleApiClient mGoogleApiClient;
    String mPass;
    String mPhone;
    @Bind({2131689680})
    ProgressBar mProgress;
    @Bind({2131689722})
    AppCompatSpinner mSpGender;
    User mUser;
    private PicPicker picPicker;
    private PicResultListener picResultListener;
    private BroadcastReceiver receiver;
    String strContryCode;
    @Bind({2131689717})
    TextView tvInvalidAddress;
    @Bind({2131689718})
    TextView tvInvalidEmail;
    @Bind({2131689713})
    TextView tvInvalidFirst;
    @Bind({2131689715})
    TextView tvInvalidLastname;
    @Bind({2131689708})
    TextView tvInvalidPass;
    @Bind({2131689706})
    TextView tvInvalidPhone;
    @Bind({2131689711})
    TextView tvInvalidRepeat;
    @Bind({2131689728})
    TextView tvTerm;
    UmberService umberService;
    User userFromLogin;

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.17 */
    class AnonymousClass17 implements Callback<ApiResponse<String>> {
        final /* synthetic */ String val$pass;
        final /* synthetic */ String val$phone;
        final /* synthetic */ User val$user;

        AnonymousClass17(User user, String str, String str2) {
            this.val$user = user;
            this.val$phone = str;
            this.val$pass = str2;
        }

        public void onResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {
            if (response.isSuccessful()) {
                ApiResponse<String> apiResponse = (ApiResponse) response.body();
                if (apiResponse.getData() != null) {
                    this.val$user.setAvatar((String) apiResponse.getData());
                    RegisterActivity.this.checkUsernameToSignUp(this.val$phone, this.val$user, this.val$pass);
                    return;
                }
                RegisterActivity.this.checkUsernameToSignUp(this.val$phone, this.val$user, this.val$pass);
                return;
            }
            RegisterActivity.this.checkUsernameToSignUp(this.val$phone, this.val$user, this.val$pass);
        }

        public void onFailure(Call<ApiResponse<String>> call, Throwable t) {
            RLog.m86e(t.getMessage());
            RegisterActivity.this.checkUsernameToSignUp(this.val$phone, this.val$user, this.val$pass);
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.18 */
    class AnonymousClass18 implements Callback<ApiResponse<User>> {
        final /* synthetic */ User val$user;

        AnonymousClass18(User user) {
            this.val$user = user;
        }

        public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
            if (response.isSuccessful()) {
                User auth = (User) ((ApiResponse) response.body()).getData();
                RLog.m86e(auth.getId());
                if (auth != null) {
                    Intent i = new Intent();
                    i.putExtra(Constant.KEY_MSG, this.val$user.getToken());
                    RegisterActivity.this.setResult(RegisterActivity.PLACE_PICKER_FLAG, i);
                    RegisterActivity.this.finish();
                    return;
                }
                AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
                return;
            }
            RLog.m86e(Integer.valueOf(response.code()));
            AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
            RLog.m86e(t.getMessage());
            AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
            RegisterActivity.this.dialogProgress.hideDialog();
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.1 */
    class C13561 extends BroadcastReceiver {
        C13561() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                RegisterActivity.this.location = (Location) intent.getParcelableExtra(Properties.LOCATION);
                if (RegisterActivity.this.location != null && !RegisterActivity.this.isFixed) {
                    RegisterActivity.this.coordinates[0] = RegisterActivity.this.location.getLongitude() + BuildConfig.FLAVOR;
                    RegisterActivity.this.coordinates[RegisterActivity.PLACE_PICKER_FLAG] = RegisterActivity.this.location.getLatitude() + BuildConfig.FLAVOR;
                    String manufacturer = Build.MANUFACTURER;
                    RLog.m86e(manufacturer);
                    if (manufacturer.equals("samsung")) {
                        if (VERSION.SDK_INT > 9) {
                            StrictMode.setThreadPolicy(new Builder().permitAll().build());
                        }
                        RegisterActivity.this.mEdtAddress.setText(CommonUtils.getCompleteAddressNomal(RegisterActivity.this.getApplicationContext(), RegisterActivity.this.location.getLatitude(), RegisterActivity.this.location.getLongitude()));
                        RegisterActivity.this.mEdtAddress.setFocusable(false);
                        return;
                    }
                    new GeoTask(new LatLng(RegisterActivity.this.location.getLatitude(), RegisterActivity.this.location.getLongitude())).execute(new Void[0]);
                }
            }
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.20 */
    class AnonymousClass20 implements Callback<AuthResponse> {
        final /* synthetic */ ParamRegUser val$ex;
        final /* synthetic */ String val$pass;

        AnonymousClass20(ParamRegUser paramRegUser, String str) {
            this.val$ex = paramRegUser;
            this.val$pass = str;
        }

        public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
            RegisterActivity.this.dialogProgress.hideDialog();
            if (response.isSuccessful()) {
                AuthResponse auth = (AuthResponse) response.body();
                if (auth.getData() != null) {
                    RLog.m86e(auth.getData().getName() + " - " + auth.getData().getEmail());
                    Intent intent = new Intent();
                    intent.putExtra(Constant.KEY_EMAIL, this.val$ex.getEmail());
                    intent.putExtra(Constant.KEY_PASS, this.val$pass);
                    RegisterActivity.this.setResult(-1, intent);
                    RegisterActivity.this.finish();
                    return;
                }
                AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.exist_acc)).show();
                return;
            }
            RLog.m86e(Integer.valueOf(response.code()));
            AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.exist_acc)).show();
        }

        public void onFailure(Call<AuthResponse> call, Throwable t) {
            RLog.m86e(t.getMessage());
            AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
            RegisterActivity.this.dialogProgress.hideDialog();
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.25 */
    class AnonymousClass25 implements Callback<ApiResponse<CheckResponse>> {
        final /* synthetic */ String val$pass;
        final /* synthetic */ User val$user;

        AnonymousClass25(User user, String str) {
            this.val$user = user;
            this.val$pass = str;
        }

        public void onResponse(Call<ApiResponse<CheckResponse>> call, Response<ApiResponse<CheckResponse>> response) {
            RegisterActivity.this.dialogProgress.hideDialog();
            if (response.isSuccessful()) {
                CheckResponse code = (CheckResponse) ((ApiResponse) response.body()).getData();
                if (code == null || !code.getCode().equals("NOT_FOUND_USER")) {
                    AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.exist_email)).show();
                    return;
                }
                RegisterActivity.this.mUser = this.val$user;
                RegisterActivity.this.mPass = this.val$pass;
                if (RegisterActivity.this.isUpdateAKProfile) {
                    RegisterActivity.this.updateAcountKitInfo(RegisterActivity.this.mPhone, RegisterActivity.this.mPass, RegisterActivity.this.umberService, RegisterActivity.this.mUser);
                    return;
                } else {
                    RegisterActivity.this.onLoginPhone(RegisterActivity.this.mEdtPhone.getText().toString());
                    return;
                }
            }
            RLog.m86e("Check user -" + response.code());
            AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<CheckResponse>> call, Throwable t) {
            RegisterActivity.this.dialogProgress.hideDialog();
            RLog.m86e("Check user -" + t.getMessage());
            AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.26 */
    class AnonymousClass26 implements Callback<ApiResponse<CheckResponse>> {
        final /* synthetic */ String val$pass;
        final /* synthetic */ User val$user;
        final /* synthetic */ String val$username;

        AnonymousClass26(User user, String str, String str2) {
            this.val$user = user;
            this.val$pass = str;
            this.val$username = str2;
        }

        public void onResponse(Call<ApiResponse<CheckResponse>> call, Response<ApiResponse<CheckResponse>> response) {
            RegisterActivity.this.dialogProgress.hideDialog();
            if (response.isSuccessful()) {
                CheckResponse code = (CheckResponse) ((ApiResponse) response.body()).getData();
                if (code == null || !code.getCode().equals("NOT_FOUND_USER")) {
                    AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.exist_phone)).show();
                    return;
                }
                RegisterActivity.this.mUser = this.val$user;
                RegisterActivity.this.mPass = this.val$pass;
                RegisterActivity.this.mPhone = this.val$username;
                RegisterActivity.this.checkEmail(this.val$user.getEmail(), this.val$user, this.val$pass);
                return;
            }
            RLog.m86e("Check user -" + response.code());
            AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<CheckResponse>> call, Throwable t) {
            RegisterActivity.this.dialogProgress.hideDialog();
            RLog.m86e("Check user -" + t.getMessage());
            AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.27 */
    class AnonymousClass27 implements Callback<ApiResponse<CheckResponse>> {
        final /* synthetic */ String val$pass;
        final /* synthetic */ User val$user;
        final /* synthetic */ String val$username;

        AnonymousClass27(User user, String str, String str2) {
            this.val$user = user;
            this.val$pass = str;
            this.val$username = str2;
        }

        public void onResponse(Call<ApiResponse<CheckResponse>> call, Response<ApiResponse<CheckResponse>> response) {
            RegisterActivity.this.dialogProgress.hideDialog();
            if (response.isSuccessful()) {
                CheckResponse code = (CheckResponse) ((ApiResponse) response.body()).getData();
                if (code == null || !code.getCode().equals("NOT_FOUND_USER")) {
                    AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.exist_phone)).show();
                    return;
                }
                RegisterActivity.this.mUser = this.val$user;
                RegisterActivity.this.mPass = this.val$pass;
                RegisterActivity.this.mPhone = this.val$username;
                if (RegisterActivity.this.isUpdateFacebook) {
                    RegisterActivity.this.updateFacebookInfo(RegisterActivity.this.mPhone, RegisterActivity.this.mPass, RegisterActivity.this.umberService, RegisterActivity.this.mUser);
                    return;
                } else {
                    RegisterActivity.this.signUp(RegisterActivity.this.mPhone, RegisterActivity.this.mPass, RegisterActivity.this.umberService, RegisterActivity.this.mUser);
                    return;
                }
            }
            RLog.m86e("Check user -" + response.code());
            AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<CheckResponse>> call, Throwable t) {
            RegisterActivity.this.dialogProgress.hideDialog();
            RLog.m86e("Check user -" + t.getMessage());
            AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.2 */
    class C13582 extends SimpleTarget<Bitmap> {
        C13582() {
        }

        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
            RegisterActivity.this.imgAvt.setImageBitmap(resource);
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.3 */
    class C13593 implements RequestListener<String, Bitmap> {
        C13593() {
        }

        public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
            RegisterActivity.this.imgAvt.setImageResource(R.drawable.ic_stat_onesignal_default);
            return false;
        }

        public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
            RegisterActivity.this.imgAvt.setImageBitmap(resource);
            return true;
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.4 */
    class C13604 extends SimpleTarget<Bitmap> {
        C13604() {
        }

        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
            RegisterActivity.this.imgAvt.setImageBitmap(resource);
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.5 */
    class C13615 implements RequestListener<String, Bitmap> {
        C13615() {
        }

        public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
            RegisterActivity.this.imgAvt.setImageResource(R.drawable.ic_stat_onesignal_default);
            return false;
        }

        public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
            RegisterActivity.this.imgAvt.setImageBitmap(resource);
            return true;
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.6 */
    class C13626 implements Callback<ResponseBody> {
        C13626() {
        }

        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful()) {
                RegisterActivity.this.mFileAvata = ApiUtils.writeResponseBodyToDisk((ResponseBody) response.body(), RegisterActivity.this, "pin.png");
                return;
            }
            RLog.m86e(Integer.valueOf(response.code()));
        }

        public void onFailure(Call<ResponseBody> call, Throwable t) {
            RLog.m86e(t.getMessage());
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.7 */
    class C13637 implements OnCountryChangeListener {
        C13637() {
        }

        public void onCountrySelected() {
            RegisterActivity.this.strContryCode = RegisterActivity.this.contryCode.getSelectedCountryNameCode();
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.8 */
    class C13648 implements OnFocusChangeListener {
        C13648() {
        }

        public void onFocusChange(View view, boolean b) {
            RegisterActivity.this.getWindow().setSoftInputMode(3);
            CommonUtils.hideKeyBroad(RegisterActivity.this, RegisterActivity.this.mEdtAddress);
        }
    }

    /* renamed from: com.umberapp.umber.activities.RegisterActivity.9 */
    class C13659 implements OnFocusChangeListener {
        C13659() {
        }

        public void onFocusChange(View view, boolean b) {
            if (!b) {
                if (RegisterActivity.this.mEdtPhone.getText().toString().equals(BuildConfig.FLAVOR)) {
                    RegisterActivity.this.tvInvalidPhone.setVisibility(0);
                } else {
                    RegisterActivity.this.tvInvalidPhone.setVisibility(8);
                }
            }
        }
    }

    class GeoTask extends AsyncTask<Void, Void, String> {
        LatLng f102l;

        public GeoTask(LatLng l) {
            this.f102l = l;
        }

        protected String doInBackground(Void... voids) {
            return CommonUtils.getCompleteAddressNomal(RegisterActivity.this.getApplicationContext(), this.f102l.latitude, this.f102l.longitude);
        }

        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null && !s.isEmpty()) {
                RegisterActivity.this.mEdtAddress.setText(s);
                RegisterActivity.this.mEdtAddress.setFocusable(false);
            }
        }
    }

    public RegisterActivity() {
        this.arrGender = new String[]{"Male", "Female"};
        this.receiver = new C13561();
        this.coordinates = new String[2];
        this.picResultListener = new PicResultListener() {

            /* renamed from: com.umberapp.umber.activities.RegisterActivity.21.1 */
            class C13571 extends BitmapCompressor {
                C13571(int x0) {
                    super(x0);
                }

                protected void onPostExecute(Bitmap[] bitmaps) {
                    RegisterActivity.this.mProgress.setVisibility(8);
                    RegisterActivity.this.mFileAvata = FileUtils.SaveImage(RegisterActivity.this, bitmaps[0]);
                    Image image = new Image();
                    image.setPhoto(Bitmap.createScaledBitmap(bitmaps[0], RegisterActivity.PLACE_AUTOCOMPLETE_REQUEST_CODE, RegisterActivity.PLACE_AUTOCOMPLETE_REQUEST_CODE, false));
                    if (RegisterActivity.this.mFileAvata != null && RegisterActivity.this.mFileAvata.exists()) {
                        RegisterActivity.this.imgAvt.setImageBitmap(Bitmap.createScaledBitmap(bitmaps[0], ApiConstants.CODE_SUCESS, ApiConstants.CODE_SUCESS, false));
                        RegisterActivity.this.btnRemovePhoto.setVisibility(0);
                        RegisterActivity.this.imgAvt.setVisibility(0);
                        image.setPath(RegisterActivity.this.mFileAvata.getPath());
                    }
                }
            }

            public void onPictureResult(Bitmap bitmap) {
                RLog.m86e("recieve photo");
                RegisterActivity.this.mProgress.setVisibility(0);
                RegisterActivity.this.llRootImage.setVisibility(0);
                C13571 c13571 = new C13571(ApiConstants.CODE_ERROR_SERVER);
                Bitmap[] bitmapArr = new Bitmap[RegisterActivity.PLACE_PICKER_FLAG];
                bitmapArr[0] = bitmap;
                c13571.execute(bitmapArr);
            }
        };
        this.cameraAppErrorListener = new CantFindCameraAppErrorListener() {
            public void cantFindCameraApp() {
                Toast.makeText(RegisterActivity.this, "Can't find the camera app", 0).show();
            }
        };
        this.fileForCameraListener = new ErrorCreatingTempFileForCameraListener() {
            public void errorCreatingTempFileForCamera() {
                Log.e(BuildConfig.FLAVOR, "errorCreatingTempFileForCamera: ");
                Toast.makeText(RegisterActivity.this, "Error starting camera", 0).show();
            }
        };
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_register);
        ButterKnife.bind((Activity) this);
        this.umberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        initView();
        getWindow().setSoftInputMode(3);
        AccountKit.initialize(getApplicationContext());
    }

    private void initView() {
        Intent i = getIntent();
        if (i != null) {
            Bundle b = i.getBundleExtra(Constant.KEY_BUNDLE);
            if (b != null) {
                this.userFromLogin = (User) b.getParcelable(Constant.KEY_USER);
                if (this.userFromLogin != null) {
                    AlertDialogCustom.dialogMsg(this, getString(R.string.non_exist_fb)).show();
                    this.isUpdateFacebook = true;
                    this.llRepass.setVisibility(0);
                    this.llPass.setVisibility(0);
                    if (this.userFromLogin.getAvatar() != null) {
                        if (this.userFromLogin.getAvatar().contains("http")) {
                            ((C13582) Glide.with((FragmentActivity) this).load(this.userFromLogin.getAvatar()).asBitmap().thumbnail(0.5f).listener(new C13593()).into(new C13582())).onLoadFailed(new IOException(), getResources().getDrawable(R.drawable.ic_stat_onesignal_default));
                        } else {
                            ((C13604) Glide.with((FragmentActivity) this).load(ApiConstants.API_PHOTO_ROOT + this.userFromLogin.getAvatar()).asBitmap().thumbnail(0.5f).listener(new C13615()).into(new C13604())).onLoadFailed(new IOException(), getResources().getDrawable(R.drawable.ic_stat_onesignal_default));
                        }
                        this.llRootImage.setVisibility(0);
                        this.btnRemovePhoto.setVisibility(0);
                        this.imgAvt.setVisibility(0);
                        this.umberService.downloadFilePin(this.userFromLogin.getAvatar()).enqueue(new C13626());
                    }
                    if (this.userFromLogin.getBirthday() != null) {
                        this.mEdtBirth.setText(this.userFromLogin.getBirthday());
                    }
                    if (this.userFromLogin.getFirst_name() != null) {
                        this.mEdtFirstName.setText(this.userFromLogin.getFirst_name());
                    }
                    if (this.userFromLogin.getLast_name() != null) {
                        this.mEdtLastName.setText(this.userFromLogin.getLast_name());
                    }
                    if (this.userFromLogin.getPhone() != null) {
                        this.mEdtPhone.setText("+" + this.userFromLogin.getPhone());
                        this.mEdtPhone.setEnabled(false);
                        this.contryCode.setVisibility(8);
                        this.isUpdateAKProfile = true;
                    }
                    if (this.userFromLogin.getEmail() != null) {
                        this.mEdtEmail.setText(this.userFromLogin.getEmail());
                    }
                }
            }
        }
        this.contryCode.setOnCountryChangeListener(new C13637());
        this.dialogProgress = new ProgressDialogCustom(this);
        this.picPicker = new PicPicker(this, this.picResultListener).setFileForCameraListener(this.fileForCameraListener).setCameraAppErrorListener(this.cameraAppErrorListener);
        this.adapter = new ArrayAdapter(this, R.layout.item_sp_gender, this.arrGender);
        this.adapter.setDropDownViewResource(17367049);
        this.mSpGender.setAdapter(this.adapter);
        this.mSpGender.setSelection(0);
        this.mGoogleApiClient = new GoogleApiClient.Builder(this).addApi(Places.GEO_DATA_API).build();
        this.mEdtAddress.setOnClickListener(this);
        this.mEdtAddress.setOnFocusChangeListener(new C13648());
        this.mEdtPhone.setOnFocusChangeListener(new C13659());
        this.mEdtPassword.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    if (RegisterActivity.this.mEdtPassword.getText().length() < 6) {
                        RegisterActivity.this.tvInvalidPass.setVisibility(0);
                    } else {
                        RegisterActivity.this.tvInvalidPass.setVisibility(8);
                    }
                }
            }
        });
        this.mEdtRePassword.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    if (RegisterActivity.this.mEdtRePassword.getText().toString().equals(RegisterActivity.this.mEdtPassword.getText().toString())) {
                        RegisterActivity.this.tvInvalidRepeat.setVisibility(8);
                    } else {
                        RegisterActivity.this.tvInvalidRepeat.setVisibility(0);
                    }
                }
            }
        });
        this.mEdtFirstName.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    if (RegisterActivity.this.mEdtFirstName.getText().toString().isEmpty()) {
                        RegisterActivity.this.tvInvalidFirst.setVisibility(0);
                    } else {
                        RegisterActivity.this.tvInvalidFirst.setVisibility(8);
                    }
                }
            }
        });
        this.mEdtLastName.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    if (RegisterActivity.this.mEdtLastName.getText().toString().isEmpty()) {
                        RegisterActivity.this.tvInvalidLastname.setVisibility(0);
                    } else {
                        RegisterActivity.this.tvInvalidLastname.setVisibility(8);
                    }
                }
            }
        });
        this.mEdtAddress.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    if (RegisterActivity.this.mEdtAddress.getText().toString().isEmpty()) {
                        RegisterActivity.this.tvInvalidAddress.setVisibility(0);
                    } else {
                        RegisterActivity.this.tvInvalidAddress.setVisibility(8);
                    }
                }
            }
        });
        this.mEdtEmail.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    if (RegisterActivity.this.mEdtEmail.getText().toString().isEmpty() || !RegisterActivity.this.mEdtEmail.getText().toString().contains("@")) {
                        RegisterActivity.this.tvInvalidEmail.setVisibility(0);
                    } else {
                        RegisterActivity.this.tvInvalidEmail.setVisibility(8);
                    }
                }
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /*2131689701*/:
                finish();
            case R.id.edt_address /*2131689716*/:
                try {
                    this.builder = new IntentBuilder();
                    startActivityForResult(this.builder.build(this), PLACE_PICKER_FLAG);
                } catch (GooglePlayServicesRepairableException e) {
                    GooglePlayServicesUtil.getErrorDialog(e.getConnectionStatusCode(), this, 0);
                } catch (GooglePlayServicesNotAvailableException e2) {
                    Toast.makeText(this, R.string.service_not_avalable, PLACE_PICKER_FLAG).show();
                }
            case R.id.edt_birth /*2131689720*/:
                getWindow().setSoftInputMode(3);
                DatePickerDialog date = DatePickerDialog.newInstance(new OnDateSetListener() {
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        RegisterActivity.this.mEdtBirth.setText(String.format("%02d/%02d/%02d", new Object[]{Integer.valueOf(monthOfYear + RegisterActivity.PLACE_PICKER_FLAG), Integer.valueOf(dayOfMonth), Integer.valueOf(year)}));
                    }
                }, 2016, PLACE_PICKER_FLAG, PLACE_PICKER_FLAG);
                date.setAccentColor(getResources().getColor(R.color.colorPrimary));
                date.setMaxDate(Calendar.getInstance());
                date.show(getFragmentManager(), "date");
            case R.id.btn_remove_photo /*2131689725*/:
                if (this.mFileAvata != null) {
                    this.mFileAvata.delete();
                    this.mFileAvata = null;
                }
                this.btnRemovePhoto.setVisibility(8);
                this.imgAvt.setVisibility(8);
                this.llRootImage.setVisibility(8);
            case R.id.btn_photo /*2131689726*/:
                PhotoPicker.builder().setPhotoCount(PLACE_PICKER_FLAG).setShowCamera(true).setShowGif(true).setPreviewEnabled(true).start((Activity) this, PhotoPicker.REQUEST_CODE);
            case R.id.tv_term /*2131689728*/:
                AlertDialogCustom.dialogTerm(this).show();
            case R.id.btn_register /*2131689729*/:
                CommonUtils.hideKeyBroad(this, this.mEdtPassword);
                String phone = this.mEdtPhone.getText().toString();
                String pass = this.mEdtPassword.getText().toString();
                String repass = this.mEdtRePassword.getText().toString();
                String email = this.mEdtEmail.getText().toString();
                String bith = this.mEdtBirth.getText().toString();
                String firstName = this.mEdtFirstName.getText().toString();
                String lastname = this.mEdtLastName.getText().toString();
                String address = this.mEdtAddress.getText().toString();
                String ref = this.mEdtRef.getText().toString();
                String gender = this.arrGender[this.mSpGender.getSelectedItemPosition()];
                if (phone.isEmpty()) {
                    AlertDialogCustom.dialogMsg(this, getString(R.string.please_enter_phone)).show();
                } else if (pass.isEmpty()) {
                    AlertDialogCustom.dialogMsg(this, getString(R.string.enter_pass)).show();
                } else if (pass.length() < 6) {
                    AlertDialogCustom.dialogMsg(this, getString(R.string.pass_incorrectly)).show();
                } else if (!pass.equals(repass)) {
                    AlertDialogCustom.dialogMsg(this, getString(R.string.repass_incorrectly)).show();
                } else if (firstName.isEmpty()) {
                    AlertDialogCustom.dialogMsg(this, getString(R.string.please_enter_firstname)).show();
                } else if (lastname.isEmpty()) {
                    AlertDialogCustom.dialogMsg(this, getString(R.string.please_enter_last_name)).show();
                } else if (address.isEmpty()) {
                    AlertDialogCustom.dialogMsg(this, getString(R.string.please_enter_address)).show();
                } else if (email.isEmpty()) {
                    AlertDialogCustom.dialogMsg(this, getString(R.string.please_enter_email)).show();
                } else {
                    if (!email.contains("@")) {
                        AlertDialogCustom.dialogMsg(this, getString(R.string.emaill_incorrectly)).show();
                    } else if (gender.isEmpty()) {
                        AlertDialogCustom.dialogMsg(this, getString(R.string.please_enter_gender)).show();
                    } else {
                        if (this.mCb.isChecked()) {
                            UmberService umberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
                            User user = new User();
                            user.setLast_name(lastname);
                            user.setFirst_name(firstName);
                            user.setAddress(address);
                            user.setEmail(email);
                            user.setPhone(phone);
                            user.setGender(gender);
                            user.setCustomer(true);
                            user.setPassword(pass);
                            if (this.userFromLogin != null) {
                                user.setId(this.userFromLogin.getId());
                                user.setToken(this.userFromLogin.getToken());
                            }
                            if (!bith.isEmpty()) {
                                user.setBirthday(CommonUtils.convertToSec2(bith, StringUtil.DATE_FORMAT_7) + BuildConfig.FLAVOR);
                            }
                            this.dialogProgress.showDialog();
                            if (this.mFileAvata != null) {
                                if (this.mFileAvata.exists()) {
                                    RequestBody requestFile = RequestBody.create(MediaType.parse(MainActivity.MULTIPART_FORM_DATA), this.mFileAvata);
                                    Part body = Part.createFormData(ApiConstants.KEY_FILE, this.mFileAvata.getName(), requestFile);
                                    umberService.uploadAvtPhotos(body).enqueue(new AnonymousClass17(user, phone, pass));
                                    return;
                                }
                            }
                            checkUsernameToSignUp(phone, user, pass);
                            return;
                        }
                        AlertDialogCustom.dialogMsg(this, getString(R.string.no_check)).show();
                    }
                }
            default:
        }
    }

    private void updateAcountKitInfo(String phone, String pass, UmberService umberService, User user) {
        umberService.updateInfoAKReg(user.getToken(), user.getFirst_name(), user.getLast_name(), user.getAddress(), user.getGender(), user.getBirthday(), user.getAvatar(), user.getEmail(), pass).enqueue(new AnonymousClass18(user));
    }

    private void updateFacebookInfo(String phone, String pass, UmberService umberService, User user) {
        umberService.updateInfoReg(user.getToken(), user.getFirst_name(), user.getLast_name(), user.getAddress(), user.getGender(), user.getBirthday(), user.getAvatar(), user.getEmail(), phone, pass).enqueue(new Callback<ApiResponse<User>>() {
            public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
                if (response.isSuccessful()) {
                    User auth = (User) ((ApiResponse) response.body()).getData();
                    RLog.m86e(auth.getId());
                    if (auth != null) {
                        RegisterActivity.this.setResult(RegisterActivity.PLACE_PICKER_FLAG);
                        RegisterActivity.this.finish();
                        return;
                    }
                    AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
                    return;
                }
                RLog.m86e(Integer.valueOf(response.code()));
                AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
            }

            public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
                RLog.m86e(t.getMessage());
                AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
                RegisterActivity.this.dialogProgress.hideDialog();
            }
        });
    }

    private void signUp(String phone, String pass, UmberService umberService, User user) {
        if (!(this.dialogProgress == null || this.dialogProgress.isShowing())) {
            this.dialogProgress.showDialog();
        }
        ParamRegUser ex = new ParamRegUser();
        ex.setPhone(phone);
        ex.setPassword(user.getPassword());
        ex.setFirst_name(user.getFirst_name());
        ex.setLast_name(user.getLast_name());
        ex.setAddress(user.getAddress());
        ex.setEmail(user.getEmail());
        ex.setBirthday(user.getBirthday());
        ex.setGender(user.getGender());
        ex.setAvatar(user.getAvatar());
        ex.setCoordinates("[\"" + this.coordinates[0] + "\"," + "\"" + this.coordinates[PLACE_PICKER_FLAG] + "\"]");
        umberService.register(ex).enqueue(new AnonymousClass20(ex, pass));
    }

    protected void onResume() {
        super.onResume();
        this.mProgress.setVisibility(8);
        registerReceiver(this.receiver, new IntentFilter(EtaxiService.ACTION_LOCATION_UPDATE));
    }

    protected void onStart() {
        super.onStart();
        this.mGoogleApiClient.connect();
        startService(new Intent(this, EtaxiService.class));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mGoogleApiClient.disconnect();
        stopService(new Intent(this, EtaxiService.class));
        try {
            unregisterReceiver(this.receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!this.picPicker.onActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == PLACE_PICKER_FLAG) {
            if (resultCode == -1) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                RLog.m86e(place.toString());
                this.mEdtAddress.setText(place.getAddress());
                this.coordinates[0] = place.getLatLng().longitude + BuildConfig.FLAVOR;
                this.coordinates[PLACE_PICKER_FLAG] = place.getLatLng().latitude + BuildConfig.FLAVOR;
                this.isFixed = true;
            } else if (resultCode == 2) {
                RLog.m86e(PlaceAutocomplete.getStatus(this, data).getStatusMessage());
            } else if (resultCode == 0) {
            }
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
                AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
                    public void onSuccess(Account account) {
                        RegisterActivity.this.mPhone = "+" + account.getPhoneNumber().getRawPhoneNumber();
                        RegisterActivity.this.checkPhoneFromAK(RegisterActivity.this.mPhone, RegisterActivity.this.mUser, RegisterActivity.this.mPass);
                    }

                    public void onError(AccountKitError accountKitError) {
                        AlertDialogCustom.dialogMsg(RegisterActivity.this, RegisterActivity.this.getString(R.string.unknow_error)).show();
                        RLog.m86e("Error get phone AK " + accountKitError.getUserFacingMessage());
                    }
                });
            } else {
                Object[] objArr = new Object[PLACE_PICKER_FLAG];
                objArr[0] = loginResult.getAuthorizationCode().substring(0, 10);
                String.format("Success:%s...", objArr);
            }
        }
        if (resultCode == -1 && requestCode == 233 && data != null) {
            File newFile = new File((String) data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS).get(0));
            if (newFile != null && newFile.exists()) {
                CropImage.activity(Uri.fromFile(newFile)).setGuidelines(Guidelines.ON).setRequestedSize(ApiConstants.CODE_SUCESS, ApiConstants.CODE_SUCESS).setAspectRatio(PLACE_PICKER_FLAG, PLACE_PICKER_FLAG).start(this);
            }
        }
        if (requestCode == 203) {
            ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == -1) {
                this.mFileAvata = new File(result.getUri().getPath());
                this.imgAvt.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeFile(this.mFileAvata.getPath()), PLACE_AUTOCOMPLETE_REQUEST_CODE, PLACE_AUTOCOMPLETE_REQUEST_CODE, false));
                Glide.with((FragmentActivity) this).load(this.mFileAvata).into(this.imgAvt).onLoadFailed(new IOException(), getResources().getDrawable(R.drawable.ic_stat_onesignal_default));
                this.mProgress.setVisibility(8);
                this.llRootImage.setVisibility(0);
                this.btnRemovePhoto.setVisibility(0);
                this.imgAvt.setVisibility(0);
            } else if (resultCode == 204) {
                result.getError();
            }
        }
    }

    public void onRespone(Integer object) {
    }

    static {
        APP_REQUEST_CODE = 99;
    }

    public void onLoginPhone(String phone) {
        Intent intent = new Intent(this, AccountKitActivity.class);
        AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder = new AccountKitConfiguration.AccountKitConfigurationBuilder(LoginType.PHONE, AccountKitActivity.ResponseType.TOKEN);
        configurationBuilder.setDefaultCountryCode(this.strContryCode);
        configurationBuilder.setInitialPhoneNumber(new PhoneNumber(getResources().getConfiguration().locale.getCountry(), phone));
        intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION, configurationBuilder.build());
        startActivityForResult(intent, APP_REQUEST_CODE);
    }

    void checkEmail(String username, User user, String pass) {
        this.dialogProgress.showDialog();
        this.umberService.checkUsername(username).enqueue(new AnonymousClass25(user, pass));
    }

    void checkUsernameToSignUp(String username, User user, String pass) {
        this.dialogProgress.showDialog();
        this.umberService.checkUsername(this.contryCode.getSelectedCountryCodeWithPlus() + username).enqueue(new AnonymousClass26(user, pass, username));
    }

    void checkPhoneFromAK(String username, User user, String pass) {
        this.dialogProgress.showDialog();
        this.umberService.checkUsername(username).enqueue(new AnonymousClass27(user, pass, username));
    }
}
