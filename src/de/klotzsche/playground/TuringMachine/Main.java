package de.klotzsche.playground.TuringMachine;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class Main {

    public static void main(String[] args){
        char[] sourceCode = {'#', '+', '#', '+', '#'};
        Machine m = new Machine(sourceCode);

        m.run();
    }
}
