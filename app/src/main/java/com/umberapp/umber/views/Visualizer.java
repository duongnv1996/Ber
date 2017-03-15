package com.umberapp.umber.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Visualizer extends View {
    private static final int LINE_SCALE = 75;
    private static final int LINE_WIDTH = 2;
    private List<Float> amplitudes;
    private int height;
    private Paint linePaint;
    private int width;

    public Visualizer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.linePaint = new Paint();
        this.linePaint.setColor(Color.RED);
        this.linePaint.setStrokeWidth(2.0f);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.width = w;
        this.height = h;
        this.amplitudes = new ArrayList(this.width / LINE_WIDTH);
    }

    public void clear() {
        this.amplitudes.clear();
    }

    public void addAmplitude(float amplitude) {
        this.amplitudes.add(Float.valueOf(amplitude));
        if (this.amplitudes.size() * LINE_WIDTH >= this.width) {
            this.amplitudes.remove(0);
        }
    }

    public void onDraw(Canvas canvas) {
        int middle = this.height / LINE_WIDTH;
        float curX = 0.0f;
        for (Float floatValue : this.amplitudes) {
            float scaledHeight = floatValue.floatValue() / 75.0f;
            curX += 2.0f;
            Canvas canvas2 = canvas;
            float f = curX;
            canvas2.drawLine(curX, (scaledHeight / 2.0f) + ((float) middle), f, ((float) middle) - (scaledHeight / 2.0f), this.linePaint);
        }
    }
}
