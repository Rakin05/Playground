package de.klotzsche.playground;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/**
 * Created by Felix Klotzsche on 17.06.2014.
 */
public class Hangman {
    private static String word = null;
    private static int tries = 0;
    private static int foundSoFar = 0;
    private static String output = null;

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        word = generateRandomString();
        output = word.replaceAll("[A-Za-z]", "_");

        runHangMan();
    }

    private static void runHangMan() {
        System.out.println(word);
        while (tries < 10 && foundSoFar < word.length()) {
            System.out.print("Welchen Buchstaben willst du probieren?: ");
            if (checkIfInputMatches()) {
                // wenn der eingegeben Buchstabe im Wort vorkommt
                // mach einfach weiter mit der Schleife
                System.out.println(output);
                continue;
            }
            tries += 1;
            System.out.println(output);
            System.out.println("Du hast " + (10 - tries) + " Versuche übrig");
        }

        if(tries == 10)
            System.out.println("Haste verloren, wa?" + word + " war es.");
    }

    private static boolean checkIfInputMatches() {
        String input = sc.nextLine();
        char compare = input.toLowerCase().charAt(0);

        boolean found = false;

        // Prüfe, ob der eingegeben Buchstabe im Wort vorkommt
        // wenn ja, ändere die Ausgabe, sodass der gefundene Buchstabe
        // angezeigt wird
        // setze foundSoFar jeweils um 1 hoch...Wenn ein buchstabe mehrmals
        // vorkommt, dann wird foundSoFar um die jeweilige Anzahl erhöht
        char[] wordArr = word.toLowerCase().toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i] == compare) {
                foundSoFar += 1;
                output = changeOutPut(i, compare);
                found = true;
            }
        }
        return found;
    }

    private static String changeOutPut(int i, char compare) {
        char[] temp = output.toCharArray();
        temp[i] = compare;
        return String.valueOf(temp);
    }

    private static String generateRandomString() throws Exception {
        Path p = FileSystems.getDefault().getPath("resource/wortlisten");
        List<String> lines = Files.lines(p).collect(toList());
        final int random = new Random().nextInt(lines.size() - 1);
        return lines.get(random);
    }
}
