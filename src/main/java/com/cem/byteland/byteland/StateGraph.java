package com.cem.byteland.byteland;

import java.util.ArrayList;

public class StateGraph {

    private int stateCount = 0;//State count in the land

    private State stateZero;// First state
    private ArrayList<State> stateList;// List of the all states

    /**
     * Creates the first state and adds to the state list
     */
    public StateGraph() {
        this.stateZero = new State(stateCount++);
        this.stateList = new ArrayList<>();
        this.stateList.add(this.stateZero);
    }

    /**
     * Creates new state and palaces the state in wanted distance from
     * the stateZero
     *
     * @param distance
     */
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


    /**
     * Returns the wanted N th distanced neighbour states from wanted state
     *
     * @param rootState
     * @param distance
     * @param previousState
     * @return N th distanced neighbour state list
     */
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


    /**
     * Returns the state which has least number of neighbour
     * from the given list
     *
     * @param stateList
     * @return Least neighboured state
     */
    private State getStateWithLeastNeighbour(ArrayList<State> stateList) {
        State currentState = stateList.get(0);
        for (State possibleState : stateList) {
            if (currentState.getNeighbourStates().size() > possibleState.getNeighbourStates().size()) {
                currentState = possibleState;
            }
        }
        return currentState;
    }

    /**
     * Connects two states together
     *
     * @param state1
     * @param state2
     */
    private void createRoadBetweenStates(State state1, State state2) {
        state1.addNewNeighbourState(state2);
        state2.addNewNeighbourState(state1);
    }

    /**
     * Returns the total count of the states
     *
     * @return Total number of states
     */
    public Integer getStateCount() {
        return this.stateList.size();
    }

    /**
     * Returns all state list
     *
     * @return All state list
     */
    public ArrayList<State> getStateList() {
        return stateList;
    }

    /**
     * Merges two states together
     * State with smaller id survives
     * The names are merged
     * Neighbour states and state list updates
     *
     * @param state1
     * @param state2
     */
    public void mergeStates(State state1, State state2) {
        //System.out.println(String.format("State %s and State %s merged", state1.getStateName(), state2.getStateName()));
        state1.removeNeighbourState(state2);
        state2.removeNeighbourState(state1);
        if (state1.getStateId() > state2.getStateId()) {//Preserve the smallest state id
            State dummyState = state1;
            state1 = state2;
            state2 = dummyState;
        }
        state1.addNewNeighbourStates(state2.getNeighbourStates());
        state1.setStateName(state1.getStateName() + " - " + state2.getStateName());
        this.stateList.remove(state2);
    }
}
