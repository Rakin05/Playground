package de.klotzsche.playground.pruefziffern;

import java.util.ArrayList;

/**
 * Created by Felix Klotzsche on 19.06.2014.
 */
public class Pruefziffern {

    final ArrayList<Integer> numbers = new ArrayList<>();
    final String serialNumber;
    final int checkSum;

    public Pruefziffern(String serialNumber){
        this.serialNumber = serialNumber;
        this.checkSum = getCheckSum(serialNumber);
        this.fillArrayList();
    }

    public boolean isValidSerialNumber(){
        final int completeCheckSum = numbers.stream().mapToInt(Integer::intValue).sum();
        final int calculatedChecksum = Math.abs((completeCheckSum % 9) - 8);
        if(calculatedChecksum == this.checkSum)
            return true;
        else if(calculatedChecksum == 0 && this.checkSum == 9)
            return true;
        else return false;
    }

    private int getCheckSum(final String serialNumber){
        return Character.digit(serialNumber.charAt(serialNumber.length() - 1), 10);
    }

    private void fillArrayList(){
        numbers.add(checkSum(getFirstCharacterAsInt(this.serialNumber))); // Erst den Buchstaben
        serialNumber.substring(1, 11).chars() // Dann den Rest
                    .forEach(c -> numbers.add(Character.digit(c, 10)));
    }

    private int getFirstCharacterAsInt(final String checkSum){
        return checkSum.charAt(0)-64; // Berechne einfach Das A = 1, B = 2, Z = 26 usw.
    }

    private int checkSum(int value) {
        return String.valueOf(value).chars()
                     .map(i -> Character.digit(i, 10))
                     .sum();
    }

    @Override
    public String toString(){
        return this.serialNumber;
    }
}
