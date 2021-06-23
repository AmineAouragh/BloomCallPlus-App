package com.example.contactsapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.contactsapp.main.ReportActivity;
import com.example.contactsapp.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private FloatingActionButton mNewContactFab, mNewMsgFab, mNewDialFab;

    private ExtendedFloatingActionButton mNewActionFab;

    private TextView addNewContactTxt, addNewMsgText, newDialTxt;

    private Boolean isAllFabsVisible;

    private final int[] tabIcons = {
            R.drawable.ic_tab_history,
            R.drawable.ic_outline_call,
            R.drawable.ic_outline_message
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FF03DAC5"));

        actionBar.setBackgroundDrawable(colorDrawable);

        mNewActionFab = findViewById(R.id.new_action_fab);

        mNewContactFab = findViewById(R.id.new_contact);
        mNewMsgFab = findViewById(R.id.new_msg);
        mNewDialFab = findViewById(R.id.new_dial);

        addNewContactTxt = findViewById(R.id.add_new_contact_text);
        addNewMsgText = findViewById(R.id.new_msg_text);
        newDialTxt = findViewById(R.id.new_dial_text);

        mNewContactFab.setVisibility(View.GONE);
        addNewContactTxt.setVisibility(View.GONE);

        mNewMsgFab.setVisibility(View.GONE);
        addNewMsgText.setVisibility(View.GONE);

        mNewDialFab.setVisibility(View.GONE);
        newDialTxt.setVisibility(View.GONE);

        isAllFabsVisible = false;

        mNewActionFab.shrink();

        mNewActionFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!isAllFabsVisible) {

                            mNewContactFab.show();
                            mNewMsgFab.show();
                            mNewDialFab.show();

                            addNewContactTxt.setVisibility(View.VISIBLE);
                            addNewMsgText.setVisibility(View.VISIBLE);
                            newDialTxt.setVisibility(View.VISIBLE);

                            mNewActionFab.extend();

                            isAllFabsVisible = true;

                        } else {

                            mNewActionFab.hide();
                            mNewMsgFab.hide();
                            mNewDialFab.hide();

                            addNewContactTxt.setVisibility(View.GONE);
                            addNewMsgText.setVisibility(View.GONE);
                            newDialTxt.setVisibility(View.GONE);

                            mNewActionFab.shrink();

                            isAllFabsVisible = false;

                        }
                    }
                }
        );


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

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch(item.getItemId()) {
            case R.id.about:
                // about
                return true;
            case R.id.report_bug:
                sendEmail();
                return true;
            case R.id.settings:
                // settings
                return true;
            case R.id.donate:
                // donate
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    protected void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"ask.bloomcall@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }

}
