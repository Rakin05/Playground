package de.klotzsche.playground;

/**
 * Created by Master on 11.06.2014.
 */
public class Geldbetrag {

    // Münzwerte in Cent als Array
    static int[] münzWerte = {200, 100, 50, 20, 10, 5, 2, 1};

    public static int[] wechselGeld(double geldWert){
        // für jede Münze, die Anzahl in einem Array festhalten
        int[] anzahlMünzen = {0,0,0,0,0,0,0,0};

        // den Geldwert in Cent umrechnen
        int wechselWert = new Float(geldWert * 100).intValue();

        // Rekursion anstatt einer Schleife nutzen
        return wechselGeld(wechselWert, anzahlMünzen, münzWerte, 0);
    }

    public static String printGeldBeträge(int[] münzen){
        return printGeldBeträge(münzen, "", 0);
    }

    private static String printGeldBeträge(int[] münzen, String toPrint, int acc){
        if(acc == münzen.length) return toPrint;
        else if(münzen[acc] == 0) return printGeldBeträge(münzen, toPrint, acc + 1);
        else if(münzWerte[acc] >= 100) toPrint = String.format("%s %d %.2f € Stücke\n", toPrint, münzen[acc], (double)münzWerte[acc]/100);
        else toPrint = String.format("%s %d %.2f Cent Stück\n", toPrint, münzen[acc], (double)münzWerte[acc]/100);
        return printGeldBeträge(münzen, toPrint, acc + 1);
    }

    private static int[] wechselGeld(int geldWert, int[] anzahlMünzen, int[] münzWerte, int acc){
        if(geldWert == 0.00 || acc == münzWerte.length ) return anzahlMünzen;
        else if(münzWerte[acc] > geldWert) return wechselGeld(geldWert, anzahlMünzen, münzWerte,acc + 1);
        else anzahlMünzen[acc]++;
        return wechselGeld(geldWert - münzWerte[acc], anzahlMünzen, münzWerte, acc);
    }
}
