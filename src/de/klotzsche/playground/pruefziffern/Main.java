package de.klotzsche.playground.pruefziffern;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.LongStream.rangeClosed;

/**
 * Created by Felix Klotzsche on 19.06.2014.
 */
public class Main {
    public static void main(String[] args)throws Exception{
        String pruefziffer = "Z60162200226";
        Pruefziffern p = new Pruefziffern(pruefziffer);
        if(p.isValidSerialNumber())
            System.out.println(pruefziffer + " ist eine valide Prüfziffer.");
        else
            System.out.println(pruefziffer + " ist keine valide Prüfziffer.");
    }

    public static void checkSerialNumbers(){
        for(char i = 'C'; i <= 'Z'; i++){
            for(long j = 10_000_000_000L; j <= 99_999_999_999L; j++){
                for(int k = 1; k <= 9; k++){
                    Pruefziffern p = constructSerialNumber(i,j,k);
                    if(p.isValidSerialNumber())
                        System.out.println(p + " ist eine valide Seriennummer");
                }
            }
        }
    }

    public static Pruefziffern constructSerialNumber(char i, long j, int k){
        final String sn = Character.toString(i) + String.valueOf(j) + String.valueOf(k);
        Pruefziffern p = new Pruefziffern(sn);
        return p;
    }

}
