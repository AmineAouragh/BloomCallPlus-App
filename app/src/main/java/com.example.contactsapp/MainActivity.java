package com.example.contactsapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.contactsapp.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.ic_tab_history,
            R.drawable.ic_outline_call,
            R.drawable.ic_outline_message
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Recents"));
        tabLayout.addTab(tabLayout.newTab().setText("Contacts"));
        tabLayout.addTab(tabLayout.newTab().setText("Messages"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final SectionsPagerAdapter adapter = new SectionsPagerAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        setupTabIcons();

        FloatingActionButton fab = findViewById(R.id.fab);


        /* This block of code is replaced by lambda
         fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
          });
        * */

        fab.setOnClickListener(view -> Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                                               .setAction("Action", null).show());

        //inputNumber = (EditText) findViewById(R.id.number);
        //btn_call = (Button) findViewById(R.id.btnCall);

        /* This block is replaced by the lambda form
        * btn_call.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhoneNumber();
            }
          });
        * */

        //btn_call.setOnClickListener(v -> callPhoneNumber());

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }


    /*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
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
    }*/

}
