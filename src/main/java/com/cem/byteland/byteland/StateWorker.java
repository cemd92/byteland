package com.cem.byteland.byteland;

import com.cem.byteland.reader.ByteLandCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class StateWorker {

    private StateGraph stateGraph;//state map
    private Integer negotiationCount = 0;//total negotiation round

    /**
     * Initialize the states locations
     *
     * @param byteLandCase
     */
    public void createStateMap(ByteLandCase byteLandCase) {
        this.stateGraph = new StateGraph();
        for (Integer distance : byteLandCase.getDistanceList()) {
            stateGraph.addNewState(distance);
        }
        uniteStates();
    }

    /**
     * Unites states
     */
    public void uniteStates() {
        while (!isUnited()) {
            ArrayList<State> sortedStateList = getStatesSortedByNeighbourCount();
            Iterator<State> iterator = sortedStateList.iterator();

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

    /**
     * Returns the sorted list of states
     * least neighbour to most
     *
     * @return Sorted list of states
     */
    private ArrayList<State> getStatesSortedByNeighbourCount() {
        ArrayList<State> sortedStateList = new ArrayList<>(stateGraph.getStateList());
        Collections.sort(sortedStateList);
        return sortedStateList;

    }

    /**
     * Checks all states are united
     *
     * @return If there is only one state returns true
     */
    private Boolean isUnited() {
        if (stateGraph.getStateCount() > 1) {
            return false;
        }
        return true;
    }

    /**
     * Searches for the unnegotiated state to negotiate
     *
     * @param sortedStateList
     * @param state
     * @return Unnegotiated state
     * @throws Exception
     */
    private State getUnmergedNeighbourCity(ArrayList<State> sortedStateList, State state) throws Exception {
        for (State neighbourState : state.getNeighbourStates()) {
            if (sortedStateList.contains(neighbourState)) {
                return neighbourState;
            }
        }
        throw new Exception("Handle alone state!");
    }
}
