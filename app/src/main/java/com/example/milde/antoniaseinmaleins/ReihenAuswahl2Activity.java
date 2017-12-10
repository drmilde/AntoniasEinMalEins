package com.example.milde.antoniaseinmaleins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReihenAuswahl2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reihen_auswahl2);


        Button btnNumber2 = (Button)findViewById(R.id.btnNumber2);
        btnNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(2);
            }
        });

        Button btnNumber3 = (Button)findViewById(R.id.btnNumber3);
        btnNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(3);
            }
        });

        Button btnNumber4 = (Button)findViewById(R.id.btnNumber4);
        btnNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(4);
            }
        });

        Button btnNumber5 = (Button)findViewById(R.id.btnNumber5);
        btnNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(5);
            }
        });

        Button btnNumber6 = (Button)findViewById(R.id.btnNumber6);
        btnNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(6);
            }
        });

        Button btnNumber7 = (Button)findViewById(R.id.btnNumber7);
        btnNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(7);
            }
        });

        Button btnNumber8 = (Button)findViewById(R.id.btnNumber8);
        btnNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(8);
            }
        });

        Button btnNumber9 = (Button)findViewById(R.id.btnNumber9);
        btnNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(9);
            }
        });

        Button btnNumber10 = (Button)findViewById(R.id.btnNumber10);
        btnNumber10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callActivity(10);
            }
        });

    }

    private void callActivity(int reihe) {
        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
        intent.putExtra("reihe", reihe);
        startActivity(intent);
    }
}
