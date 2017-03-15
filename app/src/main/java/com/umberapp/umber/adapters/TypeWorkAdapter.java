package com.umberapp.umber.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.umberapp.umber.R;
import com.umberapp.umber.activities.MapsActivity;
import com.umberapp.umber.models.Work;
import com.umberapp.umber.utils.Constant;

import java.util.List;

public class TypeWorkAdapter extends Adapter<TypeWorkAdapter.ViewHolder> {
    Context context;
    List<Work> listWorks;

    /* renamed from: com.umberapp.umber.adapters.TypeWorkAdapter.1 */
    class C13981 implements OnClickListener {
        final /* synthetic */ int val$position;

        C13981(int i) {
            this.val$position = i;
        }

        public void onClick(View view) {
            Intent intent = new Intent(TypeWorkAdapter.this.context, MapsActivity.class);
            intent.putExtra(Constant.KEY_TYPE_WORK, this.val$position);
            TypeWorkAdapter.this.context.startActivity(intent);
        }
    }

    class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        LinearLayout llRoot;
        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tv = (TextView) itemView.findViewById(R.id.tv_name_work);
            this.llRoot = (LinearLayout) itemView.findViewById(R.id.ll_work);
        }
    }

    public TypeWorkAdapter(Context context, List<Work> listWorks) {
        this.context = context;
        this.listWorks = listWorks;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_work, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder != null) {
            holder.tv.setText(((Work) this.listWorks.get(position)).getName());
            holder.llRoot.setOnClickListener(new C13981(position));
        }
    }

    public int getItemCount() {
        return this.listWorks.size();
    }
}
