package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    String idTXT;
    TextView id;
    Button logout;
    String nameTXT;
    TextView name,address,pass,disease,blood;
    TextView change;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        DB= new DBHelper(this);

        id= findViewById(R.id.texview3b);
        idTXT= getIntent().getStringExtra("key2");
        id.setText(idTXT);

        name= findViewById(R.id.texview1b);
        address= findViewById(R.id.texview2b);
        pass= findViewById(R.id.texview4b);
        disease= findViewById(R.id.texview5b);
        blood= findViewById(R.id.texview6b);

        change= findViewById(R.id.change);


        Cursor res= DB.getinfo(idTXT);
//        StringBuffer buffer= new StringBuffer();

//        name.setText("hello");
        while (res.moveToNext()){
            name.setText(res.getString(0));
            address.setText(res.getString(1));
            pass.setText(res.getString(3));
            disease.setText(res.getString(4));
            blood.setText(res.getString(5));
            //name.setText("hello");

        }
        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Home.class);
                intent.putExtra("key2",idTXT);
                startActivity(intent);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Profile.this, ChangePassword.class);

                intent.putExtra("key2",idTXT);
                startActivity(intent);
            }
        });

    }
}