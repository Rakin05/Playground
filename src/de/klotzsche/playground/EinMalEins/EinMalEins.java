package de.klotzsche.playground.EinMalEins;

import static java.util.stream.LongStream.rangeClosed;

/**
 * Created by Felix Klotzsche on 19.06.2014.
 */
public class EinMalEins {
    public static void main(String[] args){
        rangeClosed(1, 100).forEach( i ->
        rangeClosed(1, 100).forEach( j ->
                System.out.printf("|\t%2d x %2d\t|\t%2d\t|\n", i, j, i * j)
        ));
    }
}
