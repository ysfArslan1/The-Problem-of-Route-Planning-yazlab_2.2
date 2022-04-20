package com.yazlab.yazlab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminDuraklarActivity extends AppCompatActivity  {

    EditText name_durak,durak_kisi_sayisi,name_lat,name_long;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_duraklar);
        name_durak = (EditText) findViewById(R.id.name_durak);
        durak_kisi_sayisi =(EditText) findViewById(R.id.durak_kisi_sayisi);
        name_lat = (EditText) findViewById(R.id.name_lat);
        name_long = (EditText) findViewById(R.id.name_long);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_durakTXT = name_durak.getText().toString();
                String durak_kisi_sayisiTXT = durak_kisi_sayisi.getText().toString();
                String name_latTXT = name_lat.getText().toString();
                String name_longTXT = name_long.getText().toString();

                Boolean checkinsertdata = DB.createDurak(name_durakTXT, durak_kisi_sayisiTXT,name_latTXT,name_longTXT);
                if(checkinsertdata==true)
                    Toast.makeText(AdminDuraklarActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminDuraklarActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_durakTXT = name_durak.getText().toString();
                String durak_kisi_sayisiTXT = durak_kisi_sayisi.getText().toString();
                String name_latTXT = name_lat.getText().toString();
                String name_longTXT = name_long.getText().toString();

                Boolean checkupdatedata = DB.updatedurakdata(name_durakTXT, durak_kisi_sayisiTXT,name_latTXT,name_longTXT);
                if(checkupdatedata==true)
                    Toast.makeText(AdminDuraklarActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminDuraklarActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_durakTXT = name_durak.getText().toString();
                Boolean checkudeletedata = DB.deletedurakdata(name_durakTXT);
                if(checkudeletedata==true)
                    Toast.makeText(AdminDuraklarActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminDuraklarActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdurakdata();
                if(res.getCount()==0){
                    Toast.makeText(AdminDuraklarActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Durak_Name :"+res.getString(0)+"\n");
                    buffer.append("Kisi_sayisi :"+res.getString(1)+"\n\n");
                    buffer.append("Lat :"+res.getString(2)+"\n");
                    buffer.append("Long :"+res.getString(3)+"\n\n");

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminDuraklarActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });

    }
}