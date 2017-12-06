package com.example.milde.antoniaseinmaleins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.milde.antoniaseinmaleins.Helper.MyTimer;
import com.example.milde.antoniaseinmaleins.Helper.MyTimerFinishedCallback;
import com.example.milde.antoniaseinmaleins.Logik.AufgabenGenerator;

public class RechnenActivity extends AppCompatActivity implements MyTimerFinishedCallback {

    private AufgabenGenerator ag = new AufgabenGenerator();
    private Button btnNaechsteAufgabe;
    private Button btnLoesung;
    private Button btnNochmal;

    private TextView tvErgebnis;
    private TextView tvAufgabe;
    private TextView tvReihe;

    private TextView tvScore;
    private TextView tvTimer;
    private MyTimer timer;

    private int score = 0;
    private int timerDuration = 60000;

    private Animation animFadeOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechnen);

        tvErgebnis = (TextView)findViewById(R.id.tvErgebnis);
        tvAufgabe = (TextView)findViewById(R.id.tvAufgabe);
        tvReihe = (TextView)findViewById(R.id.tvReihe);

        tvScore= (TextView)findViewById(R.id.tvScore);

        // setze Timer auf 30 und starte ihn
        tvTimer = (TextView)findViewById(R.id.tvTimer);
        timer = new MyTimer(timerDuration, 1000, tvTimer, this);
        timer.start();

        btnNaechsteAufgabe = (Button)findViewById(R.id.btnWeiter);
        btnNaechsteAufgabe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naechsteAufgabe();
                score++;
                tvScore.setText(score + " Punkte");
            }
        });

        btnLoesung = (Button)findViewById(R.id.btnLoesung);
        btnLoesung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvAufgabe.setText(ag.getErgebnis() + " = " + ag.getAufgabe());
            }
        });

        btnNochmal = (Button)findViewById(R.id.btnNochmal);
        btnNochmal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naechsteAufgabe();
                score = 0;
                tvScore.setText(score + " Punkte");

                timer.start();
                btnNochmal.setEnabled(false);
                btnNaechsteAufgabe.setEnabled(true);
            }
        });


    }

    @Override
    public void finished() {
        btnNochmal.setEnabled(true);
        btnNaechsteAufgabe.setEnabled(false);
    }

    private void naechsteAufgabe() {
        // Animationen laden
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animFadeOut.setDuration(2000);
        tvAufgabe.setText(ag.getErgebnis() + " = " + ag.getAufgabe());
        tvAufgabe.setAnimation(animFadeOut);

        ag.generate();

        tvErgebnis.setText(ag.getErgebnis());
        //tvAufgabe.setText("");
        tvReihe.setText(ag.getReihe());
    }


    /*****/

    public int getTimerDuration() {
        return timerDuration;
    }

    public void setTimerDuration(int timerDuration) {
        this.timerDuration = timerDuration;
    }
}
