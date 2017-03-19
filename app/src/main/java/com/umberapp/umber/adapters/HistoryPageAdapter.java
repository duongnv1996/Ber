package com.umberapp.umber.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.models.UpcommingItem;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import me.zhanghai.android.materialprogressbar.BuildConfig;

public class HistoryPageAdapter extends Adapter<HistoryPageAdapter.NotitHolder> {
    Context context;
    List<UpcommingItem> listEx;
    OnRespone<UpcommingItem> onItemClick;

    /* renamed from: com.umberapp.umber.adapters.HistoryPageAdapter.1 */
    class C13911 implements OnClickListener {
        final /* synthetic */ UpcommingItem val$ex;

        C13911(UpcommingItem upcommingItem) {
            this.val$ex = upcommingItem;
        }

        public void onClick(View view) {
            HistoryPageAdapter.this.onItemClick.onRespone(this.val$ex);
        }
    }

    class NotitHolder extends ViewHolder {
        ImageView img;
        LinearLayout llRoot;
        TextView tvMess;
        TextView tvStatus;
        TextView tvTime;
        TextView tvTitle;

        public NotitHolder(View itemView) {
            super(itemView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.tvMess = (TextView) itemView.findViewById(R.id.tv_mess);
            this.tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            this.tvStatus = (TextView) itemView.findViewById(R.id.tv_status);
            this.img = (ImageView) itemView.findViewById(R.id.img_avatar);
            this.llRoot = (LinearLayout) itemView.findViewById(R.id.ll_root_ex);
        }
    }

    public HistoryPageAdapter(Context context, List<UpcommingItem> listEx, OnRespone<UpcommingItem> onItemClick) {
        this.context = context;
        this.listEx = listEx;
        this.onItemClick = onItemClick;
    }

    public void notifion(int pos) {
        notifyItemInserted(pos);
    }

    public NotitHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotitHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_page, parent, false));
    }

    public void onBindViewHolder(NotitHolder holder, int position) {
        if (holder != null) {
            UpcommingItem ex = (UpcommingItem) this.listEx.get(position);
            holder.tvTitle.setText(ex.getAddress());
            long rangTime;
            String str = BuildConfig.FLAVOR;
            String strTime = ex.getUpdatedAt().replace("T", " ").replace("Z", "");
            holder.tvStatus.setText(ApiUtils.getStatusFromServer(ex.getStatus(), this.context));
            long currentTime = CommonUtils.getUTCTime();
            SimpleDateFormat sdf = new SimpleDateFormat(StringUtil.DATE_FORMAT_27);
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                str = ex.getCreatedAt();
                rangTime = currentTime - sdf.parse("" + BuildConfig.FLAVOR).getTime();
                if (currentTime - sdf.parse("" + BuildConfig.FLAVOR).getTime() < 3600000) {
                    holder.tvTime.setText(String.format(this.context.getString(R.string.ago), new Object[]{Long.valueOf(rangTime / 60000)}));
                } else {
                    String formattedTime = new SimpleDateFormat("HH:mm MM/dd/yyyy").format(sdf.parse(ex.getCreatedAt()));
                    holder.tvTime.setText(" - " + formattedTime);
                }
            } catch (ParseException e) {
                e.printStackTrace();
                holder.tvTime.setText(" - " + ex.getCreatedAt());
            }
            holder.llRoot.setOnClickListener(new C13911(ex));
        }
    }

    public int getItemCount() {
        return this.listEx.size();
    }
}
