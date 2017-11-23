package com.cem.byteland.byteland;

import java.util.ArrayList;

public class StateGraph {

    private int stateCount = 0;

    private State stateZero;
    private ArrayList<State> stateList;

    public StateGraph() {
        this.stateZero = new State(stateCount++);
        this.stateList = new ArrayList<>();
        this.stateList.add(this.stateZero);
    }

    public void addNewState(Integer distance) {
        State newState = new State(stateCount++);
        ArrayList<State> possibleNeighbourStates = getNthNeighbourStates(this.stateZero, distance, null);
        State neighbourState;
        if (possibleNeighbourStates.size() > 1) {
            neighbourState = getStateWithLeastNeighbour(possibleNeighbourStates);
        } else {
            neighbourState = possibleNeighbourStates.get(0);
        }
        createRoadBetweenStates(neighbourState, newState);
        this.stateList.add(newState);
    }


    private ArrayList<State> getNthNeighbourStates(State rootState, Integer distance, State previousState) {
        ArrayList<State> nthNeighbourStateList = new ArrayList<>();
        if (distance.equals(0)) {//add as its neighbour
            nthNeighbourStateList.add(rootState);
        } else {
            for (State neighbourState : rootState.getNeighbourStates()) {
                if (!neighbourState.equals(previousState) && !neighbourState.getNeighbourStates().isEmpty()) {
                    Integer newDistance = distance - 1;
                    nthNeighbourStateList.addAll(getNthNeighbourStates(neighbourState, newDistance, rootState));
                }
            }

        }
        return nthNeighbourStateList;
    }


    private State getStateWithLeastNeighbour(ArrayList<State> stateList) {
        State currentState = stateList.get(0);
        for (State possibleState : stateList) {
            if (currentState.getNeighbourStates().size() > possibleState.getNeighbourStates().size()) {
                currentState = possibleState;
            }
        }
        return currentState;
    }

    private void createRoadBetweenStates(State state1, State state2) {
        state1.addNewNeighbourState(state2);
        state2.addNewNeighbourState(state1);
    }

    public Integer getStateCount() {
        return this.stateList.size();
    }

    public ArrayList<State> getStateList() {
        return stateList;
    }

    public void mergeStates(State state1, State state2) {
        //System.out.println(String.format("State %s and State %s merged", state1.getStateName(), state2.getStateName()));
        state1.removeNeighbourState(state2);
        state2.removeNeighbourState(state1);
        if (state1.getStateId() > state2.getStateId()) {
            State dummyState = state1;
            state1 = state2;
            state2 = dummyState;
        }
        state1.addNewNeighbourStates(state2.getNeighbourStates());
        state1.setStateName(state1.getStateName() + " - " + state2.getStateName());
        this.stateList.remove(state2);

    }
}
