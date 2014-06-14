package de.klotzsche.playground.Temperature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.IntStream.range;

/**
 * Created by Felix on 13.06.2014.
 */
public class Temperature {

    private final ConcurrentHashMap<Integer, Integer> temperatures;
    private final ArrayList<TemperatureDifference> differences;

    public Temperature() {
        this.temperatures = new ConcurrentHashMap<>();
        this.differences = new ArrayList<>();
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
        range(0, temps.length - 1).forEach( i -> differences.add(new TemperatureDifference(Math.abs(temps[i] - temps[i+1]), i+1 , i +2)));
    }

    public void printGreatestTemperatureDifference() {
        int biggestDifference = differences.stream().mapToInt(diff -> diff.getDifference()).max().getAsInt(); // get the greatest difference
        differences.stream()
                .filter( diff -> diff.getDifference() == biggestDifference)
                .forEach(System.out::println); // filter all the difference and print each
    }

    public static void main(String[] args) {
        final Temperature t = new Temperature();

        System.out.println(t.getAverageTemperature());
        System.out.println(t.getMinTemperature());

        t.printDaysTemperatures();
        t.printGreatestTemperatureDifference();
    }
}
