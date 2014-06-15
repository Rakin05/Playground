package de.klotzsche.playground.Caesar;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Felix on 14.06.2014.
 */
public class Caesar {



    public static void main(String[] args) throws Exception{
        Path p = FileSystems.getDefault().getPath("resource/quote.txt");

        Files.lines(p)
             .map(String::toLowerCase)
             .forEach(System.out::println);
    }

}
