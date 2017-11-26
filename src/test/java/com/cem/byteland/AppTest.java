package com.cem.byteland;

import com.cem.byteland.byteland.StateGraphTest;
import com.cem.byteland.byteland.StateTest;
import com.cem.byteland.reader.ByteLandCaseTest;
import com.cem.byteland.reader.TextReaderTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Unit test for simple App.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ByteLandCaseTest.class, TextReaderTest.class, StateTest.class, StateGraphTest.class
})
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
