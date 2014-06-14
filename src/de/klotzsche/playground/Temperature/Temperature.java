package de.klotzsche.playground.Temperature;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.IntStream.range;

/**
 * Created by Felix on 13.06.2014.
 */
public class Temperature {

    private final ConcurrentHashMap<Integer, Integer> temperatures;

    public Temperature() {
        this.temperatures = new ConcurrentHashMap<>();

        this.setupTemperatures();
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

    private int biggestDifferenceBetweenTwoDays(){
        final Integer[] temps = temperatures.values().toArray(new Integer[temperatures.values().size()]);
        return range(0, temps.length - 1)
                .map( i -> Math.abs(temps[i] - temps[i+1]))
                .parallel()
                .max().getAsInt();
    }

    public void printGreatestTemperatureDifference() {
        final Integer[] temps = temperatures.values().toArray(new Integer[temperatures.values().size()]);
        range(0, temps.length - 1)
                .mapToObj( i -> new TemperatureDifference(Math.abs(temps[i] - temps[i+1]),i+1, i+2))
                .parallel()
                .filter(tp -> tp.getDifference() == biggestDifferenceBetweenTwoDays())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        final Temperature t = new Temperature();

        System.out.println(t.getAverageTemperature());
        System.out.println(t.getMinTemperature());

        t.printDaysTemperatures();
        t.printGreatestTemperatureDifference();
    }
}
