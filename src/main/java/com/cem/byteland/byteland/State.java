package com.cem.byteland.byteland;

import java.util.ArrayList;

public class State {

    private int stateId;
    private ArrayList<State> neighbourStates;


    public State(int stateId) {
        this.stateId = stateId;
        this.neighbourStates = new ArrayList<>();
    }

    public ArrayList<State> getNeighbourStates() {
        return neighbourStates;
    }

    public void addNewNeighbourState(State state) {
        this.neighbourStates.add(state);
    }

    public String toString() {
        return String.valueOf(this.stateId);
    }
}
