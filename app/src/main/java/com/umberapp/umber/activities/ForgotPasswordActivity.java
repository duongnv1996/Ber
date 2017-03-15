package com.umberapp.umber.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.afollestad.materialdialogs.MaterialDialog.Builder;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.models.CheckResponse;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.views.AlertDialogCustom;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity implements OnClickListener {
    @Bind({2131689677})
    EditText mEdtEmail;
    @Bind({2131689680})
    ProgressBar mProgress;
    UmberService umberService;

    /* renamed from: com.umberapp.umber.activities.ForgotPasswordActivity.1 */
    class C13191 implements Callback<ResponseBody> {
        C13191() {
        }

        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful()) {
                ForgotPasswordActivity.this.setResult(-1);
                ForgotPasswordActivity.this.finish();
            }
        }

        public void onFailure(Call<ResponseBody> call, Throwable t) {
            AlertDialogCustom.dialogMsg(ForgotPasswordActivity.this, ForgotPasswordActivity.this.getString(R.string.check_connect)).show();
        }
    }

    /* renamed from: com.umberapp.umber.activities.ForgotPasswordActivity.2 */
    class C13202 implements Callback<ApiResponse<CheckResponse>> {
        final /* synthetic */ String val$username;

        C13202(String str) {
            this.val$username = str;
        }

        public void onResponse(Call<ApiResponse<CheckResponse>> call, Response<ApiResponse<CheckResponse>> response) {
            if (response.isSuccessful()) {
                CheckResponse code = (CheckResponse) ((ApiResponse) response.body()).getData();
                if (code == null || !code.getCode().equals("NOT_FOUND_USER")) {
                    ForgotPasswordActivity.this.resetPass(this.val$username);
                    return;
                }
                ForgotPasswordActivity.this.mProgress.setVisibility(8);
                AlertDialogCustom.dialogMsg(ForgotPasswordActivity.this, ForgotPasswordActivity.this.getString(R.string.exist_auth)).show();
                return;
            }
            ForgotPasswordActivity.this.mProgress.setVisibility(8);
            RLog.m86e("Check user -" + response.code());
            AlertDialogCustom.dialogMsg(ForgotPasswordActivity.this, ForgotPasswordActivity.this.getString(R.string.unknow_error)).show();
        }

        public void onFailure(Call<ApiResponse<CheckResponse>> call, Throwable t) {
            ForgotPasswordActivity.this.mProgress.setVisibility(8);
            RLog.m86e("Check user -" + t.getMessage());
            AlertDialogCustom.dialogMsg(ForgotPasswordActivity.this, ForgotPasswordActivity.this.getString(R.string.unknow_error)).show();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_forgot_password);
        ButterKnife.bind((Activity) this);
        this.umberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        getWindow().setSoftInputMode(3);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back /*2131689670*/:
                finish();
            case R.id.btn_resetpass /*2131689678*/:
                CommonUtils.hideKeyBroad(this, this.mEdtEmail);
                String email = this.mEdtEmail.getText().toString();
                if (email.isEmpty()) {
                    new Builder(this).title((int) R.string.missing_data).content((int) R.string.please_enter_email).show();
                    return;
                }
                this.mProgress.setVisibility(0);
                checkEmail(email);
            default:
        }
    }

    private void resetPass(String email) {
        this.umberService.sendEmailVerify(email).enqueue(new C13191());
    }

    void checkEmail(String username) {
        this.umberService.checkUsername(username).enqueue(new C13202(username));
    }

    protected void onResume() {
        super.onResume();
        this.mProgress.setVisibility(8);
    }
}
