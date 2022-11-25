package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NGOMessage extends AppCompatActivity {

    TextView number, message;
    Button submit;
    DBHelper DB;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngomessage);
        DB= new DBHelper(this);

        String idTXT= getIntent().getStringExtra("key2");
        String nameTXT= getIntent().getStringExtra("key3");

        number= findViewById(R.id.number);
        message= findViewById(R.id.message);
        submit= findViewById(R.id.submit);
        back= findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(NGOMessage.this, NGOs.class);
                intent.putExtra("key2",idTXT);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberTXT= number.getText().toString();
                String messageTXT= message.getText().toString();
                if(numberTXT.equals("")|| messageTXT.equals("")){
                    Toast.makeText(NGOMessage.this, "Please Fill All Requirements", Toast.LENGTH_SHORT).show();
                }
                else{

                    Boolean checkyesno= DB.checkyesno(idTXT,"YES");
                    if(checkyesno==true){
                        Toast.makeText(NGOMessage.this, "Request Already Granted", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Boolean checkUserID= DB.checkIDForNGO(idTXT,nameTXT);
                        if(checkUserID==true){

                            Toast.makeText(NGOMessage.this, "Already Requested The NGO", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            DB.insertdata3(idTXT, nameTXT, numberTXT, messageTXT);
                            DB.insertdata4(idTXT,nameTXT,"NO");

//                        Intent intent = new Intent(NGOMessage.this, NGOs.class);
//                        startActivity(intent);

                            Toast.makeText(NGOMessage.this, "Request Sent To The NGO", Toast.LENGTH_SHORT).show();

                        }
                    }

                }
            }
        });
    }
}