package com.umberapp.umber.maputils;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class PlacesAutoCompleteAdapter extends ArrayAdapter<PlacesAutoCompleteAdapter.PlaceAutocomplete> implements Filterable {
    private static final String TAG = "PlaceAutocomplete";
    private LatLngBounds mBounds;
    private GoogleApiClient mGoogleApiClient;
    private AutocompleteFilter mPlaceFilter;
    private ArrayList<PlaceAutocomplete> mResultList;

    /* renamed from: com.umberapp.umber.maputils.PlacesAutoCompleteAdapter.1 */
    class C14331 extends Filter {
        C14331() {
        }

        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null) {
                PlacesAutoCompleteAdapter.this.mResultList = PlacesAutoCompleteAdapter.this.getAutocomplete(constraint);
                if (PlacesAutoCompleteAdapter.this.mResultList != null) {
                    results.values = PlacesAutoCompleteAdapter.this.mResultList;
                    results.count = PlacesAutoCompleteAdapter.this.mResultList.size();
                }
            }
            return results;
        }

        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results == null || results.count <= 0) {
                PlacesAutoCompleteAdapter.this.notifyDataSetInvalidated();
            } else {
                PlacesAutoCompleteAdapter.this.notifyDataSetChanged();
            }
        }
    }

    public class PlaceAutocomplete {
        public CharSequence description;
        public CharSequence placeId;

        PlaceAutocomplete(CharSequence placeId, CharSequence description) {
            this.placeId = placeId;
            this.description = description;
        }

        public String toString() {
            return this.description.toString();
        }
    }

    public PlacesAutoCompleteAdapter(Context context, int resource, GoogleApiClient googleApiClient, LatLngBounds bounds, AutocompleteFilter filter) {
        super(context, resource);
        this.mGoogleApiClient = googleApiClient;
        this.mBounds = bounds;
        this.mPlaceFilter = filter;
    }

    public void setBounds(LatLngBounds bounds) {
        this.mBounds = bounds;
    }

    public int getCount() {
        return this.mResultList.size();
    }

    public PlaceAutocomplete getItem(int position) {
        return (PlaceAutocomplete) this.mResultList.get(position);
    }

    public Filter getFilter() {
        return new C14331();
    }

    private ArrayList<PlaceAutocomplete> getAutocomplete(CharSequence constraint) {
        if (this.mGoogleApiClient.isConnected()) {
            AutocompletePredictionBuffer autocompletePredictions = (AutocompletePredictionBuffer) Places.GeoDataApi.getAutocompletePredictions(this.mGoogleApiClient, constraint.toString(), this.mBounds, this.mPlaceFilter).await(60, TimeUnit.SECONDS);
            Status status = autocompletePredictions.getStatus();
            if (status.isSuccess()) {
                Iterator<AutocompletePrediction> iterator = autocompletePredictions.iterator();
                ArrayList<PlaceAutocomplete> resultList = new ArrayList(autocompletePredictions.getCount());
                while (iterator.hasNext()) {
                    AutocompletePrediction prediction = (AutocompletePrediction) iterator.next();
                    resultList.add(new PlaceAutocomplete(prediction.getPlaceId(), prediction.getFullText(null)));
                }
                autocompletePredictions.release();
                return resultList;
            }
            Toast.makeText(getContext(), "Error contacting API: " + status.toString(), 0).show();
            Log.e(TAG, "Error getting autocomplete prediction API call: " + status.toString());
            autocompletePredictions.release();
            return null;
        }
        Log.e(TAG, "Google API client is not connected for autocomplete query.");
        return null;
    }
}
