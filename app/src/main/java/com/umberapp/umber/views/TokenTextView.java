package com.umberapp.umber.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.umberapp.umber.R;

public class TokenTextView extends TextView {
    public TokenTextView(Context context) {
        super(context);
    }

    public TokenTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSelected(boolean selected) {
        int i;
        super.setSelected(selected);
        if (selected) {
            i = R.drawable.ic_clear_black;
        } else {
            i = 0;
        }
        setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
    }
}
