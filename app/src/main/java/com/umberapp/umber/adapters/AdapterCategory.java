package com.umberapp.umber.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.models.Category;

import java.util.ArrayList;
import java.util.List;

public class AdapterCategory extends ArrayAdapter<Category> implements Filterable {
    Context context;
    List<Category> listCategories;
    List<Category> listOld;

    /* renamed from: com.umberapp.umber.adapters.AdapterCategory.1 */
    class C13841 extends Filter {
        C13841() {
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            List<Category> listResult = new ArrayList();
            if (charSequence != null) {
                if (charSequence.length() == 0) {
                    listResult.addAll(AdapterCategory.this.listOld);
                } else {
                    for (Category cate : AdapterCategory.this.listOld) {
                        if (cate.getName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                            listResult.add(cate);
                        }
                    }
                }
            }
            filterResults.values = listResult;
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            AdapterCategory.this.listCategories = (List) filterResults.values;
            AdapterCategory.this.notifyDataSetChanged();
        }
    }

    public AdapterCategory(Context context, int resource, List<Category> listCategories) {
        super(context, resource, listCategories);
        this.listOld = new ArrayList();
        this.context = context;
        this.listCategories = listCategories;
        this.listOld.addAll(listCategories);
    }

    public int getCount() {
        return this.listCategories.size();
    }

    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = ((LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_category, parent, false);
        ImageView img = (ImageView) view.findViewById(R.id.img_cate);
        Category category = (Category) this.listCategories.get(position);
        ((TextView) view.findViewById(R.id.tv_cate)).setText(category.getName());
        Picasso.with(this.context).load(ApiConstants.API_MEDIA_ROOT + category.getIcon()).into(img);
        return view;
    }

    @Nullable
    public Category getItem(int position) {
        return (Category) this.listCategories.get(position);
    }

    @NonNull
    public Filter getFilter() {
        return new C13841();
    }
}
