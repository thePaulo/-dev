package com.example.paulov.nijyuunijyugyou;

import java.io.Serializable;

public class GeoLocalizacao implements Serializable {

    private double latitude;
    private double longitude;

    public GeoLocalizacao(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
