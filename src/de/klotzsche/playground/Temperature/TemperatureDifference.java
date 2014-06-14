package de.klotzsche.playground.Temperature;

/**
 * Created by Felix on 14.06.2014.
 */
public class TemperatureDifference {

    private int day1;
    private int day2;
    private int temperatureDifference;

    public TemperatureDifference(int temperatureDifference, int day1, int day2) {
        this.temperatureDifference = temperatureDifference;
        this.day1 = day1;
        this.day2 = day2;
    }

    public int getDifference(){
        return this.temperatureDifference;
    }

    public boolean isExactlyDifferent(int difference){
        return this.temperatureDifference == difference;
    }

    @Override
    public String toString(){
        return String.format("Größter Unterschied von %d °C zwischen Tag %d und %d", temperatureDifference, day1, day2);
    }
}
