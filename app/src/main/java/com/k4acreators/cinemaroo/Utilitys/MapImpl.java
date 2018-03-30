package com.k4acreators.cinemaroo.Utilitys;

import org.json.JSONObject;

/**
 * Created by PC on 1/27/2018.
 */

public class MapImpl {
    public static String MAP_API_URL;

    public static JSONObject getLocationByCity(String city) {
        JSONObject jsonObject = null;
        try {
            city = city.replaceAll(" ","%20");
            JSONObject json = new JSONObject(HttpClient.get(MAP_API_URL + "address=" + city).toString());
            //System.out.println(HttpClient.get(MAP_API_URL + "address=" + city));
            //System.out.println(json);
            jsonObject = json.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
