package com.umberapp.umber.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.plus.PlusShare;
import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.entities.Feed.Builder;
import com.sromku.simple.fb.listeners.OnLoginListener;
import com.sromku.simple.fb.listeners.OnPublishListener;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiConstants;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import me.zhanghai.android.materialprogressbar.BuildConfig;

public class CommonUtils {
    public static final String YES_ACTION = "YES_ACTION";

    /* renamed from: com.umberapp.umber.utils.CommonUtils.1 */
    static class C14501 implements OnClickListener {
        C14501() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    }

    /* renamed from: com.umberapp.umber.utils.CommonUtils.2 */
    static class C14512 extends OnPublishListener {
        final /* synthetic */ Context val$context;

        C14512(Context context) {
            this.val$context = context;
        }

        public void onComplete(String response) {
            super.onComplete(response);
            Toast.makeText(this.val$context, "Share success!", Toast.LENGTH_SHORT).show();
        }
    }

    /* renamed from: com.umberapp.umber.utils.CommonUtils.3 */
    static class C14523 implements OnLoginListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ SimpleFacebook val$mSimpleFacebook;
        final /* synthetic */ OnPublishListener val$onPublishListener;

        C14523(Context context, SimpleFacebook simpleFacebook, OnPublishListener onPublishListener) {
            this.val$context = context;
            this.val$mSimpleFacebook = simpleFacebook;
            this.val$onPublishListener = onPublishListener;
        }

        public void onLogin(String accessToken, List<Permission> list, List<Permission> list2) {
            this.val$mSimpleFacebook.publish(new Builder().setMessage(this.val$context.getString(R.string.share_fb)).setLink("https://umberus.com").setName(this.val$context.getString(R.string.umber_android)).build(), true, this.val$onPublishListener);
        }

        public void onCancel() {
            RLog.m86e("Cancel");
        }

        public void onException(Throwable throwable) {
            RLog.m86e("Exception");
        }

