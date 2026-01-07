# Avaj Launcher

A Java-based aircraft simulation program that demonstrates design patterns and object-oriented programming principles through weather-based aircraft behavior simulation.

## Overview

Avaj Launcher simulates the flight of various aircraft types responding to different weather conditions. The program implements the Observer pattern, where aircraft register with a weather tower and receive weather updates that affect their behavior.

## Features

-   **Multiple Aircraft Types**: Supports helicopters, jetplanes, and balloons
-   **Dynamic Weather System**: Simulates changing weather conditions (RAIN, FOG, SUN, SNOW)
-   **Observer Pattern Implementation**: Aircraft subscribe to weather updates from a central tower
-   **Scenario-Based Simulation**: Configurable flight scenarios through input files
-   **Logging System**: Detailed output of aircraft responses and tower communications

## Installation

### Prerequisites

-   Java Development Kit (JDK) 8 or higher
-   A Java IDE or text editor

## Usage

### Running the Simulation

```bash
./run.sh <scenario.txt>
```

### Input File Format

Create a scenario file (e.g., `scenario.txt`) with the following format:

```
25
Balloon B1 2 3 20
Balloon B2 1 8 66
JetPlane J1 23 44 32
Helicopter H1 654 33 20
Helicopter H2 22 33 44
Helicopter H3 98 68 99
Baloon B3 102 22 34
JetPlane J2 11 99 768
Helicopter H4 223 23 54
```

**Format Rules:**

-   First line: Number of simulation cycles (positive integer)
-   Following lines: `TYPE NAME LONGITUDE LATITUDE HEIGHT`
    -   TYPE: `Balloon`, `JetPlane`, or `Helicopter`
    -   NAME: Unique identifier
    -   LONGITUDE, LATITUDE, HEIGHT: Positive integers

### Output

The program generates a `simulation.txt` file containing:

-   Aircraft registration confirmations
-   Weather updates for each cycle
-   Aircraft responses to weather conditions
-   Landing notifications when aircraft reach ground level (height ≤ 0)
-   Unregistration messages

Example output:

```
Tower says: Helicopter#H1(1) registered to weather tower.
Tower says: Balloon#B1(2) registered to weather tower.
Helicopter#H1(1): The weather is RAIN. Better watch out for lightning!
Balloon#B1(2): The weather is SUN. Let's enjoy the good weather and take some pics.
Tower says: Helicopter#H1(1) unregistered from weather tower.
```

## Design Patterns

### Observer Pattern

-   **WeatherTower** acts as the subject
-   **Aircraft** implementations are observers
-   Weather changes trigger notifications to all registered aircraft

### Factory Pattern

-   **AircraftFactory** creates appropriate aircraft instances based on type strings

### Singleton Pattern

-   **WeatherProvider** ensures a single weather generation source

## Weather Effects

Each aircraft type responds differently to weather conditions:

### Helicopter

-   **SUN**: Gains altitude and moves forward
-   **RAIN**: Moves east
-   **FOG**: Moves east
-   **SNOW**: Loses altitude

### JetPlane

-   **SUN**: Gains altitude and moves forward
-   **RAIN**: Gains altitude
-   **FOG**: Reduced movement
-   **SNOW**: Loses altitude

### Balloon

-   **SUN**: Gains altitude and moves east
-   **RAIN**: Loses altitude
-   **FOG**: Loses altitude
-   **SNOW**: Loses altitude significantly

## License

This project is part of the 42 school curriculum.
