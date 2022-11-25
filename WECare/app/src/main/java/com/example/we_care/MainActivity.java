package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView create;
    EditText name, pass;
    Button button;
    DBHelper DB;
    String nameTXT;
    String passTXT;
    ToggleButton toggleButton;
    ImageView information;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create= (TextView) findViewById(R.id.create);

        create.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                Intent intent1= new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent1);
            }
        });

        name= (EditText) findViewById(R.id.name);
        pass= (EditText) findViewById(R.id.pass);
        button= (Button) findViewById(R.id.button);
        toggleButton=(ToggleButton) findViewById(R.id.tog);


        DB= new DBHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTXT= name.getText().toString();
                passTXT= pass.getText().toString();

                if(nameTXT.equals("")|| passTXT.equals("")){
                    Toast.makeText(MainActivity.this, "Please Fill All Requirements", Toast.LENGTH_SHORT).show();
                }
                else if(!toggleButton.isChecked()) {
                    Boolean success = DB.checklogin(nameTXT, passTXT);
                    if (success == true) {
                        Intent intent = new Intent(MainActivity.this, Home.class);

                        intent.putExtra("key2",nameTXT);

                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "UserID/Password Incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    if(nameTXT.toString().equals("admin")&&passTXT.toString().toString().equals("admin"))
                    {
                        Intent intent = new Intent(MainActivity.this, AdminHome.class);
                        intent.putExtra("key2",nameTXT);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "UserID/Password Incorrect", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });

        information=findViewById(R.id.information);
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, developers.class);
                startActivity(intent);
            }
        });

    }
}