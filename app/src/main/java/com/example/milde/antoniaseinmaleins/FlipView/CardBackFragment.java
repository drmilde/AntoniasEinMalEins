package com.example.milde.antoniaseinmaleins.FlipView;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.milde.antoniaseinmaleins.R;

/**
 * Created by milde on 01.12.17.
 */


public class CardBackFragment extends CardSideFragment {
    private String ergebnisText = "";
    private String aufgabenText = "";



    @Override
    public void changeCardContent() {

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            ergebnisText = bundle.getString("ergebnis");
            aufgabenText = bundle.getString("aufgabe");
        }

        inflatedView.<TextView>findViewById(R.id.tvAufgabeBackCalc).setText(aufgabenText);
        inflatedView.<TextView>findViewById(R.id.tvErgebnisBackCalc).setText(ergebnisText);
    }

}
