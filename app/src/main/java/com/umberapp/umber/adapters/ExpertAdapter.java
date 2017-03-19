package com.umberapp.umber.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.models.ExpertBit;
import com.umberapp.umber.models.RangeTime;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.StringUtil;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import me.zhanghai.android.materialprogressbar.BuildConfig;

public class ExpertAdapter extends Adapter<ExpertAdapter.ExpertHolder> {
    Context context;
    List<ExpertBit> listEx;
    RangeTime mRangTime;
    OnRespone<ExpertBit> onItemClick;

    /* renamed from: com.umberapp.umber.adapters.ExpertAdapter.1 */
    class C13881 implements OnClickListener {
        final /* synthetic */ ExpertBit val$ex;

        C13881(ExpertBit expertBit) {
            this.val$ex = expertBit;
        }

        public void onClick(View view) {
            ExpertAdapter.this.onItemClick.onRespone(this.val$ex);
        }
    }

    class ExpertHolder extends ViewHolder {
        CircleImageView img;
        LinearLayout llRoot;
        RatingBar rate;
        TextView tvCost;
        TextView tvDist;
        TextView tvJob;
        TextView tvName;
        TextView tvTime;

        public ExpertHolder(View itemView) {
            super(itemView);
            this.tvJob = (TextView) itemView.findViewById(R.id.tv_job);
            this.tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            this.tvCost = (TextView) itemView.findViewById(R.id.tv_cost);
            this.tvName = (TextView) itemView.findViewById(R.id.tv_name);
            this.tvDist = (TextView) itemView.findViewById(R.id.tv_dist);
            this.rate = (RatingBar) itemView.findViewById(R.id.rate);
            this.img = (CircleImageView) itemView.findViewById(R.id.img_avatar);
            this.llRoot = (LinearLayout) itemView.findViewById(R.id.ll_root_ex);
        }
    }

    public ExpertAdapter(Context context, List<ExpertBit> listEx, OnRespone<ExpertBit> onItemClick) {
        this.context = context;
        this.listEx = listEx;
        this.onItemClick = onItemClick;
    }

    public RangeTime getmRangTime() {
        return this.mRangTime;
    }

    public void setmRangTime(RangeTime mRangTime) {
        this.mRangTime = mRangTime;
    }

    public ExpertHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExpertHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expert, parent, false));
    }

    public void onBindViewHolder(ExpertHolder holder, int position) {
        if (holder != null) {
            ExpertBit ex = (ExpertBit) this.listEx.get(position);
            holder.img.setImageResource(R.mipmap.icon_app);
            if (!(ex.getAvatar() == null || ex.getAvatar().isEmpty())) {
                Picasso.with(this.context).load(ApiConstants.API_MEDIA_ROOT + ex.getAvatar()).into(holder.img);
            }
            holder.tvName.setText(ex.getLast_name());
            holder.tvDist.setText(CommonUtils.round(ex.getDistance() / 1000.0d, 2) + this.context.getString(R.string.km));
            RangeTime rangeTime = ex.getTimeRange();
            if (rangeTime == null || rangeTime.getStart().isEmpty() || rangeTime.getEnd().isEmpty() || this.mRangTime == null || (rangeTime.getEnd().equals(this.mRangTime.getEnd()) && rangeTime.getStart().equals(this.mRangTime.getStart()))) {
                holder.tvTime.setVisibility(View.GONE);
            } else {
                long start = Long.parseLong(rangeTime.getStart());
                long end = Long.parseLong(rangeTime.getEnd());
                String timeStart = CommonUtils.getDate(start, StringUtil.DATE_FORMAT_18);
                holder.tvTime.setText(this.context.getString(R.string.time_changed) + timeStart + " - " + CommonUtils.getDate(end, StringUtil.DATE_FORMAT_18));
            }
            TextView textView = holder.tvCost;
            String string = this.context.getString(R.string.cost_hour);
            Object[] objArr = new Object[2];
            objArr[0] = this.context.getString(R.string.unit_cost);
            objArr[1] = CommonUtils.formatDecima(ex.getCostHour() + BuildConfig.FLAVOR);
            textView.setText(String.format(string, objArr));
            holder.tvJob.setText(String.format(this.context.getString(R.string.job_done_format), new Object[]{Integer.valueOf(ex.getTotalOrderSuccess())}));
            holder.rate.setRating((float) ex.getRating());
            holder.llRoot.setOnClickListener(new C13881(ex));
        }
    }

    public int getItemCount() {
        return this.listEx.size();
    }
}
