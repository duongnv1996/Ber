package com.umberapp.umber.apis;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.sromku.simple.fb.entities.Profile.Properties;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.utils.RLog;

public class EtaxiService extends Service implements ConnectionCallbacks, OnConnectionFailedListener, LocationListener {
    public static final String ACTION_LOCATION_UPDATE = "Action";
    private static Location _location;
    private GoogleApiClient _gac;

    public void onLocationChanged(Location arg0) {
        _location = arg0;
        Intent i = new Intent(ACTION_LOCATION_UPDATE);
        i.putExtra(Properties.LOCATION, arg0);
        RLog.m86e("Update location : " + arg0.getLatitude() + " - " + arg0.getLongitude());
        AppController.getInstance().setLocation(arg0);
        sendBroadcast(i);
    }

    public void onConnected(Bundle arg0) {
        LocationRequest lr = LocationRequest.create();
        lr.setPriority(100);
        lr.setInterval(10000);
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            LocationServices.FusedLocationApi.requestLocationUpdates(this._gac, lr, (LocationListener) this);
        }
    }

    public void onConnectionSuspended(int arg0) {
        LocationServices.FusedLocationApi.removeLocationUpdates(this._gac, (LocationListener) this);
    }

    private void stopLocationUpdate() {
        if (this._gac != null) {
            this._gac.disconnect();
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        switch (connectionResult.getErrorCode()) {
        }
    }

    public void onCreate() {
        super.onCreate();
        if (this._gac == null) {
            this._gac = new Builder(getApplicationContext()).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        }
        this._gac.connect();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }

    public void onDestroy() {
        stopLocationUpdate();
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
