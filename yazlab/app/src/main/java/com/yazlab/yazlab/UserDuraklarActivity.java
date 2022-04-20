package com.yazlab.yazlab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class UserDuraklarActivity extends AppCompatActivity implements
AdapterView.OnItemSelectedListener {

        String[] duraklar ={"","","","","","","","","","","","","","","","","","","",""};
        Button user_view_duraklar,durak_sec2;
        DBHelper DB;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            DB = new DBHelper(this);
            setContentView(R.layout.activity_user_duraklar);
            user_view_duraklar = findViewById(R.id.user_view_duraklar);
            durak_sec2 = findViewById(R.id.durak_sec2);
            Spinner spin = (Spinner) findViewById(R.id.spinner);
            spin.setOnItemSelectedListener(this);
            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,duraklar);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spin.setAdapter(aa);
            //Performing action onItemSelected and onNothing selected
            user_view_duraklar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor res = DB.getdurakdata();
                    if(res.getCount()==0){
                        Toast.makeText(UserDuraklarActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    int i=0;
                    while(res.moveToNext()){
                        buffer.append("Durak_Name :"+res.getString(0)+"\n");
                        buffer.append("Kisi_sayisi :"+res.getString(1)+"\n\n");
                        duraklar[i]=res.getString(0);
                        i++;
                     }
                    AlertDialog.Builder builder = new AlertDialog.Builder(UserDuraklarActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("User Entries");
                    builder.setMessage(buffer.toString());
                    builder.show();

                }        });
            durak_sec2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    String konum = spin.getSelectedItem().toString();

                }        });



        }


        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

            Toast.makeText(getApplicationContext(),duraklar[position] , Toast.LENGTH_LONG).show();
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    }