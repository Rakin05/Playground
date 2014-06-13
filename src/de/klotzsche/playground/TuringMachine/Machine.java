package de.klotzsche.playground.TuringMachine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class Machine {

    private ReadWriteHead rwh;
    private WorkingTape wt;

    private char[] sourceCode;

    public Machine(char[] sourceCode){
        this.wt = new WorkingTape();
        this.rwh = new ReadWriteHead(wt);

        this.sourceCode = sourceCode;
    }

    public void start(){
        for(char c : sourceCode)
            doStep(c);
    }

    void doStep(char c) {
        switch(c) {
            case '>':
                rwh.nextPosition();
                break;
            case '<':
                rwh.previousPosition();
                break;
            case '+':
                rwh.incrementValue();
                break;
            case '-':
                rwh.decrmentValue();
                break;
            case '#':
                System.out.println(rwh.readValue());
                break;
        }
    }
}
