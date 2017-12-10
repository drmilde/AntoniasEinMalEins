package com.example.milde.antoniaseinmaleins.Logik;

/**
 * Created by milde on 10.12.17.
 */

public class DataManager {
    private static final DataManager ourInstance = new DataManager();
    private IAufgabenGenerator afg;


    private DataManager() {
        // cannot be called from outside
        afg = new AufgabenMixer();
    }


    public static DataManager getInstance() {
        return ourInstance;
    }

    // getter


    public IAufgabenGenerator getAfg() {
        return afg;
    }
}
