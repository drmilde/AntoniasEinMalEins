package com.example.milde.antoniaseinmaleins;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.milde.antoniaseinmaleins.FlipView.CardSideFragment;
import com.example.milde.antoniaseinmaleins.FlipView.FlipViewWrapper;
import com.example.milde.antoniaseinmaleins.Helper.MyTimer;
import com.example.milde.antoniaseinmaleins.Helper.MyTimerFinishedCallback;
import com.example.milde.antoniaseinmaleins.Logik.AufgabenGenerator;
import com.example.milde.antoniaseinmaleins.Logik.AufgabenMixer;
import com.example.milde.antoniaseinmaleins.Logik.IAufgabenGenerator;

public class RechenFlipActivity extends AppCompatActivity implements MyTimerFinishedCallback {
    private int mShowing = 1;
    private FlipViewWrapper flipViewWrapper;

    private IAufgabenGenerator afg = new AufgabenMixer();

    // Control
    private Button btnNaechsteAufgabe;
    private Button btnAufgabeFalsch;
    private Button btnNochmal;

    // Timer and Score
    private TextView tvScore;
    private TextView tvTimer;
    private MyTimer timer;

    // State
    private int score = 0;
    private int timerDuration = 60000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechen_flip);

        flipViewWrapper = new FlipViewWrapper(
                R.layout.front_card_calulation,
                R.layout.back_card_calculation,
                afg
        );

        if (savedInstanceState == null) {

            CardSideFragment frontSide = flipViewWrapper.getFrontSide();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, frontSide)
                    .commit();

        }


        FrameLayout fl = (FrameLayout) findViewById(R.id.container);
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipCard();
            }
        });


        // initialize interface
        tvScore = (TextView) findViewById(R.id.tvScore);

        // setze Timer auf 30 und starte ihn
        tvTimer = (TextView) findViewById(R.id.tvTimer);
        timer = new MyTimer(timerDuration, 1000, tvTimer, this);
        timer.start();

        btnNaechsteAufgabe = (Button) findViewById(R.id.btnWeiter);
        btnNaechsteAufgabe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weiterBlaettern(1);
            }
        });

        btnAufgabeFalsch = (Button) findViewById(R.id.btnFalseWeiter);
        btnAufgabeFalsch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do something useful here
                weiterBlaettern(0);
            }
        });


        btnNochmal = (Button) findViewById(R.id.btnNochmal);
        btnNochmal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0;
                tvScore.setText(score + " Punkte");
                mShowing = 0;

                timer.start();
                btnNochmal.setEnabled(false);
                btnNaechsteAufgabe.setEnabled(true);
                btnAufgabeFalsch.setEnabled(true);

                naechsteAufgabe();
            }
        });

    }

    private void weiterBlaettern(int step) {
        naechsteAufgabe();
        if (mShowing == 1) {
            score += step;
        }
        tvScore.setText(score + " Punkte");
    }

    private void naechsteAufgabe() {
        // do something useful here
        flipCard();
    }


    private void flipCard() {
        switch (mShowing) {
            case 0: // front
                mShowing = 1;

                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.animator.card_flip_right_in,
                                R.animator.card_flip_right_out,
                                R.animator.card_flip_left_in,
                                R.animator.card_flip_left_out)
                        .replace(R.id.container, flipViewWrapper.getFrontSide())
                        .commit();
                break;
            case 1: // back
                mShowing = 0;
                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.animator.card_flip_right_in,
                                R.animator.card_flip_right_out,
                                R.animator.card_flip_left_in,
                                R.animator.card_flip_left_out)
                        .replace(R.id.container, flipViewWrapper.getBackSide())
                        //.addToBackStack(null)
                        .commit();
                break;
        }
    }

    @Override
    public void finished() {
        btnNochmal.setEnabled(true);
        btnNaechsteAufgabe.setEnabled(false);
        btnAufgabeFalsch.setEnabled(false);
    }
}
