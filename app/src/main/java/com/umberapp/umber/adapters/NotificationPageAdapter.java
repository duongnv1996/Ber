package com.umberapp.umber.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.apis.ApiUtils;
import com.umberapp.umber.apis.UmberService;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.models.NotificationItemPage;
import com.umberapp.umber.utils.CommonUtils;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.utils.SharedPref;
import com.umberapp.umber.utils.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import de.hdodenhof.circleimageview.CircleImageView;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationPageAdapter extends Adapter<NotificationPageAdapter.NotitHolder> {
    Context context;
    List<NotificationItemPage> listEx;
    OnRespone<NotificationItemPage> onItemClick;
    OnRespone<Boolean> responseAllRead;

    /* renamed from: com.umberapp.umber.adapters.NotificationPageAdapter.1 */
    class C13971 implements OnClickListener {
        final /* synthetic */ NotificationItemPage val$ex;
        final /* synthetic */ int val$position;

        /* renamed from: com.umberapp.umber.adapters.NotificationPageAdapter.1.1 */
        class C13961 implements Callback<ResponseBody> {
            C13961() {
            }

            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    RLog.m86e("Success read");
                    C13971.this.val$ex.setSeen(1);
                    NotificationPageAdapter.this.listEx.set(C13971.this.val$position, C13971.this.val$ex);
                    NotificationPageAdapter.this.notifyItemChanged(C13971.this.val$position);
                    boolean readAll = true;
                    for (NotificationItemPage i : NotificationPageAdapter.this.listEx) {
                        if (i.getSeen() == 0) {
                            readAll = false;
                        }
                    }
                    NotificationPageAdapter.this.responseAllRead.onRespone(Boolean.valueOf(readAll));
                    return;
                }
                RLog.m86e(Integer.valueOf(response.code()));
            }

            public void onFailure(Call<ResponseBody> call, Throwable t) {
                RLog.m86e(t.getMessage());
            }
        }

        C13971(NotificationItemPage notificationItemPage, int i) {
            this.val$ex = notificationItemPage;
            this.val$position = i;
        }

        public void onClick(View view) {
            ((UmberService) ApiUtils.getRootApi().create(UmberService.class)).readNoti(SharedPref.getInstance(NotificationPageAdapter.this.context).getString(Constant.KEY_TOKEN, BuildConfig.FLAVOR), this.val$ex.getId()).enqueue(new C13961());
            NotificationPageAdapter.this.onItemClick.onRespone(this.val$ex);
        }
    }

    class NotitHolder extends ViewHolder {
        CircleImageView img;
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
            this.img = (CircleImageView) itemView.findViewById(R.id.img_avatar);
            this.llRoot = (LinearLayout) itemView.findViewById(R.id.ll_root_ex);
        }
    }

    public NotificationPageAdapter(Context context, List<NotificationItemPage> listEx, OnRespone<NotificationItemPage> onItemClick, OnRespone<Boolean> responseAllRead) {
        this.context = context;
        this.listEx = listEx;
        this.onItemClick = onItemClick;
        this.responseAllRead = responseAllRead;
    }

    public void notifion(int pos) {
        notifyItemInserted(pos);
    }

    public NotitHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotitHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification_item_page, parent, false));
    }

    public void onBindViewHolder(NotitHolder holder, int position) {
        if (holder != null) {
            NotificationItemPage ex = (NotificationItemPage) this.listEx.get(position);
            holder.img.setImageResource(R.mipmap.icon_app);
            holder.tvStatus.setText(ApiUtils.getStatusFromServer(ex.getContent().getFields().getStatusOrder(), this.context));
            if (ex.getFrom() != null) {
                if (!(ex.getFrom().getAvatar() == null || ex.getFrom().getAvatar().isEmpty())) {
                    Picasso.with(this.context).load(ApiConstants.API_MEDIA_ROOT + ex.getFrom().getAvatar()).into(holder.img);
                }
                holder.tvTitle.setText(ex.getFrom().getFirst_name() + " " + ex.getContent().getTitle());
            }
            holder.tvMess.setText(ex.getContent().getMessage());
            long currentTime = CommonUtils.getUTCTime();
            SimpleDateFormat sdf = new SimpleDateFormat(StringUtil.DATE_FORMAT_27);
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (currentTime - sdf.parse(ex.getCreatedAt() + BuildConfig.FLAVOR).getTime() < 3600000) {
                    holder.tvTime.setText(String.format(this.context.getString(R.string.ago), new Object[]{Long.valueOf(rangTime / 60000)}));
                } else {
                    holder.tvTime.setText(" - " + new SimpleDateFormat("HH:mm MM/dd/yyyy").format(sdf.parse(ex.getCreatedAt())));
                }
            } catch (ParseException e) {
                e.printStackTrace();
                holder.tvTime.setText(" - " + ex.getCreatedAt());
            }
            if (ex.getSeen() == 0) {
                holder.llRoot.setBackgroundColor(this.context.getResources().getColor(R.color.bg_setting));
            }
            holder.llRoot.setOnClickListener(new C13971(ex, position));
        }
    }

    public int getItemCount() {
        return this.listEx.size();
    }
}
