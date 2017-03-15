package com.umberapp.umber.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.umberapp.umber.R;
import com.umberapp.umber.activities.MainActivity;
import com.umberapp.umber.adapters.FaqAdapter;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.models.FaqItem;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.views.ProgressDialogCustom;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FaqFragment extends BaseFragment implements OnClickListener {
    private ProgressDialogCustom dialogProgress;
    @Bind({2131689927})
    EditText edtSearch;
    FaqAdapter faqAdapter;
    @Bind({2131689701})
    ImageView imgBack;
    List<FaqItem> listNotificationItemPages;
    @Bind({2131689793})
    LinearLayout llNoti;
    @Bind({2131689792})
    AVLoadingIndicatorView loadNoti;
    private UmberService mUmberService;
    int page;
    @Bind({2131689794})
    PullToRefreshRecyclerView rcvNoti;

    /* renamed from: com.umberapp.umber.fragments.FaqFragment.1 */
    class C14031 implements TextWatcher {
        C14031() {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            FaqFragment.this.faqAdapter.getFilter().filter(charSequence.toString());
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.umberapp.umber.fragments.FaqFragment.2 */
    class C14042 implements Callback<ApiResponse<List<FaqItem>>> {
        C14042() {
        }

        public void onResponse(Call<ApiResponse<List<FaqItem>>> call, Response<ApiResponse<List<FaqItem>>> response) {
            FaqFragment.this.loadNoti.setVisibility(8);
            if (response.isSuccessful()) {
                FaqFragment.this.llNoti.setVisibility(0);
                int offset = FaqFragment.this.listNotificationItemPages.size();
                FaqFragment.this.listNotificationItemPages.addAll((Collection) ((ApiResponse) response.body()).getData());
                FaqFragment.this.rcvNoti.setLayoutManager(new LinearLayoutManager(FaqFragment.this.getContext()));
                FaqFragment.this.rcvNoti.removeHeader();
                FaqFragment.this.rcvNoti.setOnRefreshComplete();
                FaqFragment.this.rcvNoti.setOnLoadMoreComplete();
                FaqFragment.this.faqAdapter.notifyDataSetChanged();
                FaqFragment faqFragment = FaqFragment.this;
                faqFragment.page++;
                return;
            }
            RLog.m86e(Integer.valueOf(response.code()));
        }

        public void onFailure(Call<ApiResponse<List<FaqItem>>> call, Throwable t) {
            FaqFragment.this.loadNoti.setVisibility(8);
            RLog.m86e(t.getMessage());
        }
    }

    public FaqFragment() {
        this.listNotificationItemPages = new ArrayList();
        this.page = 1;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_faq, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind((Object) this, view);
        this.mUmberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        initView();
    }

    private void initView() {
        this.dialogProgress = new ProgressDialogCustom(getContext());
        this.faqAdapter = new FaqAdapter(getContext(), this.listNotificationItemPages);
        this.rcvNoti.setAdapter(this.faqAdapter);
        this.page = 1;
        this.listNotificationItemPages.clear();
        getNotificationPage();
        this.imgBack.setOnClickListener(this);
        this.edtSearch.addTextChangedListener(new C14031());
    }

    private void getNotificationPage() {
        this.mUmberService.getFAQ(AppController.getInstance().getUser().getToken()).enqueue(new C14042());
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /*2131689701*/:
                ((MainActivity) getActivity()).onBackPressed();
            default:
        }
    }
}
