package de.klotzsche.playground.TuringMachine;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class WorkingTape {

    private int currentValue = 0;

    public void incrementValue(){
        currentValue = currentValue + 1;
    }

    public void decrementValue(){
        currentValue = currentValue - 1;
    }

    public char getCurrentValue(){
        return (char) ('a' + currentValue);
    }

}
