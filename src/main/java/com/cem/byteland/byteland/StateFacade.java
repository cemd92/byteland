package com.cem.byteland.byteland;

import com.cem.byteland.reader.ByteLandCase;

import java.util.ArrayList;

public class StateFacade {

    private StateGraph stateGraph;

    public void createStateMap(ArrayList<ByteLandCase> byteLandCaseList) {


        for (ByteLandCase byteLandCase : byteLandCaseList) {
            StateGraph stateGraph = new StateGraph();
            for (Integer distance : byteLandCase.getDistanceList()) {
                stateGraph.addNewState(distance);
            }
        }
    }

}
