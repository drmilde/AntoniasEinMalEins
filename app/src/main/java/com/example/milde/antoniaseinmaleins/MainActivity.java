package com.example.milde.antoniaseinmaleins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLos = (Button)findViewById(R.id.btnLosGehts);
        btnLos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RechenFlipActivity.class);
                startActivity(intent);
            }
        });


        Button btnSettings = (Button)findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSettings();
            }
        });

        Button btnRowSelection = (Button)findViewById(R.id.btnRowSelection);
        btnRowSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRowSelection();;
            }
        });

        Button btnTableList = (Button)findViewById(R.id.btnTableList);

        btnTableList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTableList();
            }
        });

    }

    private void showTableList() {
        Intent intent = new Intent(getApplicationContext(), TableActivity.class);
        startActivity(intent);
    }

    private void showSettings() {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(intent);
    }

    private void showRowSelection() {
        Intent intent = new Intent(getApplicationContext(), ReihenAuswahlActivity.class);
        startActivity(intent);
    }


    /* Option Menu Creation and Event Handling */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.optionsMenuSetting:
                showSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
