package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NGONotification extends AppCompatActivity {

    TextView text;
    DBHelper DB;
    Button button;
    String ngo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngonotification);

        DB= new DBHelper(this);
        text= findViewById(R.id.text);
        String idTXT= getIntent().getStringExtra("key2");


        Cursor res= DB.getngoname(idTXT);
        while(res.moveToNext()){
            ngo= res.getString(1);
        }

        boolean request= DB.checkrequestornot(idTXT);
        if(request==true){
            boolean accept= DB.checkacceptedornot(idTXT);
            if(accept==true){
                text.setText("Accepted By "+ ngo);
            }
            else{
                text.setText("Not Accepted By Any NGO");
            }
        }
        else{
            text.setText("NO Request Sent");
        }


        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(NGONotification.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}