package com.example.milde.antoniaseinmaleins.Logik;

import android.media.MediaActionSound;

/**
 * Created by milde on 07.12.17.
 */

public class ConfigAufgaben {
    private boolean doAdd = true;
    private boolean doMin = true;
    private boolean doMul = true;
    private boolean doDiv = true;

    private int MAX_FACTOR = 10;

    private boolean[] series = new boolean[MAX_FACTOR];

    public ConfigAufgaben(int MAX_FACTOR) {
        this.MAX_FACTOR = MAX_FACTOR;
        series = new boolean[MAX_FACTOR];
        resetData();
        loadPreferences();
    }

    private void resetData() {
        initCalculations();
        initSeries();
    }

    private void initCalculations() {
        doAdd = true;
        doMin = true;
        doMul = true;
        doDiv = true;
    }

    //TODO hier fehlt noch das Setzten der Reihen

    private void initSeries() {
        for (int i = 0; i < series.length; i++) {
            series[i] = true;
        }
    }

    private void clearSeries() {
        for (int i = 0; i < series.length; i++) {
            series[i] = false;
        }
    }

    private void loadPreferences() {
    }


    // setter

    public void setDoAdd(boolean doAdd) {
        this.doAdd = doAdd;
    }

    public void setDoMin(boolean doMin) {
        this.doMin = doMin;
    }

    public void setDoMul(boolean doMul) {
        this.doMul = doMul;
    }

    public void setDoDiv(boolean doDiv) {
        this.doDiv = doDiv;
    }


    // getter

    public boolean isDoAdd() {
        return doAdd;
    }

    public boolean isDoMin() {
        return doMin;
    }

    public boolean isDoMul() {
        return doMul;
    }

    public boolean isDoDiv() {
        return doDiv;
    }
}
