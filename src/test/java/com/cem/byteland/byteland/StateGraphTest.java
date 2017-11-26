package com.cem.byteland.byteland;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StateGraphTest {

    private StateGraph stateGraph;

    @Before
    public void setUp() throws Exception {
        stateGraph = new StateGraph();
        stateGraph.addNewState(0);
    }

    @Test
    public void addNewState() throws Exception {
        assertTrue(stateGraph.getStateCount().equals(2));
        stateGraph.addNewState(1);
        assertTrue(stateGraph.getStateCount().equals(3));
    }

    @Test
    public void getStateCount() throws Exception {
        assertTrue(stateGraph.getStateCount().equals(2));
    }

    @Test
    public void getStateList() throws Exception {
        stateGraph.addNewState(1);
        Integer idCounter = 0;
        for (State state : stateGraph.getStateList()) {
            assertTrue(idCounter.equals(state.getStateId()));
            idCounter++;
        }
    }

    @Test
    public void mergeStates() throws Exception {
        stateGraph.addNewState(1);
        State state0 = stateGraph.getStateList().get(0);
        State state1 = stateGraph.getStateList().get(1);
        State state2 = stateGraph.getStateList().get(2);
        assertEquals(state0.getStateName(), "0");
        stateGraph.mergeStates(state0, state1);
        assertTrue(stateGraph.getStateCount().equals(2));
        state0 = stateGraph.getStateList().get(0);
        assertEquals(state0.getStateName(), "0 - 1");
        assertTrue(state0.getNeighbourStates().contains(state2));
    }

}