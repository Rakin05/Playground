package de.klotzsche.playground.TuringMachine;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class Machine {

    private ReadWriteHead rwh;
    private WorkingTape wt;

    private char[] sourceCode;

    public Machine(char[] sourceCode) {
        this.wt = new WorkingTape();
        this.rwh = new ReadWriteHead(wt, sourceCode.length - 1);

        this.sourceCode = sourceCode;
    }

    public void run() {
        for(char c : sourceCode)
            rwh.getSymbolTable().get(c).runCommand();
    }
}
