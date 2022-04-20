package com.yazlab.yazlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AdminSecimActivity extends AppCompatActivity {

    Button buttonsehir,buttonsqlite,rota_cal,rota,buttonaraclar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_secim);

        buttonaraclar = (Button) findViewById(R.id.buttonaraclar);
        buttonsqlite = (Button) findViewById(R.id.buttonsqlite);
        buttonsehir = (Button) findViewById(R.id.buttondurak);
        rota_cal = (Button) findViewById(R.id.rota_cal);
        rota = (Button) findViewById(R.id.rota);

        buttonaraclar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminAraclarActivity.class);
                startActivity(intent);
            }
        });

        buttonsqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminSqliteActivity.class);
                startActivity(intent);
            }
        });
        buttonsehir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminDuraklarActivity.class);
                startActivity(intent);
            }
        });
        rota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminMapActivity.class);
                startActivity(intent);
            }
        });
        rota_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RotaCalActivity.class);
                startActivity(intent);
            }
        });
    }
}