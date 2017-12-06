package com.example.milde.antoniaseinmaleins.FlipView;

import android.os.Bundle;

import com.example.milde.antoniaseinmaleins.Logik.AufgabenGenerator;
import com.example.milde.antoniaseinmaleins.R;

import java.util.Random;

/**
 * Created by milde on 02.12.17.
 */

public class FlipViewWrapper {
    private int layoutFrontID;
    private int layoutBackID;

    private CardSideFragment frontSide;
    private CardSideFragment backSide;

    private AufgabenGenerator afg = new AufgabenGenerator();

    public FlipViewWrapper(int layoutFrontID, int layoutBackID) {
        this.layoutFrontID = layoutFrontID;
        this.layoutBackID = layoutBackID;


        // init front- und backside
        initFrontSide(layoutFrontID);
        initBackSide(layoutBackID);
    }

    private void initBackSide(int layoutBackID) {
        backSide = new CardBackFragment();
        Bundle bundleBack = new Bundle();
        bundleBack.putInt(
                String.valueOf(R.string.card_fragment_bundle_layout_identifier),
                layoutBackID);
        bundleBack.putString("ergebnis", afg.getErgebnis());
        bundleBack.putString("aufgabe", afg.getAufgabe());
        backSide.setArguments(bundleBack);
    }

    private void initFrontSide(int layoutFrontID) {
        afg.generate();
        frontSide = new CardFrontFragment();
        Bundle bundleFront = new Bundle();
        bundleFront.putInt(
                String.valueOf(R.string.card_fragment_bundle_layout_identifier),
                layoutFrontID);
        bundleFront.putString("ergebnis", afg.getErgebnis());
        bundleFront.putString("aufgabe", afg.getReihe() + " x ?");
        frontSide.setArguments(bundleFront);
    }

    // getter
    public CardSideFragment getFrontSide() {
        initFrontSide(layoutFrontID);
        return frontSide;
    }

    public CardSideFragment getBackSide() {
        initBackSide(layoutBackID);
        return backSide;
    }
}
