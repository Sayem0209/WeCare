package com.example.we_care;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewSingleNGORequest extends AppCompatActivity {

    TextView idedit, ngoedit, numberedit, messageedit;
    DBHelper DB;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_single_ngorequest);

        DB= new DBHelper(this);

        idedit= findViewById(R.id.idedit);
        ngoedit= findViewById(R.id.ngoedit);
        numberedit= findViewById(R.id.numberedit);
        messageedit= findViewById(R.id.messageedit);

        button= findViewById(R.id.button);

        String idTXT= getIntent().getStringExtra("key2");
        String ngoTXT= getIntent().getStringExtra("key3");

        Cursor res= DB.getreqngo(idTXT,ngoTXT);

        while (res.moveToNext()){
            idedit.setText(res.getString(0));
            ngoedit.setText(res.getString(1));
            numberedit.setText(res.getString(2));
            messageedit.setText(res.getString(3));

            //name.setText("hello");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB.updateaccept(idTXT,ngoTXT,"YES");
                Toast.makeText(ViewSingleNGORequest.this, "Request Accepted", Toast.LENGTH_SHORT).show();
                DB.deletengo(idTXT);
            }
        });




    }
}