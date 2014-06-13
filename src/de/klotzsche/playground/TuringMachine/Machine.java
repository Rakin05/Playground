package de.klotzsche.playground.TuringMachine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class Machine {

    private int head = 0;

    private char[] sourceCode;
    private char[] band = {'a','a','a','a','a','a','a','a','a','a'};

    private Map<Character, Command> symbolTable;

    public Machine(char[] sourceCode) {
        this.sourceCode = sourceCode;

        this.symbolTable = new HashMap<>();

        this.setupSymbolTable();
    }

    private void setupSymbolTable(){
        this.symbolTable.put('>', () -> { // move the head one position one place forward
            if (head == band.length) head = 0; else head += 1;
        });
        this.symbolTable.put('<', () -> { // move the head one position one place backward
            if (head < 0) head = band.length - 1; else head -= 1;
        });
        this.symbolTable.put('+', () -> band[head] += 1 );
        this.symbolTable.put('-', () -> band[head] -= 1 );
        this.symbolTable.put('#', () -> System.out.println(band[head]));
    }

    public void run() {
        for(char c : sourceCode)
            symbolTable.get(c).runCommand();
    }
}
