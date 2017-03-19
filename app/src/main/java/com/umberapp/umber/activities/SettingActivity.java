package com.umberapp.umber.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.brunodles.compressor.BitmapCompressor;
import com.github.brunodles.pic_picker.PicPicker;
import com.github.brunodles.pic_picker.listener.CantFindCameraAppErrorListener;
import com.github.brunodles.pic_picker.listener.ErrorCreatingTempFileForCameraListener;
import com.github.brunodles.pic_picker.listener.PicResultListener;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlacePicker.IntentBuilder;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.plus.Plus;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.entities.Profile.Properties;
import com.sromku.simple.fb.listeners.OnLoginListener;
import com.sromku.simple.fb.utils.Attributes;
import com.sromku.simple.fb.utils.PictureAttributes;
import com.sromku.simple.fb.utils.PictureAttributes.PictureType;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImage.ActivityResult;
import com.theartofdev.edmodo.cropper.CropImageView.Guidelines;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.fragments.ChangePasswordFragment;
import com.umberapp.umber.instagram.InstagramApp;
import com.umberapp.umber.instagram.InstagramApp.OAuthAuthenticationListener;
import com.umberapp.umber.models.ExpertBit;
import com.umberapp.umber.models.Image;
import com.umberapp.umber.models.User;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.FileUtils;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.utils.SharedPref;
import com.umberapp.umber.utils.StringUtil;
import com.umberapp.umber.views.AlertDialogCustom;
import com.umberapp.umber.views.ProgressDialogCustom;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

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

public class SettingActivity extends BaseActivity implements OnClickListener, OnConnectionFailedListener {
    public static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 100;
    private static final int PLACE_PICKER_FLAG = 1;
    private static final int RC_SIGN_IN = 100;
    ArrayAdapter<String> adapter;
    final String[] arrGender;
    @Bind({2131689826})
    CardView btnOk;
    private IntentBuilder builder;
    private CantFindCameraAppErrorListener cameraAppErrorListener;
    ProgressDialogCustom dialogProgress;
    private ErrorCreatingTempFileForCameraListener fileForCameraListener;
    @Bind({2131689821})
    CircleImageView imgAvt;
    OAuthAuthenticationListener listener;
    @Bind({2131689681})
    RelativeLayout llroot;
    InstagramApp mApp;
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
    @Bind({2131689705})
    EditText mEdtPhone;
    private File mFileAvata;
    FragmentManager mFragmentManager;
    GoogleApiClient mGoogleApiClient;
    @Bind({2131689722})
    AppCompatSpinner mSpGender;
    private UmberService mUmberService;
    private PicPicker picPicker;
    private PicResultListener picResultListener;
    @Bind({2131689822})
    ProgressBar progressBar;
    @Bind({2131689825})
    TextView tvBalance;
    @Bind({2131689824})
    TextView tvName;
    private User user;

    /* renamed from: com.umberapp.umber.activities.SettingActivity.1 */
    class C13661 implements OAuthAuthenticationListener {
        C13661() {
        }

        public void onSuccess() {
            if (SettingActivity.this.mApp.hasAccessToken()) {
                SettingActivity.this.linkToIns(SettingActivity.this.mApp.getmAccessToken());
            } else {
                Toast.makeText(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error), Toast.LENGTH_SHORT).show();
            }
        }

