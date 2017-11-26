package com.cem.byteland.reader;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ByteLandCaseTest {

    @Test
    public void testCase1() {
        String stateCount = "4";
        String distanceList = "0 1 2";
        ArrayList<Integer> distanceListArray = stringToArray(distanceList);
        ByteLandCase byteLandCase = new ByteLandCase(stateCount, distanceList);

        Assert.assertNotNull(byteLandCase);
        Assert.assertEquals(byteLandCase.getDistanceList(), distanceListArray);
    }

    @Test
    public void testCase2() {
        String stateCount = "8";
        String distanceList = "0 1 2 0 0 3 3";
        ArrayList<Integer> distanceListArray = stringToArray(distanceList);
        ByteLandCase byteLandCase = new ByteLandCase(stateCount, distanceList);

        Assert.assertNotNull(byteLandCase);
        Assert.assertEquals(byteLandCase.getDistanceList(), distanceListArray);
    }

    @Test
    public void testCase3() {
        String stateCount = "9";
        String distanceList = "0 1 1 1 1 0 2 2";
        ArrayList<Integer> distanceListArray = stringToArray(distanceList);
        ByteLandCase byteLandCase = new ByteLandCase(stateCount, distanceList);

        Assert.assertNotNull(byteLandCase);
        Assert.assertEquals(byteLandCase.getDistanceList(), distanceListArray);
    }

    private ArrayList<Integer> stringToArray(String string) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String distance : string.split(" ")) {
            arrayList.add(Integer.parseInt(distance));
        }
        return arrayList;
    }

}
