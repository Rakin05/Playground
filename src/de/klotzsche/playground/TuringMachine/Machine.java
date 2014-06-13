package de.klotzsche.playground.TuringMachine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class Machine {

    private int currentValue = 0;
    private char[] sourceCode;
    private Map<Character, Command> symbolTable;

    public Machine(char[] sourceCode) {
        this.sourceCode = sourceCode;

        this.symbolTable = new HashMap<>();

        this.setupSymbolTable();
    }

    private void setupSymbolTable(){
        this.symbolTable.put('>', () -> {/*does nothing currently*/});
        this.symbolTable.put('<', () -> {/*does nothing currently*/ });
        this.symbolTable.put('+', () -> currentValue += 1);
        this.symbolTable.put('-', () -> currentValue -= 1);
        this.symbolTable.put('#', () -> System.out.println((char) ('a' + currentValue)));
    }

    public void run() {
        for(char c : sourceCode)
            symbolTable.get(c).runCommand();
    }
}
