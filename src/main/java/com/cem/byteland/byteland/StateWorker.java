package com.cem.byteland.byteland;

import com.cem.byteland.reader.ByteLandCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class StateWorker {

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
            Iterator<State> iterator = sortedStateList.iterator();

            Integer i = 0;
            while (iterator.hasNext() && sortedStateList.size() > 1) {
                State state1 = iterator.next();
                State state2;
                try {
                    state2 = getUnmergedNeighbourCity(sortedStateList, state1);
                } catch (Exception e) {
                    continue;
                }
                stateGraph.mergeStates(state1, state2);
                sortedStateList.remove(state1);
                sortedStateList.remove(state2);
                iterator = sortedStateList.iterator();
            }
            this.negotiationCount++;
        }
        System.out.println(this.negotiationCount);
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

    private State getUnmergedNeighbourCity(ArrayList<State> sortedStateList, State state) throws Exception {
        for (State neighbourState : state.getNeighbourStates()) {
            if (sortedStateList.contains(neighbourState)) {
                return neighbourState;
            }
        }
        throw new Exception("Handle alone state!");
    }
}
