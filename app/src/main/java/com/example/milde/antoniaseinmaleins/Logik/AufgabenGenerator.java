package com.example.milde.antoniaseinmaleins.Logik;

import java.util.Random;

/**
 * Created by milde on 26.11.17.
 */

public class AufgabenGenerator implements IAufgabenGenerator{
    public static final int ADD_TYPE = 0;
    public static final int MIN_TYPE = 1;
    public static final int MUL_TYPE = 2;
    public static final int DIV_TYPE = 3;

    // Configuration
    private ConfigAufgaben cfg = null;

    // strings
    private String ergebnis = "42";
    private String aufgabe = "6 x 7";
    private String frage = "6 x ?";
    private String reihe = "6";
    private String loesung = "7";
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
        generate();
    }

    public AufgabenGenerator() {
        rn = new Random();
        generate();
    }

    public void generate() {
        op01 = rn.nextInt(maxOp) + 1;
        op02 = rn.nextInt(maxOp) + 1;
        processOp();
        createStrings();
    }

    public void generate(int row) {
        int oldOp02 = op02;
        op01 = row;

        // no repetion please
        while(oldOp02 == op02) {
            op02 = rn.nextInt(maxOp) + 1;
        }

        // generate results and strings
        processOp();
        createStrings();
    }

    private void processOp() {
        switch (excerciseType) {
            case ADD_TYPE:
                result = op01 + op02;
                break;
            case MIN_TYPE:
                // nur positiove zahlen
                while ((op01 - op02) < 0) {
                    op02 = rn.nextInt(maxOp) + 1;
                }
                result = op01 - op02;
                break;
            case MUL_TYPE:
                result = op01 * op02;
                break;
            case DIV_TYPE:
                // nur ganzzahlige divisionen sind zulässig
                op01 = op01 * op02;
                result = op01 / op02;
                break;
            default:
                result = op01 * op02;
                excerciseType = MUL_TYPE;
                break;
        }
    }

    @Override
    public void setConfig(ConfigAufgaben cfg) {
        this.cfg = cfg;
    }

    private void createStrings() {
        ergebnis = "" + result;

        switch (excerciseType) {
            case ADD_TYPE:
                aufgabe = op01 + " + " + op02;
                frage = op01 + " + ?";
                break;
            case MIN_TYPE:
                aufgabe = op01 + " - " + op02;
                frage = op01 + " - ?";
                break;
            case MUL_TYPE:
                aufgabe = op01 + " x " + op02;
                frage = op01 + " x ?";
                break;
            case DIV_TYPE:
                aufgabe = op01 + " / " + op02;
                frage = op01 + " / ?";
                break;
        }

        reihe = "" + op01;
        loesung ="" +  op02;
    }


    // Interfave IAufgabenGenerator

    public String getErgebnis() {
        return ergebnis;
    }

    public String getAufgabe() {
        return aufgabe;
    }

    public String getReihe() {
        return reihe;
    }

    @Override
    public String getLoesung() {
        return loesung;
    }

    public String getFrage() {
        return frage;
    }
}
