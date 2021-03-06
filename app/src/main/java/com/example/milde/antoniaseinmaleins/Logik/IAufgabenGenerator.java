package com.example.milde.antoniaseinmaleins.Logik;

/**
 * Created by milde on 07.12.17.
 */

public interface IAufgabenGenerator {

    public String getFrage();
    public String getAufgabe();
    public String getErgebnis();
    public String getReihe();
    public String getLoesung();
    public String getVariant();

    public void generate();
    public void generate(int row);
    public void setConfig(ConfigAufgaben cfg);

}
