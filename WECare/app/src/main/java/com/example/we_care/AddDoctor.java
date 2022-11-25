package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
public class AddDoctor extends AppCompatActivity {

    EditText dname,location,quali,hospital;
    Spinner avai,special;
    Button reg;
    DBHelper DB;
    String specialTXT;
    String available;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        Spinner mySpinner1= (Spinner) findViewById(R.id.Special);
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
        Spinner mySpinner2= (Spinner) findViewById(R.id.Available);

        String[] bloodArr;
        bloodArr= getResources().getStringArray(R.array.Available);
        ArrayAdapter<String> myAdapter2= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bloodArr);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);

        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                available= bloodArr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        dname= (EditText) findViewById(R.id.name);
        location= (EditText) findViewById(R.id.loca);
        quali= (EditText) findViewById(R.id.qua);
        hospital= (EditText) findViewById(R.id.hospital);
        reg= (Button) findViewById(R.id.reg);

        DB= new DBHelper(this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dnameTXT= dname.getText().toString();
                String locationTXT= location.getText().toString();
                String qualiTXT= quali.getText().toString();
                String hospitalTXT=hospital.getText().toString();

                if(dnameTXT.equals("")|| locationTXT.equals("")|| qualiTXT.equals("")|| hospitalTXT.equals("")|| specialTXT.equals("(default)")|| available.equals("(default)")){
                    Toast.makeText(AddDoctor.this, "Please Fill All Requirements", Toast.LENGTH_SHORT).show();
                }
                else {


                    Boolean insert = DB.insertdata2(dnameTXT, specialTXT, locationTXT, qualiTXT,hospitalTXT,available);
                    Intent intent = new Intent(AddDoctor.this, AdminHome.class);
                    startActivity(intent);
                    intent.putExtra("key",dnameTXT);
                    Toast.makeText(AddDoctor.this, "Dr."+dnameTXT+" Added as a Doctor", Toast.LENGTH_SHORT).show();
                }

            }

        });



    }
}

