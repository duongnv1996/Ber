package com.umberapp.umber.fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.umberapp.umber.R;
import com.umberapp.umber.instagram.InstagramApp;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WebFragment extends Fragment {
    static final float[] DIMENSIONS_LANDSCAPE;
    static final float[] DIMENSIONS_PORTRAIT;
    static final int MARGIN = 4;
    static final int PADDING = 2;
    private static final String TAG = "Instagram-WebView";
    private OAuthDialogListener mListener;
    private ProgressDialog mSpinner;
    private TextView mTitle;
    private String mUrl;
    @Bind({2131689924})
    WebView mWebView;

    public interface OAuthDialogListener {
        void onComplete(String str);

        void onError(String str);
    }

    private class OAuthWebViewClient extends WebViewClient {
        private OAuthWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d(WebFragment.TAG, "Redirecting URL " + url);
            if (!url.startsWith(InstagramApp.mCallbackUrl)) {
                return false;
            }
            WebFragment.this.mListener.onComplete(url.split("=")[1]);
            WebFragment.this.getActivity().onBackPressed();
            return true;
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Log.d(WebFragment.TAG, "Page error: " + description);
            super.onReceivedError(view, errorCode, description, failingUrl);
            WebFragment.this.mListener.onError(description);
            WebFragment.this.getActivity().onBackPressed();
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.d(WebFragment.TAG, "Loading URL: " + url);
            super.onPageStarted(view, url, favicon);
            WebFragment.this.mSpinner.show();
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            String title = WebFragment.this.mWebView.getTitle();
            if (title == null || title.length() > 0) {
                Log.d(WebFragment.TAG, "onPageFinished URL: " + url);
                WebFragment.this.mSpinner.dismiss();
            } else {
                Log.d(WebFragment.TAG, "onPageFinished URL: " + url);
                WebFragment.this.mSpinner.dismiss();
            }
        }
    }

    @SuppressLint({"ValidFragment"})
    public WebFragment(String url, OAuthDialogListener listener) {
        this.mUrl = url;
        this.mListener = listener;
    }

    static {
        DIMENSIONS_LANDSCAPE = new float[]{460.0f, 260.0f};
        DIMENSIONS_PORTRAIT = new float[]{640.0f, 640.0f};
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind((Object) this, view);
        this.mSpinner = new ProgressDialog(getContext());
        this.mSpinner.requestWindowFeature(1);
        this.mSpinner.setMessage("Loading...");
        setUpWebView();
        CookieSyncManager.createInstance(getContext());
        CookieManager.getInstance().removeAllCookie();
    }

    private void setUpTitle() {
        this.mTitle = new TextView(getContext());
        this.mTitle.setText("Instagram");
        this.mTitle.setTextColor(-1);
        this.mTitle.setTypeface(Typeface.DEFAULT_BOLD);
        this.mTitle.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
    }

    private void setUpWebView() {
        this.mWebView.setVerticalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setWebViewClient(new OAuthWebViewClient());
        this.mWebView.loadUrl(this.mUrl);
    }
}