        public void onFail(String error) {
            Toast.makeText(SettingActivity.this, error, Toast.LENGTH_SHORT).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.SettingActivity.2 */
    class C13672 implements ConnectionCallbacks {
        C13672() {
        }

        public void onConnected(@Nullable Bundle bundle) {
            RLog.m86e("onConnected");
        }

        public void onConnectionSuspended(int i) {
            RLog.m86e("onConnectionSuspended");
        }
    }

    /* renamed from: com.umberapp.umber.activities.SettingActivity.3 */
    class C13693 implements PicResultListener {

        /* renamed from: com.umberapp.umber.activities.SettingActivity.3.1 */
        class C13681 extends BitmapCompressor {
            C13681(int x0) {
                super(x0);
            }

            protected void onPostExecute(Bitmap[] bitmaps) {
                SettingActivity.this.progressBar.setVisibility(View.GONE);
                SettingActivity.this.mFileAvata = FileUtils.SaveImage(SettingActivity.this, bitmaps[0]);
                Image image = new Image();
                image.setPhoto(bitmaps[0]);
                if (SettingActivity.this.mFileAvata != null && SettingActivity.this.mFileAvata.exists()) {
                    SettingActivity.this.imgAvt.setImageBitmap(Bitmap.createScaledBitmap(bitmaps[0], SettingActivity.RC_SIGN_IN, SettingActivity.RC_SIGN_IN, false));
                    SettingActivity.this.imgAvt.setVisibility(View.VISIBLE);
                    image.setPath(SettingActivity.this.mFileAvata.getPath());
                }
            }
        }

        C13693() {
        }

        public void onPictureResult(Bitmap bitmap) {
            RLog.m86e("recieve photo");
            SettingActivity.this.progressBar.setVisibility(View.VISIBLE);
            C13681 c13681 = new C13681(SettingActivity.RC_SIGN_IN);
            Bitmap[] bitmapArr = new Bitmap[SettingActivity.PLACE_PICKER_FLAG];
            bitmapArr[0] = bitmap;
            c13681.execute(bitmapArr);
        }
    }

    /* renamed from: com.umberapp.umber.activities.SettingActivity.4 */
    class C13704 implements CantFindCameraAppErrorListener {
        C13704() {
        }

        public void cantFindCameraApp() {
            Toast.makeText(SettingActivity.this, "Can't find the camera app", Toast.LENGTH_SHORT).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.SettingActivity.5 */
    class C13715 implements ErrorCreatingTempFileForCameraListener {
        C13715() {
        }

        public void errorCreatingTempFileForCamera() {
            Log.e(BuildConfig.FLAVOR, "errorCreatingTempFileForCamera: ");
            Toast.makeText(SettingActivity.this, "Error starting camera", Toast.LENGTH_SHORT).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.SettingActivity.6 */
    class C13726 implements OnDateSetListener {
        C13726() {
        }

        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
            SettingActivity.this.mEdtBirth.setText(dayOfMonth + "/" + (monthOfYear + SettingActivity.PLACE_PICKER_FLAG) + "/" + year);
        }
    }

    /* renamed from: com.umberapp.umber.activities.SettingActivity.7 */
    class C13737 implements Callback<ApiResponse<String>> {
        C13737() {
        }

        public void onResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {
            if (response.isSuccessful()) {
                try {
                    if (((ApiResponse) response.body()).getData() != null) {
                        SettingActivity.this.user.setAvatar((String) ((ApiResponse) response.body()).getData());
                        SettingActivity.this.signUp(SettingActivity.this.mUmberService, SettingActivity.this.user);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    SettingActivity.this.signUp(SettingActivity.this.mUmberService, SettingActivity.this.user);
                    return;
                }
            }
            SettingActivity.this.signUp(SettingActivity.this.mUmberService, SettingActivity.this.user);
        }

        public void onFailure(Call<ApiResponse<String>> call, Throwable t) {
            SettingActivity.this.signUp(SettingActivity.this.mUmberService, SettingActivity.this.user);
        }
    }

    /* renamed from: com.umberapp.umber.activities.SettingActivity.8 */
    class C13748 implements Callback<ApiResponse<User>> {
        final /* synthetic */ User val$user;

        C13748(User user) {
            this.val$user = user;
        }

        public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
            if (!response.isSuccessful()) {
                SettingActivity.this.dialogProgress.hideDialog();
                RLog.m86e(Integer.valueOf(response.code()));
                AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error)).show();
            } else if (((ApiResponse) response.body()).getData() != null) {
                RLog.m86e(((ApiResponse) response.body()).toString());
                SettingActivity.this.getProfile(this.val$user.getToken());
            } else {
                SettingActivity.this.dialogProgress.hideDialog();
                AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error)).show();
            }
        }

        public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
            RLog.m86e(t.getMessage());
            AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error)).show();
            SettingActivity.this.dialogProgress.hideDialog();
        }
    }

    /* renamed from: com.umberapp.umber.activities.SettingActivity.9 */
    class C13759 implements Callback<ApiResponse<User>> {
        final /* synthetic */ String val$userString;

        C13759(String str) {
            this.val$userString = str;
        }

        public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
            SettingActivity.this.dialogProgress.hideDialog();
            if (response.isSuccessful()) {
                User user = (User) ((ApiResponse) response.body()).getData();
                user.setToken(this.val$userString);
                AppController.getInstance().setUser(user);
                SettingActivity.this.saveUserInfor((User) ((ApiResponse) response.body()).getData());
                Toast.makeText(SettingActivity.this, SettingActivity.this.getString(R.string.update_success), Toast.LENGTH_SHORT).show();
                SettingActivity.this.setResult(-1);
                SettingActivity.this.finish();
                return;
            }
            RLog.m86e(Integer.valueOf(response.code()));
            AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
            SettingActivity.this.dialogProgress.hideDialog();
            RLog.m86e(t.getMessage());
            AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error)).show();
        }
    }

    class GeoTask extends AsyncTask<LatLng, Void, String> {
        GeoTask() {
        }

        protected String doInBackground(LatLng... latLngs) {
            LatLng latLng = latLngs[0];
            return CommonUtils.getCompleteAddressString(SettingActivity.this.getApplicationContext(), latLng.latitude, latLng.longitude);
        }

        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            SettingActivity.this.mEdtAddress.setText(s);
        }
    }

    class GetTokenTask extends AsyncTask<Void, Void, String> {
        public GetTokenTask() {
            SettingActivity.this.dialogProgress.showDialog();
        }

        protected String doInBackground(Void... voids) {
            String ace = BuildConfig.FLAVOR;
            String SCOPES = "https://www.googleapis.com/auth/userinfo.profile";
            try {
                if (ContextCompat.checkSelfPermission(SettingActivity.this, "android.permission.GET_ACCOUNTS") != 0) {
                    Toast.makeText(SettingActivity.this, SettingActivity.this.getString(R.string.permission_message), Toast.LENGTH_SHORT).show();
                    return null;
                }
                ace = GoogleAuthUtil.getToken(SettingActivity.this.getApplicationContext(), Plus.AccountApi.getAccountName(SettingActivity.this.mGoogleApiClient), "oauth2:https://www.googleapis.com/auth/userinfo.profile");
                Log.i(BuildConfig.FLAVOR, "mustafa olll " + ace);
                return ace;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GoogleAuthException e2) {
                e2.printStackTrace();
            }
            return ace;
        }

        protected void onPostExecute(String s) {
            SettingActivity.this.dialogProgress.hideDialog();
            super.onPostExecute(s);
            String tokenAccess = s;
            RLog.m86e("Token access GG =" + tokenAccess);
            if (tokenAccess == null || tokenAccess.isEmpty()) {
                AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unable_access_google)).show();
            } else {
                SettingActivity.this.linkToGG(tokenAccess);
            }
        }
    }

    public SettingActivity() {
        this.arrGender = new String[]{"Male", "Female"};
        this.listener = new C13661();
        this.picResultListener = new C13693();
        this.cameraAppErrorListener = new C13704();
        this.fileForCameraListener = new C13715();
    }

    void startToFragment(ExpertBit expertBit) {
    }

    void finishOrder() {
    }

    void unreadNotification(int count) {
    }

    void trackExpert(String lat, String l) {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_setting);
        ButterKnife.bind((Activity) this);
        this.mUmberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        initView();
        getWindow().setSoftInputMode(3);
        this.mApp = new InstagramApp(this, "1c574942ea664a1095f903251f7c414f", "904159d085f0415aaf6d8bd6a996d6d6", "https://umberus.com", getSupportFragmentManager());
        this.mApp.setListener(this.listener);
        this.mGoogleApiClient = new Builder(this).addApi(Plus.API).addConnectionCallbacks(new C13672()).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestServerAuthCode(getString(R.string.key_api_gplus)).requestScopes(new Scope(Scopes.PLUS_LOGIN), new Scope[0]).requestProfile().requestIdToken(getString(R.string.key_api_gplus)).build()).build();
    }

    public void trantoTab(Fragment tab) {
        this.mFragmentManager.beginTransaction().replace(R.id.contentview, tab).addToBackStack(null).commit();
        CommonUtils.disable(this.llroot);
    }

    void initView() {
        this.mFragmentManager = getSupportFragmentManager();
        this.view = this.llroot;
        this.dialogProgress = new ProgressDialogCustom(this);
        this.user = AppController.getInstance().getUser();
        if (this.user != null) {
            if (!(this.user.getAvatar() == null || this.user.getAvatar().isEmpty())) {
                Picasso.with(this).load(ApiConstants.API_MEDIA_ROOT + this.user.getAvatar()).resize(RC_SIGN_IN, RC_SIGN_IN).error(getResources().getDrawable(R.drawable.ic_stat_onesignal_default)).into(this.imgAvt);
                Glide.with((FragmentActivity) this).load(ApiConstants.API_MEDIA_ROOT + this.user.getAvatar()).thumbnail(0.5f).into(this.imgAvt).onLoadFailed(new IOException(), getResources().getDrawable(R.drawable.ic_stat_onesignal_default));
            }
            this.tvName.setText(this.user.getFirst_name() + " " + this.user.getLast_name());
            TextView textView = this.tvBalance;
            String string = getString(R.string.you_have_);
            Object[] objArr = new Object[PLACE_PICKER_FLAG];
            objArr[0] = AppController.getInstance().getAppConfig().getCurrency() + this.user.getBalance();
            textView.setText(String.format(string, objArr));
            this.mEdtAddress.setText(this.user.getAddress());
            this.mEdtEmail.setText(this.user.getEmail());
            this.mEdtFirstName.setText(this.user.getFirst_name());
            this.mEdtLastName.setText(this.user.getLast_name());
            this.mEdtPhone.setText(this.user.getPhone());
            if (!(this.user.getBirthday() == null || this.user.getBirthday().isEmpty())) {
                this.mEdtBirth.setText(CommonUtils.getDate(Long.parseLong(this.user.getBirthday()), StringUtil.DATE_FORMAT_7));
            }
            this.adapter = new ArrayAdapter(this, R.layout.item_sp_update_gender, this.arrGender);
            this.adapter.setDropDownViewResource(17367049);
            this.mSpGender.setAdapter(this.adapter);
            if (this.user.getGender() == null || !this.user.getGender().equals(this.arrGender[0])) {
                this.mSpGender.setSelection(PLACE_PICKER_FLAG);
            } else {
                this.mSpGender.setSelection(0);
            }
        }
        this.picPicker = new PicPicker(this, this.picResultListener).setFileForCameraListener(this.fileForCameraListener).setCameraAppErrorListener(this.cameraAppErrorListener);
        this.mGoogleApiClient = new Builder(this).addApi(Places.GEO_DATA_API).build();
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
            } else if (resultCode == 2) {
                RLog.m86e(PlaceAutocomplete.getStatus(this, data).getStatusMessage());
            } else if (resultCode == 0) {
            }
        }
        if (resultCode == -1 && requestCode == PhotoPicker.REQUEST_CODE && data != null) {
            File newFile = new File((String) data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS).get(0));
            if (newFile != null && newFile.exists()) {
                CropImage.activity(Uri.fromFile(newFile)).setGuidelines(Guidelines.ON).setRequestedSize(ApiConstants.CODE_SUCESS, ApiConstants.CODE_SUCESS).setAspectRatio(PLACE_PICKER_FLAG, PLACE_PICKER_FLAG).start(this);
            }
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == -1) {
                this.mFileAvata = new File(result.getUri().getPath());
                this.imgAvt.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeFile(this.mFileAvata.getPath()), RC_SIGN_IN, RC_SIGN_IN, false));
                Glide.with((FragmentActivity) this).load(this.mFileAvata).into(this.imgAvt).onLoadFailed(new IOException(), getResources().getDrawable(R.drawable.ic_stat_onesignal_default));
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                result.getError();
            }
        }
        if (requestCode == RC_SIGN_IN) {
            handleSignInResult(Auth.GoogleSignInApi.getSignInResultFromIntent(data));
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d("Login GG Result", "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            String token = result.getSignInAccount().getIdToken();
            new GetTokenTask().execute(new Void[0]);
            return;
        }
        RLog.m86e("loginResult unsuccess!");
        result.getStatus();
        AlertDialogCustom.dialogMsg(this, getString(R.string.unknow_error)).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back /*2131689670*/:
                finish();
            case R.id.fb /*2131689673*/:
                signInFacebook();
            case R.id.ins /*2131689674*/:
                if (this.mApp.hasAccessToken()) {
                    RLog.m89w("token - inst = " + this.mApp.getmAccessToken());
                    linkToIns(this.mApp.getmAccessToken());
                    return;
                }
                this.mApp.authorize();
            case R.id.gg /*2131689675*/:
                signInGoogle();
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
                DatePickerDialog date = DatePickerDialog.newInstance(new C13726(), 2016, PLACE_PICKER_FLAG, PLACE_PICKER_FLAG);
                date.setMaxDate(Calendar.getInstance());
                date.setAccentColor(getResources().getColor(R.color.colorPrimary));
                date.show(getFragmentManager(), "date");
            case R.id.btn_change_pass /*2131689730*/:
                trantoTab(new ChangePasswordFragment());
            case R.id.profilePic /*2131689821*/:
                PhotoPicker.builder().setPhotoCount(PLACE_PICKER_FLAG).setShowCamera(true).setShowGif(true).setPreviewEnabled(true).start((Activity) this, (int) PhotoPicker.REQUEST_CODE);
            case R.id.ll_ok /*2131689826*/:
                this.user.setFirst_name(this.mEdtFirstName.getText().toString());
                this.user.setLast_name(this.mEdtLastName.getText().toString());
                this.user.setFirst_name(this.mEdtFirstName.getText().toString());
                this.user.setFirst_name(this.mEdtFirstName.getText().toString());
                this.user.setAddress(this.mEdtAddress.getText().toString());
                if (this.mEdtBirth.getText().length() > 0) {
                    this.user.setBirthday(CommonUtils.convertToSec2(this.mEdtBirth.getText().toString(), StringUtil.DATE_FORMAT_7) + BuildConfig.FLAVOR);
                }
                this.user.setGender(this.arrGender[this.mSpGender.getSelectedItemPosition()]);
                this.dialogProgress.showDialog();
                if (this.mFileAvata == null || !this.mFileAvata.exists()) {
                    signUp(this.mUmberService, this.user);
                    return;
                }
                this.mUmberService.uploadPhotos(Part.createFormData(ApiConstants.KEY_FILE, this.mFileAvata.getName(), RequestBody.create(MediaType.parse(MainActivity.MULTIPART_FORM_DATA), this.mFileAvata))).enqueue(new C13737());
            default:
        }
    }

    private void signUp(UmberService umberService, User user) {
        String token = SharedPref.getInstance(this).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
        RLog.m86e(token);
        umberService.updateInfo(token, user.getFirst_name(), user.getLast_name(), user.getAddress(), user.getGender(), user.getBirthday(), user.getAvatar()).enqueue(new C13748(user));
    }

    public void onBackPressed() {
        super.onBackPressed();
        CommonUtils.enable(this.llroot);
    }

    public void getProfile(String userString) {
        if (!(this.dialogProgress == null || this.dialogProgress.isShowing())) {
            this.dialogProgress.showDialog();
        }
        RLog.m85d("token = " + userString);
        this.mUmberService.getInfor(userString).enqueue(new C13759(userString));
    }

    private void saveUserInfor(User data) {
        SharedPref.getInstance(this).putString(Constant.KEY_USER, new Gson().toJson((Object) data));
        SharedPref.getInstance(this).putString(Constant.KEY_TOKEN, data.getToken());
    }

    protected void onStart() {
        super.onStart();
        this.mGoogleApiClient.connect();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mGoogleApiClient.disconnect();
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    private void signInGoogle() {
        startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(this.mGoogleApiClient), RC_SIGN_IN);
    }

    private void linkToGG(String tokenAccess) {
        String token = SharedPref.getInstance(this).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
        if (!token.isEmpty()) {
            this.dialogProgress.showDialog();
            this.mUmberService.linkSocial(token, "connect-google", tokenAccess).enqueue(new Callback<ResponseBody>() {
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    SettingActivity.this.dialogProgress.hideDialog();
                    if (response.isSuccessful()) {
                        Toast.makeText(SettingActivity.this, SettingActivity.this.getString(R.string.success), 0).show();
                    } else {
                        AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error)).show();
                    }
                }

                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    SettingActivity.this.dialogProgress.hideDialog();
                    AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error)).show();
                    RLog.m86e(t.getMessage());
                }
            });
        }
    }

    private void signInFacebook() {
        this.simpleFacebook.login(new OnLoginListener() {
            public void onLogin(String accessToken, List<Permission> list, List<Permission> list2) {
                if (accessToken != null && !accessToken.isEmpty()) {
                    PictureAttributes pictureAttributes = Attributes.createPictureAttributes();
                    pictureAttributes.setHeight(ApiConstants.CODE_ERROR_SERVER);
                    pictureAttributes.setWidth(ApiConstants.CODE_ERROR_SERVER);
                    pictureAttributes.setType(PictureType.SQUARE);
                    Properties properties = new Properties.Builder().add(Properties.PICTURE, pictureAttributes).add(ApiConstants.KEY_BIRTH).build();
                    SettingActivity.this.linkFacebook(accessToken);
                }
            }

            public void onCancel() {
                RLog.m86e("ex cancel");
            }

            public void onException(Throwable throwable) {
                RLog.m86e("ex fb" + throwable.getMessage());
            }

            public void onFail(String reason) {
                RLog.m86e("fail fb" + reason);
            }
        });
    }

    private void linkFacebook(String tokenFacebook) {
        String token = SharedPref.getInstance(this).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
        if (!token.isEmpty()) {
            this.dialogProgress.showDialog();
            this.mUmberService.linkSocial(token, "connect-facebook", tokenFacebook).enqueue(new Callback<ResponseBody>() {
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    SettingActivity.this.dialogProgress.hideDialog();
                    if (response.isSuccessful()) {
                        Toast.makeText(SettingActivity.this, SettingActivity.this.getString(R.string.success), Toast.LENGTH_SHORT).show();
                    } else {
                        AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error)).show();
                    }
                }

                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    SettingActivity.this.dialogProgress.hideDialog();
                    AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error)).show();
                    RLog.m86e(t.getMessage());
                }
            });
        }
    }

    private void linkToIns(String tokenInst) {
        String token = SharedPref.getInstance(this).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
        if (!token.isEmpty()) {
            this.dialogProgress.showDialog();
            this.mUmberService.linkSocial(token, "connect-instagram", tokenInst).enqueue(new Callback<ResponseBody>() {
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    SettingActivity.this.dialogProgress.hideDialog();
                    if (response.isSuccessful()) {
                        Toast.makeText(SettingActivity.this, SettingActivity.this.getString(R.string.success), Toast.LENGTH_SHORT).show();
                    } else {
                        AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error)).show();
                    }
                }

                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    SettingActivity.this.dialogProgress.hideDialog();
                    AlertDialogCustom.dialogMsg(SettingActivity.this, SettingActivity.this.getString(R.string.unknow_error)).show();
                    RLog.m86e(t.getMessage());
                }
            });
        }
    }
}
