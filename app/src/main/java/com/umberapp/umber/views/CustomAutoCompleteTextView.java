package com.umberapp.umber.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import com.sromku.simple.fb.entities.Page.Properties;

import java.util.HashMap;

public class CustomAutoCompleteTextView extends android.support.v7.widget.AppCompatAutoCompleteTextView {
    public CustomAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected CharSequence convertSelectionToString(Object selectedItem) {
        return (CharSequence) ((HashMap) selectedItem).get(Properties.DESCRIPTION);
    }
}
