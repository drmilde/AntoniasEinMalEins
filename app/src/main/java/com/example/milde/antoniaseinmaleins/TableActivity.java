package com.example.milde.antoniaseinmaleins;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TableActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

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
        btnReiheUeben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO switch tu new intent
            }
        });
    }
}
