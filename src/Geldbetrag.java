import java.util.Scanner;

/**
 * Created by Master on 11.06.2014.
 */
public class Geldbetrag {

    static int[] münzWerte = {200, 100, 50, 20, 10, 5, 2, 1};

    static int[] wechselGeld(double geldWert){
        // für jede Münze, die Anzahl in einem Array festhalten
        int[] anzahlMünzen = {0,0,0,0,0,0,0,0};

        // den Geldwert in Cent umrechnen
        int wechselWert = new Float(geldWert * 100).intValue();

        int i = 0; // Zähler
        while(i < münzWerte.length && wechselWert >= 0){
            if(münzWerte[i] > wechselWert) i++;
            else{ wechselWert -= münzWerte[i]; anzahlMünzen[i]+= 1; }
        }

        return anzahlMünzen;
    }

    static void printWechselGeld(double geldWert){
        System.out.println(geldWert + " wird gewechselt");
        int[] wechselMünzen = wechselGeld(geldWert);
        for(int i = 0; i < wechselMünzen.length; i++){
            if(wechselMünzen[i] != 0) {// Nur Münzen ausgeben, die zum wechseln des Betrags benötigt werden
                if(münzWerte[i] >= 100)
                    System.out.printf("%d %.2f € Stück\n", wechselMünzen[i], (double) münzWerte[i] / 100);
                else
                    System.out.printf("%d %.2f Cent Stück\n", wechselMünzen[i], (double) münzWerte[i] / 100);
            }
        }
    }


    public static void main(String[] args){
        System.out.print("Betrag zum wechseln eingeben: ");
        double geldWert = new Scanner(System.in).nextDouble();
        printWechselGeld(geldWert);
    }

}
