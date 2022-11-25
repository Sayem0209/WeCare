package com.example.we_care;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAvailableDoctor extends AppCompatActivity {
    DBHelper DB;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_available_doctor);

        text= findViewById(R.id.text);

        DB= new DBHelper(this);
        Cursor res= DB.getdoctor();
        if(res.getCount()==0){
            Toast.makeText(ViewAvailableDoctor.this,"No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            StringBuffer buffer= new StringBuffer();
            while (res.moveToNext()){
                if(DB.checkdoctor(res.getString(2),"Asperger’s Syndrome")==true){
                    buffer.append("Name: "+res.getString(1)+"\n" );
                    buffer.append("Specialised: "+res.getString(2)+"\n" );
                    buffer.append("Hospital: "+res.getString(5)+"\n\n" );
                    //String na= res.getString(2);
                }

            }
            text.setText(buffer.toString());
//            AlertDialog.Builder builder= new AlertDialog.Builder(ViewAvailableDoctor.this);
//            builder.setCancelable(true);
//            builder.setTitle("User Entries");
//            builder.setMessage(buffer.toString());
//            builder.show();
        }

    }
}