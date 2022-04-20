package com.yazlab.yazlab;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnlogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsignin1);
        DB = new DBHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        if(user.equals("admin")){
                            if(pass.equals("123")){
                                Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                                Intent intent  = new Intent(getApplicationContext(), AdminSecimActivity.class);
                                startActivity(intent);
                            }


                        }
                        else {
                            //40.692812402717315, 29.878351009546734
                            //DB.createuserkonum();
                            /*if(checkupdatedata==true)
                                Toast.makeText(LoginActivity.this, "Kullanıcı login durumuna geçti", Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(LoginActivity.this, "Kullanıcı login durumuna geçemedi", Toast.LENGTH_SHORT).show();
                            */
                            Intent intent  = new Intent(getApplicationContext(), UserActivity.class);
                            //
                           // Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();

                            startActivity(intent);

                        }

                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}