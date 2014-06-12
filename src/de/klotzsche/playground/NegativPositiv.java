package de.klotzsche.playground;

import java.util.Scanner;

/**
 * Created by Felix Klotzsche on 12.06.2014.
 */
public class NegativPositiv {

    public static void main(String[] args){
        System.out.print("Gib deine Zahl ein und Ich unterscheide, ob positiv oder negativ: ");
        int eingabe = new Scanner(System.in).nextInt();
        if(eingabe < 0)
            System.out.println("Computer sagt...negativ");
        else
            System.out.println("Computer sagt...positiv");
    }

}
