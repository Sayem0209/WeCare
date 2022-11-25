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

public class AddSchool extends AppCompatActivity {
    EditText sname,eiin,contact,email,fees;
    Spinner address,special,rate;
    Button reg;
    DBHelper DB;
    String specialTXT;
    String addressTXT;
    String rateTXT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_school);

        Spinner mySpinner1= (Spinner) findViewById(R.id.disease);

        String[] diseaseArr;
        diseaseArr= getResources().getStringArray(R.array.diseaseS);
        ArrayAdapter<String> myAdapter1= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,diseaseArr);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);
        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                specialTXT= diseaseArr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner mySpinner2= (Spinner) findViewById(R.id.rate);

        String[] bloodArr;
        bloodArr= getResources().getStringArray(R.array.rateS);
        ArrayAdapter<String> myAdapter2= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bloodArr);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);

        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                rateTXT= bloodArr[i];
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

        sname= (EditText) findViewById(R.id.sname);
        eiin= (EditText) findViewById(R.id.eiin);
        contact= (EditText) findViewById(R.id.contact);
        email= (EditText) findViewById(R.id.email);
        fees= (EditText) findViewById(R.id.fees);
        reg= (Button) findViewById(R.id.reg);

        DB= new DBHelper(this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT= sname.getText().toString();
                String eiinTXT= eiin.getText().toString();
                String contactTXT= contact.getText().toString();
                String emailTXT= email.getText().toString();
                String feesTXT=fees.getText().toString();


                if(nameTXT.equals("")|| eiinTXT.equals("")|| contactTXT.equals("")|| specialTXT.equals("(default)")|| rateTXT.equals("(default)")|| addressTXT.equals("(default)")||emailTXT.equals("")||feesTXT.equals("")){
                    Toast.makeText(AddSchool.this, "Please Fill All Requirements", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean check= DB.checkeiin(eiinTXT);
                    if (check == false) {
                        Boolean insert = DB.insertdata1(nameTXT, addressTXT, eiinTXT, rateTXT,contactTXT,emailTXT,specialTXT,feesTXT);

                        Intent intent = new Intent(AddSchool.this, AdminHome.class);

                        intent.putExtra("key",eiinTXT);

                        startActivity(intent);
                    } else {
                        Toast.makeText(AddSchool.this, "UserID already Exist", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}