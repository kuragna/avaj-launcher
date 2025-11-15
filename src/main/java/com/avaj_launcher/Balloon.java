package com.avaj_launcher;

public class Balloon extends Aircraft {


    public Balloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinate);

        switch (weather) {
            case "SUN": {
                // SUN - Longitude increases with 2, Height increases with 4
                coordinate.incLongitude(2);
                coordinate.incHeight(4);
                Simulation.print(toString() + ": The sun is out! Rising gently and drifting forward. " + weather);
            } break;
            case "RAIN": {
                // RAIN - Height decreases with 5
                coordinate.decHeight(5);
                Simulation.print(toString() + ": Rain is falling! Losing some altitude, stay careful. " + weather);
            } break;
            case "FOG": {
                // FOG - Height decreases with 3
                coordinate.decHeight(3);
                Simulation.print(toString() + ": Fog surrounds us. Descending slowly, proceed with caution. " + weather);
            } break;
            case "SNOW": {
                // SNOW - Height decreases with 15
                coordinate.decHeight(15);
                Simulation.print(toString() + ": Snowstorm ahead! Rapidly losing altitude, hold tight. " + weather);
            } break;
        }
        landed();
    }

    public String toString() {
        return "Balloon#" + name + "(" + id + ")";
    }
}