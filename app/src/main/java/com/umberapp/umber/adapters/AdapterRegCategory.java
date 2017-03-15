package com.umberapp.umber.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.umberapp.umber.R;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.interfaces.OnRespone;
import com.umberapp.umber.models.Category;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterRegCategory extends Adapter<AdapterRegCategory.CategoryHolder> {
    Context context;
    List<Category> listCategories;
    OnRespone<Integer> responeDelete;

    /* renamed from: com.umberapp.umber.adapters.AdapterRegCategory.1 */
    class C13851 implements OnClickListener {
        final /* synthetic */ int val$position;

        C13851(int i) {
            this.val$position = i;
        }

        public void onClick(View view) {
            AdapterRegCategory.this.remove(this.val$position);
        }
    }

    class CategoryHolder extends ViewHolder {
        ImageView close;
        CircleImageView icon;
        TextView tvName;

        public CategoryHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.tv_cate);
            this.icon = (CircleImageView) itemView.findViewById(R.id.img_cate);
            this.close = (ImageView) itemView.findViewById(R.id.close);
        }
    }

    public AdapterRegCategory(Context context, List<Category> listCategories, OnRespone<Integer> responeDelete) {
        this.responeDelete = responeDelete;
        this.context = context;
        this.listCategories = listCategories;
    }

    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reg_category, parent, false));
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
            holder.close.setOnClickListener(new C13851(position));
        }
    }

    public int getItemCount() {
        return this.listCategories.size();
    }
}
