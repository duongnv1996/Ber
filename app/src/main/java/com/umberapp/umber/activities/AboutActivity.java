package com.umberapp.umber.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.umberapp.umber.R;
import com.umberapp.umber.utils.CommonUtils;

import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity implements OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_about);
        ButterKnife.bind((Activity) this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back /*2131689670*/:
                finish();
            case R.id.tw /*2131689672*/:
                CommonUtils.openUrl(this, "https://twitter.com/umberindonesia");
            case R.id.fb /*2131689673*/:
                CommonUtils.openUrl(this, "https://www.facebook.com/umberIndonesia/");
            case R.id.ins /*2131689674*/:
                CommonUtils.openUrl(this, "https://www.instagram.com/umberindonesia/");
            case R.id.gg /*2131689675*/:
                CommonUtils.openUrl(this, "https://plus.google.com/105171263272563024894");
            default:
        }
    }
}
