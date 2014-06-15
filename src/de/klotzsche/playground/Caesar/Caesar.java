package de.klotzsche.playground.Caesar;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by Felix on 14.06.2014.
 */
public class Caesar {

    public static String removeAllNonAlphabetics(String s){
        return s.replaceAll("[^A-Za-z0-9üöäß ]","");
    }

    public static String cipherByPassword(String s, int amount){
        return s.chars()
                .map( c -> c + amount)                // the character by amount
                .mapToObj( c -> Character.toChars(c)) // Construct a new Character containing the shifted value
                .map( c -> String.valueOf(c))         // Convert back to String
                .collect(joining());                  // Return a String instead of ReferencePipeline
    }

    private static Stream<String> readLinesFromFile(String filename) throws Exception{
        Path p = FileSystems.getDefault().getPath(filename);
        return Files.lines(p);
    }


    public static void main(String[] args) throws Exception{

        System.out.print("Gib das Paswort ein: ");
        int password = new Scanner(System.in).nextInt();

        readLinesFromFile("resource/quote.txt")
             .map(String::toLowerCase)
             .map(Caesar::removeAllNonAlphabetics)
             .map(s -> Caesar.cipherByPassword(s, password))
             .forEach(System.out::println);
    }

}
