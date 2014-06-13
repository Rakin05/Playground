package de.klotzsche.playground;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Felix Klotzsche on 12.06.2014.
 */
public class Kassenbon {

    private List<Item> items;

    public Kassenbon() {
        items = new ArrayList<Item>();
        items.add(new Item("Wurst", 4.20F, 1));
        items.add(new Item("Käse", 2.30F, 1));
        items.add(new Item("Brot", 2.10F, 1));
        items.add(new Item("DVD", 12.00F, 2));
    }

    public double getFullPrice() {
        return items.parallelStream().mapToDouble(i -> i.getPrice() * i.getCount()).sum();
    }

    public void printItem(Item w) {
        System.out.printf("%s\t\t%d x %.2f\n", w.getName(), w.getCount(), w.getPrice());
        System.out.printf("\t\t\t\t%.2f\n", w.getPrice() * w.getCount());
    }

    public void printItems(float given) {
        items.forEach(this::printItem);

        System.out.println("---------------------");
        System.out.printf("%s\t\t%.2f\n", "Gesamt: ", getFullPrice());
        System.out.printf("%s\t\t%.2f\n\n", "Gegeben: ", given);
        System.out.printf("%s\t\t%.2f\n", "Zurück: ", given - getFullPrice());
    }

    public double missingAmount(double amount) {
        return getFullPrice() - amount;
    }

    public static void main(String[] args) {
        Kassenbon k = new Kassenbon();

        System.out.print("Wat hasdn einstecken?: ");
        float walletAmount = new Scanner(System.in).nextFloat();
        if (walletAmount < k.getFullPrice())
            System.out.println("Du hast zu wenig einstecken. Du brauchst noch " + k.missingAmount(walletAmount) + " um zu zahlen");
        else
            k.printItems(walletAmount);
    }

    class Item {
        private String name;
        private double price;
        private int count;

        public Item(String name, double price, int count) {
            this.name = name;
            this.price = price;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getCount() {
            return count;
        }
    }


}
