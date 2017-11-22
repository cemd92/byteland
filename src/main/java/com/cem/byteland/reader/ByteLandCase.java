package com.cem.byteland.reader;

import java.util.ArrayList;

public class ByteLandCase {

    private Integer stateCount;
    private ArrayList<Integer> distanceList;

    public ByteLandCase(String stateCountLine, String distanceListLine) {
        this.stateCount = getNumberFromLine(stateCountLine);
        this.distanceList = getNumbersFromLine(distanceListLine);
        if (distanceList.size() + 1 != stateCount) {
            throw new IllegalArgumentException("Deformed input!");
        }
    }

    private Integer getNumberFromLine(String line) {
        if (line != null && line.length() > 0 && line.matches("[0-9]+")) {
            return Integer.parseInt(line);
        }
        throw new IllegalArgumentException("Deformed input!");
    }

    private ArrayList<Integer> getNumbersFromLine(String line) {
        ArrayList<Integer> distanceList = new ArrayList<>();
        if (line != null && line.length() > 0 && line.matches("^[0-9]+( [0-9]+)+$")) {
            for (String distance : line.split(" ")) {
                distanceList.add(getNumberFromLine(distance));
            }
        }
        return distanceList;
    }

    public ArrayList<Integer> getDistanceList() {
        return distanceList;
    }
}
