//package com.umberapp.umber.fragments;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.CountDownTimer;
//import android.support.annotation.Nullable;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import com.google.gson.Gson;
//import com.umberapp.umber.R;
//import com.umberapp.umber.activities.LoginActivity;
//import com.umberapp.umber.activities.MainActivity;
//import com.umberapp.umber.apis.ApiResponse;
//import com.umberapp.umber.apis.ApiUtils;
//import com.umberapp.umber.apis.UmberService;
//import com.umberapp.umber.application.AppController;
//import com.umberapp.umber.models.User;
//import com.umberapp.umber.utils.Constant;
//import com.umberapp.umber.utils.RLog;
//import com.umberapp.umber.utils.SharedPref;
//import com.umberapp.umber.views.ProgressDialogCustom;
//import com.wang.avi.indicators.LineScalePartyIndicator;
//
//
//import org.java_websocket.framing.CloseFrame;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//import me.zhanghai.android.materialprogressbar.BuildConfig;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class SMSFragment extends BaseFragment implements OnClickListener {
//    @Bind({R.id.ll_submit})
//    Button btnSubmit;
//    private int count;
//    private CountDownTimer countDownTimer;
//    private ProgressDialogCustom dialogProgress;
////    @Bind({R.id.edt_sms_code})
////    EditText edtCodeSms;
////    private UmberService mUmberService;
////    @Bind({R.id.progress})
////    ProgressBar progressBar;
////    private int time;
////    @Bind({R.id.tv_count})
////    TextView tvCount;
//
//    /* renamed from: com.umberapp.umber.fragments.SMSFragment.1 */
//    class C14231 extends CountDownTimer {
//        C14231(long x0, long x1) {
//            super(x0, x1);
//        }
//
//        public void onTick(long l) {
//            SMSFragment.this.count = SMSFragment.this.count - 1;
//            SMSFragment.this.tvCount.setText(String.format(SMSFragment.this.getContext().getString(R.string.you_don_t_have_receive_d), new Object[]{Integer.valueOf(SMSFragment.this.count)}));
//        }
//
//        public void onFinish() {
//            SMSFragment.this.btnSubmit.setEnabled(true);
//            SMSFragment.this.btnSubmit.setClickable(true);
//            SMSFragment.this.btnSubmit.setAlpha(LineScalePartyIndicator.SCALE);
//            SMSFragment.this.time = 60000;
//            SMSFragment.this.count = 60;
//            SMSFragment.this.tvCount.setText(String.format(SMSFragment.this.getContext().getString(R.string.you_don_t_have_receive_d), new Object[]{Integer.valueOf(SMSFragment.this.count)}));
//        }
//    }
//
//    /* renamed from: com.umberapp.umber.fragments.SMSFragment.2 */
//    class C14242 implements TextWatcher {
//        C14242() {
//        }
//
//        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//        }
//
//        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            if (charSequence.length() == 4) {
//                SMSFragment.this.verify(charSequence.toString());
//            }
//        }
//
//        public void afterTextChanged(Editable editable) {
//        }
//    }
//
//    /* renamed from: com.umberapp.umber.fragments.SMSFragment.3 */
//    class C14253 implements Callback<ApiResponse<String>> {
//        C14253() {
//        }
//
//        public void onResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {
//            if (response.isSuccessful()) {
//                ApiResponse<String> stringRs = (ApiResponse) response.body();
//                if (stringRs.getData() == null || !((String) stringRs.getData()).equals("YES")) {
//                    SMSFragment.this.progressBar.setVisibility(View.VISIBLE);
//                    SMSFragment.this.edtCodeSms.setText(BuildConfig.FLAVOR);
//                    return;
//                }
//                SMSFragment.this.getProfile();
//                return;
//            }
//            SMSFragment.this.progressBar.setVisibility(View.VISIBLE);
//            SMSFragment.this.edtCodeSms.setText(BuildConfig.FLAVOR);
//            RLog.m86e(Integer.valueOf(response.code()));
//        }
//
//        public void onFailure(Call<ApiResponse<String>> call, Throwable t) {
//            RLog.m86e(t.getMessage());
//            SMSFragment.this.edtCodeSms.setText(BuildConfig.FLAVOR);
//            SMSFragment.this.progressBar.setVisibility(View.VISIBLE);
//        }
//    }
//
//    /* renamed from: com.umberapp.umber.fragments.SMSFragment.4 */
//    class C14264 implements Callback<ApiResponse<User>> {
//        final /* synthetic */ String val$userString;
//
//        C14264(String str) {
//            this.val$userString = str;
//        }
//
//        public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
//            SMSFragment.this.progressBar.setVisibility(View.VISIBLE);
//            if (response.isSuccessful()) {
//                User user = (User) ((ApiResponse) response.body()).getData();
//                user.setToken(this.val$userString);
//                AppController.getInstance().setUser(user);
//                SMSFragment.this.saveUserInfor(user);
//                ((MainActivity) SMSFragment.this.getActivity()).onBackPressed();
//                return;
//            }
//            RLog.m86e(Integer.valueOf(response.code()));
//            SMSFragment.this.startActivity(new Intent(SMSFragment.this.getActivity(), LoginActivity.class));
//            SMSFragment.this.getActivity().finish();
//        }
//
//        public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
//            SMSFragment.this.progressBar.setVisibility(View.VISIBLE);
//            RLog.m86e(t.getMessage());
//            SMSFragment.this.startActivity(new Intent(SMSFragment.this.getActivity(), LoginActivity.class));
//            SMSFragment.this.getActivity().finish();
//        }
//    }
//
//    public SMSFragment() {
//        this.time = 60000;
//        this.count = 60;
//    }
//
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("list", this.count);
//    }
//
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        if (savedInstanceState != null) {
//            this.count = savedInstanceState.getInt("list");
//        }
//    }
//
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        this.mUmberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
//    }
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_sms, container, false);
//    }
//
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        ButterKnife.bind((Object) this, view);
//        initView();
//    }
//
//    private void initView() {
//        this.btnSubmit.setAlpha(0.5f);
//        this.btnSubmit.setEnabled(false);
//        this.tvCount.setText(String.format(getContext().getString(R.string.you_don_t_have_receive_d), new Object[]{Integer.valueOf(this.count)}));
//        this.dialogProgress = new ProgressDialogCustom(getContext());
//        this.time = this.count * CloseFrame.NORMAL;
//        this.countDownTimer = new C14231((long) this.time, 1000);
//        this.countDownTimer.start();
//        this.edtCodeSms.addTextChangedListener(new C14242());
//        this.btnSubmit.setOnClickListener(this);
//    }
//
//    public void onStop() {
//        super.onStop();
//        this.countDownTimer.cancel();
//    }
//
//    void verify(String code) {
//        this.progressBar.setVisibility(View.VISIBLE);
//        this.mUmberService.verifySMS(AppController.getInstance().getUser().getToken(), code).enqueue(new C14253());
//    }
//
//    void getProfile() {
//        String userString = SharedPref.getInstance(getContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
//        if (userString.equals(BuildConfig.FLAVOR)) {
//            startActivity(new Intent(getActivity(), LoginActivity.class));
//            return;
//        }
//        RLog.m85d("token = " + userString);
//        this.mUmberService.getInfor(userString).enqueue(new C14264(userString));
//    }
//
//    private void saveUserInfor(User data) {
//        SharedPref.getInstance(getContext()).putString(Constant.KEY_USER, new Gson().toJson((Object) data));
//        SharedPref.getInstance(getContext()).putString(Constant.KEY_TOKEN, data.getToken());
//    }
//
//    public void onClick(View view) {
//        if (view.getId() == R.id.ll_submit) {
//            this.countDownTimer.cancel();
//            this.count = 60;
//            this.time = 60000;
//            this.countDownTimer.start();
//            this.btnSubmit.setAlpha(0.5f);
//            this.btnSubmit.setClickable(false);
//            ((MainActivity) getActivity()).sendSms();
//        }
//    }
//}
