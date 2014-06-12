package de.klotzsche.playground;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Felix Klotzsche on 12.06.2014.
 */
public class Kassenbon {

    private ArrayList<Item> items;

    public Kassenbon(){
        items = new ArrayList<Item>();
        items.add(new Item("Wurst", 4.20F, 1));
        items.add(new Item("Käse", 2.30F, 1));
        items.add(new Item("Brot", 2.10F, 1));
        items.add(new Item("DVD", 12.00F, 2));
    }

    public float getFullPrice(){
        float fullPrice = 0.0F;
        for(Item w : items)
            fullPrice += w.getPrice() * w.getCount();
        return fullPrice;
    }

    public void printItem(Item w){
        System.out.printf("%s\t\t%d x %.2f\n", w.getName(),w.getCount(),w.getPrice());
        System.out.printf("\t\t\t\t%.2f\n", w.getPrice() * w.getCount());
    }

    public void printItems(float given){
        for(Item w : items)
            printItem(w);

        System.out.println("---------------------");
        System.out.printf("%s\t\t%.2f\n", "Gesamt: ", getFullPrice());
        System.out.printf("%s\t\t%.2f\n\n", "Gegeben: ",given);
        System.out.printf("%s\t\t%.2f\n", "Zurück: ",given - getFullPrice());
    }

    public float missingAmount(float amount){
        return getFullPrice() - amount;
    }

    public static void main(String[] args){
        Kassenbon k = new Kassenbon();

        System.out.print("Wat hasdn einstecken?: ");
        float walletAmount = new Scanner(System.in).nextFloat();
        if(walletAmount < k.getFullPrice())
            System.out.println("Du hast zu wenig einstecken. Du brauchst noch " + k.missingAmount(walletAmount) + " um zu zahlen");
        else
            k.printItems(walletAmount);
    }

    class Item {
        private String name;
        private float price;
        private int count;

        public Item(String name, float price, int count){
            this.name = name;
            this.price = price;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public float getPrice() {
            return price;
        }

        public int getCount() {
            return count;
        }
    }


}
