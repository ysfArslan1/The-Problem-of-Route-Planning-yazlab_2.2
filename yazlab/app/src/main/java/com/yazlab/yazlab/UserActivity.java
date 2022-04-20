package com.yazlab.yazlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {

    Button durak_sec,guzergah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        durak_sec = (Button) findViewById(R.id.durak_sec);
        guzergah = (Button) findViewById(R.id.guzergah);

        /*Intent intent = getIntent();
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);*/


        durak_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), UserDuraklarActivity.class);
                startActivity(intent);
            }
        });
        guzergah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserMapActivity.class);
                startActivity(intent);
            }
        });


    }
}