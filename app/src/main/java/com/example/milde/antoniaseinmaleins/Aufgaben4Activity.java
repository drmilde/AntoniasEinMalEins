package com.example.milde.antoniaseinmaleins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.milde.antoniaseinmaleins.Logik.AufgabenMixer;
import com.example.milde.antoniaseinmaleins.Logik.DataManager;

public class Aufgaben4Activity extends AppCompatActivity {
    private TextView tvAufgabeAnzeige;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aufgaben4);

        tvAufgabeAnzeige = (TextView)findViewById(R.id.tvAufgabeAnzeige);

        final Button btnAnswer1 = (Button)findViewById(R.id.btnAnswer1);
        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AufgabenMixer am = (AufgabenMixer)DataManager.getInstance().getAfg();
                am.generate(5);
                String aufgabenText =  am.getMulFrage()
                        + " = "
                        + am.getMulErgebnis();

                tvAufgabeAnzeige.setText(aufgabenText);
                btnAnswer1.setText(am.getMulLoesung());
            }
        });
    }
}
