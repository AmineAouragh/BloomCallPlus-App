package com.example.contactsapp.main;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contactsapp.R;


public class MyContactsListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] contacts;
    private final String number;
    private final Integer img_item;

    public MyContactsListAdapter(Activity context, String[] contacts, String number, Integer img_item) {

        super(context, R.layout.contact_item, contacts);

        this.context = context;
        this.contacts = contacts;
        this.number = number;
        this.img_item = img_item;

    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.contact_item, null, true);

        TextView contactName = (TextView) rowView.findViewById(R.id.fullname);
        ImageView profilePic = (ImageView) rowView.findViewById(R.id.profile_pic);
        TextView contactNumber = (TextView) rowView.findViewById(R.id.number);

        contactName.setText(contacts[position]);
        profilePic.setImageResource(img_item);
        contactNumber.setText(number);

        return rowView;

    }

}
