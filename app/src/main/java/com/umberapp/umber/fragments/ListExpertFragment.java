package com.umberapp.umber.fragments;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.Gson;
import com.umberapp.umber.R;
import com.umberapp.umber.activities.MainActivity;
import com.umberapp.umber.adapters.ExpertAdapter;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.models.DetailOrderItem;
import com.umberapp.umber.models.Expert;
import com.umberapp.umber.models.ExpertBit;
import com.umberapp.umber.models.Work;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.views.AlertDialogCustom;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListExpertFragment extends BaseFragment implements OnClickListener {
    boolean JobDecs;
    boolean PriceDecs;
    boolean StartDecs;
    @Bind({2131689864})
    CardView btnBack;
    boolean distDecs;
    ExpertBit ex;
    boolean genderDecs;
    @Bind({2131689930})
    ImageView imgSortDesc;
    @Bind({2131689929})
    LinearLayout imgSortRate;
    private List<ExpertBit> listEx;
    private ExpertAdapter mAdapter;
    private List<Work> mListWorks;
    UmberService mUmberService;
    private String orderId;
    @Bind({2131689935})
    RecyclerView rcvExperts;
    BroadcastReceiver receiver;
    @Bind({2131689932})
    TextView tvSortDist;
    @Bind({2131689933})
    TextView tvSortGender;
    @Bind({2131689934})
    TextView tvSortJob;
    @Bind({2131689931})
    TextView tvSortPrice;
    @Bind({2131689928})
    TextView tvTitle;

    /* renamed from: com.umberapp.umber.fragments.ListExpertFragment.1 */
    class C14051 extends BroadcastReceiver {
        C14051() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                ListExpertFragment.this.jsonResponse = intent.getStringExtra(Constant.KEY_MSG);
                if (ListExpertFragment.this.jsonResponse != null) {
                    try {
                        JSONObject obj = new JSONObject(ListExpertFragment.this.jsonResponse);
                        if (obj.has(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) && obj.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS).equals("ServerDecline")) {
                            try {
                                ((MainActivity) ListExpertFragment.this.getActivity()).removeAllTab();
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (ListExpertFragment.this.jsonResponse != null && !ListExpertFragment.this.jsonResponse.isEmpty()) {
                    RLog.m86e("ListFragment" + ListExpertFragment.this.jsonResponse);
                    ExpertBit mExpert = (ExpertBit) new Gson().fromJson(ListExpertFragment.this.jsonResponse, ExpertBit.class);
                    if (ListExpertFragment.this.mUmberService == null) {
                        ListExpertFragment.this.mUmberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
                    }
                    ListExpertFragment.this.getInforExpert(mExpert);
                }
            }
        }
    }

    /* renamed from: com.umberapp.umber.fragments.ListExpertFragment.2 */
    class C14062 implements Callback<ApiResponse<Expert>> {
        final /* synthetic */ ExpertBit val$mExpert;

        C14062(ExpertBit expertBit) {
            this.val$mExpert = expertBit;
        }

        public void onResponse(Call<ApiResponse<Expert>> call, Response<ApiResponse<Expert>> response) {
            boolean isAdd;
            if (response.isSuccessful()) {
                Expert ex = (Expert) ((ApiResponse) response.body()).getData();
                Location exLocation = new Location(BuildConfig.FLAVOR);
                exLocation.setLatitude(ex.getLocation()[1]);
                exLocation.setLongitude(ex.getLocation()[0]);
                Location mLocation = AppController.getInstance().getLocation();
                if (mLocation != null) {
                    float[] result = new float[1];
                    Location.distanceBetween(ex.getLocation()[1], ex.getLocation()[0], mLocation.getLatitude(), mLocation.getLongitude(), result);
                    this.val$mExpert.setDistance((double) result[0]);
                }
                isAdd = false;
                for (ExpertBit e : ListExpertFragment.this.listEx) {
                    if (e.getId().equals(ex.getId())) {
                        isAdd = true;
                        break;
                    }
                }
                if (!isAdd) {
                    ListExpertFragment.this.listEx.add(this.val$mExpert);
                    ListExpertFragment.this.btnBack.setVisibility(View.GONE);
                    ListExpertFragment.this.mAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            isAdd = false;
            for (ExpertBit e2 : ListExpertFragment.this.listEx) {
                if (e2.getId().equals(this.val$mExpert.getId())) {
                    isAdd = true;
                    break;
                }
            }
            if (!isAdd) {
                ListExpertFragment.this.listEx.add(this.val$mExpert);
                ListExpertFragment.this.mAdapter.notifyDataSetChanged();
            }
        }

        public void onFailure(Call<ApiResponse<Expert>> call, Throwable t) {
            RLog.m86e(t.getMessage());
            ListExpertFragment.this.listEx.add(this.val$mExpert);
            ListExpertFragment.this.mAdapter.notifyDataSetChanged();
        }
    }

    /* renamed from: com.umberapp.umber.fragments.ListExpertFragment.3 */
    class C14073 implements Callback<ApiResponse<DetailOrderItem>> {
        C14073() {
        }

        public void onResponse(Call<ApiResponse<DetailOrderItem>> call, Response<ApiResponse<DetailOrderItem>> response) {
            if (response.isSuccessful()) {
                DetailOrderItem orderItem = (DetailOrderItem) ((ApiResponse) response.body()).getData();
                if (!(orderItem == null || orderItem.getExoertsJoined() == null)) {
                    for (ExpertBit ex : orderItem.getExoertsJoined()) {
                        ListExpertFragment.this.getInforExpert(ex);
                    }
                }
                if (orderItem != null) {
                    ListExpertFragment.this.mAdapter.setmRangTime(orderItem.getRangeTime());
                }
            }
        }

        public void onFailure(Call<ApiResponse<DetailOrderItem>> call, Throwable t) {
            RLog.m86e(t.getMessage());
        }
    }

    /* renamed from: com.umberapp.umber.fragments.ListExpertFragment.4 */
    class C14094 implements OnRespone<ExpertBit> {

        /* renamed from: com.umberapp.umber.fragments.ListExpertFragment.4.1 */
        class C14081 implements OnRespone<ExpertBit> {
            final /* synthetic */ ExpertBit val$object1;

            C14081(ExpertBit expertBit) {
                this.val$object1 = expertBit;
            }

            public void onRespone(ExpertBit exBit) {
                if (((MainActivity) ListExpertFragment.this.getActivity()) != null) {
                    ((MainActivity) ListExpertFragment.this.getActivity()).selectExpert(this.val$object1.getId(), ListExpertFragment.this.orderId);
                    ((MainActivity) ListExpertFragment.this.getActivity()).showDialogConfirm(exBit, ListExpertFragment.this.orderId);
                }
            }
        }

        C14094() {
        }

        public void onRespone(ExpertBit object1) {
            AlertDialogCustom.dialogDetailExpert(ListExpertFragment.this.getContext(), new C14081(object1), object1).show();
        }
    }

    /* renamed from: com.umberapp.umber.fragments.ListExpertFragment.5 */
    class C14105 implements Comparator<ExpertBit> {
        C14105() {
        }

        public int compare(ExpertBit expertBit, ExpertBit t1) {
            return new Integer(t1.getRating()).compareTo(new Integer(expertBit.getRating()));
        }
    }

    /* renamed from: com.umberapp.umber.fragments.ListExpertFragment.6 */
    class C14116 implements Comparator<ExpertBit> {
        C14116() {
        }

        public int compare(ExpertBit expertBit, ExpertBit t1) {
            return new Integer(expertBit.getRating()).compareTo(new Integer(t1.getRating()));
        }
    }

    /* renamed from: com.umberapp.umber.fragments.ListExpertFragment.7 */
    class C14127 implements Comparator<ExpertBit> {
        C14127() {
        }

        public int compare(ExpertBit expertBit, ExpertBit t1) {
            return new Integer(t1.getTotalOrderSuccess()).compareTo(new Integer(expertBit.getTotalOrderSuccess()));
        }
    }

    /* renamed from: com.umberapp.umber.fragments.ListExpertFragment.8 */
    class C14138 implements Comparator<ExpertBit> {
        C14138() {
        }

        public int compare(ExpertBit expertBit, ExpertBit t1) {
            return new Integer(expertBit.getTotalOrderSuccess()).compareTo(new Integer(t1.getTotalOrderSuccess()));
        }
    }

    /* renamed from: com.umberapp.umber.fragments.ListExpertFragment.9 */
    class C14149 implements Comparator<ExpertBit> {
        C14149() {
        }

        public int compare(ExpertBit expertBit, ExpertBit t1) {
            return new Double(t1.getCostHour()).compareTo(new Double(expertBit.getCostHour()));
        }
    }

    private void getInforExpert(ExpertBit mExpert) {
        this.mUmberService.getInforEx(AppController.getInstance().getUser().getToken(), mExpert.getId()).enqueue(new C14062(mExpert));
    }

    void getDetailOrder(String id) {
        if (!id.isEmpty() && AppController.getInstance().getUser() != null) {
            this.mUmberService.getDetailOrder(AppController.getInstance().getUser().getToken(), id).enqueue(new C14073());
        }
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            this.listEx = (List) savedInstanceState.getSerializable("list");
            this.orderId = savedInstanceState.getString(Constant.KEY_ID);
        } else if (this.listEx != null && this.listEx.size() > 0) {
        }
    }

    public ListExpertFragment() {
        this.receiver = new C14051();
    }

    @SuppressLint({"ValidFragment"})
    public ListExpertFragment(String id) {
        this.receiver = new C14051();
        this.orderId = id;
    }

    @SuppressLint({"ValidFragment"})
    public ListExpertFragment(ExpertBit ex) {
        this.receiver = new C14051();
        this.ex = ex;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("list", (Serializable) this.listEx);
        outState.putString(Constant.KEY_ID, this.orderId);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_ex, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind((Object) this, view);
        this.rcvExperts.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rcvExperts.setHasFixedSize(true);
        if (AppController.getInstance().getUser() != null) {
            this.tvTitle.setText(String.format(getContext().getString(R.string.title_list_ex), new Object[]{AppController.getInstance().getUser().getLast_name()}));
        }
        this.listEx = new ArrayList();
        if (this.ex != null) {
            this.listEx.add(this.ex);
        }
        if (this.mAdapter == null) {
            this.mAdapter = new ExpertAdapter(getContext(), this.listEx, new C14094());
        }
        this.mUmberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        if (!(this.orderId == null || this.orderId.isEmpty())) {
            getDetailOrder(this.orderId);
        }
        this.rcvExperts.setAdapter(this.mAdapter);
        this.imgSortRate.setOnClickListener(this);
        this.tvSortDist.setOnClickListener(this);
        this.tvSortGender.setOnClickListener(this);
        this.tvSortJob.setOnClickListener(this);
        this.tvSortPrice.setOnClickListener(this);
        this.btnBack.setOnClickListener(this);
    }

    public void onResume() {
        super.onResume();
        IntentFilter i = new IntentFilter();
        i.addAction(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        getContext().registerReceiver(this.receiver, i);
    }

    public void onDestroy() {
        super.onDestroy();
        getContext().unregisterReceiver(this.receiver);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back /*2131689864*/:
                ((MainActivity) getActivity()).removeAllTab();
                break;
            case R.id.sort_rate /*2131689929*/:
                this.imgSortDesc.setVisibility(0);
                if (this.StartDecs) {
                    this.imgSortDesc.setImageResource(R.drawable.ic_arrow_upward_black_24dp);
                    this.StartDecs = false;
                    Collections.sort(this.listEx, new C14105());
                } else {
                    this.imgSortDesc.setImageResource(R.drawable.ic_arrow_downward_black_24dp);
                    this.StartDecs = true;
                    Collections.sort(this.listEx, new C14116());
                }
                this.tvSortGender.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.tvSortPrice.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.tvSortDist.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.tvSortJob.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                break;
            case R.id.sort_price /*2131689931*/:
                if (this.PriceDecs) {
                    this.tvSortPrice.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_downward_black_24dp, 0);
                    this.PriceDecs = false;
                    Collections.sort(this.listEx, new C14149());
                } else {
                    this.tvSortPrice.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_upward_black_24dp, 0);
                    this.PriceDecs = true;
                    Collections.sort(this.listEx, new Comparator<ExpertBit>() {
                        public int compare(ExpertBit expertBit, ExpertBit t1) {
                            return new Double(expertBit.getCostHour()).compareTo(new Double(t1.getCostHour()));
                        }
                    });
                }
                this.imgSortDesc.setVisibility(8);
                this.tvSortGender.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.tvSortJob.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.tvSortDist.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                break;
            case R.id.sort_dist /*2131689932*/:
                if (this.distDecs) {
                    this.tvSortDist.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_downward_black_24dp, 0);
                    this.distDecs = false;
                    Collections.sort(this.listEx, new Comparator<ExpertBit>() {
                        public int compare(ExpertBit expertBit, ExpertBit t1) {
                            return new Double(t1.getDistance()).compareTo(new Double(expertBit.getDistance()));
                        }
                    });
                } else {
                    this.tvSortDist.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_upward_black_24dp, 0);
                    this.distDecs = true;
                    Collections.sort(this.listEx, new Comparator<ExpertBit>() {
                        public int compare(ExpertBit expertBit, ExpertBit t1) {
                            return new Double(expertBit.getDistance()).compareTo(new Double(t1.getDistance()));
                        }
                    });
                }
                this.imgSortDesc.setVisibility(8);
                this.tvSortGender.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.tvSortPrice.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.tvSortJob.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                break;
            case R.id.sort_gender /*2131689933*/:
                if (this.genderDecs) {
                    this.genderDecs = false;
                    this.tvSortGender.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_downward_black_24dp, 0);
                    Collections.sort(this.listEx, new Comparator<ExpertBit>() {
                        public int compare(ExpertBit expertBit, ExpertBit t1) {
                            return t1.getGender().compareTo(expertBit.getGender());
                        }
                    });
                } else {
                    this.genderDecs = true;
                    this.tvSortGender.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_upward_black_24dp, 0);
                    Collections.sort(this.listEx, new Comparator<ExpertBit>() {
                        public int compare(ExpertBit expertBit, ExpertBit t1) {
                            return expertBit.getGender().compareTo(t1.getGender());
                        }
                    });
                }
                this.imgSortDesc.setVisibility(8);
                this.tvSortJob.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.tvSortPrice.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.tvSortDist.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                break;
            case R.id.sort_job /*2131689934*/:
                if (this.JobDecs) {
                    this.tvSortJob.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_downward_black_24dp, 0);
                    this.JobDecs = false;
                    Collections.sort(this.listEx, new C14127());
                } else {
                    this.tvSortJob.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_upward_black_24dp, 0);
                    this.JobDecs = true;
                    Collections.sort(this.listEx, new C14138());
                }
                this.tvSortGender.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.tvSortPrice.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.tvSortDist.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.imgSortDesc.setVisibility(8);
                break;
        }
        this.mAdapter.notifyDataSetChanged();
    }
}
