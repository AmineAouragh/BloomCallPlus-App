package com.example.contactsapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.view.View.OnClickListener;

import com.example.contactsapp.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    private EditText inputNumber;
    private Button btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        
        getSupportActionBar().hide();
        
        setContentView(R.layout.activity_main);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        inputNumber = (EditText) findViewById(R.id.number);
        btn_call = (Button) findViewById(R.id.btnCall);

        btn_call.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhoneNumber();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhoneNumber();
            }
        }
    }

    public void callPhoneNumber() {

        try {

            if (Build.VERSION.SDK_INT > 22) {

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) !=PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                            Manifest.permission.CALL_PHONE}, 101);
                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + inputNumber.getText().toString()));
                startActivity(callIntent);

            } else {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + inputNumber.getText().toString()));
                startActivity(callIntent);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
