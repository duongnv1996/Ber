package com.umberapp.umber.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView.PagingableListener;
import com.umberapp.umber.R;
import com.umberapp.umber.activities.BaseActivity;
import com.umberapp.umber.activities.MainActivity;
import com.umberapp.umber.activities.MapsActivity;
import com.umberapp.umber.adapters.NotificationPageAdapter;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.models.DetailOrderItem;
import com.umberapp.umber.models.NotificationItem;
import com.umberapp.umber.models.NotificationItemPage;
import com.umberapp.umber.socket.SocketConstants;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.utils.SharedPref;
import com.umberapp.umber.views.AlertDialogCustom;
import com.umberapp.umber.views.ProgressDialogCustom;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationFragment extends BaseFragment implements OnClickListener {
    ProgressDialogCustom dialogCustom;
    @Bind({2131689701})
    ImageView imgBack;
    List<NotificationItemPage> listNotificationItemPages;
    @Bind({2131689793})
    LinearLayout llNoti;
    @Bind({2131689792})
    AVLoadingIndicatorView loadNoti;
    private UmberService mUmberService;
    NotificationPageAdapter notificationPageAdapter;
    int page;
    @Bind({2131689794})
    PullToRefreshRecyclerView rcvNoti;
    @Bind({2131689937})
    TextView tvRead;

    /* renamed from: com.umberapp.umber.fragments.NotificationFragment.1 */
    class C14171 implements OnRespone<NotificationItemPage> {

        /* renamed from: com.umberapp.umber.fragments.NotificationFragment.1.1 */
        class C14151 implements OnRespone<DetailOrderItem> {
            C14151() {
            }

            public void onRespone(DetailOrderItem object) {
                Intent intent = new Intent(NotificationFragment.this.getActivity(), MapsActivity.class);
                intent.putExtra(Constant.KEY_MSG, object.getCustomer().getPhone());
                NotificationFragment.this.startActivity(intent);
            }
        }

        /* renamed from: com.umberapp.umber.fragments.NotificationFragment.1.2 */
        class C14162 implements OnRespone<DetailOrderItem> {
            C14162() {
            }

            public void onRespone(DetailOrderItem object) {
            }
        }

        C14171() {
        }

        public void onRespone(NotificationItemPage object) {
            if (object.getContent() == null || object.getContent().getFields() == null || object.getContent().getFields().getStatusOrder() == null) {
                AlertDialogCustom.dialogMsg(NotificationFragment.this.getContext(), NotificationFragment.this.getString(R.string.error_status)).show();
            } else if (object.getContent().getFields().getStatusOrder().equals(SocketConstants.KEY_FINDING)) {
                if (((MainActivity) NotificationFragment.this.getActivity()) != null) {
                    ((MainActivity) NotificationFragment.this.getActivity()).removeAllTab();
                    try {
                        ((MainActivity) NotificationFragment.this.getActivity()).reconnectBookingOrder(object.getContent().getFields().getOrderId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (object.getContent().getFields().getStatusOrder().equals(SocketConstants.KEY_ON_MY_WAY) || object.getContent().getFields().getStatusOrder().equals(SocketConstants.KEY_ARRIVED)) {
                AlertDialogCustom.dialogDetailOrder(NotificationFragment.this.getContext(), object, new C14151()).show();
            } else if (!object.getContent().getFields().getStatusOrder().equals(SocketConstants.STATUS_ORDER_ESTIMATED)) {
                AlertDialogCustom.dialogDetailOrder(NotificationFragment.this.getContext(), object, new C14162()).show();
            } else if (object.getContent().getFields().getTotalCost() != 0.0d && object.getContent().getFields().getMaterialCost() != 0.0d) {
                NotificationItem item = new NotificationItem();
                item.setContent(object.getContent());
                item.setFrom(object.getFrom().getId());
                item.setTo(object.getTo());
                item.setSeen(object.getSeen());
                item.setType(object.getType());
                try {
                    ((BaseActivity) NotificationFragment.this.getActivity()).estimatedCostOrder(item);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.umberapp.umber.fragments.NotificationFragment.2 */
    class C14182 implements OnRespone<Boolean> {
        C14182() {
        }

        public void onRespone(Boolean object) {
            if (object.booleanValue()) {
                ((MainActivity) NotificationFragment.this.getActivity()).readAllNotify();
            }
        }
    }

    /* renamed from: com.umberapp.umber.fragments.NotificationFragment.3 */
    class C14193 implements PagingableListener {
        C14193() {
        }

        public void onLoadMoreItems() {
            NotificationFragment.this.getNotificationPage();
        }
    }

    /* renamed from: com.umberapp.umber.fragments.NotificationFragment.4 */
    class C14204 implements OnRefreshListener {
        C14204() {
        }

        public void onRefresh() {
            NotificationFragment.this.page = 1;
            NotificationFragment.this.listNotificationItemPages.clear();
            NotificationFragment.this.getNotificationPage();
        }
    }

    /* renamed from: com.umberapp.umber.fragments.NotificationFragment.5 */
    class C14215 implements Callback<ApiResponse<List<NotificationItemPage>>> {
        C14215() {
        }

        public void onResponse(Call<ApiResponse<List<NotificationItemPage>>> call, Response<ApiResponse<List<NotificationItemPage>>> response) {
            NotificationFragment.this.loadNoti.setVisibility(8);
            if (response.isSuccessful()) {
                NotificationFragment.this.llNoti.setVisibility(0);
                int offset = NotificationFragment.this.listNotificationItemPages.size();
                NotificationFragment.this.listNotificationItemPages.addAll((Collection) ((ApiResponse) response.body()).getData());
                NotificationFragment.this.rcvNoti.setSwipeEnable(true);
                NotificationFragment.this.rcvNoti.setOnRefreshComplete();
                NotificationFragment.this.rcvNoti.setOnLoadMoreComplete();
                if (((ApiResponse) response.body()).getData() == null || ((List) ((ApiResponse) response.body()).getData()).size() <= 0) {
                    NotificationFragment.this.rcvNoti.onFinishLoading(false, true);
                } else {
                    NotificationFragment.this.rcvNoti.onFinishLoading(true, false);
                }
                NotificationFragment notificationFragment = NotificationFragment.this;
                notificationFragment.page++;
                return;
            }
            NotificationFragment.this.rcvNoti.setOnRefreshComplete();
            NotificationFragment.this.rcvNoti.setOnLoadMoreComplete();
            RLog.m86e(Integer.valueOf(response.code()));
        }

        public void onFailure(Call<ApiResponse<List<NotificationItemPage>>> call, Throwable t) {
            NotificationFragment.this.loadNoti.setVisibility(8);
            NotificationFragment.this.rcvNoti.setOnRefreshComplete();
            NotificationFragment.this.rcvNoti.setOnLoadMoreComplete();
            RLog.m86e(t.getMessage());
        }
    }

    /* renamed from: com.umberapp.umber.fragments.NotificationFragment.6 */
    class C14226 implements Callback<ResponseBody> {
        C14226() {
        }

        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            NotificationFragment.this.dialogCustom.hideDialog();
            if (response.isSuccessful()) {
                List<NotificationItemPage> list = new ArrayList();
                int i = 0;
                for (NotificationItemPage item : NotificationFragment.this.listNotificationItemPages) {
                    item.setSeen(1);
                    NotificationFragment.this.listNotificationItemPages.set(i, item);
                    NotificationFragment.this.notificationPageAdapter.notifyItemChanged(i);
                    i++;
                }
                ((MainActivity) NotificationFragment.this.getActivity()).readAllNotify();
            }
        }

        public void onFailure(Call<ResponseBody> call, Throwable t) {
            RLog.m86e(t.getMessage());
            NotificationFragment.this.dialogCustom.hideDialog();
        }
    }

    public NotificationFragment() {
        this.listNotificationItemPages = new ArrayList();
        this.page = 1;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind((Object) this, view);
        this.mUmberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        initView();
    }

    private void initView() {
        this.dialogCustom = new ProgressDialogCustom(getContext());
        this.notificationPageAdapter = new NotificationPageAdapter(getContext(), this.listNotificationItemPages, new C14171(), new C14182());
        this.rcvNoti.setAdapter(this.notificationPageAdapter);
        this.page = 1;
        this.listNotificationItemPages.clear();
        this.rcvNoti.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rcvNoti.removeHeader();
        this.rcvNoti.setPagingableListener(new C14193());
        this.rcvNoti.setOnRefreshListener(new C14204());
        getNotificationPage();
        this.tvRead.setOnClickListener(this);
        this.imgBack.setOnClickListener(this);
    }

    private void getNotificationPage() {
        String token = SharedPref.getInstance(getContext()).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR);
        if (!token.equals(BuildConfig.FLAVOR)) {
            this.mUmberService.getNotification(token, this.page + BuildConfig.FLAVOR).enqueue(new C14215());
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /*2131689701*/:
                ((MainActivity) getActivity()).onBackPressed();
            case R.id.read_all /*2131689937*/:
                this.dialogCustom.showDialog();
                this.mUmberService.readAllNoti(AppController.getInstance().getUser().getToken()).enqueue(new C14226());
            default:
        }
    }
}
