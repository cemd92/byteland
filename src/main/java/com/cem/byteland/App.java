package com.cem.byteland;

import com.cem.byteland.byteland.StateFacade;
import com.cem.byteland.reader.CaseCreator;
import com.cem.byteland.reader.TextReader;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");


        StateFacade stateFacade = new StateFacade();
        stateFacade.createStateMap(CaseCreator.getCasesFromFile("input.txt"));


    }
}
