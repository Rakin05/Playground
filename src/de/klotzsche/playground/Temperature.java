package de.klotzsche.playground;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

/**
 * Created by Felix on 13.06.2014.
 */
public class Temperature {

    private HashMap<Integer, Integer> temperatures;
    private HashMap<Integer, List<Integer>> differences;


    public Temperature(){
        this.temperatures = new HashMap<>();
        this.differences =  new HashMap<>();
        this.setupTemperatures();
        this.fillTemperatureDifferences();
    }

    private void setupTemperatures() {
        this.temperatures.put(1, 12);
        this.temperatures.put(2, 14);
        this.temperatures.put(3, 9);
        this.temperatures.put(4, 12);
        this.temperatures.put(5, 15);
        this.temperatures.put(6, 19);
        this.temperatures.put(7, 25);
        this.temperatures.put(8, 18);
        this.temperatures.put(9, 8);
        this.temperatures.put(10, 17);
        this.temperatures.put(11, 13);
        this.temperatures.put(12, 15);
        this.temperatures.put(13, 23);
        this.temperatures.put(14, 25);
    }

    public double getAverageTemperature(){
        return temperatures.values().stream()
                .parallel()
                .mapToDouble(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public int getMinTemperature(){
        return Collections.min(temperatures.values());
    }

    private void printDayTemperature(int day, int temperature){
        System.out.printf("|\t%2d\t|\t%2d\t|\n", day, temperature);
    }

    public void printDaysTemperatures(){
        temperatures.keySet().stream().parallel().forEach( i -> printDayTemperature(i, temperatures.get(i)));
    }

    private void fillTemperatureDifferences(){
        Integer[] temps = temperatures.values().toArray(new Integer[temperatures.values().size()]);
        Integer[] days  = temperatures.keySet().toArray(new Integer[temperatures.keySet().size()]);
        range(0, temps.length - 1)
                .parallel()
                .forEach( i -> differences.put(Math.abs(temps[i] - temps[i+1]), Arrays.asList(days[i], days[i+1])) );
    }

    public void printGreatestTemperatureDifference(){
        int greatestDifference = Collections.max(differences.keySet());
        int day1 = (int) differences.get(greatestDifference).toArray()[0];
        int day2 = (int) differences.get(greatestDifference).toArray()[1];
        System.out.printf("Größter Temperaturunterschied von %d °C zwischen Tag %d und %d", greatestDifference, day1, day2);
    }

    public static void main(String[] args){
        Temperature t = new Temperature();

        System.out.println(t.getAverageTemperature());
        System.out.println(t.getMinTemperature());

        t.printDaysTemperatures();
        t.printGreatestTemperatureDifference();
    }
}
