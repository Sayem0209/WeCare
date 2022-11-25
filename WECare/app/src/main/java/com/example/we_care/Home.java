package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    LinearLayout profile;
    TextView profile2, name;
    String idTXT;
    String diseaseTXT;
    DBHelper DB;
    ImageView doctor, ngo, school, overview;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profile2= findViewById(R.id.profile2);
        name= findViewById(R.id.name);

        idTXT= getIntent().getStringExtra("key2");
        profile2.setText(idTXT);

        DB= new DBHelper(this);

        Cursor res= DB.getinfo(idTXT);

        while (res.moveToNext()){
            name.setText(res.getString(0));
            diseaseTXT= res.getString(4);


        }

        profile= (LinearLayout) findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1= new Intent(Home.this, Profile.class);

                intent1.putExtra("key2",idTXT);
                startActivity(intent1);

            }
        });

        doctor= findViewById(R.id.doctor);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(Home.this, ViewAvailableDoctor.class);
                intent2.putExtra("key2",idTXT);
                startActivity(intent2);
            }
        });

        ngo= findViewById(R.id.ngo);
        ngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(Home.this, NGOs.class);
                intent2.putExtra("key2",idTXT);
                startActivity(intent2);
            }
        });

        school= findViewById(R.id.school);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(Home.this, ViewAvailableSchool.class);
                intent2.putExtra("key2",idTXT);
                startActivity(intent2);
            }
        });

        overview= findViewById(R.id.overview);
        overview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(Home.this, OverviewDisease.class);
                intent2.putExtra("key2",idTXT);
                intent2.putExtra("key3",diseaseTXT);
                startActivity(intent2);
            }
        });

        logout= findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(Home.this, MainActivity.class);
                startActivity(intent2);
            }
        });
    }
}