package com.avaj_launcher;
import java.util.concurrent.ConcurrentHashMap;

public class Tower {
    // Observer design patters.
    private ConcurrentHashMap<Integer, Flyable> observers;

    public Tower() {
        observers = new ConcurrentHashMap<Integer, Flyable>();
    }

    public void register(Flyable p_flyable) {
        int id = (int)((Aircraft)p_flyable).getId();
        observers.put(id, p_flyable);
        Simulation.print("Tower says: " + p_flyable.toString() + " registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        int id = (int)((Aircraft)p_flyable).getId();
        observers.remove(id);
        Simulation.print("Tower says: " + p_flyable.toString() + " unregistered from weather tower.");
    }

    protected void conditionChanged() {
        observers.forEach((key, value) -> {
            value.updateConditions();
        });
    }
}