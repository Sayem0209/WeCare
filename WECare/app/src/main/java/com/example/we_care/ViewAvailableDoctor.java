package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewAvailableDoctor extends AppCompatActivity {
    DBHelper db;
    ListView listview;
    String speciTXT;
    TextView avail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_available_doctor);

        avail= findViewById(R.id.avail);

        listview= findViewById(R.id.myListView);
        DBHelper db= new DBHelper(this);

        String userIDTXT= getIntent().getStringExtra("key2");


        Cursor res= db.getInfoSpeci(userIDTXT);
        while (res.moveToNext()){
            speciTXT= res.getString(4);
        }

        //avail.setText(speciTXT);

        ArrayList<String> doctors= new ArrayList<>();
        List<Doctor> allDoctors= db.getAllDoctor(speciTXT);

        for(Doctor doctor: allDoctors){
            doctors.add(doctor.getName());
            //contacts.add(contact.getName());
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, doctors);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text= ((TextView) view).getText().toString();
                Intent intent= new Intent(ViewAvailableDoctor.this, ViewSingleDoctor.class);

                intent.putExtra("key3",userIDTXT);//userid
                intent.putExtra("key4",text);//school's name
                startActivity(intent);
            }
        });
    }
}