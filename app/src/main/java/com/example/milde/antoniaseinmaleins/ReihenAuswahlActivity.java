package com.example.milde.antoniaseinmaleins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.milde.antoniaseinmaleins.R;

public class ReihenAuswahlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reihen_auswahl);

        setCallbacks();
    }

    private void setCallbacks() {
        TextView tvReihe2er = (TextView)findViewById(R.id.reihe_2er);
        tvReihe2er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message("2er Reihe");
            }
        });

        TextView tvReihe3er = (TextView)findViewById(R.id.reihe_3er);
        tvReihe3er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message("3er Reihe");
            }
        });

        TextView tvReihe4er = (TextView)findViewById(R.id.reihe_4er);
        tvReihe4er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message("4er Reihe");
            }
        });

        TextView tvReihe5er = (TextView)findViewById(R.id.reihe_5er);
        tvReihe5er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message("5er Reihe");
            }
        });

        TextView tvReihe6er = (TextView)findViewById(R.id.reihe_6er);
        tvReihe6er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message("6er Reihe");
            }
        });

        TextView tvReihe7er = (TextView)findViewById(R.id.reihe_7er);
        tvReihe7er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message("7er Reihe");
            }
        });

        TextView tvReihe8er = (TextView)findViewById(R.id.reihe_8er);
        tvReihe8er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message("8er Reihe");
            }
        });

        TextView tvReihe9er = (TextView)findViewById(R.id.reihe_9er);
        tvReihe9er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message("9er Reihe");
            }
        });

        TextView tvReihe10er = (TextView)findViewById(R.id.reihe_10er);
        tvReihe10er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message("10er Reihe");
            }
        });

    }

    private void message(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
