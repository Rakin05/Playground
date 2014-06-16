package de.klotzsche.playground.DDDText;

import java.util.Scanner;

import static java.util.stream.IntStream.range;

/**
 * Created by Felix Klotzsche on 16.06.2014.
 */
public class Main {

    public static void main(String[] args){
        System.out.println("Gib deinen Text ein: ");
        String text = new Scanner(System.in).nextLine();

        text.toLowerCase().chars().forEach(Main::printDDDCharacter);
    }

    public static void printDDDCharacter(int c){
        int dddCharacter = c - 97;
        final String[] character = Letters.letters[dddCharacter];
        range(0, character.length).forEach( i -> System.out.println(character[i]));
    }
}
