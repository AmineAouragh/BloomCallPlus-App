package com.example.contactsapp.main;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.contactsapp.R;

public class TextViewAdapter extends BaseAdapter {

    private Context context;
    private final String[] numbers;

    public TextViewAdapter(Context context, String[] numbers) {
        this.context = context;
        this.numbers = numbers;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            gridView = new View(context);

            gridView = inflater.inflate(R.layout.dial_item, null);

            TextView textView = (TextView) gridView.findViewById(R.id.grid_item_label);
            textView.setText(numbers[position]);

        } else {
            gridView = (View) convertView;
        }

        return gridView;

    }

    @Override
    public int getCount() {
        return numbers.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
