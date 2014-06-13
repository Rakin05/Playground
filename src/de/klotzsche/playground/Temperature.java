package de.klotzsche.playground;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.IntStream.range;

/**
 * Created by Felix on 13.06.2014.
 */
public class Temperature {

    private final ConcurrentHashMap<Integer, Integer> temperatures;
    private final ConcurrentHashMap<Integer, List<Integer>> differences;


    public Temperature() {
        this.temperatures = new ConcurrentHashMap<>();
        this.differences = new ConcurrentHashMap<>();
        this.setupTemperatures();
        this.fillTemperatureDifferences();
    }

    private void setupTemperatures() {
        this.temperatures.put(1, 12);
        this.temperatures.put(2, 14);
        this.temperatures.put(3, 9);
        this.temperatures.put(4, 12);
        this.temperatures.put(5, 15);
        this.temperatures.put(6, 16);
        this.temperatures.put(7, 15);
        this.temperatures.put(8, 15);
        this.temperatures.put(9, 11);
        this.temperatures.put(10, 8);
        this.temperatures.put(11, 13);
        this.temperatures.put(12, 15);
        this.temperatures.put(13, 12);
    }

    public double getAverageTemperature() {
        return temperatures.values().stream()
                .parallel()
                .mapToDouble(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public int getMinTemperature() {
        return Collections.min(temperatures.values());
    }

    private void printDayTemperature(int day, int temperature) {
        System.out.printf("|\t%2d\t|\t%2d\t|\n", day, temperature);
    }

    public void printDaysTemperatures() {
        temperatures.keySet().stream().parallel().forEach(i -> printDayTemperature(i, temperatures.get(i)));
    }

    private void fillTemperatureDifferences() {
        Integer[] temps = temperatures.values().toArray(new Integer[temperatures.values().size()]);
        Integer[] days = temperatures.keySet().toArray(new Integer[temperatures.keySet().size()]);
        range(0, temps.length - 1)
                .parallel()
                .forEach(i -> differences.put(Math.abs(temps[i] - temps[i + 1]), Arrays.asList(days[i], days[i + 1])));
    }

    private void printTemperatureDifference(int temp, int day1, int day2){
        System.out.printf("Größter Temperaturunterschied von %d °C zwischen Tag %d und %d\n", temp, day1, day2);
    }

    public void printGreatestTemperatureDifference() {
        int biggestDifference = Collections.max(differences.keySet());
        differences.forEach( (key, values) -> {
            if (key == biggestDifference) printTemperatureDifference(key, values.get(0), values.get(1));
        });
    }

    public static void main(String[] args) {
        final Temperature t = new Temperature();

        System.out.println(t.getAverageTemperature());
        System.out.println(t.getMinTemperature());

        t.printDaysTemperatures();
        t.printGreatestTemperatureDifference();
    }
}
