package com.avaj_launcher;

public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinate);

        switch (weather) {
            case "SUN": {
                // SUN - Longitude increases with 10, Height increases with 2
                coordinate.incLongitude(10);
                coordinate.incHeight(2);
                Simulation.print(toString() + ": Clear skies! Gaining altitude and moving forward with ease.");
            } break;
            case "RAIN": {
                // RAIN - Longitude increases with 5
                coordinate.incLongitude(5);
                Simulation.print(toString() + ": Rain ahead! Progressing steadily through the clouds.");
            } break;
            case "FOG": {
                // FOG - Longitude increases with 1
                coordinate.incLongitude(1);
                Simulation.print(toString() + ": Foggy conditions. Advancing cautiously, slow and steady.");
            } break;
            case "SNOW": {
                // SNOW - Height decreases with 12
                coordinate.decHeight(12);
                Simulation.print(toString() + ": Snow is heavy! Losing altitude, staying vigilant.");
            } break;
        }
        landed();
    }

    public String toString() {
        return "Helicopter#" + name + "(" + id + ")";
    }
}