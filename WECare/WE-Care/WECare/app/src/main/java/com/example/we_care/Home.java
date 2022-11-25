package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    LinearLayout profile;
    TextView name;
    String nameTXT;

    Button doctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name= findViewById(R.id.profile2);

        nameTXT= getIntent().getStringExtra("key");
        name.setText(nameTXT);




        profile= (LinearLayout) findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1= new Intent(Home.this, Profile.class);

                intent1.putExtra("key2",nameTXT);
                startActivity(intent1);

            }
        });

        doctor= findViewById(R.id.doctor);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(Home.this, ViewAvailableDoctor.class);
                startActivity(intent2);
            }
        });
    }
}