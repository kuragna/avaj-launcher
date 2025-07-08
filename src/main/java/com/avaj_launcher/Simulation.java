package com.avaj_launcher;
import java.io.*;
import java.nio.file.*;
import java.util.*;


class Simulation {
    static public PrintWriter outFile;
    private WeatherTower weatherTower;
    private int numberOfIteration = 0;

    public Simulation(String inFile) throws Exception {
        Iterator<String> iter = Files.readAllLines(Paths.get(inFile)).iterator();

        if (!iter.hasNext()) {
            throw new InvalidArgumentException("file is empty!");
        }

        numberOfIteration = Integer.parseUnsignedInt(iter.next().trim());
        outFile           = new PrintWriter("simulation.txt", "UTF-8");
        weatherTower      = new WeatherTower();

        while (iter.hasNext()) {
            String line = iter.next();
            ParseLine parseLine = new ParseLine(line);

            String type   = parseLine.getType();
            String name   = parseLine.getName();
            Coordinates c = parseLine.getCoordinate();

            Flyable flyable = AircraftFactory.getInstance().newAircraft(type, name, c);
            if (flyable != null) {
                flyable.registerTower(weatherTower);
            }
        }
    }

    public static void print(String str) {
        outFile.println(str);
    }

    public void run() {
        for (int i = 0; i < numberOfIteration; i += 1) {
            Simulation.print("----------------------------------");
            weatherTower.changeWeather();
        }
        outFile.close();
    }
}