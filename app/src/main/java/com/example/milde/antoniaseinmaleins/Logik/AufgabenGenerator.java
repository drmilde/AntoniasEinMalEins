package com.example.milde.antoniaseinmaleins.Logik;

import java.util.Random;

/**
 * Created by milde on 26.11.17.
 */

public class AufgabenGenerator {
    private static final int ADD_TYPE = 0;
    private static final int MIN_TYPE = 1;
    private static final int MUL_TYPE = 2;
    private static final int DIV_TYPE = 3;

    // strings
    private String ergebnis = "42";
    private String aufgabe = "6 x 7";
    private String reihe = "7";
    private Random rn = new Random();

    // state of the generator
    private int maxOp = 10;
    private int op01 = 0;
    private int op02 = 0;
    private int result = 0;

    private int excerciseType = MUL_TYPE;

    public AufgabenGenerator(int maxOp, int excerciseType) {
        this();
        this.maxOp = maxOp;
        this.excerciseType = excerciseType;
    }

    public AufgabenGenerator() {
        rn = new Random();
    }

    public void generate() {
        op01 = rn.nextInt(maxOp) + 1;
        op02 = rn.nextInt(maxOp) + 1;

        switch (excerciseType) {
            case ADD_TYPE:
                result = op01 + op02;
                break;
            case MIN_TYPE:
                result = op01 - op02;
                break;
            case MUL_TYPE:
                result = op01 * op02;
                break;
            case DIV_TYPE:
                result = op01 / op02;
                break;
            default:
                result = op01 * op02;
                excerciseType = MUL_TYPE;
                break;
        }
        createStrings();
    }

    private void createStrings() {
        ergebnis = "" + result;

        switch (excerciseType) {
            case ADD_TYPE:
                aufgabe = op01 + " + " + op02;
                break;
            case MIN_TYPE:
                aufgabe = op01 + " - " + op02;
                break;
            case MUL_TYPE:
                aufgabe = op01 + " x " + op02;
                break;
            case DIV_TYPE:
                aufgabe = op01 + " / " + op02;
                break;
        }

        reihe = "" + op01;
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
