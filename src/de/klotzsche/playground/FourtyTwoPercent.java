package de.klotzsche.playground;

import java.util.Random;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class FourtyTwoPercent {

    public static void main(String[] args){
        int number = new Random().nextInt(100);

        if(number > 42)
            System.out.println("Du hast gewonnen...");
        else
            System.out.println("Ich habe gewonnen...");
    }

}
