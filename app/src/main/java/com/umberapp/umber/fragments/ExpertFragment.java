package com.umberapp.umber.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.umberapp.umber.R;
import com.umberapp.umber.adapters.DescriptionAdapter;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.apis.ApiResponse;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.application.AppController;
import com.umberapp.umber.models.Category;
import com.umberapp.umber.models.Expert;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.RLog;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExpertFragment extends BaseFragment implements OnClickListener {
    @Bind({2131689864})
    CardView btnBack;
    @Bind({2131689865})
    CardView btnSelect;
    private String idEx;
    @Bind({2131689821})
    CircleImageView imgAvatar;
    @Bind({2131689823})
    CircleImageView imgCategory;
    private DescriptionAdapter mAdapter;
    private Expert mExpert;
    private UmberService mUmberService;
    @Bind({2131689861})
    RatingBar rate;
    @Bind({2131689863})
    RecyclerView rcvDes;
    @Bind({2131690043})
    TextView tvCost;
    @Bind({2131689862})
    TextView tvJobDone;
    @Bind({2131689824})
    TextView tvName;

    /* renamed from: com.umberapp.umber.fragments.ExpertFragment.1 */
    class C14021 implements Callback<ApiResponse<Expert>> {
        C14021() {
        }

        public void onResponse(Call<ApiResponse<Expert>> call, Response<ApiResponse<Expert>> response) {
            if (response.isSuccessful()) {
                ExpertFragment.this.mExpert = (Expert) ((ApiResponse) response.body()).getData();
                if (ExpertFragment.this.mExpert != null) {
                    ExpertFragment.this.tvName.setText(ExpertFragment.this.mExpert.getLast_name());
                    ExpertFragment.this.tvJobDone.setText(ExpertFragment.this.mExpert.getTotalOrderSuccess() + ExpertFragment.this.getString(R.string.job_dones));
                    if (!(ExpertFragment.this.mExpert.getAvatar() == null || ExpertFragment.this.mExpert.getAvatar().isEmpty())) {
                        Picasso.with(ExpertFragment.this.getContext()).load(ApiConstants.API_MEDIA_ROOT + ExpertFragment.this.mExpert.getAvatar()).into(ExpertFragment.this.imgAvatar);
                    }
                    if (!(ExpertFragment.this.mExpert.getCategory() == null || ExpertFragment.this.mExpert.getCategory().size() <= 0 || AppController.getInstance().getOrder() == null)) {
                        String idCate = AppController.getInstance().getOrder().getId();
                        for (Category cate : ExpertFragment.this.mExpert.getCategory()) {
                            if (cate.getId().equals(idCate)) {
                                ExpertFragment.this.tvCost.setText(CommonUtils.formatDecima(cate.getCostHour() + BuildConfig.FLAVOR));
                                Picasso.with(ExpertFragment.this.getContext()).load(ApiConstants.API_PHOTO_ROOT + cate.getIcon()).into(ExpertFragment.this.imgCategory);
                                break;
                            }
                        }
                    }
                    ExpertFragment.this.mAdapter = new DescriptionAdapter(ExpertFragment.this.getContext(), ExpertFragment.this.mExpert.getSelfDescriptions());
                    ExpertFragment.this.rcvDes.setAdapter(ExpertFragment.this.mAdapter);
                }
            }
        }

        public void onFailure(Call<ApiResponse<Expert>> call, Throwable t) {
            RLog.m86e(t.getMessage());
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_detail_ex, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind((Object) this, view);
        initView();
    }

    private void initView() {
        this.rcvDes.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rcvDes.setHasFixedSize(true);
        this.mUmberService = (UmberService) ApiUtils.getRootApi().create(UmberService.class);
        this.mUmberService.getInforEx(AppController.getInstance().getUser().getToken(), this.idEx).enqueue(new C14021());
        this.btnBack.setOnClickListener(this);
        this.btnSelect.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back /*2131689864*/:
                getActivity().onBackPressed();
            case R.id.ll_select /*2131689865*/:
                if (this.mExpert != null) {
                    getActivity().onBackPressed();
                }
            default:
        }
    }
}
