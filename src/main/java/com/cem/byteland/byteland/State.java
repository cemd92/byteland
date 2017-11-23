package com.cem.byteland.byteland;

import java.util.ArrayList;

public class State implements Comparable<State> {

    private int stateId;//states unique id
    private String stateName;//states name
    private ArrayList<State> neighbourStates;// Neighbour state list


    /**
     * Creates the state object
     *
     * @param stateId
     */
    public State(int stateId) {
        this.stateId = stateId;
        this.stateName = String.valueOf(stateId);
        this.neighbourStates = new ArrayList<>();
    }

    /**
     * Returns the state id
     *
     * @return State Id
     */
    public int getStateId() {
        return stateId;
    }

    /**
     * Changes the state name after unification
     *
     * @param stateName
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * Returns the state name
     *
     * @return State Name
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * Returns the neighbour state list
     *
     * @return
     */
    public ArrayList<State> getNeighbourStates() {
        return neighbourStates;
    }

    /**
     * Adds the new neighbour state to the list
     *
     * @param state
     */
    public void addNewNeighbourState(State state) {
        this.neighbourStates.add(state);
    }

    /**
     * Adds the new neighbour states to the list
     *
     * @param states
     */
    public void addNewNeighbourStates(ArrayList<State> states) {
        this.neighbourStates.addAll(states);
    }

    /**
     * Removes the state form neighbour state list
     * Used after unification
     *
     * @param state
     */
    public void removeNeighbourState(State state) {
        this.neighbourStates.remove(state);
    }

    /**
     * Returns the name of the state
     *
     * @return State Name
     */
    public String toString() {
        return getStateName();
    }

    /**
     * Compares states via their neighbour count
     *
     * @param state
     * @return State which has less neighbour to other
     */
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
