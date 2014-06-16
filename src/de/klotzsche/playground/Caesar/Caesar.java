package de.klotzsche.playground.Caesar;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by Felix on 14.06.2014.
 */
public class Caesar {


    private static Stream<String> readLinesFromFile(String filename) throws Exception{
        Path p = FileSystems.getDefault().getPath(filename);
        return Files.lines(p);
    }

    public static String cipherByPassword(String s, int amount){
        return s.chars()
                .filter(c -> Character.isAlphabetic(c) || Character.isWhitespace(c)) // filter all values, that are not Characters or Whitespace
                .map(c -> c + amount)                // shift the character by amount -> e.g. a + 10 = k
                .mapToObj(Character::toChars)         // Construct a new Character containing the shifted value
                .map(String::valueOf)                 // Convert back to String
                .collect(joining());                  // Return a String instead of ReferencePipeline
    }

    public static void WriteCryptedToFile(String filename, String contents) throws Exception{
        Files.write(FileSystems.getDefault().getPath(filename), contents.getBytes());
    }

    public static void main(String[] args) throws Exception{
        // Just grab the Password to cipher
        System.out.print("Gib das Paswort ein: ");
        int password = new Scanner(System.in).nextInt();

        // get The Stuff going...should be obvious, what it's doing
        final String cipheredContents = readLinesFromFile("resource/quote.txt")
                                            .map(String::toLowerCase)
                                            .map(s -> Caesar.cipherByPassword(s, password))
                                            .collect(joining());

        Caesar.WriteCryptedToFile("resource/ciphered_quote.txt", cipheredContents);
    }

}
