package de.klotzsche.playground.DDDText;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Felix Klotzsche on 16.06.2014.
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("Gib deinen Text ein: ");

        new Scanner(System.in).nextLine() // Grab text from command line
                .toLowerCase() // lowercase it
                .chars() // turn it into a char[]
                .mapToObj(i -> Letters.letters[i - 97]) // subtract from each char 97 so 'a' becomes 0 and grab the according 3D Letter
                .flatMap(c -> Arrays.stream(c)) // Turn all nested arrays into one big datastructure
                .forEach(System.out::println); // print each line
    }
}