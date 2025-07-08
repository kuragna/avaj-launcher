package com.avaj_launcher;

public class Main {
    public static void main(String[] args) {
        try {

            if (args.length != 1) {
                throw new InvalidArgumentException("invalid argument");
            }

            Simulation simulation = new Simulation(args[0]);
            simulation.run();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            //e.printStackTrace();
            System.exit(1);
        }
    }
}