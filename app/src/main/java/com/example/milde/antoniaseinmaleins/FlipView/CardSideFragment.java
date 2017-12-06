package com.example.milde.antoniaseinmaleins.FlipView;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.milde.antoniaseinmaleins.R;

import java.util.Random;

/**
 * Created by milde on 02.12.17.
 */

public abstract class CardSideFragment extends Fragment {
    protected int layout;
    protected View inflatedView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int id = bundle.getInt(
                    String.valueOf(R.string.card_fragment_bundle_layout_identifier)
            );
            layout = id;
        }

        inflatedView = inflater.inflate(layout, container, false);
        changeCardContent();

        return inflatedView;
    }

    public abstract void changeCardContent();

}
