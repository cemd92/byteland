package com.cem.byteland.byteland;

import java.util.ArrayList;

public class State implements Comparable<State> {

    private int stateId;
    private String stateName;
    private ArrayList<State> neighbourStates;


    public State(int stateId) {
        this.stateId = stateId;
        this.stateName = String.valueOf(stateId);
        this.neighbourStates = new ArrayList<>();
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public ArrayList<State> getNeighbourStates() {
        return neighbourStates;
    }

    public void addNewNeighbourState(State state) {
        this.neighbourStates.add(state);
    }

    public void addNewNeighbourStates(ArrayList<State> states) {
        this.neighbourStates.addAll(states);
    }

    public void removeNeighbourState(State state) {
        this.neighbourStates.remove(state);
    }

    public String toString() {
        return getStateName();
    }

    @Override
    public int compareTo(State state) {
        if (this.getNeighbourStates().size() > state.getNeighbourStates().size()) {
            return 1;
        } else if (this.getNeighbourStates().size() < state.getNeighbourStates().size()) {
            return -1;
        }
        return 0;
    }
}
