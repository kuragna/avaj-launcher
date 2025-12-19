package com.avaj_launcher;

public class Aircraft extends Flyable
{
    protected long   id;
    protected String name;
    protected Coordinates coordinate;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        id         = p_id;
        name       = p_name;
        coordinate = p_coordinate;
    }

    public void updateConditions() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public void landed() {
        if (coordinate.getHeight() == Coordinates.HEIGHT_MIN) {
            Simulation.print(toString() + " landing.");
            weatherTower.unregister(this);
        }
    }
}
