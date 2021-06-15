package com.example.contactsapp.main;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.contactsapp.R;


public class DialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_dialpad);

        GridView gridView = (GridView) findViewById(R.id.dialpad_grid);


    }
}
