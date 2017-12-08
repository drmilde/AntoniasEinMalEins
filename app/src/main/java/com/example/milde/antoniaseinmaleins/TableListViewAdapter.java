package com.example.milde.antoniaseinmaleins;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by milde on 08.12.17.
 */

public class TableListViewAdapter implements ListAdapter {
    private ArrayList<String> data;
    private Context context;

    public TableListViewAdapter(String[] strings, Context context) {
        data = new ArrayList<String>();
        for (int i = 0; i < strings.length; i++) {
            data.add(strings[i]);
        }
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater
                .inflate(R.layout.list_view_item, viewGroup, false);

        TextView tvItemView = rowView
                .findViewById(R.id.listItemTextView);

        tvItemView.setText(data.get(position));

        return rowView;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