        public void onFail(String reason) {
            RLog.m86e("fail " + reason);
        }
    }

    public static void disable(ViewGroup layout) {
        layout.setEnabled(false);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof ViewGroup) {
                disable((ViewGroup) child);
            } else {
                child.setEnabled(false);
            }
        }
    }

    public static void enable(ViewGroup layout) {
        layout.setEnabled(true);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof ViewGroup) {
                enable((ViewGroup) child);
            } else {
                child.setEnabled(true);
            }
        }
    }

    public static void launchMarket(Context context, String packageName) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, " unable to find market app", Toast.LENGTH_SHORT).show();
        }
    }

    public static void launchMoreAppMarket(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pub:DuongKK")));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, " unable to find market app", Toast.LENGTH_SHORT).show();
        }
    }

    public static void shareEmail(String email, Context context) {
        Intent emailIntent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", email, null));
        emailIntent.putExtra("android.intent.extra.SUBJECT", context.getResources().getString(R.string.app_name));
        emailIntent.putExtra("android.intent.extra.TEXT", BuildConfig.FLAVOR);
        context.startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    public static void launchApp(Context mContext, String packageName) {
        try {
            Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(packageName);
            intent.addCategory("android.intent.category.LAUNCHER");
            if (intent == null) {
                throw new NameNotFoundException();
            }
            mContext.startActivity(intent);
        } catch (NameNotFoundException e) {
            Log.e("Launch", e.getMessage());
        }
    }

    public static void runApp(Context context, String appName) throws IllegalArgumentException {
        Intent mainIntent = new Intent("android.intent.action.MAIN", null);
        mainIntent.addCategory("android.intent.category.LAUNCHER");
        for (ResolveInfo info : context.getPackageManager().queryIntentActivities(mainIntent, 0)) {
            if (info.loadLabel(context.getPackageManager()).equals(appName)) {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(info.activityInfo.applicationInfo.packageName));
                return;
            }
        }
        throw new IllegalArgumentException("Application not found!");
    }

    public static AlertDialog showDialog(Context context, String name, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(name);
        builder.setMessage(msg);
        builder.setPositiveButton("OK", new C14501());
        AlertDialog dialog = builder.create();
        dialog.show();
        return dialog;
    }

    public static void hideKeyBroad(Context context, EditText mEdt) {
        ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mEdt.getWindowToken(), 0);
    }

    public static void shareGooglePlus(Activity context, String text) {
        context.startActivityForResult(new PlusShare.Builder(context).setType("text/plain").setText(text).setContentUrl(Uri.parse(BuildConfig.FLAVOR)).getIntent(), 0);
    }

    public static String getDate(long milliSeconds, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public static Date convertTimeToDate(long milliSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        Date date = new Date();
        date.setDate(calendar.get(Calendar.DATE));
        date.setMonth(calendar.get(Calendar.MONTH));
        date.setYear(calendar.get(Calendar.YEAR));
        date.setHours(calendar.get(Calendar.HOUR));
        int am = calendar.get(Calendar.AM_PM);
        if(am==Calendar.PM){
            date.setHours(date.getHours()+12);
        }
        date.setMinutes(calendar.get(Calendar.MINUTE));
        return date;
    }

    public static long convertToSec2(String givenDateString, String dateFormat) {
        try {
            long timeInMilliseconds = new SimpleDateFormat(dateFormat).parse(givenDateString).getTime();
            System.out.println("Date in milli :: " + timeInMilliseconds);
            return timeInMilliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Date getCurrentDate() {
        Calendar c = Calendar.getInstance();
        int seconds = c.get(Calendar.SECOND);
        return new Date(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE),c.get(Calendar.HOUR),c.get(Calendar.MINUTE));
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("dd/MM HH:mm").format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String getCurrentTimeByFormat(String format) {
        return new SimpleDateFormat(format).format(Long.valueOf(System.currentTimeMillis()));
    }

    public static void openUrl(Context context, String url) {
        Intent i = new Intent("android.intent.action.VIEW");
        i.setData(Uri.parse(url));
        context.startActivity(i);
    }

    public static String getImei(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    public static long getUTCTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(sdf.format(new Date()));
        System.out.println("Millis = " + sdf.getCalendar().getTimeInMillis());
        return sdf.getCalendar().getTimeInMillis();
    }

    public static void sendViaFacebook(Context context, String msg, SimpleFacebook mSimpleFacebook) {
        mSimpleFacebook.login(new C14523(context, mSimpleFacebook, new C14512(context)));
    }

    public static boolean isPackageInstalled(String packagename, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static void focusCurrentLocation(LatLng latLng, float sizeZoom, GoogleMap mMap) {
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(latLng).zoom(sizeZoom).build()));
    }

    public static void focusLocations(LatLngBounds bounds, GoogleMap mMap) {
        try {
            CameraUpdate zoom = CameraUpdateFactory.newLatLngBounds(bounds, ApiConstants.CODE_ERROR_LOGIN_PARAM, ApiConstants.CODE_ERROR_LOGIN_PARAM, 5);
            if (mMap != null && zoom != null) {
                mMap.animateCamera(zoom);
            }
        } catch (Exception e) {
            RLog.m86e(e.getMessage());
        }
    }

    public static void focusAllMarkers(List<Place> places, GoogleMap mMap, Context context) {
        LatLngBounds.Builder latLngBounds = new LatLngBounds.Builder();
        for (Place place : places) {
            latLngBounds.include(place.getLatLng());
        }
        LatLngBounds bounds = latLngBounds.build();
        int width = context.getResources().getDisplayMetrics().widthPixels;
        int height = context.getResources().getDisplayMetrics().heightPixels;
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, ApiConstants.CODE_ERROR_LOGIN_PARAM, ApiConstants.CODE_ERROR_LOGIN_PARAM, 5));
    }

    public static void focusAllMarkers(List<LatLng> places, GoogleMap mMap) {
        LatLngBounds.Builder latLngBounds = new LatLngBounds.Builder();
        for (LatLng place : places) {
            latLngBounds.include(place);
        }
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds.build(), ApiConstants.CODE_ERROR_LOGIN_PARAM, ApiConstants.CODE_ERROR_LOGIN_PARAM, 5));
    }

    public static void focuseLocation(LatLng latLng, float sizeZoom, GoogleMap mMap) {
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(latLng.latitude, latLng.longitude)).zoom(sizeZoom).build()));
    }

    public static String getCompleteAddressNomal(Context context, double LATITUDE, double LONGITUDE) {
        String strAdd = BuildConfig.FLAVOR;
        try {
            List<Address> addresses = new Geocoder(context, Locale.getDefault()).getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = (Address) addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder(BuildConfig.FLAVOR);
                for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();
                RLog.m86e("My Current loction Nomal address" + strReturnedAddress.toString());
                return strAdd;
            }
            RLog.m86e("My Current loction address NomalNo Address returned!");
            return getCompleteAddressString(context, LATITUDE, LONGITUDE);
        } catch (Exception e) {
            e.printStackTrace();
            RLog.m86e("My Current loction address NomalCanont get Address!");
            return getCompleteAddressString(context, LATITUDE, LONGITUDE);
        }
    }

    public static String getCompleteAddressString(Context context, double LATITUDE, double LONGITUDE) {
        String strAdd = BuildConfig.FLAVOR;
        try {
            List<com.doctoror.geocoder.Address> addresses = new com.doctoror.geocoder.Geocoder(context, Locale.getDefault()).getFromLocation(LATITUDE, LONGITUDE, 20, true);
            if (addresses != null) {
                com.doctoror.geocoder.Address returnedAddress = (com.doctoror.geocoder.Address) addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder(BuildConfig.FLAVOR);
                RLog.m86e(returnedAddress.toString());
                strAdd = returnedAddress.getFormattedAddress();
                RLog.m86e("My Current loction address" + strAdd.toString());
                return strAdd;
            }
            RLog.m86e("My Current loction addressNo Address returned!");
            return strAdd;
        } catch (Exception e) {
            e.printStackTrace();
            RLog.m86e("My Current loction addressCanont get Address!");
            return strAdd;
        }
    }

    private static String addressToPrettyString(@NonNull com.doctoror.geocoder.Address address) {
        return "mFormattedAddress='" + address.getFormattedAddress() + '\'' + "\nmStreetAddress='" + address.getStreetAddress() + '\'' + "\nmRoute='" + address.getRoute() + '\'' + "\nmIntersection='" + address.getIntersection() + '\'' + "\nmPolitical='" + address.getPolitical() + '\'' + "\nmCountry='" + address.getCountry() + '\'' + "\nmAdministrativeAreaLevel1='" + address.getAdministrativeAreaLevel1() + '\'' + "\nmAdministrativeAreaLevel2='" + address.getAdministrativeAreaLevel2() + '\'' + "\nmAdministrativeAreaLevel3='" + address.getAdministrativeAreaLevel3() + '\'' + "\nmAdministrativeAreaLevel4='" + address.getAdministrativeAreaLevel4() + '\'' + "\nmAdministrativeAreaLevel5='" + address.getAdministrativeAreaLevel5() + '\'' + "\nmColloquialArea='" + address.getColloquialArea() + '\'' + "\nmLocality='" + address.getLocality() + '\'' + "\nmWard='" + address.getWard() + '\'' + "\nmSubLocality='" + address.getSubLocality() + '\'' + "\nmSubLocalityLevel1='" + address.getSubLocalityLevel1() + '\'' + "\nmSubLocalityLevel2='" + address.getSubLocalityLevel2() + '\'' + "\nmSubLocalityLevel3='" + address.getSubLocalityLevel3() + '\'' + "\nmSubLocalityLevel4='" + address.getSubLocalityLevel4() + '\'' + "\nmSubLocalityLevel5='" + address.getSubLocalityLevel5() + '\'' + "\nmNeighborhood='" + address.getNeighborhood() + '\'' + "\nmPremise='" + address.getPremise() + '\'' + "\nmSubPremise='" + address.getSubPremise() + '\'' + "\nmPostalCode='" + address.getPostalCode() + '\'' + "\nmNaturalFeature='" + address.getNaturalFeature() + '\'' + "\nmAirport='" + address.getAirport() + '\'' + "\nmPark='" + address.getPark() + '\'' + "\nmPointOfInterest='" + address.getPointOfInterest() + '\'' + "\nmFloor='" + address.getFloor() + '\'' + "\nmEstablishment='" + address.getEstablishment() + '\'' + "\nmParking='" + address.getParking() + '\'' + "\nmPostBox='" + address.getPostBox() + '\'' + "\nmPostTown='" + address.getPostTown() + '\'' + "\nmRoom='" + address.getRoom() + '\'' + "\nmStreetNumber='" + address.getStreetNumber() + '\'' + "\nmBusStation='" + address.getBusStation() + '\'' + "\nmTrainStation='" + address.getTrainStation() + '\'' + "\nmTransitStation='" + address.getTransitStation() + '\'' + "\nmLocation=" + address.getLocation() + "\nmLocationType='" + address.getLocationType() + '\'' + "\nmViewport=" + address.getViewport() + "\nmBounds=" + address.getBounds() + '}';
    }

    public static Marker addMarkerFromFile(File resource, GoogleMap mMap, LatLng latLng) {
        Marker marker = mMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeFile(resource.getPath()), 90, 90, false))));
        marker.showInfoWindow();
        return marker;
    }

    public static Marker addMarker(int resource, GoogleMap mMap, LatLng latLng) {
        Marker marker = mMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(resource)));
        marker.showInfoWindow();
        return marker;
    }

    public static Marker addMarker(int resource, GoogleMap mMap, LatLng latLng, String title) {
        Marker marker = mMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(resource)).title(title));
        marker.showInfoWindow();
        return marker;
    }

    public static Marker addMarker(GoogleMap mMap, LatLng latLng) {
        Marker marker = mMap.addMarker(new MarkerOptions().position(latLng));
        marker.showInfoWindow();
        return marker;
    }

    public static String formatDecima(String number) {
        return NumberFormat.getInstance().format(Double.parseDouble(number));
    }

    public static void shareSimpleText(String msg, Context context) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", R.string.app_name);
        intent.putExtra("android.intent.extra.TEXT", msg);
        context.startActivity(Intent.createChooser(intent, "Send via"));
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10.0d, (double) places);
        return ((double) Math.round(value * ((double) factor))) / ((double) factor);
    }

    public static void intentToCall(String phone, Context context) {
        Intent i = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + phone));
        i.addFlags(268435456);
        context.startActivity(i);
    }

    public static void intentToSms(String phone, Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.fromParts("sms", phone, null)));
    }

    public static String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(CompressFormat.JPEG, 100, baos);
        return Base64.encodeToString(baos.toByteArray(), 0);
    }
}
