package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NGOs extends AppCompatActivity {

    TextView name1, name2, name3, name4;
    ImageView notification,back;
    TextView establisheddate1, establisheddate2, establisheddate3, establisheddate4;
    RelativeLayout layout1, layout2, layout3, layout4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngos);

        name1= findViewById(R.id.name1);
        name2= findViewById(R.id.name2);
        name3= findViewById(R.id.name3);
        name4= findViewById(R.id.name4);

        establisheddate1= findViewById(R.id.establisheddate1);
        establisheddate2= findViewById(R.id.establisheddate2);
        establisheddate3= findViewById(R.id.establisheddate3);
        establisheddate4= findViewById(R.id.establisheddate4);

        layout1= findViewById(R.id.layout1);
        layout2= findViewById(R.id.layout2);
        layout3= findViewById(R.id.layout3);
        layout4= findViewById(R.id.layout4);

        String name1TXT= name1.getText().toString();
        String name2TXT= name2.getText().toString();
        String name3TXT= name3.getText().toString();
        String name4TXT= name4.getText().toString();

         String idTXT= getIntent().getStringExtra("key2");


        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(NGOs.this,name1TXT , Toast.LENGTH_SHORT).show();

                Intent intent1= new Intent(NGOs.this, NGOdetails.class);
                intent1.putExtra("key2",idTXT);
                intent1.putExtra("key3",name1TXT);
                startActivity(intent1);
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(NGOs.this,name2TXT , Toast.LENGTH_SHORT).show();
                Intent intent1= new Intent(NGOs.this, NGOdetails.class);
                intent1.putExtra("key2",idTXT);
                intent1.putExtra("key3",name2TXT);
                startActivity(intent1);
            }
        });

        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(NGOs.this,name3TXT , Toast.LENGTH_SHORT).show();
                Intent intent1= new Intent(NGOs.this, NGOdetails.class);
                intent1.putExtra("key2",idTXT);
                intent1.putExtra("key3",name3TXT);
                startActivity(intent1);
            }
        });

        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(NGOs.this,name4TXT , Toast.LENGTH_SHORT).show();
                Intent intent1= new Intent(NGOs.this, NGOdetails.class);
                intent1.putExtra("key2",idTXT);
                intent1.putExtra("key3",name4TXT);
                startActivity(intent1);
            }
        });


        notification= findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(NGOs.this, NGONotification.class);
                intent.putExtra("key2",idTXT);
                startActivity(intent);
            }
        });

        back= findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(NGOs.this, Home.class);
                intent.putExtra("key2",idTXT);
                startActivity(intent);
            }
        });



    }
}