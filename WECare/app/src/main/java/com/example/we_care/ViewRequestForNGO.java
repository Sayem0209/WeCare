package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewRequestForNGO extends AppCompatActivity {

    ListView listview;
    DBHelper DB;
    TextView request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_request_for_ngo);

        listview= findViewById(R.id.myListView);
        request= findViewById(R.id.request);
        DBHelper db= new DBHelper(this);

        String ngoTXT= getIntent().getStringExtra("key3");

        //request.setText(ngoTXT);

        ArrayList<String> ngomodels= new ArrayList<>();
        List<Ngomodel> allNgomodels= db.getAllNgomodel(ngoTXT);

        for(Ngomodel ngomodel: allNgomodels){
            ngomodels.add(ngomodel.getUserID());
            //contacts.add(contact.getName());
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ngomodels);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String idTXT= ((TextView) view).getText().toString();
                Intent intent= new Intent(ViewRequestForNGO.this,ViewSingleNGORequest.class);
                intent.putExtra("key2",idTXT);
                intent.putExtra("key3",ngoTXT);
                startActivity(intent);
                //Toast.makeText(ViewRequestForNGO.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}