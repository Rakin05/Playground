package de.klotzsche.playground;

import java.util.Scanner;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class Greeter {

    public static String getGreeting(String name, String sex, int age){
        if(age < 18)
            return String.format("Hallo %s!", name);
        else if(sex.equals("männlich"))
            return String.format("Guten Tag Herr %s!", name);
        else
            return String.format("Guten Tag Frau %s!", name);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Name eingeben: ");
        String name = sc.nextLine();

        System.out.print("männlich oder weiblich?: ");
        String sex = sc.nextLine();

        System.out.print("Alter?: ");
        int age = sc.nextInt();

        String greeting = getGreeting(name, sex, age);
        System.out.println(greeting);
    }

}
