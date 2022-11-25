package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {

    EditText oldP, newP, confirmP;
    Button change;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        oldP= findViewById(R.id.oldPTXT);
        newP= findViewById(R.id.newPTXT);
        confirmP= findViewById(R.id.confirmPTXT);

        change= findViewById(R.id.change);

        DB= new DBHelper(this);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldTXT= oldP.getText().toString();
                String newTXT= newP.getText().toString();
                String confirmTXT= confirmP.getText().toString();

                if(oldTXT.equals("")|| newTXT.equals("")|| confirmTXT.equals("")){
                    Toast.makeText(ChangePassword.this, "Please Fill All Requirements", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(newTXT.equals(confirmTXT)){
                        String idTXT= getIntent().getStringExtra("key2");
                        DB.updatepassword(idTXT,newTXT);

                        Toast.makeText(ChangePassword.this, "Password Changed Successfully!!", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(ChangePassword.this, idTXT, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(ChangePassword.this, "New Password & Confirm Password Doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}