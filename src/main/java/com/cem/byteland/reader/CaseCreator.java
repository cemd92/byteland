package com.cem.byteland.reader;

import java.util.ArrayList;

public class CaseCreator {

    /**
     * Crates the case objects from given file name
     *
     * @param fileName
     * @return List of cases
     */
    public static ArrayList<ByteLandCase> getCasesFromFile(String fileName) {
        ArrayList<String> lines = TextReader.ReadFile(fileName);
        ArrayList<ByteLandCase> cases = new ArrayList<>();
        for (int i = 1; i < lines.size(); i += 2) {
            try {
                cases.add(new ByteLandCase(lines.get(i), lines.get(i + 1)));
            } catch (Exception e) {
                System.out.println(String.format("Case has wrong values in lines: %d - %d", i, i + 1));
            }
        }
        return cases;
    }
}
