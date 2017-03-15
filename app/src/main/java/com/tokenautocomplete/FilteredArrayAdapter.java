package com.tokenautocomplete;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class FilteredArrayAdapter<T> extends ArrayAdapter<T> {
    private Filter filter;
    private List<T> originalObjects;

    private class AppFilter extends Filter {
        private ArrayList<T> sourceObjects;

        public AppFilter(List<T> objects) {
            setSourceObjects(objects);
        }

        public void setSourceObjects(List<T> objects) {
            synchronized (this) {
                this.sourceObjects = new ArrayList(objects);
            }
        }

        protected FilterResults performFiltering(CharSequence chars) {
            FilterResults result = new FilterResults();
            if (chars == null || chars.length() <= 0) {
                result.values = this.sourceObjects;
                result.count = this.sourceObjects.size();
            } else {
                String mask = chars.toString();
                ArrayList<T> keptObjects = new ArrayList();
                Iterator it = this.sourceObjects.iterator();
                while (it.hasNext()) {
                    T object = it.next();
                    if (FilteredArrayAdapter.this.keepObject(object, mask)) {
                        keptObjects.add(object);
                    }
                }
                result.count = keptObjects.size();
                result.values = keptObjects;
            }
            return result;
        }

        protected void publishResults(CharSequence constraint, FilterResults results) {
            FilteredArrayAdapter.this.clear();
            if (results.count > 0) {
                FilteredArrayAdapter.this.addAll((Collection) results.values);
                FilteredArrayAdapter.this.notifyDataSetChanged();
                return;
            }
            FilteredArrayAdapter.this.notifyDataSetInvalidated();
        }
    }

    protected abstract boolean keepObject(T t, String str);

    public FilteredArrayAdapter(Context context, int resource, T[] objects) {
        this(context, resource, 0, (Object[]) objects);
    }

    public FilteredArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
        this(context, resource, textViewResourceId, new ArrayList(Arrays.asList(objects)));
    }

    public FilteredArrayAdapter(Context context, int resource, List<T> objects) {
        this(context, resource, 0, (List) objects);
    }

    public FilteredArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        super(context, resource, textViewResourceId, new ArrayList(objects));
        this.originalObjects = objects;
    }

    public void notifyDataSetChanged() {
        ((AppFilter) getFilter()).setSourceObjects(this.originalObjects);
        super.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {
        ((AppFilter) getFilter()).setSourceObjects(this.originalObjects);
        super.notifyDataSetInvalidated();
    }

    public Filter getFilter() {
        if (this.filter == null) {
            this.filter = new AppFilter(this.originalObjects);
        }
        return this.filter;
    }
}
