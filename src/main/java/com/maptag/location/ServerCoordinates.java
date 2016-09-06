package com.maptag.location;

public class ServerCoordinates {

    public double latitude;
    public double longitude;

    public ServerCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "ServerCoordinates{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
