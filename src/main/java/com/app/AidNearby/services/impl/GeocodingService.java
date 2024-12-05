package com.app.AidNearby.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class GeocodingService {

    private static final String GEOCODING_API_URL = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String API_KEY = "AIzaSyA_KJEl3P4jbk7kGxOuz8yUCrVVulvXSzs";

    public double[] getCoordinates(String address) {
        RestTemplate restTemplate = new RestTemplate();
        String url = GEOCODING_API_URL + "?address=" + address + "&key=" + API_KEY;

        String response = restTemplate.getForObject(url, String.class);
        JSONObject jsonResponse = new JSONObject(response);

        if (!jsonResponse.getString("status").equals("OK")) {
            throw new RuntimeException("Failed to get coordinates for address: " + address);
        }

        JSONObject location = jsonResponse
                .getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("geometry")
                .getJSONObject("location");

        return new double[]{location.getDouble("lat"), location.getDouble("lng")};
    }

    public String getAddress(double latitude, double longitude) {
        RestTemplate restTemplate = new RestTemplate();
        String url = GEOCODING_API_URL + "?latlng=" + latitude + "," + longitude + "&key=" + API_KEY;

        String response = restTemplate.getForObject(url, String.class);
        JSONObject jsonResponse = new JSONObject(response);

        if (!jsonResponse.getString("status").equals("OK")) {
            throw new RuntimeException("Failed to get address for coordinates: " + latitude + ", " + longitude);
        }

        return jsonResponse
                .getJSONArray("results")
                .getJSONObject(0)
                .getString("formatted_address");
    }
}