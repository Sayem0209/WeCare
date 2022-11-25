package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class ViewSingleSchool extends AppCompatActivity {
    TextView schoolnameedit, locationedit, EIINedit, ratingedit, contactedit, emailedit, speciaedit, feeedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_single_school);

        DBHelper DB= new DBHelper(this);

        schoolnameedit= findViewById(R.id.schoolnameedit);
        locationedit= findViewById(R.id.locationedit);
        EIINedit= findViewById(R.id.EIINedit);
        ratingedit= findViewById(R.id.ratingedit);
        contactedit= findViewById(R.id.contactedit);
        emailedit= findViewById(R.id.emailedit);
        speciaedit= findViewById(R.id.speciaedit);
        feeedit= findViewById(R.id.feeedit);

        String schoolTXT= getIntent().getStringExtra("key4");

        //schoolnameedit.setText(schoolTXT);

        Cursor res= DB.getschooldetails(schoolTXT);

        while (res.moveToNext()){
            schoolnameedit.setText(res.getString(0));
            locationedit.setText(res.getString(1));
            EIINedit.setText(res.getString(2));
            ratingedit.setText(res.getString(3));
            contactedit.setText(res.getString(4));
            emailedit.setText(res.getString(5));
            speciaedit.setText(res.getString(6));
            feeedit.setText(res.getString(7));
            //name.setText("hello");

        }


    }
}