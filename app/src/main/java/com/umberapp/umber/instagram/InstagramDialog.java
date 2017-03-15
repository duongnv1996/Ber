package com.umberapp.umber.instagram;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.Display;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InstagramDialog extends Dialog {
    static final float[] DIMENSIONS_LANDSCAPE;
    static final float[] DIMENSIONS_PORTRAIT;
    static final LayoutParams FILL;
    static final int MARGIN = 4;
    static final int PADDING = 2;
    private static final String TAG = "Instagram-WebView";
    private LinearLayout mContent;
    private OAuthDialogListener mListener;
    private ProgressDialog mSpinner;
    private TextView mTitle;
    private String mUrl;
    private WebView mWebView;

    public interface OAuthDialogListener {
        void onComplete(String str);

        void onError(String str);
    }

    private class OAuthWebViewClient extends WebViewClient {
        private OAuthWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d(InstagramDialog.TAG, "Redirecting URL " + url);
            if (!url.startsWith(InstagramApp.mCallbackUrl)) {
                return false;
            }
            InstagramDialog.this.mListener.onComplete(url.split("=")[1]);
            InstagramDialog.this.dismiss();
            return true;
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Log.d(InstagramDialog.TAG, "Page error: " + description);
            super.onReceivedError(view, errorCode, description, failingUrl);
            InstagramDialog.this.mListener.onError(description);
            InstagramDialog.this.dismiss();
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.d(InstagramDialog.TAG, "Loading URL: " + url);
            super.onPageStarted(view, url, favicon);
            InstagramDialog.this.mSpinner.show();
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            String title = InstagramDialog.this.mWebView.getTitle();
            if (title != null && title.length() > 0) {
                InstagramDialog.this.mTitle.setText(title);
            }
            Log.d(InstagramDialog.TAG, "onPageFinished URL: " + url);
            InstagramDialog.this.mSpinner.dismiss();
        }
    }

    static {
        DIMENSIONS_LANDSCAPE = new float[]{460.0f, 260.0f};
        DIMENSIONS_PORTRAIT = new float[]{280.0f, 420.0f};
        FILL = new LayoutParams(-1, -1);
    }

    public InstagramDialog(Context context, String url, OAuthDialogListener listener) {
        super(context);
        this.mUrl = url;
        this.mListener = listener;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mSpinner = new ProgressDialog(getContext());
        this.mSpinner.requestWindowFeature(1);
        this.mSpinner.setMessage("Loading...");
        this.mContent = new LinearLayout(getContext());
        this.mContent.setOrientation(LinearLayout.VERTICAL);
        setUpTitle();
        setUpWebView();
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        float scale = getContext().getResources().getDisplayMetrics().density;
        float[] dimensions = display.getWidth() < display.getHeight() ? DIMENSIONS_PORTRAIT : DIMENSIONS_LANDSCAPE;
        addContentView(this.mContent, new LayoutParams((int) ((dimensions[0] * scale) + 0.5f), (int) ((dimensions[1] * scale) + 0.5f)));
        CookieSyncManager.createInstance(getContext());
        CookieManager.getInstance().removeAllCookie();
    }

    private void setUpTitle() {
        requestWindowFeature(1);
        this.mTitle = new TextView(getContext());
        this.mTitle.setText("Instagram");
        this.mTitle.setTextColor(-1);
        this.mTitle.setTypeface(Typeface.DEFAULT_BOLD);
        this.mTitle.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.mTitle.setPadding(6, MARGIN, MARGIN, MARGIN);
        this.mContent.addView(this.mTitle);
    }

    private void setUpWebView() {
        this.mWebView = new WebView(getContext());
        this.mWebView.setVerticalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setWebViewClient(new OAuthWebViewClient());
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.loadUrl(this.mUrl);
        this.mWebView.setLayoutParams(FILL);
        this.mContent.addView(this.mWebView);
    }
}
