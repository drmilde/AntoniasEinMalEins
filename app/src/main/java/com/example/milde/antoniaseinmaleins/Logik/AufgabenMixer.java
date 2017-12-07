package com.example.milde.antoniaseinmaleins.Logik;

import android.content.res.Resources;

import com.example.milde.antoniaseinmaleins.R;

import java.util.Random;

/**
 * Created by milde on 07.12.17.
 */

public class AufgabenMixer implements IAufgabenGenerator{
    private AufgabenGenerator afgAdd;
    private AufgabenGenerator afgMin;
    private AufgabenGenerator afgMul;
    private AufgabenGenerator afgDiv;

    private int maxAdd = 20;
    private int maxMin = 40;
    private int maxMul = 10;
    private int maxDiv = 10;

    // state
    private int state = 0;
    private Random rn = new Random();

    public AufgabenMixer(int maxAdd, int maxMin, int maxMul, int maxDiv) {
        this.maxAdd = maxAdd;
        this.maxMin = maxMin;
        this.maxMul = maxMul;
        this.maxDiv = maxDiv;

        afgAdd = new AufgabenGenerator(maxAdd, AufgabenGenerator.ADD_TYPE);
        afgMin = new AufgabenGenerator(maxMin, AufgabenGenerator.MIN_TYPE);
        afgMul = new AufgabenGenerator(maxMul, AufgabenGenerator.MUL_TYPE);
        afgDiv = new AufgabenGenerator(maxDiv, AufgabenGenerator.DIV_TYPE);

        state = 0;
    }


    public AufgabenMixer() {
        this(20, 40, 10, 10);
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
