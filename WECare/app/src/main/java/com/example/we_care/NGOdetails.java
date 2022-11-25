package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NGOdetails extends AppCompatActivity {

    TextView name, established, details;
    DBHelper DB;
    Button button;
    String ngoName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngodetails);
        DB= new DBHelper(this);
        name= findViewById(R.id.name);
        established= findViewById(R.id.established);
        details= findViewById(R.id.details);
        button= findViewById(R.id.button);

        String idTXT= getIntent().getStringExtra("key2");
        String nameTXT= getIntent().getStringExtra("key3");

        //name.setText(nameTXT);
        Cursor res= DB.getestabdate(nameTXT);

        while (res.moveToNext()){
            ngoName= res.getString(0);
            name.setText(ngoName);
            established.setText(res.getString(1));
            details.setText(res.getString(2));

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(NGOdetails.this, NGOMessage.class);
                intent.putExtra("key2",idTXT);
                intent.putExtra("key3",nameTXT);
                startActivity(intent);
            }
        });



    }
}