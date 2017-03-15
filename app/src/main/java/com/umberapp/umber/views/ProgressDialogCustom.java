package com.umberapp.umber.views;

import android.app.ProgressDialog;
import android.content.Context;

import com.umberapp.umber.R;

public class ProgressDialogCustom extends ProgressDialog {
    Context context;
    private ProgressDialog mProgressDialog;

    public ProgressDialogCustom(Context context, String msg, boolean isCancelable) {
        super(context);
        this.context = context;
        this.mProgressDialog = new ProgressDialog(context);
        this.mProgressDialog.setMessage(msg);
        this.mProgressDialog.setCancelable(isCancelable);
    }

    public ProgressDialogCustom(Context context) {
        super(context);
        this.context = context;
        this.mProgressDialog = new ProgressDialog(context, R.style.AppCompatAlertDialogStyle);
        this.mProgressDialog.setMessage(context.getString(R.string.dang_xu_ly));
        this.mProgressDialog.setMax(100);
        this.mProgressDialog.setProgress(0);
        this.mProgressDialog.setCancelable(false);
    }

    public void showDialog() {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.show();
        }
    }

    public void hideDialog() {
        if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            try {
                this.mProgressDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
