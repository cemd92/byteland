package com.cem.byteland.reader;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextReaderTest {

    @Test
    public void testReadFile() {
        String testFileName = "testFile.txt";

        String line3Part = " mollis dictum. Vivamus vitae elementum eros, in molest";
        ArrayList<String> result = TextReader.ReadFile(testFileName);
        if (result.size() > 0 && result.get(2) != null) {
            Assert.assertThat(result.get(2), CoreMatchers.containsString(line3Part));
        }
    }
}
