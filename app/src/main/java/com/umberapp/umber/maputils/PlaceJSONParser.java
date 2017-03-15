package com.umberapp.umber.maputils;

import com.sromku.simple.fb.entities.Page.Properties;
import com.umberapp.umber.utils.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.zhanghai.android.materialprogressbar.BuildConfig;

public class PlaceJSONParser {
    public List<HashMap<String, String>> parse(JSONObject jObject) {
        JSONArray jPlaces = null;
        try {
            jPlaces = jObject.getJSONArray("predictions");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getPlaces(jPlaces);
    }

    private List<HashMap<String, String>> getPlaces(JSONArray jPlaces) {
        int placesCount = jPlaces.length();
        List<HashMap<String, String>> placesList = new ArrayList();
        for (int i = 0; i < placesCount; i++) {
            try {
                placesList.add(getPlace((JSONObject) jPlaces.get(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return placesList;
    }

    private HashMap<String, String> getPlace(JSONObject jPlace) {
        HashMap<String, String> place = new HashMap();
        String id = BuildConfig.FLAVOR;
        String reference = BuildConfig.FLAVOR;
        String description = BuildConfig.FLAVOR;
        try {
            description = jPlace.getString(Properties.DESCRIPTION);
            id = jPlace.getString(Constant.KEY_ID);
            reference = jPlace.getString("reference");
            place.put(Properties.DESCRIPTION, description);
            place.put("_id", id);
            place.put("reference", reference);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return place;
    }
}
