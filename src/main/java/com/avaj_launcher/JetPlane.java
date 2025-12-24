package com.avaj_launcher;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {

        String weather = weatherTower.getWeather(coordinate);

        switch(weather) {
            case "SUN": {
                // SUN - Latitude increases with 10, Height increases with 2
                coordinate.incLatitude(10);
                coordinate.incHeight(2);
                Simulation.print(toString() + ": The sun is shining! Ascending steadily and cruising forward");
            } break;
            case "RAIN": {
                // RAIN - Latitude increases with 5
                coordinate.incLatitude(5);
                Simulation.print(toString() + ": Raindrops ahead! Pushing through with steady progress.");
            } break;
            case "FOG": {
                // FOG - Latitude increases with 1
                coordinate.incLatitude(1);
                Simulation.print(toString() + ": Fog is thick. Moving cautiously, little by little.");
            } break;
            case "SNOW": {
                // SNOW - Height decreases with 7
                coordinate.decHeight(7);
                Simulation.print(toString() + ": Snowstorm encountered! Losing altitude, stay alert.");
            } break;
        }
        landed();
    }

    public String toString() {
        return "JetPlane#" + name + "(" + id + ")";
    }
}