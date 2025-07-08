package com.avaj_launcher;

class ParseLine {
    private static final String[] types = {"jetplane", "balloon", "helicopter"};
    private String type;
    private String name;
    private Coordinates coordinate;

    public ParseLine(String line) throws Exception {
        String[] words = line.trim().split("\\s+");

        if (words.length != 5) {
            throw new InvalidArgumentException("Invalid line format: " + line);
        }

        if (!checkType(words[0])) {
            throw new UnknownAircraftTypeException("Unknown aircraft type: " + words[0]);
        }

        type = words[0];
        name = words[1];

        coordinate = new Coordinates(
                Integer.parseUnsignedInt(words[2]),
                Integer.parseUnsignedInt(words[3]),
                Integer.parseUnsignedInt(words[4]));
    }

    private boolean checkType(String p_type) {

        for (int i = 0; i < types.length; i += 1) {
            if (p_type.toLowerCase().equals(types[i])) {
                return true;
            }
        }
        return false;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }
}