package com.umberapp.umber.adapters;

import android.app.Activity;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.umberapp.umber.R;
import com.umberapp.umber.models.Category;

import java.util.List;

public class AdapterSpinnerCategoy extends ArrayAdapter<String> {
    Activity activity;
    LayoutInflater layoutInflater;
    List listPlace;
    Resources res;
    ViewHolder viewHolder;

    class ViewHolder {
        TextView tvPlace;

        ViewHolder() {
        }
    }

    public AdapterSpinnerCategoy(Activity context, int textViewResourceId, List listPlace, Resources res) {
        super(context, textViewResourceId, textViewResourceId, listPlace);
        this.layoutInflater = null;
        this.listPlace = listPlace;
        this.activity = context;
        this.res = res;
        this.layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void addList(List places) {
        this.listPlace.addAll(places);
        notifyDataSetChanged();
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    private View getCustomView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.item_spinner_category, parent, false);
            this.viewHolder = new ViewHolder();
            this.viewHolder.tvPlace = (TextView) convertView.findViewById(R.id.tv_cate_item);
            convertView.setTag(this.viewHolder);
        } else {
            this.viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position == 0) {
            this.viewHolder.tvPlace.setText(R.string.pick_category);
        } else {
            this.viewHolder.tvPlace.setText(((Category) this.listPlace.get(position)).getName());
        }
        return convertView;
    }
}
