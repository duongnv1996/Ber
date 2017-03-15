package com.umberapp.umber.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog.Builder;
import com.umberapp.umber.R;
import com.umberapp.umber.models.FaqItem;

import java.util.ArrayList;
import java.util.List;

public class FaqAdapter extends Adapter<FaqAdapter.NotitHolder> implements Filterable {
    Context context;
    List<FaqItem> defaultList;
    List<FaqItem> listEx;

    /* renamed from: com.umberapp.umber.adapters.FaqAdapter.1 */
    class C13891 implements OnClickListener {
        final /* synthetic */ FaqItem val$faq;

        C13891(FaqItem faqItem) {
            this.val$faq = faqItem;
        }

        public void onClick(View view) {
            new Builder(FaqAdapter.this.context).content(Html.fromHtml(this.val$faq.content)).title(this.val$faq.title).show();
        }
    }

    /* renamed from: com.umberapp.umber.adapters.FaqAdapter.2 */
    class C13902 extends Filter {
        C13902() {
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            List<FaqItem> listResult = new ArrayList();
            if (charSequence != null) {
                if (charSequence.length() == 0) {
                    listResult.addAll(FaqAdapter.this.defaultList);
                } else {
                    for (FaqItem cate : FaqAdapter.this.listEx) {
                        if (cate.getTitle().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                            listResult.add(cate);
                        }
                    }
                }
            }
            filterResults.values = listResult;
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            FaqAdapter.this.listEx = (List) filterResults.values;
            FaqAdapter.this.notifyDataSetChanged();
        }
    }

    class NotitHolder extends ViewHolder {
        LinearLayout llRoot;
        TextView tvMess;
        TextView tvTitle;

        public NotitHolder(View itemView) {
            super(itemView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.tvMess = (TextView) itemView.findViewById(R.id.tv_mess);
            this.llRoot = (LinearLayout) itemView.findViewById(R.id.ll_root_ex);
        }
    }

    public FaqAdapter(Context context, List<FaqItem> listEx) {
        this.context = context;
        this.listEx = listEx;
        this.defaultList = listEx;
    }

    public void notifion(int pos) {
        notifyItemInserted(pos);
    }

    public NotitHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotitHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faq, parent, false));
    }

    public void onBindViewHolder(NotitHolder holder, int position) {
        if (holder != null) {
            FaqItem faq = (FaqItem) this.listEx.get(position);
            if (faq != null) {
                holder.tvTitle.setText(faq.title);
                holder.tvMess.setText(Html.fromHtml(faq.content));
                holder.llRoot.setOnClickListener(new C13891(faq));
            }
        }
    }

    public int getItemCount() {
        return this.listEx.size();
    }

    @NonNull
    public Filter getFilter() {
        return new C13902();
    }
}
