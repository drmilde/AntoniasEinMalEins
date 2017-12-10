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

    private ConfigAufgaben cfg = null;

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

    @Override
    public void generate(int row) {
        afgAdd.generate(row);
        afgMin.generate(row);
        afgMul.generate(row);
        afgDiv.generate(row);
    }

    @Override
    public void setConfig(ConfigAufgaben cfg) {
        this.cfg = cfg;
    }


    // getter

    // ADD
    public String getAddFrage() {
        return afgAdd.getFrage();
    }

    public String getAddAufgabe() {
        return afgAdd.getAufgabe();
    }

    public String getAddErgebnis() {
        return afgAdd.getErgebnis();
    }

    public String getAddReihe() {
        return afgAdd.getReihe();
    }


    // MIN
    public String getMinFrage() {
        return afgMin.getFrage();
    }

    public String getMinAufgabe() {
        return afgMin.getAufgabe();
    }

    public String getMinErgebnis() {
        return afgMin.getErgebnis();
    }

    public String getMinReihe() {
        return afgMin.getReihe();
    }

    // MUL
    public String getMulFrage() {
        return afgMul.getFrage();
    }

    public String getMulAufgabe() {
        return afgMul.getAufgabe();
    }

    public String getMulErgebnis() {
        return afgMul.getErgebnis();
    }

    public String getMulReihe() {
        return afgMin.getReihe();
    }

    // DIV
    public String getDivFrage() {
        return afgDiv.getFrage();
    }

    public String getDivAufgabe() {
        return afgDiv.getAufgabe();
    }

    public String getDivErgebnis() {
        return afgDiv.getErgebnis();
    }

    public String getDivReihe() {
        return afgDiv.getReihe();
    }

}
