package de.klotzsche.playground.TuringMachine;

import java.util.HashMap;
import java.util.function.Function;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class ReadWriteHead {

    private HashMap<Character, Command> symbolTable = new HashMap<>();

    private int position = 0;
    private int MAX_POSITION = 10;

    private WorkingTape tape;

    public ReadWriteHead(WorkingTape tape, int MAX_POSITION){
        this.tape = tape;
        this.MAX_POSITION = MAX_POSITION;

        this.setupSymbolTable();
    }
    private void setupSymbolTable(){
        this.symbolTable.put('>', () -> {
            // does nothing currently
        });
        this.symbolTable.put('<', () -> {
            // does nothing currently
        });
        this.symbolTable.put('+', () -> tape.incrementValue());
        this.symbolTable.put('-', () -> tape.decrementValue());
        this.symbolTable.put('#', () -> System.out.println(tape.getCurrentValue()));
    }

    public HashMap<Character, Command> getSymbolTable(){
        return this.symbolTable;
    }
}
