package com.cem.byteland.byteland;

import com.cem.byteland.reader.ByteLandCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class StateFacade {

    private StateGraph stateGraph;
    private Integer negotiationCount = 0;

    public void createStateMap(ByteLandCase byteLandCase) {
        this.stateGraph = new StateGraph();
        for (Integer distance : byteLandCase.getDistanceList()) {
            stateGraph.addNewState(distance);
        }
        uniteStates();
    }

    public void uniteStates() {

        while (!isUnited()) {
            ArrayList<State> sortedStateList = getStatesSortedByNeighbourCount();
            Integer possibleNegotiationNumber = new Double(Math.floor(sortedStateList.size() / 2)).intValue();
            //List<State> bigStates = sortedStateList.subList(0, possibleNegotiationNumber);
            Iterator<State> iterator = sortedStateList.iterator();

            Integer i = 0;
            while (iterator.hasNext()) {
                State state1 = iterator.next();
                //State state2 =
                this.negotiationCount++;
            }

            System.out.println(this.negotiationCount);
        }

    }

    private ArrayList<State> getStatesSortedByNeighbourCount() {
        ArrayList<State> sortedStateList = new ArrayList<>(stateGraph.getStateList());
        Collections.sort(sortedStateList);
        return sortedStateList;

    }

    private Boolean isUnited() {
        if (stateGraph.getStateCount() > 1) {
            return false;
        }
        return true;
    }

    private State getLessConnectedNeighbourState(State state) {
        ArrayList<State> allNeighbourStates = state.getNeighbourStates();
        ArrayList<State> lessConnectedNeighbourStates = new ArrayList<>();

        for (State neighbourState : allNeighbourStates) {

        }
        return null;
    }

    private Integer getStateRoadDepth(State state) {
        Integer depth = 0;
        for (State neighbourState : state.getNeighbourStates()) {

        }
        return null;
    }

}
