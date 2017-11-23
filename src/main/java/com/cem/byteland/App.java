package com.cem.byteland;

import com.cem.byteland.byteland.StateFacade;
import com.cem.byteland.reader.ByteLandCase;
import com.cem.byteland.reader.CaseCreator;
import com.cem.byteland.reader.TextReader;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");


        StateFacade stateFacade = new StateFacade();
        ArrayList<ByteLandCase> byteLandCaseList = CaseCreator.getCasesFromFile("input.txt");

        for (ByteLandCase byteLandCase : byteLandCaseList) {
            stateFacade.createStateMap(byteLandCase);
        }


    }
}
