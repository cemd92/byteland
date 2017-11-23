package com.cem.byteland;

import com.cem.byteland.byteland.StateWorker;
import com.cem.byteland.reader.ByteLandCase;
import com.cem.byteland.reader.CaseCreator;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<ByteLandCase> byteLandCaseList = CaseCreator.getCasesFromFile("input.txt");

        for (ByteLandCase byteLandCase : byteLandCaseList) {
            StateWorker stateWorker = new StateWorker();
            stateWorker.createStateMap(byteLandCase);
        }
    }
}
