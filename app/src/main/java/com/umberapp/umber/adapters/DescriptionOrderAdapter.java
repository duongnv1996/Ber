package com.umberapp.umber.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import com.umberapp.umber.R;
import com.umberapp.umber.models.Description;

import java.util.List;

public class DescriptionOrderAdapter extends Adapter<DescriptionOrderAdapter.DescriptionHolder> {
    static boolean isBlue50;
    Context context;
    List<Description> listDes;

    class DescriptionHolder extends ViewHolder {
        TableRow llRoot;
        TextView tvDes;
        TextView tvLab;

        public DescriptionHolder(View itemView) {
            super(itemView);
            this.tvLab = (TextView) itemView.findViewById(R.id.tv_lb);
            this.tvDes = (TextView) itemView.findViewById(R.id.tv_des);
            this.llRoot = (TableRow) itemView.findViewById(R.id.ll_root);
        }
    }

    static {
        isBlue50 = true;
    }

    public DescriptionOrderAdapter(Context context, List<Description> listEx) {
        this.context = context;
        this.listDes = listEx;
    }

    public DescriptionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DescriptionHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_order, parent, false));
    }

    public void onBindViewHolder(DescriptionHolder holder, int position) {
        if (holder != null) {
            Description des = (Description) this.listDes.get(position);
            holder.tvLab.setText(des.getLabel());
            holder.tvDes.setText(des.getDescription());
            if (isBlue50) {
                isBlue50 = false;
                return;
            }
            holder.llRoot.setBackgroundColor(this.context.getResources().getColor(R.color.material_blue_50));
            isBlue50 = true;
        }
    }

    public int getItemCount() {
        if (this.listDes != null) {
            return this.listDes.size();
        }
        return 0;
    }
}
