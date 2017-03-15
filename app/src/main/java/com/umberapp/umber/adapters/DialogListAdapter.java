package com.umberapp.umber.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.umberapp.umber.R;

import java.util.ArrayList;

public class DialogListAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> listString;
    String selectionString;

    public DialogListAdapter(Context context, int resource, ArrayList<String> objects, String selectionString) {
        super(context, resource, objects);
        this.selectionString = selectionString;
        this.context = context;
        this.listString = objects;
    }

    public int getCount() {
        return this.listString.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = ((LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_check_dialog_list, null, false);
        RadioButton rb = (RadioButton) view.findViewById(R.id.radiobutton);
        String item = (String) this.listString.get(position);
        ((TextView) view.findViewById(R.id.textview)).setText(item);
        if (item.equals(this.selectionString)) {
            rb.setChecked(true);
        }
        return view;
    }
}
