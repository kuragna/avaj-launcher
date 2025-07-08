package com.avaj_launcher;

abstract class Flyable {
    protected WeatherTower weatherTower;
    abstract void updateConditions();

    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
        weatherTower.register(this);
    }

    public WeatherTower getWeatherTower() {
        return weatherTower;
    }
}