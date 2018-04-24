package com.example.ankitd3.ageapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button l;
    Button r;
    EditText e;
    EditText p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        l=(Button)findViewById(R.id.login);
        r=(Button)findViewById(R.id.register);
        p=(EditText) findViewById(R.id.pass);
        e=(EditText) findViewById(R.id.email);

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u = e.getText().toString();
                String pass = p.getText().toString();

                SharedPreferences sp = getSharedPreferences("UserData",Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("Username",u);
                ed.putString("Password",pass);

                ed.apply();

                Toast.makeText(Login.this,"Registered Successfully",Toast.LENGTH_SHORT).show();

            }
        });

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u = e.getText().toString();
                String pass = p.getText().toString();

                SharedPreferences sp = getSharedPreferences("UserData",Context.MODE_PRIVATE);
                String check_u=sp.getString("Username","");
                String checl_p=sp.getString("Password","");

                if(check_u.equals(u) && checl_p.equals(pass)){
                    startActivity(new Intent(Login.this,NewActivity.class));
                }
                else {
                    Toast.makeText(Login.this,"Incorrect",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}