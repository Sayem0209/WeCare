package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText name,id,pass;
    Spinner address,disease,blood;
    Button register;
    DBHelper DB;
    String diseaseTXT;
    String addressTXT;
    String bloodTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Spinner mySpinner1= (Spinner) findViewById(R.id.disease);

        String[] diseaseArr;
        diseaseArr= getResources().getStringArray(R.array.diseaseS);
        ArrayAdapter<String> myAdapter1= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,diseaseArr);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);

        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                diseaseTXT= diseaseArr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        Spinner mySpinner2= (Spinner) findViewById(R.id.blood);

        String[] bloodArr;
        bloodArr= getResources().getStringArray(R.array.bloodS);
        ArrayAdapter<String> myAdapter2= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bloodArr);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);

        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bloodTXT= bloodArr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner mySpinner3= (Spinner) findViewById(R.id.address);

        String[] addressArr;
        addressArr= getResources().getStringArray(R.array.addressS);
        ArrayAdapter<String> myAdapter3= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,addressArr);
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(myAdapter3);

        mySpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                addressTXT= addressArr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        name= (EditText) findViewById(R.id.name);
        id= (EditText) findViewById(R.id.id);
        pass= (EditText) findViewById(R.id.pass);
        register= (Button) findViewById(R.id.register);

        DB= new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT= name.getText().toString();
                String idTXT= id.getText().toString();
                String passTXT= pass.getText().toString();


                if(nameTXT.equals("")|| idTXT.equals("")|| passTXT.equals("")|| diseaseTXT.equals("(default)")|| bloodTXT.equals("(default)")|| addressTXT.equals("(default)")){
                    Toast.makeText(MainActivity2.this, "Please Fill All Requirements", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean check= DB.checkID(idTXT);
                    if (check == false) {
                        Boolean insert = DB.insertdata(nameTXT, addressTXT, idTXT, passTXT, diseaseTXT, bloodTXT);

                        Intent intent = new Intent(MainActivity2.this, Home.class);

                        intent.putExtra("key2",idTXT);

                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity2.this, "UserID already Exist", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}