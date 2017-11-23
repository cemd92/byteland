package com.cem.byteland.reader;

import java.util.ArrayList;

public class ByteLandCase {

    private Integer stateCount;// State count in the case
    private ArrayList<Integer> distanceList;// Distances of the citiess

    /**
     * Creates the case object from string input
     *
     * @param stateCountLine
     * @param distanceListLine
     */
    public ByteLandCase(String stateCountLine, String distanceListLine) {
        this.stateCount = getNumberFromLine(stateCountLine);
        this.distanceList = getNumbersFromLine(distanceListLine);
        if (distanceList.size() + 1 != stateCount) {
            throw new IllegalArgumentException("Deformed input!");
        }
    }

    /**
     * Returns the integer value from the digit string
     *
     * @param line
     * @return Integer value of string digit
     */
    private Integer getNumberFromLine(String line) {
        if (line != null && line.length() > 0 && line.matches("[0-9]+")) {
            return Integer.parseInt(line);
        }
        throw new IllegalArgumentException("Deformed input!");
    }

    /**
     * Returns the list of integer from digit of string
     *
     * @param line
     * @return List of integer value from string
     */
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
