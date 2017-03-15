package com.umberapp.umber.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.umberapp.umber.R;
import com.umberapp.umber.utils.Constant;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PhotoViewActivity extends AppCompatActivity implements OnClickListener {
    @Bind({2131689699})
    CardView back;
    @Bind({2131689626})
    ImageView image;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) com.umberapp.umber.R.layout.activity_photo_view);
        ButterKnife.bind((Activity) this);
        Intent i = getIntent();
        if (i != null) {
            String path = i.getStringExtra(Constant.KEY_MSG);
            if (path != null) {
                Glide.with((FragmentActivity) this).load(new File(path)).skipMemoryCache(true).thumbnail(0.5f).fitCenter().error((int) R.drawable.__picker_ic_broken_image_black_48dp).into(this.image);
            }
        }
    }

    public void onClick(View view) {
        finish();
    }
}
