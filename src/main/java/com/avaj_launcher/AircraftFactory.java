package com.avaj_launcher;

public class AircraftFactory {
    // Singleton: https://en.wikipedia.org/wiki/Singleton_pattern
    // Factory Method: https://refactoring.guru/design-patterns/factory-method
    private static int id = 1;
    private static AircraftFactory instance = null;
    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (instance == null) instance = new AircraftFactory();
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinate) {
        Flyable flyable = null;

        switch (p_type.toLowerCase()) {
            case "balloon":    flyable = new Balloon(id, p_name, p_coordinate);    break;
            case "helicopter": flyable = new Helicopter(id, p_name, p_coordinate); break;
            case "jetplane":   flyable = new JetPlane(id, p_name, p_coordinate);   break;
            default: throw new UnknownAircraftTypeException("Unknown aircraft type: " + p_type);
        }
        id += 1;
        return flyable;
    }
}