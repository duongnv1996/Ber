package com.umberapp.umber.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
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
import com.umberapp.umber.socket.SocketConstants;
import com.umberapp.umber.utils.Constant;
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

public class UpcomingActivity extends BaseActivity implements OnClickListener {
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
    @Bind({R.id.tv_title})
    TextView tvTitle;

    /* renamed from: com.umberapp.umber.activities.UpcomingActivity.1 */
    class C13801 implements OnRespone<UpcommingItem> {

        /* renamed from: com.umberapp.umber.activities.UpcomingActivity.1.1 */
        class C13791 implements OnRespone<DetailOrderItem> {
            C13791() {
            }

            public void onRespone(DetailOrderItem object) {
                UpcomingActivity.this.mUmberSocket.trackingExpert(object.getExpert().getId());
                Intent intent = new Intent(UpcomingActivity.this, MapsActivity.class);
                intent.putExtra(Constant.KEY_MSG, object.getExpert().getPhone());
                Bundle b = new Bundle();
                b.putParcelable(Constant.KEY_LATLNG, new LatLng(Double.parseDouble(object.getExpert().getCoordinates()[1]), Double.parseDouble(object.getExpert().getCoordinates()[0])));
                intent.putExtra(Constant.KEY_BUNDLE, b);
                UpcomingActivity.this.startActivity(intent);
            }
        }

        C13801() {
        }

        public void onRespone(UpcommingItem object) {
            if (object.getStatus().equals(SocketConstants.KEY_FINDING)) {
                Intent intent = new Intent();
                intent.putExtra(Constant.KEY_ID, object.getId());
                UpcomingActivity.this.setResult(-1, intent);
                UpcomingActivity.this.finish();
            } else if (object.getStatus() != null) {
                AlertDialogCustom.dialogDetailOrder(UpcomingActivity.this, object.getId(), new C13791()).show();
            } else {
                AlertDialogCustom.dialogMsg(UpcomingActivity.this, UpcomingActivity.this.getString(R.string.error_status)).show();
            }
        }
    }

    /* renamed from: com.umberapp.umber.activities.UpcomingActivity.2 */
    class C13812 implements PagingableListener {
        C13812() {
        }

        public void onLoadMoreItems() {
            UpcomingActivity.this.getHistoryPage();
        }
    }

    /* renamed from: com.umberapp.umber.activities.UpcomingActivity.3 */
    class C13823 implements OnRefreshListener {
        C13823() {
        }

        public void onRefresh() {
            UpcomingActivity.this.page = 1;
            UpcomingActivity.this.listOrderItemPages.clear();
            UpcomingActivity.this.getHistoryPage();
        }
    }

    /* renamed from: com.umberapp.umber.activities.UpcomingActivity.4 */
    class C13834 implements Callback<ApiResponse<List<UpcommingItem>>> {
        C13834() {
        }

        public void onResponse(Call<ApiResponse<List<UpcommingItem>>> call, Response<ApiResponse<List<UpcommingItem>>> response) {
            UpcomingActivity.this.loadNoti.setVisibility(View.GONE);
            if (response.isSuccessful()) {
                UpcomingActivity.this.llNoti.setVisibility(View.VISIBLE);
                int offset = UpcomingActivity.this.listOrderItemPages.size();
                UpcomingActivity.this.listOrderItemPages.addAll((Collection) ((ApiResponse) response.body()).getData());
                UpcomingActivity.this.rcvNoti.setSwipeEnable(true);
                UpcomingActivity.this.rcvNoti.setLayoutManager(new LinearLayoutManager(UpcomingActivity.this));
                UpcomingActivity.this.rcvNoti.removeHeader();
                UpcomingActivity.this.historyPageAdapter.notifyItemInserted(UpcomingActivity.this.listOrderItemPages.size());
                UpcomingActivity.this.rcvNoti.setOnRefreshComplete();
                UpcomingActivity.this.rcvNoti.setOnLoadMoreComplete();
                if (((ApiResponse) response.body()).getData() == null || ((List) ((ApiResponse) response.body()).getData()).size() <= 0) {
                    UpcomingActivity.this.rcvNoti.onFinishLoading(false, true);
                } else {
                    UpcomingActivity.this.rcvNoti.onFinishLoading(true, false);
                }
                UpcomingActivity upcomingActivity = UpcomingActivity.this;
                upcomingActivity.page++;
                return;
            }
            UpcomingActivity.this.rcvNoti.setOnRefreshComplete();
            UpcomingActivity.this.rcvNoti.setOnLoadMoreComplete();
            RLog.m86e(Integer.valueOf(response.code()));
        }

        public void onFailure(Call<ApiResponse<List<UpcommingItem>>> call, Throwable t) {
            UpcomingActivity.this.rcvNoti.setOnRefreshComplete();
            UpcomingActivity.this.rcvNoti.setOnLoadMoreComplete();
            UpcomingActivity.this.loadNoti.setVisibility(View.GONE);
            RLog.m86e(t.getMessage());
        }
    }

    public UpcomingActivity() {
        this.listOrderItemPages = new ArrayList();
        this.page = 1;
    }

    void startToFragment(ExpertBit expertBit) {
    }

    void finishOrder() {
    }

    void unreadNotification(int count) {
    }

    void trackExpert(String lat, String l) {
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
        this.tvTitle.setText(R.string.upcoming);
        this.historyPageAdapter = new HistoryPageAdapter(this, this.listOrderItemPages, new C13801());
        this.rcvNoti.setAdapter(this.historyPageAdapter);
        this.page = 1;
        this.listOrderItemPages.clear();
        this.rcvNoti.setLoadmoreString(getString(R.string.loadding));
        this.rcvNoti.setPagingableListener(new C13812());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            this.rcvNoti.setOnRefreshListener(new C13823());
        }
        getHistoryPage();
    }

    private void getHistoryPage() {
        if (AppController.getInstance().getUser() != null) {
            this.mUmberService.getUpcoming(AppController.getInstance().getUser().getToken(), "upcomming").enqueue(new C13834());
        }
    }

    public void onClick(View view) {
        finish();
    }
}
