package de.klotzsche.playground.TuringMachine;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class ReadWriteHead {

    private int position = 0;
    private int MAX_POSITION = 10;

    private WorkingTape tape;

    public ReadWriteHead(WorkingTape tape){
        this.tape = tape;
    }

    public int getPosition(){
        return  position;
    }

    public void nextPosition(){
        position = position + 1;
        if(position > MAX_POSITION)
            position = 0;
    }

    public void previousPosition(){
        position = position - 1;
        if(position < 0)
            position = MAX_POSITION;
    }

    public void incrementValue(){
        tape.incrementValue();
    }


    public void decrmentValue(){
        tape.decrementValue();
    }

    public char readValue(){
        return tape.getCurrentValue();
    }

}
