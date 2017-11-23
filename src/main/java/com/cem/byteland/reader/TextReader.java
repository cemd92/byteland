package com.cem.byteland.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextReader {

    static ArrayList<String> ReadFile(String fileName) {
        ArrayList<String> lines = null;
        BufferedReader bufferedReader = null;
        try {
            lines = new ArrayList<>();
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException e) {
            System.out.println(String.format("Error while reading the file: %s", fileName));
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Shit happened!");
                }
            }
        }
        return lines;
    }
}
