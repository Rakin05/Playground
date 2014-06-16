package de.klotzsche.playground;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

/**
 * Created by Felix Klotzsche on 16.06.2014.
 */
public class XOL {

    public static void main(String[] args) {
        rangeClosed(0, 9)
                .parallel()
                .forEach(x -> rangeClosed(0, 9)
                        .filter(o -> x != o)
                        .filter(o -> x * 2 + o <= 9)
                        .forEach(o -> XOL.printEquation(x, o)));
    }

    public static void printEquation(int x, int o) {
        final int l = x + o;
        final int t = x + l;
        System.out.printf("%d%d%d + %d%d%d = %d%d%d\n", x, o, l, l, x, x, t, l, t);
    }

}
