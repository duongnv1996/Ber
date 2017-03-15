package com.tokenautocomplete;

import android.content.Context;
import android.widget.TextView;
import me.zhanghai.android.materialprogressbar.BuildConfig;

public class CountSpan extends ViewSpan {
    public String text;

    public CountSpan(int count, Context ctx, int textColor, int textSize, int maxWidth) {
        super(new TextView(ctx), maxWidth);
        this.text = BuildConfig.FLAVOR;
        TextView v = this.view;
        v.setTextColor(textColor);
        v.setTextSize(0, (float) textSize);
        setCount(count);
    }

    public void setCount(int c) {
        this.text = "+" + c;
        ((TextView) this.view).setText(this.text);
    }
}
