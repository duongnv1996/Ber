package com.umberapp.umber.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.models.Category;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterUpdateCategory extends Adapter<AdapterUpdateCategory.CategoryHolder> {
    Context context;
    List<Category> listCategories;
    OnRespone<Integer> responeDelete;

    /* renamed from: com.umberapp.umber.adapters.AdapterUpdateCategory.1 */
    class C13861 implements OnClickListener {
        final /* synthetic */ int val$position;

        C13861(int i) {
            this.val$position = i;
        }

        public void onClick(View view) {
            AdapterUpdateCategory.this.remove(this.val$position);
        }
    }

    /* renamed from: com.umberapp.umber.adapters.AdapterUpdateCategory.2 */
    class C13872 implements TextWatcher {
        final /* synthetic */ Category val$category;
        final /* synthetic */ int val$position;

        C13872(Category category, int i) {
            this.val$category = category;
            this.val$position = i;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                this.val$category.setCostHour(Double.parseDouble(editable.toString()));
                AdapterUpdateCategory.this.listCategories.set(this.val$position, this.val$category);
            }
        }
    }

    class CategoryHolder extends ViewHolder {
        ImageView close;
        EditText editText;
        CircleImageView icon;
        TextView tvName;

        public CategoryHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.tv_cate);
            this.icon = (CircleImageView) itemView.findViewById(R.id.img_cate);
            this.close = (ImageView) itemView.findViewById(R.id.close);
            this.editText = (EditText) itemView.findViewById(R.id.edt_cost);
        }
    }

    public AdapterUpdateCategory(Context context, List<Category> listCategories, OnRespone<Integer> responeDelete) {
        this.responeDelete = responeDelete;
        this.context = context;
        this.listCategories = listCategories;
    }

    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_update_category, parent, false));
    }

    private void remove(int pos) {
        this.listCategories.remove(pos);
        this.responeDelete.onRespone(Integer.valueOf(getItemCount()));
        notifyDataSetChanged();
    }

    public void onBindViewHolder(CategoryHolder holder, int position) {
        if (holder != null) {
            Category category = (Category) this.listCategories.get(position);
            holder.tvName.setText(category.getName());
            Picasso.with(this.context).load(ApiConstants.API_PHOTO_ROOT + category.getIcon()).into(holder.icon);
            holder.close.setOnClickListener(new C13861(position));
            holder.editText.addTextChangedListener(new C13872(category, position));
        }
    }

    public int getItemCount() {
        return this.listCategories.size();
    }
}
