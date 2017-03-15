package com.umberapp.umber.webview;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sromku.simple.fb.entities.Profile.Properties;
import com.sromku.simple.fb.utils.Utils;
import com.umberapp.umber.models.DebitModel;
import com.umberapp.umber.utils.Constant;

import org.apache.http.util.EncodingUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import me.zhanghai.android.materialprogressbar.BuildConfig;

public class DialogWebView extends Dialog {
    static final float[] DIMENSIONS_LANDSCAPE;
    static final float[] DIMENSIONS_PORTRAIT;
    static final LayoutParams FILL;
    static final int MARGIN = 4;
    static final int PADDING = 2;
    private static final String TAG = "Instagram-WebView";
    private static final String URL = "https://www.padipay.com/padipay-payment/payment/bca/creditcard/request.html";
    private DebitModel debitModel;
    private LinearLayout mContent;
    private OAuthDialogListener mListener;
    private ProgressDialog mSpinner;
    private TextView mTitle;
    private WebView mWebView;

    public interface OAuthDialogListener {
        void onComplete(String str);

        void onError(String str);
    }

    private class OAuthWebViewClient extends WebViewClient {
        private OAuthWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d(DialogWebView.TAG, "Redirecting URL " + url);
            if (!url.startsWith(Constant.PATH_TO_OPEN_FORMWEB)) {
                return false;
            }
            DialogWebView.this.mListener.onComplete(url.split("=")[1]);
            DialogWebView.this.dismiss();
            return true;
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Log.d(DialogWebView.TAG, "Page error: " + description);
            super.onReceivedError(view, errorCode, description, failingUrl);
            DialogWebView.this.mListener.onError(description);
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.d(DialogWebView.TAG, "Loading URL: " + url);
            super.onPageStarted(view, url, favicon);
            DialogWebView.this.mSpinner.show();
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            String title = DialogWebView.this.mWebView.getTitle();
            if (title != null && title.length() > 0) {
                DialogWebView.this.mTitle.setText(title);
            }
            Log.d(DialogWebView.TAG, "onPageFinished URL: " + url);
            DialogWebView.this.mSpinner.dismiss();
        }
    }

    static {
        DIMENSIONS_LANDSCAPE = new float[]{460.0f, 260.0f};
        DIMENSIONS_PORTRAIT = new float[]{280.0f, 420.0f};
        FILL = new LayoutParams(-1, -1);
    }

    public DialogWebView(Context context, DebitModel debitModel, OAuthDialogListener listener) {
        super(context);
        this.debitModel = debitModel;
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
        getWindow().setLayout(-1, -1);
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
        Map<String, String> mapParams = new HashMap();
        mapParams.put(Properties.CURRENCY, this.debitModel.getCurrency());
        mapParams.put("merchantCode", this.debitModel.getMerchantCode());
        mapParams.put("merchantPass", this.debitModel.getMerchantPass());
        mapParams.put("invoiceCode", this.debitModel.getInvoiceCode());
        mapParams.put("amount", this.debitModel.getAmount() + BuildConfig.FLAVOR);
        mapParams.put("transactionTime", this.debitModel.getTransactionTime());
        mapParams.put("expirationTime", this.debitModel.getExpirationTime());
        mapParams.put("merchantReturnUrl", Constant.PATH_TO_OPEN_FORMWEB);
        mapParams.put("languageVer", this.debitModel.getLanguageVer());
        mapParams.put("customerFullName", this.debitModel.getCustomerFullName());
        mapParams.put("customerEmail", this.debitModel.getCustomerEmail());
        mapParams.put("customerPhoneNumber", this.debitModel.getCustomerPhoneNumber());
        mapParams.put("customerCountry", this.debitModel.getCustomerCountry());
        mapParams.put("padipaySignature", this.debitModel.getPadipaySignature());
        mapParams.put("callBackUrl", Constant.PATH_TO_OPEN_FORMWEB);
        StringBuffer postData = new StringBuffer();
        postData.append("currency=" + this.debitModel.getCurrency()).append("&merchantCode=" + this.debitModel.getMerchantCode()).append("&merchantPass=" + this.debitModel.getMerchantPass()).append("&invoiceCode=" + this.debitModel.getInvoiceCode()).append("&amount=" + this.debitModel.getAmount()).append("&transactionTime=" + this.debitModel.getTransactionTime()).append("&expirationTime=" + this.debitModel.getExpirationTime()).append("&merchantReturnUrl=umber://android").append("&languageVer=" + this.debitModel.getLanguageVer()).append("&customerFullName=" + this.debitModel.getCustomerFullName()).append("&customerEmail=" + this.debitModel.getCustomerEmail()).append("&customerPhoneNumber=" + this.debitModel.getCustomerPhoneNumber()).append("&customerCountry=" + this.debitModel.getCustomerCountry()).append("&callBackUrl=umber://android").append("&padipaySignature=" + this.debitModel.getPadipaySignature());
        this.mWebView.postUrl(URL,  EncodingUtils.getBytes(String.valueOf(postData), "BASE64"));
        this.mWebView.setLayoutParams(FILL);
        this.mContent.addView(this.mWebView);
    }

    public void webview_ClientPost(WebView webView, String url, Collection<Entry<String, String>> postData) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head>");
        sb.append("<body onload='form1.submit()'>");
        Object[] objArr = new Object[PADDING];
        objArr[0] = url;
        objArr[1] = "post";
        sb.append(String.format("<form id='form1' action='%s' method='%s'>", objArr));
        for (Entry<String, String> item : postData) {
            Object[] objArr2 = new Object[PADDING];
            objArr2[0] = item.getKey();
            objArr2[1] = item.getValue();
            sb.append(String.format("<input name='%s' type='hidden' value='%s' />", objArr2));
        }
        sb.append("</form></body></html>");
        webView.loadData(sb.toString(), "text/html", Utils.CHARSET_NAME);
    }
}
