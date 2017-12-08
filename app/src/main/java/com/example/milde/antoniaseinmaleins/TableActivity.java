package com.example.milde.antoniaseinmaleins;

import android.app.ListActivity;
import android.os.Bundle;

public class TableActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        String[] data = {
                "3 x 2 = 6", "10 x 5 = 50",
                "3 x 2 = 6", "10 x 5 = 50",
                "3 x 2 = 6", "10 x 5 = 50",
                "3 x 2 = 6", "10 x 5 = 50",
                "3 x 2 = 6", "7 x 6 = 42"
        };

        TableListViewAdapter adapter = new TableListViewAdapter(data, this);
        setListAdapter(adapter);
    }
}
