package com.umberapp.umber.activities;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.umberapp.umber.R;
import com.umberapp.umber.models.ExpertBit;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.RLog;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MapsActivity extends BaseActivity implements OnMapReadyCallback, OnClickListener {
    private boolean isTimeToFocus;
    @Bind({R.id.ll_root_map})
    RelativeLayout llRoot;
    int mCode;
    private LatLng mCurrentLatlng;
    private LatLng mLatlng;
    private GoogleMap mMap;
    private String phone;

    /* renamed from: com.umberapp.umber.activities.MapsActivity.1 */
    class C13551 implements OnMyLocationChangeListener {
        C13551() {
        }

        public void onMyLocationChange(Location location) {
            MapsActivity.this.mLatlng = new LatLng(location.getLatitude(), location.getLongitude());
            if (MapsActivity.this.isTimeToFocus) {
                CommonUtils.focusCurrentLocation(new LatLng(location.getLatitude(), location.getLongitude()), 13.0f, MapsActivity.this.mMap);
                MapsActivity.this.isTimeToFocus = false;
            }
        }
    }

    public MapsActivity() {
        this.isTimeToFocus = true;
    }

    void startToFragment(ExpertBit expertBit) {
    }

    void finishOrder() {
    }

    void unreadNotification(int count) {
    }

    void trackExpert(String lat, String lng) {
        this.mCurrentLatlng = new LatLng(Double.parseDouble(lat), Double.parseDouble(lng));
        if (this.mMap != null) {
            this.mMap.clear();
            this.mMap.addMarker(new MarkerOptions().position(this.mCurrentLatlng));
            RLog.m86e("Add to location " + this.mCurrentLatlng.latitude + "-" + this.mCurrentLatlng.longitude);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_maps);
        ButterKnife.bind((Activity) this);
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.phone = intent.getStringExtra(Constant.KEY_MSG);
            Bundle b = intent.getBundleExtra(Constant.KEY_BUNDLE);
            if (b != null) {
                this.mCurrentLatlng = (LatLng) b.getParcelable(Constant.KEY_LATLNG);
                RLog.m86e(this.mCurrentLatlng.latitude + "-" + this.mCurrentLatlng.longitude);
                if (!(this.mCurrentLatlng == null || this.mMap == null)) {
                    this.mMap.addMarker(new MarkerOptions().position(this.mCurrentLatlng));
                }
            }
        }
        this.view = this.llRoot;
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        if (this.mMap == null) {
            return;
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            if (!(this.mCurrentLatlng == null || this.mMap == null)) {
                this.mMap.addMarker(new MarkerOptions().position(this.mCurrentLatlng));
            }
            this.mMap.setMyLocationEnabled(true);
            this.mMap.getUiSettings().setMyLocationButtonEnabled(false);
            this.mMap.setOnMyLocationChangeListener(new C13551());
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back /*2131689670*/:
                finish();
            case R.id.btn_location /*2131689696*/:
                if (this.mLatlng != null) {
                    CommonUtils.focusCurrentLocation(this.mLatlng, 13.0f, this.mMap);
                }
            case R.id.btn_phone /*2131689697*/:
                if (this.phone == null || this.phone.isEmpty()) {
                    Toast.makeText(this, R.string.unable_connect_ex, Toast.LENGTH_SHORT).show();
                } else {
                    CommonUtils.intentToCall(this.phone, this);
                }
            case R.id.btn_expert /*2131689698*/:
                if (this.mCurrentLatlng != null) {
                    CommonUtils.focusCurrentLocation(this.mCurrentLatlng, 13.0f, this.mMap);
                }
            default:
        }
    }
}
