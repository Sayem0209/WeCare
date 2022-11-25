package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminHome extends AppCompatActivity {
    Button sch,doc, ngo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        sch= (Button) findViewById(R.id.school);
        sch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminHome.this, AddSchool.class);
                startActivity(intent);
            }

        });
        doc= (Button) findViewById(R.id.doctor);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminHome.this, AddDoctor.class);
                startActivity(intent);
            }
        });

        ngo= findViewById(R.id.ngo);
        ngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHome.this, AdminNGOs.class);
                startActivity(intent);
            }
        });
    }
}