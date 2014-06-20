package de.klotzsche.playground.categorytheory;

/**
 * Created by Felix Klotzsche on 20.06.2014.
 */
public class Contract {

    public static String str(Object t) throws Exception{
        if(t instanceof String)
            return (String)t;
        else
            throw new ClassCastException("Wrong Type. Need String but was " + t.getClass());
    }
}
