package com.example.milde.antoniaseinmaleins.FlipView;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.milde.antoniaseinmaleins.R;

import java.util.Random;

/**
 * Created by milde on 01.12.17.
 */

/**
 * A fragment representing the front of the card.
 */
public class CardFrontFragment extends CardSideFragment {
    private String ergebnisText = "ergebnis";
    private String aufgabenText = "aufgabe";

    @Override
    public void changeCardContent() {

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            ergebnisText = bundle.getString("ergebnis");
            aufgabenText = bundle.getString("aufgabe");
        }

        inflatedView.<TextView>findViewById(R.id.tvAufgabeCalc).setText(aufgabenText);
        inflatedView.<TextView>findViewById(R.id.tvErgebnisCalc).setText(ergebnisText);
    }


}


