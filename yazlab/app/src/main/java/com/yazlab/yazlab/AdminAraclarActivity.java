package com.yazlab.yazlab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAraclarActivity extends AppCompatActivity {

    EditText name_arac,kisi_sayisi;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_araclar);
        name_arac = (EditText) findViewById(R.id.name_arac);
        kisi_sayisi =(EditText) findViewById(R.id.kisi_sayisi);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_aracTXT = name_arac.getText().toString();
                String kisi_sayisitTXT = kisi_sayisi.getText().toString();

                Boolean checkinsertdata = DB.createArac(name_aracTXT, kisi_sayisitTXT);
                if(checkinsertdata==true)
                    Toast.makeText(AdminAraclarActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminAraclarActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_aracTXT = name_arac.getText().toString();
                String kisi_sayisitTXT = kisi_sayisi.getText().toString();

                Boolean checkupdatedata = DB.updatearacdata(name_aracTXT, kisi_sayisitTXT);
                if(checkupdatedata==true)
                    Toast.makeText(AdminAraclarActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminAraclarActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_aracTXT = name_arac.getText().toString();
                Boolean checkudeletedata = DB.deletearacdata(name_aracTXT);
                if(checkudeletedata==true)
                    Toast.makeText(AdminAraclarActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminAraclarActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getaracdata();
                if(res.getCount()==0){
                    Toast.makeText(AdminAraclarActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Arac_Name :"+res.getString(0)+"\n");
                    buffer.append("Kisi_sayisi :"+res.getString(1)+"\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminAraclarActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });

    }
}