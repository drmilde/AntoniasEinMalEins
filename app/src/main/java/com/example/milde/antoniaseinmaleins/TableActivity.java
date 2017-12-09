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

        String[] data = {
                "8 x 1 = 8", "8 x 2 = 16",
                "8 x 3 = 24", "8 x 4 = 32",
                "8 x 5 = 40", "8 x 6 = 48",
                "8 x 7 = 56", "8 x 8 = 64",
                "8 x 9 = 72", "8 x 10 = 80"
        };

        TableListViewAdapter adapter = new TableListViewAdapter(data, this);
        setListAdapter(adapter);

        Button btnReiheUeben = (Button)findViewById(R.id.btnReiheUeben);
        btnReiheUeben.setText(getString(R.string.reihe_ueben_button_text) + reihe);

        btnReiheUeben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO switch tu new intent
            }
        });
    }
}
