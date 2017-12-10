package com.example.milde.antoniaseinmaleins.Logik;

import java.util.Random;

/**
 * Created by milde on 10.12.17.
 */

public class VariationGenerator {
    private int numberVariations = 4;
    private int[] variations = new int[numberVariations];
    private int seed;
    private Random rn;
    private int currentVariationsIdx;


    public VariationGenerator(int seed, int num) {
        intiGenerator(seed, num);
    }

    private void intiGenerator(int seed, int num) {
        this.seed = seed;
        if (num == 0) {
            num++;
        }
        this.numberVariations = num;

        variations = new int[numberVariations];
        currentVariationsIdx = 0;
        rn = new Random();

        createVariations();
    }

    private void createVariations() {
        for (int i = 0; i < variations.length; i++) {

            // zufallsvariation
            variations[i] = Math.max (1, seed - rn.nextInt(3))
                    + (i + 1 + rn.nextInt(3));

            // zufallswert darf nicht gleich seed sein
            if (variations[i] == seed) {
                variations[i] = seed + (i + 1);
            }
        }

        int idx = rn.nextInt(1000);
        idx = idx % variations.length;
        variations[idx] = seed;

        currentVariationsIdx = rn.nextInt(50);

        // TODO sicherstellen, dass alle Werte unterschiedlich sind
    }


    public int getVarations() {
        currentVariationsIdx = (currentVariationsIdx + 1) % variations.length;
        return variations[currentVariationsIdx];
    }


    public void setSeed(int seed) {
        this.seed = seed;
        intiGenerator(seed, numberVariations);
    }
}
