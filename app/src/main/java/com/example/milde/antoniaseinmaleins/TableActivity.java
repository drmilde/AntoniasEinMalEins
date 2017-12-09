package com.example.milde.antoniaseinmaleins;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TableActivity extends ListActivity {
    private int reihe = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);


        Intent iin= getIntent();
        Bundle extras = iin.getExtras();

        if(extras!=null)
        {
            reihe = extras.getInt("reihe");
        }

        String[] data = new String[10];
        generateTable(data, reihe);

        TableListViewAdapter adapter = new TableListViewAdapter(data, this);
        setListAdapter(adapter);

        Button btnReiheUeben = (Button)findViewById(R.id.btnReiheUeben);
        btnReiheUeben.setText(getString(R.string.reihe_ueben_button_text)
                + " "
                + reihe);

        btnReiheUeben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO switch to new intent
            }
        });
    }


    private void generateTable(String[] data, int reihe) {
        for (int i = 0; i < data.length; i++) {
            data[i] = reihe + " x " + (i+1) + " = " + ((i+1)*reihe);
        }
    }
}
