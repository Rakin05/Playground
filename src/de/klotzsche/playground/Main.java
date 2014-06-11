package de.klotzsche.playground;

import java.util.Scanner;

/**
 * Created by Master on 11.06.2014.
 */
public class Main {

    public static void main(String[] args){
        System.out.print("Betrag zum wechseln eingeben: ");
        double geldWert = new Scanner(System.in).nextDouble();
        System.out.printf(Geldbetrag.printGeldBeträge(Geldbetrag.wechselGeld(geldWert)));
    }

}
