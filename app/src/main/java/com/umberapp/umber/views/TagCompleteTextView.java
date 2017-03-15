package com.umberapp.umber.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tokenautocomplete.TokenCompleteTextView;
import com.umberapp.umber.R;
import com.umberapp.umber.models.Tag;

public class TagCompleteTextView extends TokenCompleteTextView<Tag> {
    public TagCompleteTextView(Context context) {
        super(context);
    }

    public TagCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TagCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected View getViewForObject(Tag person) {
        TextView token = (TextView) ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.contact_token, (ViewGroup) getParent(), false);
        token.setText(person.getText());
        return token;
    }

    protected Tag defaultObject(String completionText) {
        return new Tag(completionText);
    }
}
