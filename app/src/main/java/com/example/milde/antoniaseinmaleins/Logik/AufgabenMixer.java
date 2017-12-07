package com.example.milde.antoniaseinmaleins.Logik;

import java.util.Random;

/**
 * Created by milde on 07.12.17.
 */

public class AufgabenMixer implements IAufgabenGenerator{
    private AufgabenGenerator afgAdd;
    private AufgabenGenerator afgMin;
    private AufgabenGenerator afgMul;
    private AufgabenGenerator afgDiv;

    // state
    private int state = 0;
    private Random rn = new Random();

    public AufgabenMixer() {
        afgAdd = new AufgabenGenerator(20, AufgabenGenerator.ADD_TYPE);
        afgMin = new AufgabenGenerator(40, AufgabenGenerator.MIN_TYPE);
        afgMul = new AufgabenGenerator(10, AufgabenGenerator.MUL_TYPE);
        afgDiv = new AufgabenGenerator(10, AufgabenGenerator.DIV_TYPE);

        state = 0;
    }


    @Override
    public String getFrage() {
        switch (state) {
            case 0:
                return afgAdd.getFrage();
            case 1:
                return afgMin.getFrage();
            case 2:
                return afgMul.getFrage();
            case 3:
                return afgDiv.getFrage();
        }
        return afgAdd.getFrage();
    }

    @Override
    public String getAufgabe() {
        switch (state) {
            case 0:
                return afgAdd.getAufgabe();
            case 1:
                return afgMin.getAufgabe();
            case 2:
                return afgMul.getAufgabe();
            case 3:
                return afgDiv.getAufgabe();
        }
        return afgAdd.getAufgabe();
    }

    @Override
    public String getErgebnis() {
        switch (state) {
            case 0:
                return afgAdd.getErgebnis();
            case 1:
                return afgMin.getErgebnis();
            case 2:
                return afgMul.getErgebnis();
            case 3:
                return afgDiv.getErgebnis();
        }
        return afgAdd.getErgebnis();
    }

    @Override
    public String getReihe() {
        switch (state) {
            case 0:
                return afgAdd.getReihe();
            case 1:
                return afgMin.getReihe();
            case 2:
                return afgMul.getReihe();
            case 3:
                return afgDiv.getReihe();
        }
        return afgAdd.getReihe();
    }

    @Override
    public void generate() {
        state = (state + (rn.nextInt(16)+1)) % 4;
        afgAdd.generate();
        afgMin.generate();
        afgMul.generate();
        afgDiv.generate();
    }
}
