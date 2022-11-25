package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class ViewSingleDoctor extends AppCompatActivity {
    TextView doctornameedit, specialedit, locationedit, quaedit, hospitaledit, availedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_single_doctor);

        DBHelper DB= new DBHelper(this);
        doctornameedit= findViewById(R.id.doctornameedit);
        specialedit= findViewById(R.id.specialedit);
        locationedit= findViewById(R.id.locationedit);
        quaedit= findViewById(R.id.quaedit);
        hospitaledit= findViewById(R.id.hospitaledit);
        availedit= findViewById(R.id.availedit);

        String doctorTXT= getIntent().getStringExtra("key4");

        Cursor res= DB.getdoctordetails(doctorTXT);

        while (res.moveToNext()){
            doctornameedit.setText(res.getString(1));
            specialedit.setText(res.getString(2));
            locationedit.setText(res.getString(3));
            quaedit.setText(res.getString(4));
            hospitaledit.setText(res.getString(5));
            availedit.setText(res.getString(6));


        }

    }
}