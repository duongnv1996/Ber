package com.umberapp.umber.views;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.squareup.picasso.Picasso;
import com.sromku.simple.fb.SimpleFacebook;
import com.umberapp.umber.R;
import com.umberapp.umber.adapters.AdapterCategory;
import com.umberapp.umber.adapters.DescriptionAdapter;
import com.umberapp.umber.adapters.DescriptionOrderAdapter;
import com.umberapp.umber.adapters.DialogListAdapter;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.interfaces.CallbackDialog;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.models.Category;
import com.umberapp.umber.models.DetailOrderItem;
import com.umberapp.umber.models.Expert;
import com.umberapp.umber.models.ExpertBit;
import com.umberapp.umber.models.FeedbackUser;
import com.umberapp.umber.models.HICItem;
import com.umberapp.umber.models.NotificationItem;
import com.umberapp.umber.models.NotificationItemPage;
import com.umberapp.umber.models.OnsignalItem;
import com.umberapp.umber.models.Tag;
import com.umberapp.umber.models.User;
import com.umberapp.umber.socket.SocketConstants;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.FileUtils;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.utils.SharedPref;
import com.umberapp.umber.utils.StringUtil;
import com.wang.avi.AVLoadingIndicatorView;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog.OnTimeSetListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlertDialogCustom {

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.10 */
    static class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass10(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.11 */
    static class AnonymousClass11 implements TextWatcher {
        final /* synthetic */ ListView val$listView;

        AnonymousClass11(ListView listView) {
            this.val$listView = listView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (this.val$listView.getAdapter() != null) {
                ((AdapterCategory) this.val$listView.getAdapter()).getFilter().filter(charSequence);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.12 */
    static class AnonymousClass12 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass12(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.13 */
    static class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ List val$listRecentlyCategories;
        final /* synthetic */ ListView val$listView;
        final /* synthetic */ AVLoadingIndicatorView val$load;
        final /* synthetic */ TextView val$tvEmpty;
        final /* synthetic */ UmberService val$umberService;

        /* renamed from: com.umberapp.umber.views.AlertDialogCustom.13.1 */
        class C14531 implements Callback<ApiResponse<List<Category>>> {
            C14531() {
            }

            public void onResponse(Call<ApiResponse<List<Category>>> call, Response<ApiResponse<List<Category>>> response) {
                if (response.isSuccessful()) {
                    ApiResponse<List<Category>> apiResponse = (ApiResponse) response.body();
                    AnonymousClass13.this.val$listRecentlyCategories.clear();
                    AnonymousClass13.this.val$listRecentlyCategories.addAll((Collection) apiResponse.getData());
                    AnonymousClass13.this.val$listView.setAdapter(new AdapterCategory(AnonymousClass13.this.val$context, R.layout.item_check_dialog_list, AnonymousClass13.this.val$listRecentlyCategories));
                    AnonymousClass13.this.val$listView.setVisibility(View.VISIBLE);
                    AnonymousClass13.this.val$load.setVisibility(View.INVISIBLE);
                    AnonymousClass13.this.val$tvEmpty.setVisibility(View.INVISIBLE);
                    return;
                }
                RLog.m86e(Integer.valueOf(response.code()));
                AnonymousClass13.this.val$listView.setVisibility(View.INVISIBLE);
                AnonymousClass13.this.val$load.setVisibility(View.INVISIBLE);
                AnonymousClass13.this.val$tvEmpty.setVisibility(View.VISIBLE);
            }

            public void onFailure(Call<ApiResponse<List<Category>>> call, Throwable t) {
                RLog.m86e(t.getMessage());
                AnonymousClass13.this.val$listView.setVisibility(View.INVISIBLE);
                AnonymousClass13.this.val$load.setVisibility(View.INVISIBLE);
                AnonymousClass13.this.val$tvEmpty.setVisibility(View.VISIBLE);
            }
        }

        AnonymousClass13(ListView listView, AVLoadingIndicatorView aVLoadingIndicatorView, TextView textView, Context context, UmberService umberService, List list) {
            this.val$listView = listView;
            this.val$load = aVLoadingIndicatorView;
            this.val$tvEmpty = textView;
            this.val$context = context;
            this.val$umberService = umberService;
            this.val$listRecentlyCategories = list;
        }

        public void onClick(View view) {
            this.val$listView.setVisibility(4);
            this.val$load.setVisibility(0);
            this.val$tvEmpty.setVisibility(4);
            String token = SharedPref.getInstance(this.val$context).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
            String lang = SharedPref.getInstance(this.val$context).getString("lang", "en");
            if (lang.equals("in")) {
                lang = Constant.KEY_ID;
            }
            this.val$umberService.getCategory(token, lang).enqueue(new C14531());
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.14 */
    static class AnonymousClass14 implements OnClickListener {
        final /* synthetic */ AdapterCategory val$arrayAdapter;
        final /* synthetic */ ListView val$listView;
        final /* synthetic */ AVLoadingIndicatorView val$load;
        final /* synthetic */ TextView val$tvEmpty;

        AnonymousClass14(ListView listView, AdapterCategory adapterCategory, AVLoadingIndicatorView aVLoadingIndicatorView, TextView textView) {
            this.val$listView = listView;
            this.val$arrayAdapter = adapterCategory;
            this.val$load = aVLoadingIndicatorView;
            this.val$tvEmpty = textView;
        }

        public void onClick(View view) {
            this.val$listView.setAdapter(this.val$arrayAdapter);
            this.val$listView.setVisibility(View.VISIBLE);
            this.val$load.setVisibility(View.INVISIBLE);
            this.val$tvEmpty.setVisibility(View.INVISIBLE);
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.15 */
    static class AnonymousClass15 implements OnItemClickListener {
        final /* synthetic */ AdapterCategory val$arrayAdapter;
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ OnRespone val$respone;

        AnonymousClass15(OnRespone onRespone, AdapterCategory adapterCategory, Dialog dialog) {
            this.val$respone = onRespone;
            this.val$arrayAdapter = adapterCategory;
            this.val$dialog = dialog;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            this.val$respone.onRespone(this.val$arrayAdapter.getItem(i));
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.16 */
    static class AnonymousClass16 implements Callback<ApiResponse<Expert>> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ ExpertBit val$exBit;
        final /* synthetic */ CircleImageView val$imgAvt;
        final /* synthetic */ CircleImageView val$imgCategory;
        final /* synthetic */ LinearLayout val$llRoot;
        final /* synthetic */ AVLoadingIndicatorView val$load;
        final /* synthetic */ RatingBar val$rate;
        final /* synthetic */ RecyclerView val$rcv;
        final /* synthetic */ TextView val$tvCost;
        final /* synthetic */ TextView val$tvJobdone;
        final /* synthetic */ TextView val$tvName;

        AnonymousClass16(LinearLayout linearLayout, AVLoadingIndicatorView aVLoadingIndicatorView, RatingBar ratingBar, TextView textView, TextView textView2, ExpertBit expertBit, TextView textView3, Context context, CircleImageView circleImageView, CircleImageView circleImageView2, RecyclerView recyclerView) {
            this.val$llRoot = linearLayout;
            this.val$load = aVLoadingIndicatorView;
            this.val$rate = ratingBar;
            this.val$tvName = textView;
            this.val$tvCost = textView2;
            this.val$exBit = expertBit;
            this.val$tvJobdone = textView3;
            this.val$context = context;
            this.val$imgAvt = circleImageView;
            this.val$imgCategory = circleImageView2;
            this.val$rcv = recyclerView;
        }

        public void onResponse(Call<ApiResponse<Expert>> call, Response<ApiResponse<Expert>> response) {
            this.val$llRoot.setVisibility(View.VISIBLE);
            this.val$load.setVisibility(View.GONE);
            if (response.isSuccessful()) {
                Expert mExpert = (Expert) ((ApiResponse) response.body()).getData();
                if (mExpert != null) {
                    this.val$rate.setRating((float) mExpert.getRating());
                    this.val$tvName.setText(mExpert.getLast_name());
                    this.val$tvCost.setText(CommonUtils.formatDecima(this.val$exBit.getCostHour() + BuildConfig.FLAVOR));
                    this.val$tvJobdone.setText(this.val$exBit.getTotalOrderSuccess() + this.val$context.getString(R.string.job_dones));
                    if (!(mExpert.getAvatar() == null || mExpert.getAvatar().isEmpty())) {
                        Picasso.with(this.val$context).load(ApiConstants.API_MEDIA_ROOT + mExpert.getAvatar()).into(this.val$imgAvt);
                    }
                    if (!(mExpert.getCategory() == null || mExpert.getCategory().size() <= 0 || AppController.getInstance().getOrder() == null)) {
                        String idCate = AppController.getInstance().getOrder().getCategory();
                        for (Category cate : mExpert.getCategory()) {
                            if (cate.getId().equals(idCate)) {
                                Picasso.with(this.val$context).load(ApiConstants.API_PHOTO_ROOT + cate.getIcon()).into(this.val$imgCategory);
                                break;
                            }
                        }
                    }
                    this.val$rcv.setAdapter(new DescriptionAdapter(this.val$context, mExpert.getSelfDescriptions()));
                }
            }
        }

        public void onFailure(Call<ApiResponse<Expert>> call, Throwable t) {
            this.val$llRoot.setVisibility(View.VISIBLE);
            this.val$load.setVisibility(View.GONE);
            RLog.m86e(t.getMessage());
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.17 */
    static class AnonymousClass17 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass17(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.18 */
    static class AnonymousClass18 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ ExpertBit val$exBit;
        final /* synthetic */ OnRespone val$onRespone;

        AnonymousClass18(OnRespone onRespone, ExpertBit expertBit, Dialog dialog) {
            this.val$onRespone = onRespone;
            this.val$exBit = expertBit;
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$onRespone.onRespone(this.val$exBit);
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.19 */
    static class AnonymousClass19 implements OnClickListener {
        final /* synthetic */ OnRespone val$onResponeCancel;

        AnonymousClass19(OnRespone onRespone) {
            this.val$onResponeCancel = onRespone;
        }

        public void onClick(View view) {
            this.val$onResponeCancel.onRespone("cancle");
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.1 */
    static class C14541 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ OnRespone val$onRespone;

        C14541(OnRespone onRespone, Dialog dialog) {
            this.val$onRespone = onRespone;
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$onRespone.onRespone(null);
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.20 */
    static class AnonymousClass20 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ OnRespone val$onRespone;

        AnonymousClass20(Dialog dialog, OnRespone onRespone) {
            this.val$dialog = dialog;
            this.val$onRespone = onRespone;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
            this.val$onRespone.onRespone("ok");
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.21 */
    static class AnonymousClass21 implements OnClickListener {
        final /* synthetic */ OnRespone val$onResponeCancel;

        AnonymousClass21(OnRespone onRespone) {
            this.val$onResponeCancel = onRespone;
        }

        public void onClick(View view) {
            this.val$onResponeCancel.onRespone("cancle");
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.22 */
    static class AnonymousClass22 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ OnRespone val$onRespone;

        AnonymousClass22(Dialog dialog, OnRespone onRespone) {
            this.val$dialog = dialog;
            this.val$onRespone = onRespone;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
            this.val$onRespone.onRespone("ok");
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.23 */
    static class AnonymousClass23 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ EditText val$edt;
        final /* synthetic */ OnRespone val$onRespone;
        final /* synthetic */ RatingBar val$rate;

        AnonymousClass23(EditText editText, RatingBar ratingBar, OnRespone onRespone, Dialog dialog) {
            this.val$edt = editText;
            this.val$rate = ratingBar;
            this.val$onRespone = onRespone;
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            FeedbackUser fb = new FeedbackUser();
            fb.setComment(this.val$edt.getText() + BuildConfig.FLAVOR);
            fb.setStar((double) this.val$rate.getRating());
            this.val$onRespone.onRespone(fb);
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.24 */
    static class AnonymousClass24 implements OnClickListener {
        final /* synthetic */ Activity val$context;
        final /* synthetic */ SimpleFacebook val$simpleFacebook;

        AnonymousClass24(Activity activity, SimpleFacebook simpleFacebook) {
            this.val$context = activity;
            this.val$simpleFacebook = simpleFacebook;
        }

        public void onClick(View view) {
            CommonUtils.sendViaFacebook(this.val$context, this.val$context.getString(R.string.share_feedback), this.val$simpleFacebook);
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.25 */
    static class AnonymousClass25 implements OnClickListener {
        final /* synthetic */ Activity val$context;

        AnonymousClass25(Activity activity) {
            this.val$context = activity;
        }

        public void onClick(View view) {
            CommonUtils.shareGooglePlus(this.val$context, this.val$context.getString(R.string.share_feedback));
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.26 */
    static class AnonymousClass26 implements OnClickListener {
        final /* synthetic */ Activity val$context;

        AnonymousClass26(Activity activity) {
            this.val$context = activity;
        }

        public void onClick(View view) {
            String type = "image/*";
            try {
                AlertDialogCustom.createInstagramIntent(this.val$context, type, AlertDialogCustom.createFileFromInputStream(this.val$context, this.val$context.getAssets().open("icon_app.png")).getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Uri path = Uri.parse("android.resource://com.umberapp.umber/2130903042");
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.27 */
    static class AnonymousClass27 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass27(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.28 */
    static class AnonymousClass28 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ EditText val$edt;
        final /* synthetic */ OnRespone val$onRespone;
        final /* synthetic */ RadioGroup val$radioGroup;

        AnonymousClass28(Dialog dialog, RadioGroup radioGroup, EditText editText, OnRespone onRespone) {
            this.val$dialog = dialog;
            this.val$radioGroup = radioGroup;
            this.val$edt = editText;
            this.val$onRespone = onRespone;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
            String text = ((RadioButton) this.val$radioGroup.findViewById(this.val$radioGroup.getCheckedRadioButtonId())).getText().toString();
            if (this.val$edt.getText().length() > 0) {
                text = this.val$edt.getText().toString();
            }
            this.val$onRespone.onRespone(text);
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.29 */
    static class AnonymousClass29 implements TextWatcher {
        final /* synthetic */ Context val$context;
        final /* synthetic */ EditText val$edt;
        final /* synthetic */ OnRespone val$onRespone;
        final /* synthetic */ ProgressBar val$progressBar;
        final /* synthetic */ TextView val$tvSuccess;
        final /* synthetic */ UmberService val$umberService;

        /* renamed from: com.umberapp.umber.views.AlertDialogCustom.29.1 */
        class C14551 implements Callback<ApiResponse<String>> {
            C14551() {
            }

            public void onResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {
                AnonymousClass29.this.val$progressBar.setVisibility(View.GONE);
                if (!response.isSuccessful() || response.body() == null || ((ApiResponse) response.body()).getData() == null || ((String) ((ApiResponse) response.body()).getData()).isEmpty() || ((String) ((ApiResponse) response.body()).getData()).equals("NOT_FOUND")) {
                    RLog.m86e(Integer.valueOf(response.code()));
                    AnonymousClass29.this.val$edt.setBackgroundResource(R.drawable.bg_edt_unsuccess_form);
                    AnonymousClass29.this.val$tvSuccess.setVisibility(View.VISIBLE);
                    AnonymousClass29.this.val$tvSuccess.setText(R.string.unsuccess_code);
                    return;
                }
                AnonymousClass29.this.val$edt.setBackgroundResource(R.drawable.bg_edt_success_form);
                AnonymousClass29.this.val$onRespone.onRespone(((ApiResponse) response.body()).getData());
                AnonymousClass29.this.val$tvSuccess.setVisibility(View.VISIBLE);
                AnonymousClass29.this.val$tvSuccess.setText(R.string.success_code);
                AnonymousClass29.this.val$tvSuccess.setTextColor(AnonymousClass29.this.val$context.getResources().getColor(R.color.colorPrimary));
            }

            public void onFailure(Call<ApiResponse<String>> call, Throwable t) {
                AnonymousClass29.this.val$edt.setBackgroundResource(R.drawable.bg_edt_unsuccess_form);
                AnonymousClass29.this.val$progressBar.setVisibility(View.GONE);
                AnonymousClass29.this.val$tvSuccess.setVisibility(View.VISIBLE);
                AnonymousClass29.this.val$tvSuccess.setText(R.string.unknow_error);
                RLog.m86e(t.getMessage());
            }
        }

        AnonymousClass29(ProgressBar progressBar, UmberService umberService, EditText editText, OnRespone onRespone, TextView textView, Context context) {
            this.val$progressBar = progressBar;
            this.val$umberService = umberService;
            this.val$edt = editText;
            this.val$onRespone = onRespone;
            this.val$tvSuccess = textView;
            this.val$context = context;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence.length() > 0) {
                this.val$progressBar.setVisibility(0);
                this.val$umberService.verifyPromotionCode(AppController.getInstance().getUser().getToken(), charSequence.toString(), "promotion").enqueue(new C14551());
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.2 */
    static class C14562 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;

        C14562(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.30 */
    static class AnonymousClass30 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass30(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.31 */
    static class AnonymousClass31 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ EditText val$edt;

        AnonymousClass31(Dialog dialog, EditText editText) {
            this.val$dialog = dialog;
            this.val$edt = editText;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
            String text = BuildConfig.FLAVOR;
            if (this.val$edt.getText().length() <= 0) {
            }
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.32 */
    static class AnonymousClass32 implements Callback<ApiResponse<User>> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ CircleImageView val$imgAvt;

        AnonymousClass32(Context context, CircleImageView circleImageView) {
            this.val$context = context;
            this.val$imgAvt = circleImageView;
        }

        public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
            if (response.isSuccessful()) {
                String photoUrl = ((User) ((ApiResponse) response.body()).getData()).getAvatar();
                if (photoUrl != null && !photoUrl.isEmpty()) {
                    Picasso.with(this.val$context).load(ApiConstants.API_MEDIA_ROOT + photoUrl).into(this.val$imgAvt);
                }
            }
        }

        public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.33 */
    static class AnonymousClass33 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass33(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.34 */
    static class AnonymousClass34 implements OnClickListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ HICItem val$hic;

        AnonymousClass34(HICItem hICItem, Context context) {
            this.val$hic = hICItem;
            this.val$context = context;
        }

        public void onClick(View view) {
            CommonUtils.intentToCall(this.val$hic.getPhone(), this.val$context);
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.35 */
    static class AnonymousClass35 implements OnClickListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ HICItem val$hic;

        AnonymousClass35(HICItem hICItem, Context context) {
            this.val$hic = hICItem;
            this.val$context = context;
        }

        public void onClick(View view) {
            CommonUtils.intentToSms(this.val$hic.getPhone(), this.val$context);
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.36 */
    static class AnonymousClass36 implements Callback<ApiResponse<DetailOrderItem>> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ CircleImageView val$imgAvt;
        final /* synthetic */ ImageView val$imgCall;
        final /* synthetic */ CircleImageView val$imgCategory;
        final /* synthetic */ ImageView val$imgSms;
        final /* synthetic */ CardView val$llMap;
        final /* synthetic */ LinearLayout val$llRoot;
        final /* synthetic */ AVLoadingIndicatorView val$load;
        final /* synthetic */ OnRespone val$onRespone;
        final /* synthetic */ RatingBar val$rate;
        final /* synthetic */ RecyclerView val$rcv;
        final /* synthetic */ TextView val$tvAddressEx;
        final /* synthetic */ TextView val$tvAddressOrder;
        final /* synthetic */ TextView val$tvCategory;
        final /* synthetic */ TextView val$tvCosthour;
        final /* synthetic */ TextView val$tvFullNameEx;
        final /* synthetic */ TextView val$tvGender;
        final /* synthetic */ TextView val$tvJobId;
        final /* synthetic */ TextView val$tvJobdone;
        final /* synthetic */ TextView val$tvName;
        final /* synthetic */ TextView val$tvStatus;
        final /* synthetic */ TextView val$tvTags;
        final /* synthetic */ TextView val$tvTimeCreate;
        final /* synthetic */ TextView val$tvTimeWork;

        /* renamed from: com.umberapp.umber.views.AlertDialogCustom.36.1 */
        class C14571 implements OnClickListener {
            final /* synthetic */ DetailOrderItem val$orderItem;

            C14571(DetailOrderItem detailOrderItem) {
                this.val$orderItem = detailOrderItem;
            }

            public void onClick(View view) {
                CommonUtils.intentToCall(this.val$orderItem.getExpert().getPhone(), AnonymousClass36.this.val$context);
            }
        }

        /* renamed from: com.umberapp.umber.views.AlertDialogCustom.36.2 */
        class C14582 implements OnClickListener {
            final /* synthetic */ DetailOrderItem val$orderItem;

            C14582(DetailOrderItem detailOrderItem) {
                this.val$orderItem = detailOrderItem;
            }

            public void onClick(View view) {
                CommonUtils.intentToSms(this.val$orderItem.getExpert().getPhone(), AnonymousClass36.this.val$context);
            }
        }

        /* renamed from: com.umberapp.umber.views.AlertDialogCustom.36.3 */
        class C14593 implements OnClickListener {
            final /* synthetic */ DetailOrderItem val$orderItem;

            C14593(DetailOrderItem detailOrderItem) {
                this.val$orderItem = detailOrderItem;
            }

            public void onClick(View view) {
                AnonymousClass36.this.val$dialog.cancel();
                AnonymousClass36.this.val$onRespone.onRespone(this.val$orderItem);
            }
        }

        AnonymousClass36(LinearLayout linearLayout, AVLoadingIndicatorView aVLoadingIndicatorView, Context context, CircleImageView circleImageView, CircleImageView circleImageView2, TextView textView, TextView textView2, RatingBar ratingBar, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, CardView cardView, Dialog dialog, OnRespone onRespone) {
            this.val$llRoot = linearLayout;
            this.val$load = aVLoadingIndicatorView;
            this.val$context = context;
            this.val$imgAvt = circleImageView;
            this.val$imgCategory = circleImageView2;
            this.val$tvName = textView;
            this.val$tvJobdone = textView2;
            this.val$rate = ratingBar;
            this.val$tvJobId = textView3;
            this.val$tvStatus = textView4;
            this.val$tvTimeWork = textView5;
            this.val$tvAddressOrder = textView6;
            this.val$tvCategory = textView7;
            this.val$tvTags = textView8;
            this.val$tvTimeCreate = textView9;
            this.val$tvFullNameEx = textView10;
            this.val$tvCosthour = textView11;
            this.val$tvAddressEx = textView12;
            this.val$tvGender = textView13;
            this.val$rcv = recyclerView;
            this.val$imgCall = imageView;
            this.val$imgSms = imageView2;
            this.val$llMap = cardView;
            this.val$dialog = dialog;
            this.val$onRespone = onRespone;
        }

        public void onResponse(Call<ApiResponse<DetailOrderItem>> call, Response<ApiResponse<DetailOrderItem>> response) {
            this.val$llRoot.setVisibility(View.VISIBLE);
            this.val$load.setVisibility(View.GONE);
            if (response.isSuccessful()) {
                DetailOrderItem orderItem = (DetailOrderItem) ((ApiResponse) response.body()).getData();
                if (orderItem != null) {
                    if (!(orderItem.getExpert().getAvatar() == null || orderItem.getExpert().getAvatar().isEmpty())) {
                        Picasso.with(this.val$context).load(ApiConstants.API_MEDIA_ROOT + orderItem.getExpert().getAvatar()).into(this.val$imgAvt);
                    }
                    if (!(orderItem.getCategory().getIcon() == null || orderItem.getCategory().getIcon().isEmpty())) {
                        Picasso.with(this.val$context).load(ApiConstants.API_PHOTO_ROOT + orderItem.getCategory().getIcon()).into(this.val$imgCategory);
                    }
                    this.val$tvName.setText(orderItem.getExpert().getFirst_name());
                    this.val$tvJobdone.setText(orderItem.getExpert().getTotalOrderSuccess() + this.val$context.getString(R.string.job_dones));
                    this.val$rate.setRating((float) orderItem.getExpert().getRating());
                    this.val$tvJobId.setText(orderItem.getInvoice());
                    this.val$tvStatus.setText(ApiUtils.getStatusFromServer(orderItem.getStatus(), this.val$context));
                    this.val$tvTimeWork.setText(CommonUtils.getDate(Long.parseLong(orderItem.getRangeTime().getStart()), StringUtil.DATE_FORMAT_18) + " - " + CommonUtils.getDate(Long.parseLong(orderItem.getRangeTime().getEnd()), "HH:mm [MM/dd]"));
                    this.val$tvAddressOrder.setText(orderItem.getAddress());
                    this.val$tvCategory.setText(orderItem.getCategory().getName());
                    if (orderItem.getTags() != null && orderItem.getTags().size() > 0) {
                        String msg = BuildConfig.FLAVOR;
                        for (Tag tag : orderItem.getTags()) {
                            msg = msg + tag.getText() + ",";
                        }
                        this.val$tvTags.setText(msg);
                    }
                    this.val$tvTimeCreate.setText(CommonUtils.getDate(Long.parseLong(orderItem.getRangeTime().getStart()), "HH:mm [MM/dd]"));
                    this.val$tvFullNameEx.setText(orderItem.getExpert().getFirst_name() + " " + orderItem.getExpert().getLast_name());
                    this.val$tvCosthour.setText(orderItem.getExpert().getCostHour() + BuildConfig.FLAVOR);
                    this.val$tvAddressEx.setText(orderItem.getExpert().getAddress());
                    this.val$tvGender.setText(orderItem.getExpert().getGender());
                    this.val$rcv.setAdapter(new DescriptionOrderAdapter(this.val$context, orderItem.getExpert().getSelfDescriptions()));
                    if (!(orderItem.getExpert().getPhone() == null || orderItem.getExpert().getPhone().isEmpty())) {
                        this.val$imgCall.setVisibility(View.VISIBLE);
                        this.val$imgSms.setVisibility(View.VISIBLE);
                        this.val$imgCall.setOnClickListener(new C14571(orderItem));
                        this.val$imgSms.setOnClickListener(new C14582(orderItem));
                    }
                    if (orderItem.getStatus().equals(SocketConstants.KEY_ON_MY_WAY) || orderItem.getStatus().equals(SocketConstants.KEY_ARRIVED)) {
                        this.val$llMap.setVisibility(View.VISIBLE);
                        this.val$llMap.setOnClickListener(new C14593(orderItem));
                    }
                }
            }
        }

        public void onFailure(Call<ApiResponse<DetailOrderItem>> call, Throwable t) {
            this.val$llRoot.setVisibility(View.VISIBLE);
            this.val$load.setVisibility(View.GONE);
            RLog.m86e(t.getMessage());
            this.val$dialog.cancel();
            AlertDialogCustom.dialogMsg(this.val$context, this.val$context.getString(R.string.error_status)).show();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.37 */
    static class AnonymousClass37 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass37(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.38 */
    static class AnonymousClass38 implements Callback<ApiResponse<DetailOrderItem>> {
        final /* synthetic */ Activity val$context;
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ CircleImageView val$imgAvt;
        final /* synthetic */ ImageView val$imgCall;
        final /* synthetic */ CircleImageView val$imgCategory;
        final /* synthetic */ ImageView val$imgSms;
        final /* synthetic */ CardView val$llMap;
        final /* synthetic */ LinearLayout val$llRoot;
        final /* synthetic */ LinearLayout val$llRootFooterEx;
        final /* synthetic */ LinearLayout val$llRootHeader;
        final /* synthetic */ AVLoadingIndicatorView val$load;
        final /* synthetic */ OnRespone val$onRespone;
        final /* synthetic */ RatingBar val$rate;
        final /* synthetic */ RecyclerView val$rcv;
        final /* synthetic */ TextView val$tvAddressEx;
        final /* synthetic */ TextView val$tvAddressOrder;
        final /* synthetic */ TextView val$tvCategory;
        final /* synthetic */ TextView val$tvCosthour;
        final /* synthetic */ TextView val$tvFullNameEx;
        final /* synthetic */ TextView val$tvGender;
        final /* synthetic */ TextView val$tvJobId;
        final /* synthetic */ TextView val$tvJobdone;
        final /* synthetic */ TextView val$tvName;
        final /* synthetic */ TextView val$tvStatus;
        final /* synthetic */ TextView val$tvTags;
        final /* synthetic */ TextView val$tvTimeCreate;
        final /* synthetic */ TextView val$tvTimeWork;

        /* renamed from: com.umberapp.umber.views.AlertDialogCustom.38.1 */
        class C14601 implements OnClickListener {
            final /* synthetic */ DetailOrderItem val$orderItem;

            C14601(DetailOrderItem detailOrderItem) {
                this.val$orderItem = detailOrderItem;
            }

            public void onClick(View view) {
                CommonUtils.intentToCall(this.val$orderItem.getExpert().getPhone(), AnonymousClass38.this.val$context);
            }
        }

        /* renamed from: com.umberapp.umber.views.AlertDialogCustom.38.2 */
        class C14612 implements OnClickListener {
            final /* synthetic */ DetailOrderItem val$orderItem;

            C14612(DetailOrderItem detailOrderItem) {
                this.val$orderItem = detailOrderItem;
            }

            public void onClick(View view) {
                CommonUtils.intentToSms(this.val$orderItem.getExpert().getPhone(), AnonymousClass38.this.val$context);
            }
        }

        /* renamed from: com.umberapp.umber.views.AlertDialogCustom.38.3 */
        class C14623 implements OnClickListener {
            final /* synthetic */ DetailOrderItem val$orderItem;

            C14623(DetailOrderItem detailOrderItem) {
                this.val$orderItem = detailOrderItem;
            }

            public void onClick(View view) {
                AnonymousClass38.this.val$dialog.cancel();
                AnonymousClass38.this.val$onRespone.onRespone(this.val$orderItem);
            }
        }

        AnonymousClass38(LinearLayout linearLayout, AVLoadingIndicatorView aVLoadingIndicatorView, Activity activity, CircleImageView circleImageView, CircleImageView circleImageView2, TextView textView, TextView textView2, RatingBar ratingBar, TextView textView3, TextView textView4, TextView textView5, TextView textView6, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, CardView cardView, Dialog dialog, OnRespone onRespone) {
            this.val$llRoot = linearLayout;
            this.val$load = aVLoadingIndicatorView;
            this.val$context = activity;
            this.val$imgAvt = circleImageView;
            this.val$imgCategory = circleImageView2;
            this.val$tvName = textView;
            this.val$tvJobdone = textView2;
            this.val$rate = ratingBar;
            this.val$tvFullNameEx = textView3;
            this.val$tvCosthour = textView4;
            this.val$tvAddressEx = textView5;
            this.val$tvGender = textView6;
            this.val$rcv = recyclerView;
            this.val$imgCall = imageView;
            this.val$imgSms = imageView2;
            this.val$llRootHeader = linearLayout2;
            this.val$llRootFooterEx = linearLayout3;
            this.val$tvStatus = textView7;
            this.val$tvJobId = textView8;
            this.val$tvTimeWork = textView9;
            this.val$tvAddressOrder = textView10;
            this.val$tvCategory = textView11;
            this.val$tvTags = textView12;
            this.val$tvTimeCreate = textView13;
            this.val$llMap = cardView;
            this.val$dialog = dialog;
            this.val$onRespone = onRespone;
        }

        public void onResponse(Call<ApiResponse<DetailOrderItem>> call, Response<ApiResponse<DetailOrderItem>> response) {
            this.val$llRoot.setVisibility(View.VISIBLE);
            this.val$load.setVisibility(View.GONE);
            if (response.isSuccessful()) {
                DetailOrderItem orderItem = (DetailOrderItem) ((ApiResponse) response.body()).getData();
                if (orderItem != null) {
                    if (orderItem.getExpert() != null) {
                        if (!(orderItem.getExpert().getAvatar() == null || orderItem.getExpert().getAvatar().isEmpty())) {
                            Picasso.with(this.val$context).load(ApiConstants.API_MEDIA_ROOT + orderItem.getExpert().getAvatar()).into(this.val$imgAvt);
                        }
                        if (!(orderItem.getCategory().getIcon() == null || orderItem.getCategory().getIcon().isEmpty())) {
                            Picasso.with(this.val$context).load(ApiConstants.API_PHOTO_ROOT + orderItem.getCategory().getIcon()).into(this.val$imgCategory);
                        }
                        this.val$tvName.setText(orderItem.getExpert().getFirst_name());
                        this.val$tvJobdone.setText(orderItem.getExpert().getTotalOrderSuccess() + this.val$context.getString(R.string.job_dones));
                        this.val$rate.setRating((float) orderItem.getExpert().getRating());
                        this.val$tvFullNameEx.setText(orderItem.getExpert().getFirst_name() + " " + orderItem.getExpert().getLast_name());
                        this.val$tvCosthour.setText(orderItem.getExpert().getCostHour() + BuildConfig.FLAVOR);
                        this.val$tvAddressEx.setText(orderItem.getExpert().getAddress());
                        this.val$tvGender.setText(orderItem.getExpert().getGender());
                        this.val$rcv.setAdapter(new DescriptionOrderAdapter(this.val$context, orderItem.getExpert().getSelfDescriptions()));
                        if (!(orderItem.getExpert().getPhone() == null || orderItem.getExpert().getPhone().isEmpty())) {
                            this.val$imgCall.setVisibility(View.VISIBLE);
                            this.val$imgSms.setVisibility(View.VISIBLE);
                            this.val$imgCall.setOnClickListener(new C14601(orderItem));
                            this.val$imgSms.setOnClickListener(new C14612(orderItem));
                        }
                    } else {
                        this.val$llRootHeader.setVisibility(View.GONE);
                        this.val$llRootFooterEx.setVisibility(View.GONE);
                    }
                    if (!(orderItem.getExoertsJoined() == null || orderItem.getExoertsJoined().get(0) == null)) {
                        this.val$tvCosthour.setText(((ExpertBit) orderItem.getExoertsJoined().get(0)).getCostHour() + BuildConfig.FLAVOR);
                    }
                    this.val$tvStatus.setText(ApiUtils.getStatusFromServer(orderItem.getStatus(), this.val$context));
                    this.val$tvJobId.setText(orderItem.getInvoice());
                    this.val$tvTimeWork.setText(CommonUtils.getDate(Long.parseLong(orderItem.getRangeTime().getStart()), StringUtil.DATE_FORMAT_18) + " - " + CommonUtils.getDate(Long.parseLong(orderItem.getRangeTime().getEnd()), "HH:mm [MM/dd]"));
                    this.val$tvAddressOrder.setText(orderItem.getAddress());
                    this.val$tvCategory.setText(orderItem.getCategory().getName());
                    if (orderItem.getTags() != null && orderItem.getTags().size() > 0) {
                        String msg = BuildConfig.FLAVOR;
                        for (Tag tag : orderItem.getTags()) {
                            msg = msg + tag.getText() + ",";
                        }
                        this.val$tvTags.setText(msg);
                    }
                    this.val$tvTimeCreate.setText(CommonUtils.getDate(Long.parseLong(orderItem.getRangeTime().getStart()), "HH:mm [MM/dd]"));
                    if (orderItem.getStatus().equals(SocketConstants.KEY_ON_MY_WAY) || orderItem.getStatus().equals(SocketConstants.KEY_ARRIVED)) {
                        this.val$llMap.setVisibility(View.GONE);
                        this.val$llMap.setOnClickListener(new C14623(orderItem));
                    }
                }
            }
        }

        public void onFailure(Call<ApiResponse<DetailOrderItem>> call, Throwable t) {
            this.val$llRoot.setVisibility(View.VISIBLE);
            this.val$load.setVisibility(View.GONE);
            RLog.m86e(t.getMessage());
            if (!this.val$context.isFinishing()) {
                AlertDialogCustom.dialogMsg(this.val$context, this.val$context.getString(R.string.error_status)).show();
            }
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.39 */
    static class AnonymousClass39 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;

        AnonymousClass39(Dialog dialog) {
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.3 */
    static class C14633 implements OnClickListener {
        final /* synthetic */ OnRespone val$onRespone;

        C14633(OnRespone onRespone) {
            this.val$onRespone = onRespone;
        }

        public void onClick(View view) {
            this.val$onRespone.onRespone(null);
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.4 */
    static class C14644 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ OnRespone val$okResponse;

        C14644(Dialog dialog, OnRespone onRespone) {
            this.val$dialog = dialog;
            this.val$okResponse = onRespone;
        }

        public void onClick(View view) {
            this.val$dialog.cancel();
            this.val$okResponse.onRespone(null);
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.5 */
    static class C14665 implements OnClickListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ OnRespone val$date;
        final /* synthetic */ Date val$dateDefault;
        final /* synthetic */ EditText val$edtDate;
        final /* synthetic */ FragmentManager val$manager;
        final /* synthetic */ Date val$oldFromDate;
        final /* synthetic */ Date val$oldToDate;

        /* renamed from: com.umberapp.umber.views.AlertDialogCustom.5.1 */
        class C14651 implements OnDateSetListener {
            C14651() {
            }

            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                Date d = new Date(year, monthOfYear, dayOfMonth, C14665.this.val$oldFromDate.getHours(), C14665.this.val$oldFromDate.getMinutes());
                long t = System.currentTimeMillis();
                RLog.m86e("s - " + d.getTime());
                Date cDate = CommonUtils.getCurrentDate();
                cDate.setHours(C14665.this.val$dateDefault.getHours());
                cDate.setMinutes(C14665.this.val$dateDefault.getMinutes());
                RLog.m86e("a - " + cDate.getTime() + "calenda - " + Calendar.getInstance().getTime().getTime());
                RLog.m86e(Long.valueOf(t));
                if (d.getTime() < cDate.getTime()) {
                    Toast.makeText(C14665.this.val$context, R.string.errror_time, 0).show();
                    return;
                }
                String mDateString = (monthOfYear + 1) + "/" + dayOfMonth + "/" + year;
                long timeSeleted = CommonUtils.convertToSec2(mDateString, StringUtil.DATE_FORMAT_7);
                long currentTime = C14665.this.val$dateDefault.getTime();
                C14665.this.val$oldFromDate.setDate(dayOfMonth);
                C14665.this.val$oldFromDate.setMonth(monthOfYear);
                C14665.this.val$oldFromDate.setYear(year);
                C14665.this.val$oldToDate.setDate(dayOfMonth);
                C14665.this.val$oldToDate.setMonth(monthOfYear);
                C14665.this.val$oldToDate.setYear(year);
                C14665.this.val$date.onRespone(mDateString);
                C14665.this.val$edtDate.setText(mDateString);
            }
        }

        C14665(Date date, Date date2, Context context, Date date3, OnRespone onRespone, EditText editText, FragmentManager fragmentManager) {
            this.val$oldFromDate = date;
            this.val$dateDefault = date2;
            this.val$context = context;
            this.val$oldToDate = date3;
            this.val$date = onRespone;
            this.val$edtDate = editText;
            this.val$manager = fragmentManager;
        }

        public void onClick(View view) {
            DatePickerDialog date1 = DatePickerDialog.newInstance(new C14651(), this.val$oldFromDate.getYear(), this.val$oldFromDate.getMonth(), this.val$oldFromDate.getDate());
            date1.setMinDate(Calendar.getInstance());
            Calendar c = Calendar.getInstance();
            c.add(5, 15);
            date1.setMaxDate(c);
            date1.setAccentColor(this.val$context.getResources().getColor(R.color.colorPrimary));
            date1.show(this.val$manager, "date");
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.6 */
    static class C14686 implements OnClickListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ Date val$dateDefault;
        final /* synthetic */ EditText val$edtFrom;
        final /* synthetic */ EditText val$edtTo;
        final /* synthetic */ FragmentManager val$manager;
        final /* synthetic */ Date val$oldFromDate;
        final /* synthetic */ Date val$oldToDate;
        final /* synthetic */ OnRespone val$start;
        final /* synthetic */ OnRespone val$to;

        /* renamed from: com.umberapp.umber.views.AlertDialogCustom.6.1 */
        class C14671 implements OnTimeSetListener {
            C14671() {
            }

            public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
                Date d = new Date(C14686.this.val$oldFromDate.getYear(), C14686.this.val$oldFromDate.getMonth(), C14686.this.val$oldFromDate.getDate(), hourOfDay, minute);
                Date cDate = new Date(C14686.this.val$dateDefault.getTime());
                cDate.setHours(C14686.this.val$dateDefault.getHours());
                cDate.setMinutes(C14686.this.val$dateDefault.getMinutes());
                if (d.getTime() < cDate.getTime()) {
                    Toast.makeText(C14686.this.val$context, R.string.errror_time, 0).show();
                    return;
                }
                C14686.this.val$start.onRespone(hourOfDay + ":" + minute);
                int hour = hourOfDay;
                int hourTo = hourOfDay + 1;
                C14686.this.val$oldToDate.setHours(hourOfDay + 1);
                C14686.this.val$oldToDate.setMinutes(minute);
                C14686.this.val$oldFromDate.setMinutes(minute);
                C14686.this.val$oldFromDate.setHours(hourOfDay);
                C14686.this.val$to.onRespone(C14686.this.val$oldToDate.getHours() + ":" + C14686.this.val$oldToDate.getMinutes());
                C14686.this.val$edtFrom.setText(CommonUtils.getDate(C14686.this.val$oldFromDate.getTime(), StringUtil.DATE_FORMAT_18));
                C14686.this.val$edtTo.setText(CommonUtils.getDate(C14686.this.val$oldToDate.getTime(), StringUtil.DATE_FORMAT_18));
            }
        }

        C14686(Date date, Date date2, Context context, OnRespone onRespone, Date date3, OnRespone onRespone2, EditText editText, EditText editText2, FragmentManager fragmentManager) {
            this.val$oldFromDate = date;
            this.val$dateDefault = date2;
            this.val$context = context;
            this.val$start = onRespone;
            this.val$oldToDate = date3;
            this.val$to = onRespone2;
            this.val$edtFrom = editText;
            this.val$edtTo = editText2;
            this.val$manager = fragmentManager;
        }

        public void onClick(View view) {
            TimePickerDialog dpd = TimePickerDialog.newInstance(new C14671(), this.val$oldFromDate.getHours(), this.val$oldFromDate.getMinutes(), true);
            dpd.setAccentColor(this.val$context.getResources().getColor(R.color.colorPrimary));
            dpd.show(this.val$manager, "a");
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.7 */
    static class C14707 implements OnClickListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ EditText val$edtTo;
        final /* synthetic */ FragmentManager val$manager;
        final /* synthetic */ Date val$oldFromDate;
        final /* synthetic */ Date val$oldToDate;
        final /* synthetic */ OnRespone val$to;

        /* renamed from: com.umberapp.umber.views.AlertDialogCustom.7.1 */
        class C14691 implements OnTimeSetListener {
            C14691() {
            }

            public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
                int oldH = C14707.this.val$oldToDate.getHours();
                int oldM = C14707.this.val$oldToDate.getMinutes();
                C14707.this.val$oldToDate.setHours(hourOfDay);
                C14707.this.val$oldToDate.setMinutes(minute);
                if (C14707.this.val$oldToDate.getTime() < C14707.this.val$oldFromDate.getTime() + 3600000) {
                    Toast.makeText(C14707.this.val$context, R.string.errror_time, 0).show();
                    C14707.this.val$oldToDate.setHours(oldH);
                    C14707.this.val$oldToDate.setMinutes(oldM);
                }
                C14707.this.val$to.onRespone(C14707.this.val$oldToDate.getHours() + ":" + C14707.this.val$oldToDate.getMinutes());
                C14707.this.val$edtTo.setText(CommonUtils.getDate(C14707.this.val$oldToDate.getTime(), StringUtil.DATE_FORMAT_18));
            }
        }

        C14707(Date date, Date date2, Context context, OnRespone onRespone, EditText editText, FragmentManager fragmentManager) {
            this.val$oldToDate = date;
            this.val$oldFromDate = date2;
            this.val$context = context;
            this.val$to = onRespone;
            this.val$edtTo = editText;
            this.val$manager = fragmentManager;
        }

        public void onClick(View view) {
            TimePickerDialog dpd = TimePickerDialog.newInstance(new C14691(), this.val$oldToDate.getHours(), this.val$oldToDate.getMinutes(), true);
            dpd.setAccentColor(this.val$context.getResources().getColor(R.color.colorPrimary));
            dpd.show(this.val$manager, "a");
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.8 */
    static class C14718 implements OnClickListener {
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ Date val$oldFromDate;
        final /* synthetic */ Date val$oldToDate;
        final /* synthetic */ OnRespone val$start;
        final /* synthetic */ OnRespone val$to;

        C14718(OnRespone onRespone, Date date, OnRespone onRespone2, Date date2, Dialog dialog) {
            this.val$start = onRespone;
            this.val$oldFromDate = date;
            this.val$to = onRespone2;
            this.val$oldToDate = date2;
            this.val$dialog = dialog;
        }

        public void onClick(View view) {
            this.val$start.onRespone(this.val$oldFromDate.getHours() + ":" + this.val$oldFromDate.getMinutes());
            this.val$to.onRespone(this.val$oldToDate.getHours() + ":" + this.val$oldToDate.getMinutes());
            this.val$dialog.cancel();
        }
    }

    /* renamed from: com.umberapp.umber.views.AlertDialogCustom.9 */
    static class C14729 implements OnItemClickListener {
        final /* synthetic */ CallbackDialog val$callbackDialog;
        final /* synthetic */ int val$code;
        final /* synthetic */ Dialog val$dialog;
        final /* synthetic */ String[] val$strings;

        C14729(CallbackDialog callbackDialog, String[] strArr, int i, Dialog dialog) {
            this.val$callbackDialog = callbackDialog;
            this.val$strings = strArr;
            this.val$code = i;
            this.val$dialog = dialog;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            this.val$callbackDialog.onClickDialogEdt(this.val$strings[i], this.val$code);
            this.val$dialog.cancel();
        }
    }

    public static Dialog dialogMsg(Context context, String message, OnRespone onRespone) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_message_custom, null, false);
        ((TextView) view.findViewById(R.id.tv_mess)).setText(message);
        Button button = (Button) view.findViewById(R.id.btn_ok);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        dialog.setCancelable(false);
        button.setOnClickListener(new C14541(onRespone, dialog));
        return dialog;
    }

    public static Dialog dialogMsg(Context context, String message) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_message_custom, null, false);
        ((TextView) view.findViewById(R.id.tv_mess)).setText(message);
        Button button = (Button) view.findViewById(R.id.btn_ok);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        button.setOnClickListener(new C14562(dialog));
        return dialog;
    }

    public static Dialog dialogConfirm(Context context, ExpertBit ex, OnRespone onRespone, OnRespone okResponse) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_confirm, null, false);
        CardView buttonCancel = (CardView) view.findViewById(R.id.ll_cancel);
        CardView btnOK = (CardView) view.findViewById(R.id.ll_ok);
        ((TextView) view.findViewById(R.id.tv_mess)).setText(String.format(context.getString(R.string.alert_order), new Object[]{ex.getFirst_name() + " " + ex.getLast_name(), AppController.getInstance().getAppConfig().getCurrency() + AppController.getInstance().getAppConfig().getCancelFee()}));
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        buttonCancel.setOnClickListener(new C14633(onRespone));
        btnOK.setOnClickListener(new C14644(dialog, okResponse));
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog dialogTime(Context context, FragmentManager manager, OnRespone<String> date, OnRespone<String> start, OnRespone<String> to, Date dateDefault, Date dateToDefault) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_time, null, false);
        EditText edtDate = (EditText) view.findViewById(R.id.edt_date);
        EditText edtFrom = (EditText) view.findViewById(R.id.edt_start);
        EditText edtTo = (EditText) view.findViewById(R.id.edt_to);
        Button button = (Button) view.findViewById(R.id.btn_ok);
        int m = dateDefault.getMonth() + 1;
        RLog.m86e(m + "/" + dateDefault.getDate() + "/" + dateDefault.getYear());
        if (dateDefault.getYear() < 2016) {
            dateDefault.setYear(dateDefault.getYear() + 1900);
        }
        if (dateToDefault.getYear() < 2016) {
            dateToDefault.setYear(dateToDefault.getYear() + 1900);
        }
        edtDate.setText(m + "/" + dateDefault.getDate() + "/" + dateDefault.getYear());
        long timeEnd = System.currentTimeMillis() + 3600000;
        edtFrom.setText(CommonUtils.getDate(dateDefault.getTime(), StringUtil.DATE_FORMAT_18));
        edtTo.setText(CommonUtils.getDate(dateToDefault.getTime(), StringUtil.DATE_FORMAT_18));
        Date oldFromDate = new Date(dateDefault.getYear(), dateDefault.getMonth(), dateDefault.getDate(), dateDefault.getHours(), dateDefault.getMinutes());
        Date oldToDate = new Date(dateToDefault.getYear(), dateToDefault.getMonth(), dateToDefault.getDate(), dateToDefault.getHours(), dateToDefault.getMinutes());
        edtDate.setOnClickListener(new C14665(oldFromDate, dateDefault, context, oldToDate, date, edtDate, manager));
        edtFrom.setOnClickListener(new C14686(oldFromDate, dateDefault, context, start, oldToDate, to, edtFrom, edtTo, manager));
        edtTo.setOnClickListener(new C14707(oldToDate, oldFromDate, context, to, edtTo, manager));
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        button.setOnClickListener(new C14718(start, oldFromDate, to, oldToDate, dialog));
        dialog.getWindow().setLayout(-2, -2);
        return dialog;
    }

    public static Dialog dialogList(Context context, String titleDialog, CallbackDialog callbackDialog, String[] strings, int code, String selection) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_list, null, false);
        ImageView buttonClose = (ImageView) view.findViewById(R.id.btn_close_dialog);
        TextView tvTitleDialog = (TextView) view.findViewById(R.id.title_dialog);
        ListView listView = (ListView) view.findViewById(R.id.list);
        ArrayList<String> items = new ArrayList();
        for (int i = 0; i < strings.length; i++) {
            if (code == 0) {
                items.add(CommonUtils.formatDecima(strings[i]) + " vn\u0111");
            } else if (code == 1) {
                items.add(CommonUtils.formatDecima(strings[i]) + "vn\u0111/ 1 th\u00e1ng");
            } else if (code == 2) {
                items.add(strings[i]);
            }
        }
        if (code == 0) {
            selection = CommonUtils.formatDecima(selection) + " vn\u0111";
        } else if (code == 1) {
            selection = CommonUtils.formatDecima(selection) + "vn\u0111/ 1 th\u00e1ng";
        } else if (code == 2) {
        }
        listView.setAdapter(new DialogListAdapter(context, R.layout.item_check_dialog_list, items, selection));
        listView.setSelection(0);
        tvTitleDialog.setText(titleDialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        listView.setOnItemClickListener(new C14729(callbackDialog, strings, code, dialog));
        buttonClose.setOnClickListener(new AnonymousClass10(dialog));
        dialog.getWindow().setLayout(-2, -2);
        return dialog;
    }

    public static float dpToPx(Context context, float valueInDp) {
        return TypedValue.applyDimension(1, valueInDp, context.getResources().getDisplayMetrics());
    }

    private void getRecentlyCategory(UmberService umberService) {
    }

    public static Dialog dialogTerm(Context context) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_webview, null, false);
        WebView webView = (WebView) view.findViewById(R.id.web);
        String lang = SharedPref.getInstance(context).getString("lang", "en");
        webView.getSettings().setJavaScriptEnabled(true);
        if (lang.equals("en")) {
            webView.loadUrl("file:///android_asset/UMBER_TERM_EN.html");
        } else {
            webView.loadUrl("file:///android_asset/UMBER_TERMS_ID.html");
        }
        dialog.setContentView(view);
        dialog.getWindow().setLayout(-2, -1);
        dialog.setCancelable(true);
        return dialog;
    }

    public static Dialog dialogCategory(Context context, List<Category> list, UmberService umberService, OnRespone<Category> respone) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(new ContextThemeWrapper(context, (int) R.style.DialogSlideAnim));
        View view = factory.inflate(R.layout.dialog_get_category, null, false);
        ListView listView = (ListView) view.findViewById(R.id.lst_category);
        ImageView close = (ImageView) view.findViewById(R.id.close);
        TextView tvEmpty = (TextView) view.findViewById(R.id.tv_empty);
        AVLoadingIndicatorView load = (AVLoadingIndicatorView) view.findViewById(R.id.load);
        FrameLayout nomalCategory = (FrameLayout) view.findViewById(R.id.ll_nommal_catgory);
        FrameLayout recenlyCategory = (FrameLayout) view.findViewById(R.id.ll_recenly_catgory);
        List<Category> listRecentlyCategories = new ArrayList();
        ((EditText) view.findViewById(R.id.edt_search_cate)).addTextChangedListener(new AnonymousClass11(listView));
        AdapterCategory arrayAdapter = new AdapterCategory(context, R.layout.item_check_dialog_list, list);
        listView.setAdapter(arrayAdapter);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        close.setOnClickListener(new AnonymousClass12(dialog));
        recenlyCategory.setOnClickListener(new AnonymousClass13(listView, load, tvEmpty, context, umberService, listRecentlyCategories));
        nomalCategory.setOnClickListener(new AnonymousClass14(listView, arrayAdapter, load, tvEmpty));
        listView.setOnItemClickListener(new AnonymousClass15(respone, arrayAdapter, dialog));
        Window window = dialog.getWindow();
        window.setGravity(80);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        window.setLayout(-1, -1);
        return dialog;
    }

    public static Dialog dialogDetailExpert(Context context, OnRespone<ExpertBit> onRespone, ExpertBit exBit) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_detail_ex, null, false);
        CardView buttonClose = (CardView) view.findViewById(R.id.ll_back);
        CardView btnSelect = (CardView) view.findViewById(R.id.ll_select);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        RecyclerView rcv = (RecyclerView) view.findViewById(R.id.rcv_des);
        TextView tvCost = (TextView) view.findViewById(R.id.tv_des);
        CircleImageView imgAvt = (CircleImageView) view.findViewById(R.id.profilePic);
        CircleImageView imgCategory = (CircleImageView) view.findViewById(R.id.ic_category);
        RatingBar rate = (RatingBar) view.findViewById(R.id.rate);
        TextView tvJobdone = (TextView) view.findViewById(R.id.tv_job_done);
        AVLoadingIndicatorView load = (AVLoadingIndicatorView) view.findViewById(R.id.load);
        LinearLayout llRoot = (LinearLayout) view.findViewById(R.id.ll_root);
        rcv.setLayoutManager(new LinearLayoutManager(context));
        rcv.setHasFixedSize(true);
        UmberService umberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        Call<ApiResponse<Expert>> call = umberService.getInforEx(AppController.getInstance().getUser().getToken(), exBit.getId());
        call.enqueue(new AnonymousClass16(llRoot, load, rate, tvName, tvCost, exBit, tvJobdone, context, imgAvt, imgCategory, rcv));
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        buttonClose.setOnClickListener(new AnonymousClass17(dialog));
        btnSelect.setOnClickListener(new AnonymousClass18(onRespone, exBit, dialog));
        dialog.getWindow().setLayout(-2, -2);
        return dialog;
    }

    public static Dialog dialogConfirmCost(Context context, OnRespone onRespone, OnRespone onResponeCancel, NotificationItem noti) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_confirm_cost, null, false);
        CardView buttonClose = (CardView) view.findViewById(R.id.ll_cancel);
        CardView btnSelect = (CardView) view.findViewById(R.id.ll_ok);
        TextView tvTime = (TextView) view.findViewById(R.id.tv_des_time);
        TextView tvCost = (TextView) view.findViewById(R.id.tv_des_cost);
        TextView tvFee = (TextView) view.findViewById(R.id.tv_des_fee);
        TextView tvTotal = (TextView) view.findViewById(R.id.tv_des_total);
        TextView tvMaterial = (TextView) view.findViewById(R.id.tv_des_material);
        if (noti.getContent().getFields().getStatusOrder().equals(SocketConstants.STATUS_ORDER_ESTIMATED)) {
            tvCost.setText(context.getString(R.string.unit_cost) + CommonUtils.formatDecima(noti.getContent().getFields().getCostForTime() + BuildConfig.FLAVOR));
            tvMaterial.setText(context.getString(R.string.unit_cost) + CommonUtils.formatDecima(noti.getContent().getFields().getMaterialCost() + BuildConfig.FLAVOR));
            tvTotal.setText(context.getString(R.string.unit_cost) + CommonUtils.formatDecima((noti.getContent().getFields().getTotalCost() + ((double) AppController.getInstance().getAppConfig().getChargeFee())) + BuildConfig.FLAVOR));
            tvFee.setText(context.getString(R.string.unit_cost) + CommonUtils.formatDecima(AppController.getInstance().getAppConfig().getChargeFee() + BuildConfig.FLAVOR));
            tvTime.setText(noti.getContent().getFields().getTimes() + BuildConfig.FLAVOR);
        }
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        buttonClose.setOnClickListener(new AnonymousClass19(onResponeCancel));
        btnSelect.setOnClickListener(new AnonymousClass20(dialog, onRespone));
        dialog.getWindow().setLayout(-2, -2);
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog dialogConfirmCost(Context context, OnRespone onRespone, OnRespone onResponeCancel, OnsignalItem noti) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_confirm_cost, null, false);
        CardView buttonClose = (CardView) view.findViewById(R.id.ll_cancel);
        CardView btnSelect = (CardView) view.findViewById(R.id.ll_ok);
        TextView tvTime = (TextView) view.findViewById(R.id.tv_des_time);
        TextView tvFee = (TextView) view.findViewById(R.id.tv_des_fee);
        TextView tvTotal = (TextView) view.findViewById(R.id.tv_des_total);
        TextView tvMaterial = (TextView) view.findViewById(R.id.tv_des_material);
        ((TextView) view.findViewById(R.id.tv_des_cost)).setText(context.getString(R.string.unit_cost) + CommonUtils.formatDecima(noti.getFields().getCostForTime() + BuildConfig.FLAVOR));
        tvMaterial.setText(context.getString(R.string.unit_cost) + CommonUtils.formatDecima(noti.getFields().getMaterialCost() + BuildConfig.FLAVOR));
        tvTotal.setText(context.getString(R.string.unit_cost) + CommonUtils.formatDecima((noti.getFields().getTotalCost() + ((double) AppController.getInstance().getAppConfig().getChargeFee())) + BuildConfig.FLAVOR));
        tvFee.setText(context.getString(R.string.unit_cost) + CommonUtils.formatDecima(AppController.getInstance().getAppConfig().getChargeFee() + BuildConfig.FLAVOR));
        tvTime.setText(noti.getFields().getTimes() + BuildConfig.FLAVOR);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        buttonClose.setOnClickListener(new AnonymousClass21(onResponeCancel));
        btnSelect.setOnClickListener(new AnonymousClass22(dialog, onRespone));
        dialog.getWindow().setLayout(-2, -2);
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog dialogfeedBack(Activity context, OnRespone<FeedbackUser> onRespone, SimpleFacebook simpleFacebook) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_feedback, null, false);
        CardView btnSelect = (CardView) view.findViewById(R.id.ll_ok);
        RatingBar rate = (RatingBar) view.findViewById(R.id.rating_fb);
        EditText edt = (EditText) view.findViewById(R.id.edt);
        ImageView fb = (ImageView) view.findViewById(R.id.fb);
        ImageView ins = (ImageView) view.findViewById(R.id.inst);
        ImageView mail = (ImageView) view.findViewById(R.id.gg);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        btnSelect.setOnClickListener(new AnonymousClass23(edt, rate, onRespone, dialog));
        fb.setOnClickListener(new AnonymousClass24(context, simpleFacebook));
        mail.setOnClickListener(new AnonymousClass25(context));
        ins.setOnClickListener(new AnonymousClass26(context));
        ((LayerDrawable) rate.getProgressDrawable()).getDrawable(2).setColorFilter(context.getResources().getColor(R.color.material_yellow_700), Mode.SRC_ATOP);
        dialog.getWindow().setLayout(-2, -2);
        return dialog;
    }

    private static File createFileFromInputStream(Context context, InputStream inputStream) {
        try {
            File file = new File(FileUtils.getFolder(context) + "icon_app.png");
            OutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[Place.TYPE_SUBLOCALITY_LEVEL_2];
            while (true) {
                int length = inputStream.read(buffer);
                if (length > 0) {
                    outputStream.write(buffer, 0, length);
                } else {
                    outputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void createInstagramIntent(Context context, String type, String mediaPath) {
        Intent share = new Intent("android.intent.action.SEND");
        share.setType(type);
        share.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(mediaPath)));
        if (CommonUtils.isPackageInstalled("com.instagram.android", context.getPackageManager())) {
            share.setPackage("com.instagram.android");
            context.startActivity(Intent.createChooser(share, "Share to"));
            return;
        }
        Toast.makeText(context, R.string.install_first, 0).show();
        CommonUtils.launchMarket(context, "com.instagram.android");
    }

    public static Dialog dialogConfirmCancle(Context context, OnRespone<String> onRespone) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_confirm_cancle_order, null, false);
        CardView buttonClose = (CardView) view.findViewById(R.id.ll_cancel);
        CardView btnSelect = (CardView) view.findViewById(R.id.ll_ok);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rad_group);
        EditText edt = (EditText) view.findViewById(R.id.edt_cancle);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        buttonClose.setOnClickListener(new AnonymousClass27(dialog));
        btnSelect.setOnClickListener(new AnonymousClass28(dialog, radioGroup, edt, onRespone));
        dialog.getWindow().setLayout(-2, -2);
        return dialog;
    }

    public static Dialog dialogPromotion(Context context, UmberService umberService, OnRespone<String> onRespone) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_promo, null, false);
        CardView buttonClose = (CardView) view.findViewById(R.id.ll_cancel);
        CardView btnSelect = (CardView) view.findViewById(R.id.ll_ok);
        EditText edt = (EditText) view.findViewById(R.id.edt_cancle);
        AVLoadingIndicatorView loading = (AVLoadingIndicatorView) view.findViewById(R.id.load);
        TextView tvSuccess = (TextView) view.findViewById(R.id.tv_success);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        edt.addTextChangedListener(new AnonymousClass29(progressBar, umberService, edt, onRespone, tvSuccess, context));
        buttonClose.setOnClickListener(new AnonymousClass30(dialog));
        btnSelect.setOnClickListener(new AnonymousClass31(dialog, edt));
        dialog.getWindow().setLayout(-2, -2);
        return dialog;
    }

    public static Dialog dialogDetailHIC(Context context, HICItem hic) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_detail_hic, null, false);
        CardView buttonClose = (CardView) view.findViewById(R.id.ll_back);
        CardView btnCall = (CardView) view.findViewById(R.id.ll_call);
        CardView btnSMS = (CardView) view.findViewById(R.id.ll_sms);
        TextView tvOutPatien = (TextView) view.findViewById(R.id.tv_outpatien);
        TextView tvInPatien = (TextView) view.findViewById(R.id.tv_inpatien);
        TextView tvSpec = (TextView) view.findViewById(R.id.tv_spec);
        TextView tvAddress = (TextView) view.findViewById(R.id.tv_address);
        TextView tv_phone = (TextView) view.findViewById(R.id.tv_phone);
        AppCompatSpinner spiner = (AppCompatSpinner) view.findViewById(R.id.sp_cost);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        CircleImageView imgAvt = (CircleImageView) view.findViewById(R.id.profilePic);
        ImageView imgCategory = (CircleImageView) view.findViewById(R.id.ic_category);
        RatingBar rate = (RatingBar) view.findViewById(R.id.rate);
        LinearLayout llRoot = (LinearLayout) view.findViewById(R.id.ll_root);
        List<String> stringCost = new ArrayList();
        stringCost.add(BuildConfig.FLAVOR);
        stringCost.add("$");
        stringCost.add("$$");
        stringCost.add("$$$");
        stringCost.add("$$$$");
        stringCost.add("$$$$$");
        SpinnerAdapter adapterCost = new ArrayAdapter(context, 17367043, stringCost);
        adapterCost.setDropDownViewResource(17367050);
        spiner.setAdapter(adapterCost);
        if (hic.getCostHci() == null) {
            spiner.setSelection(0);
        } else {
            spiner.setSelection(Integer.parseInt(hic.getCostHci()));
        }
        tv_phone.setText(hic.getPhone());
        tvAddress.setText(hic.getAddress());
        tvInPatien.setText(hic.getInPatient());
        tvOutPatien.setText(hic.getOutPatient());
        tvSpec.setText(hic.getSpecialities());
        tvName.setText(hic.getFirst_name() + " " + hic.getLast_name());
        rate.setRating((float) hic.getRating());
        if (!(hic.getCategory() == null || hic.getCategory().size() <= 0 || hic.getCategory().get(0) == null)) {
            if (!((HICItem.Category) hic.getCategory().get(0)).icon.isEmpty()) {
                Picasso.with(context).load(ApiConstants.API_PHOTO_ROOT + ((HICItem.Category) hic.getCategory().get(0)).icon).into(imgCategory);
            }
        }
        UmberService umberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        String token = AppController.getInstance().getUser().getToken();
        String id = hic.getId();
        umberService.profileHic(token, id).enqueue(new AnonymousClass32(context, imgAvt));
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        buttonClose.setOnClickListener(new AnonymousClass33(dialog));
        btnCall.setOnClickListener(new AnonymousClass34(hic, context));
        btnSMS.setOnClickListener(new AnonymousClass35(hic, context));
        dialog.getWindow().setLayout(-2, -2);
        return dialog;
    }

    public static Dialog dialogDetailOrder(Context context, NotificationItemPage noti, OnRespone<DetailOrderItem> onRespone) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_detail_order, null, false);
        CardView buttonClose = (CardView) view.findViewById(R.id.ll_back);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        RecyclerView rcv = (RecyclerView) view.findViewById(R.id.rcv_des);
        CircleImageView imgAvt = (CircleImageView) view.findViewById(R.id.profilePic);
        CircleImageView imgCategory = (CircleImageView) view.findViewById(R.id.ic_category);
        RatingBar rate = (RatingBar) view.findViewById(R.id.rate);
        TextView tvJobdone = (TextView) view.findViewById(R.id.tv_job_done);
        AVLoadingIndicatorView load = (AVLoadingIndicatorView) view.findViewById(R.id.load);
        LinearLayout llRoot = (LinearLayout) view.findViewById(R.id.ll_root);
        CardView llMap = (CardView) view.findViewById(R.id.ll_map);
        TextView tvStatus = (TextView) view.findViewById(R.id.tv_status);
        TextView tvJobId = (TextView) view.findViewById(R.id.tv_jobid);
        TextView tvTimeWork = (TextView) view.findViewById(R.id.tv_time_work);
        TextView tvAddressOrder = (TextView) view.findViewById(R.id.tv_address);
        TextView tvCategory = (TextView) view.findViewById(R.id.tv_category);
        TextView tvTags = (TextView) view.findViewById(R.id.tv_tag);
        TextView tvTimeCreate = (TextView) view.findViewById(R.id.tv_time_create);
        TextView tvFullNameEx = (TextView) view.findViewById(R.id.tv_fullname_ex);
        TextView tvCosthour = (TextView) view.findViewById(R.id.tv_cost_hours_ex);
        TextView tvAddressEx = (TextView) view.findViewById(R.id.tv_address_ex);
        TextView tvGender = (TextView) view.findViewById(R.id.tv_gender_ex);
        ImageView imgCall = (ImageView) view.findViewById(R.id.btn_call);
        ImageView imgSms = (ImageView) view.findViewById(R.id.btn_sms);
        rcv.setLayoutManager(new LinearLayoutManager(context));
        rcv.setHasFixedSize(true);
        UmberService umberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        umberService.getDetailOrder(AppController.getInstance().getUser().getToken(), noti.getContent().getFields().getOrderId()).enqueue(new AnonymousClass36(llRoot, load, context, imgAvt, imgCategory, tvName, tvJobdone, rate, tvJobId, tvStatus, tvTimeWork, tvAddressOrder, tvCategory, tvTags, tvTimeCreate, tvFullNameEx, tvCosthour, tvAddressEx, tvGender, rcv, imgCall, imgSms, llMap, dialog, onRespone));
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        buttonClose.setOnClickListener(new AnonymousClass37(dialog));
        dialog.getWindow().setLayout(-2, -2);
        return dialog;
    }

    public static Dialog dialogDetailOrder(Activity context, String id, OnRespone<DetailOrderItem> onRespone) {
        LayoutInflater factory = LayoutInflater.from(context);
        Dialog dialog = new Dialog(context);
        dialog.getWindow().requestFeature(1);
        View view = factory.inflate(R.layout.dialog_detail_order, null, false);
        CardView buttonClose = (CardView) view.findViewById(R.id.ll_back);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        RecyclerView rcv = (RecyclerView) view.findViewById(R.id.rcv_des);
        CircleImageView imgAvt = (CircleImageView) view.findViewById(R.id.profilePic);
        CircleImageView imgCategory = (CircleImageView) view.findViewById(R.id.ic_category);
        RatingBar rate = (RatingBar) view.findViewById(R.id.rate);
        TextView tvJobdone = (TextView) view.findViewById(R.id.tv_job_done);
        AVLoadingIndicatorView load = (AVLoadingIndicatorView) view.findViewById(R.id.load);
        LinearLayout llRoot = (LinearLayout) view.findViewById(R.id.ll_root);
        LinearLayout llRootHeader = (LinearLayout) view.findViewById(R.id.ll_infor_header_ex);
        LinearLayout llRootFooterEx = (LinearLayout) view.findViewById(R.id.ll_infor_ex);
        TextView tvStatus = (TextView) view.findViewById(R.id.tv_status);
        TextView tvJobId = (TextView) view.findViewById(R.id.tv_jobid);
        TextView tvTimeWork = (TextView) view.findViewById(R.id.tv_time_work);
        TextView tvAddressOrder = (TextView) view.findViewById(R.id.tv_address);
        TextView tvCategory = (TextView) view.findViewById(R.id.tv_category);
        TextView tvTags = (TextView) view.findViewById(R.id.tv_tag);
        TextView tvTimeCreate = (TextView) view.findViewById(R.id.tv_time_create);
        TextView tvFullNameEx = (TextView) view.findViewById(R.id.tv_fullname_ex);
        TextView tvCosthour = (TextView) view.findViewById(R.id.tv_cost_hours_ex);
        TextView tvAddressEx = (TextView) view.findViewById(R.id.tv_address_ex);
        TextView tvGender = (TextView) view.findViewById(R.id.tv_gender_ex);
        CardView llMap = (CardView) view.findViewById(R.id.ll_map);
        ImageView imgCall = (ImageView) view.findViewById(R.id.btn_call);
        ImageView imgSms = (ImageView) view.findViewById(R.id.btn_sms);
        rcv.setLayoutManager(new LinearLayoutManager(context));
        rcv.setHasFixedSize(true);
        UmberService umberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        umberService.getDetailOrder(AppController.getInstance().getUser().getToken(), id).enqueue(new AnonymousClass38(llRoot, load, context, imgAvt, imgCategory, tvName, tvJobdone, rate, tvFullNameEx, tvCosthour, tvAddressEx, tvGender, rcv, imgCall, imgSms, llRootHeader, llRootFooterEx, tvStatus, tvJobId, tvTimeWork, tvAddressOrder, tvCategory, tvTags, tvTimeCreate, llMap, dialog, onRespone));
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(view);
        buttonClose.setOnClickListener(new AnonymousClass39(dialog));
        dialog.getWindow().setLayout(-2, -2);
        return dialog;
    }
}
