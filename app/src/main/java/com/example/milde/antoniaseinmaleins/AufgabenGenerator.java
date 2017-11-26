package com.example.milde.antoniaseinmaleins;

import java.util.Random;

/**
 * Created by milde on 26.11.17.
 */

public class AufgabenGenerator {
    private String ergebnis = "42";
    private String aufgabe = "6 x 7";
    private String reihe = "7";

    public void generate() {
        Random rn = new Random();

        int f1 = rn.nextInt(10) + 1;
        int f2 = rn.nextInt(10) + 1;

        ergebnis = "" + (f1 * f2);
        aufgabe = "" + f1 + " x " + f2;
        reihe = "" + f1;
    }

    public String getErgebnis() {
        return ergebnis;
    }

    public String getAufgabe() {
        return aufgabe;
    }

    public String getReihe() {
        return reihe;
    }
}
