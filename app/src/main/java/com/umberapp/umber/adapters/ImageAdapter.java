package com.umberapp.umber.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.umberapp.umber.R;
import com.umberapp.umber.activities.PhotoViewActivity;
import com.umberapp.umber.apis.ApiConstants;
import com.umberapp.umber.models.Image;
import com.umberapp.umber.utils.Constant;
import com.umberapp.umber.utils.FileUtils;
import com.umberapp.umber.utils.RLog;
import com.umberapp.umber.views.ProgressDialogCustom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ImageAdapter extends Adapter<ImageAdapter.ImageHolder> {
    Context context;
    ProgressDialogCustom dialog;
    List<Image> imageList;
    List<Image> imageSave;

    /* renamed from: com.umberapp.umber.adapters.ImageAdapter.1 */
    class C13921 extends SimpleTarget<Bitmap> {
        C13921() {
        }

        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
        }
    }

    /* renamed from: com.umberapp.umber.adapters.ImageAdapter.2 */
    class C13932 implements RequestListener<File, Bitmap> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ Image val$img;

        C13932(Context context, Image image) {
            this.val$context = context;
            this.val$img = image;
        }

        public boolean onException(Exception e, File model, Target<Bitmap> target, boolean isFirstResource) {
            ImageAdapter.this.dialog.hideDialog();
            Toast.makeText(this.val$context, this.val$context.getString(R.string.unknow_error), Toast.LENGTH_SHORT).show();
            RLog.m86e(e.getMessage());
            return false;
        }

        public boolean onResourceReady(Bitmap resource, File model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
            File saveFile = FileUtils.SaveImage(this.val$context, resource);
            if (saveFile != null) {
                Image i = this.val$img;
                i.setPath(saveFile.getPath());
                ImageAdapter.this.imageSave.add(i);
                if (ImageAdapter.this.imageSave.size() == ImageAdapter.this.imageList.size()) {
                    ImageAdapter.this.dialog.hideDialog();
                } else {
                    RLog.m86e("image save size = " + ImageAdapter.this.imageSave.size());
                }
            } else {
                ImageAdapter.this.dialog.hideDialog();
                Toast.makeText(this.val$context, this.val$context.getString(R.string.unknow_error), Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    }

    /* renamed from: com.umberapp.umber.adapters.ImageAdapter.3 */
    class C13943 implements OnClickListener {
        final /* synthetic */ Image val$image;

        C13943(Image image) {
            this.val$image = image;
        }

        public void onClick(View view) {
            Intent i = new Intent(ImageAdapter.this.context, PhotoViewActivity.class);
            i.putExtra(Constant.KEY_MSG, this.val$image.getPath());
            ImageAdapter.this.context.startActivity(i);
        }
    }

    /* renamed from: com.umberapp.umber.adapters.ImageAdapter.4 */
    class C13954 implements OnClickListener {
        final /* synthetic */ int val$position;

        C13954(int i) {
            this.val$position = i;
        }

        public void onClick(View view) {
            ImageAdapter.this.remove(this.val$position);
        }
    }

    class ImageHolder extends ViewHolder {
        ImageView btn;
        ImageView img;
        ProgressBar load;

        public ImageHolder(View itemView) {
            super(itemView);
            this.img = (ImageView) itemView.findViewById(R.id.img);
            this.btn = (ImageView) itemView.findViewById(R.id.btn_clear);
            this.load = (ProgressBar) itemView.findViewById(R.id.progress);
        }
    }

    public ImageAdapter(Context context, List<Image> images) {
        this.context = context;
        this.imageList = images;
        this.dialog = new ProgressDialogCustom(context);
        this.imageSave = new ArrayList();
        int i = 0;
        for (Image img : images) {
            saveImage(context, i, img);
            i++;
        }
    }

    private void saveImage(Context context, int i, Image img) {
        if (!(this.dialog == null || this.dialog.isShowing())) {
            this.dialog.showDialog();
        }
        if (img == null || img.getPath() == null) {
            this.dialog.hideDialog();
            Toast.makeText(context, context.getString(R.string.unknow_error), Toast.LENGTH_SHORT).show();
            return;
        }
        Glide.with(context).load(new File(img.getPath())).asBitmap().override((int) ApiConstants.CODE_ERROR_SERVER, (int) ApiConstants.CODE_ERROR_SERVER).fitCenter().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.ALL).listener(new C13932(context, img)).into(new C13921());
    }

    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }

    public void add(Image img) {
        this.imageList.add(img);
        saveImage(this.context, this.imageList.size() - 1, img);
        notifyItemInserted(getItemCount() - 1);
    }

    public void removeAll() {
        try {
            this.imageList.clear();
            this.imageSave.clear();
            notifyDataSetChanged();
        } catch (Exception e) {
            RLog.m86e(e.getMessage());
        }
    }

    private void remove(int pos) {
        try {
            this.imageList.remove(pos);
            this.imageSave.remove(pos);
            notifyDataSetChanged();
        } catch (Exception e) {
            RLog.m86e(e.getMessage());
        }
    }

    public void onBindViewHolder(ImageHolder holder, int position) {
        if (holder != null) {
            Image image = (Image) this.imageList.get(position);
            File fileImage = new File(image.getPath());
            holder.load.setVisibility(View.GONE);
            holder.img.setVisibility(View.VISIBLE);
            if (fileImage.exists()) {
                Glide.with(this.context).load(fileImage).asBitmap().skipMemoryCache(true).centerCrop().thumbnail(0.1f).error((int) R.drawable.__picker_ic_broken_image_black_48dp).into(holder.img);
            }
            holder.img.setOnClickListener(new C13943(image));
            holder.btn.setOnClickListener(new C13954(position));
        }
    }

    public List<Image> getList() {
        return this.imageSave;
    }

    public int getItemCount() {
        return this.imageList.size();
    }
}
