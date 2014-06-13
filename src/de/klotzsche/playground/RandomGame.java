package de.klotzsche.playground;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class RandomGame {

    public static void declareWinner(int p1, int p2, int random){
        int p1Diff = Math.abs(random - p1);
        int p2Diff = Math.abs(random - p2);

        if(p1Diff == p2Diff)
            System.out.println("Unentschieden");
        else if(p1Diff < p2Diff)
            System.out.println("Spieler 1 hat gewonnen.");
        else
            System.out.println("Spieler 2 hat gewonnen.");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Zahl Spieler 1: ");
        int player1 = sc.nextInt();

        System.out.print("Zahl Spieler 2: ");
        int player2 = sc.nextInt();


        int random = new Random().nextInt(100);
        declareWinner(player1, player2, random);
    }

}
