package com.example.milde.antoniaseinmaleins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
                callActivity("2er Reihe",2);
            }
        });

        TextView tvReihe3er = (TextView)findViewById(R.id.reihe_3er);
        tvReihe3er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity("3er Reihe",3);
            }
        });

        TextView tvReihe4er = (TextView)findViewById(R.id.reihe_4er);
        tvReihe4er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity("4er Reihe",4);
            }
        });

        TextView tvReihe5er = (TextView)findViewById(R.id.reihe_5er);
        tvReihe5er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity("5er Reihe",5);
            }
        });

        TextView tvReihe6er = (TextView)findViewById(R.id.reihe_6er);
        tvReihe6er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity("6er Reihe",6);
            }
        });

        TextView tvReihe7er = (TextView)findViewById(R.id.reihe_7er);
        tvReihe7er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity("7er Reihe",7);
            }
        });

        TextView tvReihe8er = (TextView)findViewById(R.id.reihe_8er);
        tvReihe8er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity("8er Reihe",8);
            }
        });

        TextView tvReihe9er = (TextView)findViewById(R.id.reihe_9er);
        tvReihe9er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity("9er Reihe",9);
            }
        });

        TextView tvReihe10er = (TextView)findViewById(R.id.reihe_10er);
        tvReihe10er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity("10er Reihe",10);
            }
        });

    }

    private void callActivity(String s, int reihe) {
        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
        intent.putExtra("reihe", reihe);
        startActivity(intent);

    }
}
