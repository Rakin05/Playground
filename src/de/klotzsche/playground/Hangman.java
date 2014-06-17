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

    public static void main(String[] args) throws Exception{
        word = generateRandomString();
        output = word.replaceAll("[A-Za-z]", "_");

        runHangMan();

        System.out.println(word);
        System.out.println("Haste gewonnen...Guter Junge");
    }

    private static void runHangMan(){
        while(tries < 10 && foundSoFar < word.length()){
            System.out.print("Welchen Buchstaben willst du probieren?: ");
            if(checkIfInputMatches()){
                System.out.println(output);
                continue;
            }
            tries += 1;
            System.out.println(output);
            System.out.println("Du hast" + (10 - tries) + " übrig");
        }
    }

    private static boolean checkIfInputMatches(){
        String input = sc.nextLine();
        char guessed = input.charAt(0);
        char compare = input.toLowerCase().charAt(0);

        if(word.toLowerCase().indexOf(compare) != -1){
            System.out.println(guessed + " kommt im Wort vor.");
            char[] wortArr = word.toLowerCase().toCharArray();
            range(0, wortArr.length)
                    .forEach(i -> {
                        if (wortArr[i] == compare)
                            output = changeOutPut(i, compare);
                    });
        };
        return false;
    }

    private static String changeOutPut(int i, char compare){
        foundSoFar += 1;
        char[] temp = output.toCharArray();
        temp[i] = compare;
        return String.valueOf(temp);
    }

    private static String generateRandomString() throws Exception{
        Path p = FileSystems.getDefault().getPath("resource/wortlisten");
        List<String> lines = Files.lines(p).collect(toList());
        final int random = new Random().nextInt(lines.size() - 1);
        return lines.get(random);
    }
}
