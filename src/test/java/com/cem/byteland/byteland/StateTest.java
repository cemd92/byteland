package com.cem.byteland.byteland;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StateTest {

    private State state0;
    private State state1;
    private State state2;

    @Before
    public void setUp() {
        state0 = new State(0);
        state1 = new State(1);
        state2 = new State(2);
        state0.addNewNeighbourState(state1);
    }

    @Test
    public void getStateId() throws Exception {
        assertTrue(state0.getStateId().equals(0));
    }

    @Test
    public void setStateName() throws Exception {
        state0.setStateName("00");
        assertEquals(state0.getStateName(), "00");
    }

    @Test
    public void getStateName() throws Exception {
        assertEquals(state0.getStateName(), "0");
    }

    @Test
    public void getNeighbourStates() throws Exception {
        ArrayList<State> neighbourStateList = state0.getNeighbourStates();
        assertTrue(neighbourStateList.contains(state1));
    }

    @Test
    public void addNewNeighbourState() throws Exception {
        ArrayList<State> neighbourStateList = state1.getNeighbourStates();
        assertTrue(neighbourStateList.isEmpty());
        state1.addNewNeighbourState(state2);
        assertTrue(neighbourStateList.contains(state2));
    }

    @Test
    public void addNewNeighbourStates() throws Exception {
        State state3 = new State(3);
        State state4 = new State(4);
        ArrayList<State> stateList = new ArrayList<>();
        stateList.add(state3);
        stateList.add(state4);
        state0.addNewNeighbourStates(stateList);
        assertTrue(state0.getNeighbourStates().contains(state3));
        assertTrue(state0.getNeighbourStates().contains(state4));
    }

    @Test
    public void removeNeighbourState() throws Exception {
        assertTrue(state0.getNeighbourStates().contains(state1));
        state0.removeNeighbourState(state1);
        assertFalse(state0.getNeighbourStates().contains(state1));
    }

}