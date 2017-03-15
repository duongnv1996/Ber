package com.tokenautocomplete;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.bumptech.glide.request.target.Target;

public class ViewSpan extends ReplacementSpan {
    private int maxWidth;
    protected View view;

    public ViewSpan(View v, int maxWidth) {
        this.maxWidth = maxWidth;
        this.view = v;
        this.view.setLayoutParams(new LayoutParams(-2, -2));
    }

    private void prepView() {
        this.view.measure(MeasureSpec.makeMeasureSpec(this.maxWidth, Target.SIZE_ORIGINAL), MeasureSpec.makeMeasureSpec(0, 0));
        this.view.layout(0, 0, this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
    }

    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        prepView();
        canvas.save();
        canvas.translate(x, (float) ((bottom - this.view.getBottom()) - (((bottom - top) - this.view.getBottom()) / 2)));
        this.view.draw(canvas);
        canvas.restore();
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fm) {
        prepView();
        if (fm != null) {
            int need = this.view.getMeasuredHeight() - (fm.descent - fm.ascent);
            if (need > 0) {
                int ascent = need / 2;
                fm.descent += need - ascent;
                fm.ascent -= ascent;
                fm.bottom += need - ascent;
                fm.top -= need / 2;
            }
        }
        return this.view.getRight();
    }
}
