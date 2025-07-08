package com.avaj_launcher;

import java.util.Random;

public class WeatherProvider {
    // Singleton:      https://en.wikipedia.org/wiki/Singleton_pattern
    private static WeatherProvider instance = null;
    private final  String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public String getCurrentWeather(Coordinates p_coordinate) {
        int height    = p_coordinate.getHeight();
        int latitude  = p_coordinate.getLatitude();
        int longitude = p_coordinate.getLongitude();
        int num       = ((longitude + latitude + height) % weather.length) + 1;
        int index     = (int)(Math.random() * num);
        return weather[index];
    }

    public static WeatherProvider getInstance() {
        if (instance == null) instance = new WeatherProvider();
        return instance;
    }

}