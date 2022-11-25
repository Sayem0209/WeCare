package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class OverviewDisease extends AppCompatActivity {

    TextView diseasename, whatsyndromeans, whattreatmentans;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_disease);
        DB= new DBHelper(this);

        diseasename= findViewById(R.id.diseasename);
        whatsyndromeans= findViewById(R.id.whatsyndromeans);
        whattreatmentans= findViewById(R.id.whattreatmentans);

        String diseaseTXT= getIntent().getStringExtra("key3");
        diseasename.setText(diseaseTXT);

        Cursor res= DB.getoverview(diseaseTXT);

        while (res.moveToNext()){
            whatsyndromeans.setText(res.getString(1));
            whattreatmentans.setText(res.getString(2));


        }


    }
}