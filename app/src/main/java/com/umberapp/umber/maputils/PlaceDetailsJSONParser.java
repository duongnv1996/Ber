package com.umberapp.umber.maputils;

import com.sromku.simple.fb.entities.Profile.Properties;
import com.umberapp.umber.apis.ApiConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaceDetailsJSONParser {
    public List<HashMap<String, String>> parse(JSONObject jObject) {
        Double lat = Double.valueOf(0.0d);
        Double lng = Double.valueOf(0.0d);
        HashMap<String, String> hm = new HashMap();
        List<HashMap<String, String>> list = new ArrayList();
        try {
            lat = (Double) jObject.getJSONObject("result").getJSONObject("geometry").getJSONObject(Properties.LOCATION).get(ApiConstants.KEY_LAT);
            lng = (Double) jObject.getJSONObject("result").getJSONObject("geometry").getJSONObject(Properties.LOCATION).get(ApiConstants.KEY_LONG);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        hm.put(ApiConstants.KEY_LAT, Double.toString(lat.doubleValue()));
        hm.put(ApiConstants.KEY_LONG, Double.toString(lng.doubleValue()));
        list.add(hm);
        return list;
    }
}
