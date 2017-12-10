package com.example.milde.antoniaseinmaleins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.milde.antoniaseinmaleins.Logik.AufgabenMixer;
import com.example.milde.antoniaseinmaleins.Logik.DataManager;

public class Aufgaben4Activity extends AppCompatActivity {
    private TextView tvAufgabeAnzeige;
    private Button btnAnswer1;
    private Button btnAnswer2;
    private Button btnAnswer3;
    private Button btnAnswer4;

    private int reihe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aufgaben4);


        // read the data
        reihe = 4;
        Intent iin = getIntent();
        Bundle extras = iin.getExtras();

        if (extras != null) {
            if (extras.containsKey("reihe")) {
                reihe = extras.getInt("reihe");
            } else {
                reihe = 4;
            }
        }

        tvAufgabeAnzeige = (TextView) findViewById(R.id.tvAufgabeAnzeige);
        tvAufgabeAnzeige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFields();
            }
        });

        btnAnswer1 = (Button) findViewById(R.id.btnAnswer1);
        btnAnswer2 = (Button) findViewById(R.id.btnAnswer2);
        btnAnswer3 = (Button) findViewById(R.id.btnAnswer3);
        btnAnswer4 = (Button) findViewById(R.id.btnAnswer4);
        setFields();

        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswer1);
            }
        });
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswer2);
            }
        });
        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswer3);
            }
        });
        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswer4);
            }
        });

    }

    private void checkAnswer(Button btn) {
        String vString = btn.getText().toString();
        AufgabenMixer am = (AufgabenMixer) DataManager.getInstance().getAfg();

        if (vString.equalsIgnoreCase(am.getMulLoesung())) {
            btn.setText("OK");
            setFields();
        } else {
            btn.setText("NO");
        }
    }

    private void setFields() {
        AufgabenMixer am = (AufgabenMixer) DataManager.getInstance().getAfg();
        am.generate(reihe);
        String aufgabenText = am.getMulFrage()
                + " = "
                + am.getMulErgebnis();

        tvAufgabeAnzeige.setText(aufgabenText);
        btnAnswer1.setText(am.getMulVariant());
        btnAnswer2.setText(am.getMulVariant());
        btnAnswer3.setText(am.getMulVariant());
        btnAnswer4.setText(am.getMulVariant());
    }
}
