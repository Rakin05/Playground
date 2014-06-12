package de.klotzsche.playground;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by Felix Klotzsche on 12.06.2014.
 */
public class NegativPositiv {

    public static void main(String[] args){
        int eingabe = Integer.valueOf(JOptionPane.showInputDialog(null, "Gib deine Zahl ein!"));
        if(eingabe < 0)
            JOptionPane.showMessageDialog(null, "Computer sagt...negativ");
        else
            JOptionPane.showMessageDialog(null, "Computer sagt...positiv");
    }

}
