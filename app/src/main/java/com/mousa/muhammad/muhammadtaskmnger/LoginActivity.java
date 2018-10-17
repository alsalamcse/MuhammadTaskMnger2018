package com.mousa.muhammad.muhammadtaskmnger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
{

    private EditText etEmail1,etPassword1;
    private Button btnSignin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail1=(EditText) findViewById(R.id.etEmail1);
        etPassword1=(EditText) findViewById(R.id.etPassword1);
        btnSignin=(Button) findViewById(R.id.btnSignin);
        btnSignup=(Button) findViewById(R.id.btnSignup);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(LoginActivity.this, MainTabsActivity .class);
                startActivity(i1);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2= new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i2);
                

            }
        });

    }
}
