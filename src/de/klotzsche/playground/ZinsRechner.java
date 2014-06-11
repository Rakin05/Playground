package de.klotzsche.playground;

/**
 * Created by Master on 11.06.2014.
 */
public class ZinsRechner {
    public static double berechneZins(double kapital, double zinsSatz, int anlageDauer) {
        return kapital * zinsSatz * anlageDauer/(12*100);
    }
}
