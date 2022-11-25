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

public class ViewAvailableSchool extends AppCompatActivity {
    DBHelper db;
    ListView listview;
    String speciTXT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_available_school);

        listview= findViewById(R.id.myListView);
        DBHelper db= new DBHelper(this);

        String userIDTXT= getIntent().getStringExtra("key2");

        Cursor res= db.getInfoSpeci(userIDTXT);
        while (res.moveToNext()){
            speciTXT= res.getString(4);
        }

        ArrayList<String> schools= new ArrayList<>();
        List<School> allSchools= db.getAllSchool(speciTXT);

        for(School school: allSchools){
            schools.add(school.getName());
            //contacts.add(contact.getName());

        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, schools);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text= ((TextView) view).getText().toString();
                Intent intent= new Intent(ViewAvailableSchool.this, ViewSingleSchool.class);

                intent.putExtra("key3",userIDTXT);//userid
                intent.putExtra("key4",text);//school's name
                startActivity(intent);
            }
        });
    }
}