package com.avaj_launcher;

public class Coordinates {

    public static final int HEIGHT_MAX = 100;
    public static final int HEIGHT_MIN = 0;

    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) throws Exception {
        if (p_height < 0 || p_height > HEIGHT_MAX) {
            throw new InvalidCoordinatesException("Invalid height: " + p_height);
        }
        if (p_longitude < 0 || p_latitude < 0) {
            throw new InvalidCoordinatesException("Longitude or latitude is negative: " + p_longitude + ", " + p_latitude);
        }
        longitude = p_longitude;
        latitude  = p_latitude;
        height    = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void incHeight(int value) {
        height = Math.max(HEIGHT_MIN, Math.min(height + value, HEIGHT_MAX));
    }

    public void decHeight(int value) {
        height = Math.max(HEIGHT_MIN, Math.min(height - value, HEIGHT_MAX));
    }

    public void incLatitude(int value) {
        latitude += value;
    }

    public void incLongitude(int value) {
        longitude += value;
    }
}