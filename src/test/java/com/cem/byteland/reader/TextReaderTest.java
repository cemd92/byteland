package com.cem.byteland.reader;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextReaderTest {

    @Test
    public void testReadFile() {
        String testFileName = "testFile.txt";
        ArrayList<String> result = TextReader.ReadFile(testFileName);
        if (result.size() > 0 && result.get(3) != null) {

        }
        //assertEquals(expected, result);

    }
}
