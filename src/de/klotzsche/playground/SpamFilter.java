package de.klotzsche.playground;

import java.util.ArrayList;

/**
 * Created by Felix Klotzsche on 17.06.2014.
 */
public class SpamFilter {

    public static void main(String[] args){
        final String mail = "Kaufen Sie jetzt...Viagra";

        System.out.println(isSpam(mail));
    }

    private static boolean isSpam(String mail){
        final ArrayList<String> spamWords = new ArrayList<>();
        spamWords.add("viagra");
        spamWords.add("kaufe");

        return spamWords.stream()
                .filter(mail.toLowerCase()::contains)
                .count() != 0;
    }
}
