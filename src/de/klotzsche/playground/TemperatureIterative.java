package de.klotzsche.playground;

/**
 * Created by Felix on 13.06.2014.
 */
public class TemperatureIterative {

    public static void main(String[] args){
        int temps[] = {12,14,9,12,15,16,15,15,11,8,13,13,15,12};

        int tempDiff = 0;
        int day1 = 0;
        int day2 = 0;
        for ( int i = 0; i < temps.length-1; i++){
            int diff = Math.abs(temps[i] - temps[i + 1]);
            if(diff > tempDiff) {
                tempDiff = diff;
                day1 = i + 1;
                day2 = i + 2;
            }
        }
        System.out.printf("Der größte Temperaturunterschied ist %d\n zwischen Tag %d und %d", tempDiff, day1, day2);
    }

}
