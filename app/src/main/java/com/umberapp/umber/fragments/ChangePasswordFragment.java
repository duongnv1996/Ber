package com.umberapp.umber.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;

import com.umberapp.umber.R;
import com.umberapp.umber.activities.SettingActivity;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.views.AlertDialogCustom;
import com.umberapp.umber.views.ProgressDialogCustom;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordFragment extends Fragment {
    @Bind({R.id.ll_update})
    CardView btnChange;
    ProgressDialogCustom dialogCustom;
    @Bind({R.id.edt_password})
    EditText edtPassword;
    @Bind({R.id.edt_repassword})
    EditText edtRepassword;

    /* renamed from: com.umberapp.umber.fragments.ChangePasswordFragment.1 */
    class C14011 implements OnClickListener {

        /* renamed from: com.umberapp.umber.fragments.ChangePasswordFragment.1.1 */
        class C14001 implements Callback<ApiResponse<String>> {
            C14001() {
            }

            public void onResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {
                ChangePasswordFragment.this.dialogCustom.hideDialog();
                if (response == null) {
                    AlertDialogCustom.dialogMsg(ChangePasswordFragment.this.getContext(), ChangePasswordFragment.this.getString(R.string.unknow_error)).show();
                } else if (((ApiResponse) response.body()).getData() == null || !((String) ((ApiResponse) response.body()).getData()).equals("updated password")) {
                    AlertDialogCustom.dialogMsg(ChangePasswordFragment.this.getContext(), ChangePasswordFragment.this.getString(R.string.unknow_error)).show();
                } else {
                    ((SettingActivity) ChangePasswordFragment.this.getActivity()).getProfile(AppController.getInstance().getUser().getToken());
                }
            }

            public void onFailure(Call<ApiResponse<String>> call, Throwable t) {
                ChangePasswordFragment.this.dialogCustom.hideDialog();
                RLog.m86e(t.getMessage());
                AlertDialogCustom.dialogMsg(ChangePasswordFragment.this.getContext(), ChangePasswordFragment.this.getString(R.string.unknow_error)).show();
            }
        }

        C14011() {
        }

        public void onClick(View view) {
            if (view.getId() == R.id.ll_update) {
                String pass = ChangePasswordFragment.this.edtPassword.getText().toString();
                String repass = ChangePasswordFragment.this.edtRepassword.getText().toString();
                if (pass.isEmpty()) {
                    AlertDialogCustom.dialogMsg(ChangePasswordFragment.this.getContext(), ChangePasswordFragment.this.getString(R.string.enter_pass)).show();
                } else if (pass.length() < 6) {
                    AlertDialogCustom.dialogMsg(ChangePasswordFragment.this.getContext(), ChangePasswordFragment.this.getString(R.string.pass_incorrectly)).show();
                } else if (pass.equals(repass)) {
                    ChangePasswordFragment.this.dialogCustom.showDialog();
                    ((UmberService) ApiUtils.getRootApi().create(UmberService.class)).changePass(AppController.getInstance().getUser().getToken(), pass).enqueue(new C14001());
                } else {
                    AlertDialogCustom.dialogMsg(ChangePasswordFragment.this.getContext(), ChangePasswordFragment.this.getString(R.string.repass_incorrectly)).show();
                }
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_change_password, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind((Object) this, view);
        this.dialogCustom = new ProgressDialogCustom(getContext());
        this.btnChange.setOnClickListener(new C14011());
    }
}
