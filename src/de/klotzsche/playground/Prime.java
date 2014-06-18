package de.klotzsche.playground;

import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

/**
 * Created by Felix Klotzsche on 18.06.2014.
 */
public class Prime {
    public static void main(String[] args) {
        final long now = System.currentTimeMillis();
        System.out.println("Anzahl Primzahl bis 10: " + howManyPrimeNumbersUpTo(10));
        System.out.println("Anzahl Primzahl bis 100: " + howManyPrimeNumbersUpTo(100));
        System.out.println("Anzahl Primzahl bis 1.000: " + howManyPrimeNumbersUpTo(1000));
        System.out.println("Anzahl Primzahl bis 10.000: " + howManyPrimeNumbersUpTo(10000));
        System.out.println("Anzahl Primzahl bis 100.000: " + howManyPrimeNumbersUpTo(100000));
        //System.out.println("Anzahl Primzahl bis 1.000.000: " + howManyPrimeNumbersUpTo(1000000));

        final long now2 = System.currentTimeMillis();
        final double elapsed = (double) (now2 - now) / 1000;
        System.out.println("Es dauerte " + elapsed + " Sekunden");
    }

    private static long howManyPrimeNumbersUpTo(int number){
        return range(2, number)
                .parallel()
                .filter(Prime::isPrime)
                .count() - 1;
    }

    public static boolean isPrime(final int number) {
        return range(2, number / 2)
                .filter(i -> (number % i) == 0)
                .count() == 0;
    }
}
