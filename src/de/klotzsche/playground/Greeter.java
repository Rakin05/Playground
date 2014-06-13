package de.klotzsche.playground;

import java.util.Scanner;

/**
 * Created by Felix Klotzsche on 13.06.2014.
 */
public class Greeter {

    public static String getGreeting(String name, String sex, int age){

        String greeting = "";

        if(age < 18)
            return greeting = String.format("%sHallo %s!", greeting, name);
        else if(sex.equals("männlich"))
            return greeting = String.format("%sGuten Tag Herr %s!", greeting, name);
        else
            return greeting = String.format("%sGuten Tag Frau %s!", greeting, name);
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
