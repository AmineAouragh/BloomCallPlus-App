package com.example.contactsapp.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.contactsapp.R;


public class DialActivity extends AppCompatActivity {

    private final String[] numbers = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_dialpad);

        GridView gridView = (GridView) findViewById(R.id.grid_dial);
        gridView.setAdapter(new TextViewAdapter(this, numbers));


    }
}
