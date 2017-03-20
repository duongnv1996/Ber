package com.umberapp.umber.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView.PagingableListener;
import com.umberapp.umber.R;
import com.umberapp.umber.adapters.HistoryPageAdapter;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.models.DetailOrderItem;
import com.umberapp.umber.models.ExpertBit;
import com.umberapp.umber.models.UpcommingItem;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.views.AlertDialogCustom;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends BaseActivity implements OnClickListener {
    HistoryPageAdapter historyPageAdapter;
    List<UpcommingItem> listOrderItemPages;
    @Bind({R.id.ll_noti})
    LinearLayout llNoti;
    @Bind({R.id.contentview})
    RelativeLayout llroot;
    @Bind({R.id.load_noti})
    AVLoadingIndicatorView loadNoti;
    private UmberService mUmberService;
    int page;
    @Bind({R.id.rcv_noti})
    PullToRefreshRecyclerView rcvNoti;

    /* renamed from: com.umberapp.umber.activities.HistoryActivity.1 */
    class C13221 implements OnRespone<UpcommingItem> {

        /* renamed from: com.umberapp.umber.activities.HistoryActivity.1.1 */
        class C13211 implements OnRespone<DetailOrderItem> {
            C13211() {
            }

            public void onRespone(DetailOrderItem object) {
            }
        }

        C13221() {
        }

        public void onRespone(UpcommingItem object) {
            if (object.getStatus() == null || object.getStatus().isEmpty()) {
                AlertDialogCustom.dialogMsg(HistoryActivity.this, HistoryActivity.this.getString(R.string.error_status)).show();
            } else {
                AlertDialogCustom.dialogDetailOrder(HistoryActivity.this, object.getId(), new C13211()).show();
            }
        }
    }

    /* renamed from: com.umberapp.umber.activities.HistoryActivity.2 */
    class C13232 implements PagingableListener {
        C13232() {
        }

        public void onLoadMoreItems() {
            HistoryActivity.this.getHistoryPage();
        }
    }

    /* renamed from: com.umberapp.umber.activities.HistoryActivity.3 */
    class C13243 implements OnRefreshListener {
        C13243() {
        }

        public void onRefresh() {
            HistoryActivity.this.page = 1;
            HistoryActivity.this.listOrderItemPages.clear();
            HistoryActivity.this.getHistoryPage();
        }
    }

    /* renamed from: com.umberapp.umber.activities.HistoryActivity.4 */
    class C13254 implements Callback<ApiResponse<List<UpcommingItem>>> {
        C13254() {
        }

        public void onResponse(Call<ApiResponse<List<UpcommingItem>>> call, Response<ApiResponse<List<UpcommingItem>>> response) {
            HistoryActivity.this.loadNoti.setVisibility(View.GONE);
            if (response.isSuccessful()) {
                HistoryActivity.this.llNoti.setVisibility(View.VISIBLE);
                int offset = HistoryActivity.this.listOrderItemPages.size();
                HistoryActivity.this.listOrderItemPages.addAll((Collection) ((ApiResponse) response.body()).getData());
                HistoryActivity.this.rcvNoti.setSwipeEnable(true);
                HistoryActivity.this.rcvNoti.setOnRefreshComplete();
                HistoryActivity.this.rcvNoti.setOnLoadMoreComplete();
                if (((ApiResponse) response.body()).getData() == null || ((List) ((ApiResponse) response.body()).getData()).size() <= 0) {
                    HistoryActivity.this.rcvNoti.onFinishLoading(false, true);
                } else {
                    HistoryActivity.this.rcvNoti.onFinishLoading(true, false);
                }
                HistoryActivity historyActivity = HistoryActivity.this;
                historyActivity.page++;
                return;
            }
            HistoryActivity.this.rcvNoti.setOnRefreshComplete();
            HistoryActivity.this.rcvNoti.setOnLoadMoreComplete();
            RLog.m86e(Integer.valueOf(response.code()));
        }

        public void onFailure(Call<ApiResponse<List<UpcommingItem>>> call, Throwable t) {
            HistoryActivity.this.rcvNoti.setOnRefreshComplete();
            HistoryActivity.this.rcvNoti.setOnLoadMoreComplete();
            HistoryActivity.this.loadNoti.setVisibility(View.GONE);
            RLog.m86e(t.getMessage());
        }
    }

    public HistoryActivity() {
        this.listOrderItemPages = new ArrayList();
        this.page = 1;
    }

    void startToFragment(ExpertBit expertBit) {
    }

    void finishOrder() {
    }

    void unreadNotification(int count) {
    }

    void trackExpert(String s, String s1) {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_history);
        ButterKnife.bind((Activity) this);
        this.mUmberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        initView();
    }

    void initView() {
        this.view = this.llroot;
        this.historyPageAdapter = new HistoryPageAdapter(this, this.listOrderItemPages, new C13221());
        this.rcvNoti.setAdapter(this.historyPageAdapter);
        this.page = 1;
        this.listOrderItemPages.clear();
        this.rcvNoti.setLayoutManager(new LinearLayoutManager(this));
        this.rcvNoti.removeHeader();
        this.rcvNoti.setLoadmoreString(getString(R.string.loadding));
        this.rcvNoti.setPagingableListener(new C13232());
        this.rcvNoti.setOnRefreshListener(new C13243());
        getHistoryPage();
    }

    private void getHistoryPage() {
        if (AppController.getInstance().getUser() != null) {
            this.mUmberService.getHistory(AppController.getInstance().getUser().getToken(), this.page, "history").enqueue(new C13254());
        }
    }

    public void onClick(View view) {
        finish();
    }
}
