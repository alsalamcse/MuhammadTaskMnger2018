package com.mousa.muhammad.muhammadtaskmnger;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail1, etPassword1;
    private Button btnSignin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail1 = (EditText) findViewById(R.id.etEmail1);
        etPassword1 = (EditText) findViewById(R.id.etPassword1);
        btnSignin = (Button) findViewById(R.id.btnSignin);
        btnSignup = (Button) findViewById(R.id.btnSignup);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i1 = new Intent(LoginActivity.this, MainTabsActivity.class);
                dataHandler();
               // startActivity(i1);
                // if email &
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(LoginActivity.this, SignupActivity.class);

                startActivity(i2);


            }
        });


    }


    private void signIn(String etEmail1, String etPassword1) {
        FirebaseAuth auth = null;
        auth.signInWithEmailAndPassword(etEmail1, etPassword1).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                     Intent intent=new Intent(LoginActivity.this,MainTabsActivity.class);
                      startActivity(intent);
                    //  finish();
                } else {
                    Toast.makeText(LoginActivity.this, "signIn failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }


    private void dataHandler() {
        boolean isok = true; // if all the fields filled well
        //if(etEmail2.getText().toString()
        String email1 = etEmail1.getText().toString();
        String password1 = etPassword1.getText().toString();

        if (email1.length() < 4 || email1.indexOf('@') < 0 || email1.indexOf('.') < 0) {
            etEmail1.setError("wrong Email");
            isok = false;
        }
        if (password1.length() < 8) {
            etPassword1.setError("Have to be at least 8 char");
            isok = false;
        }
        if (isok) {
            signIn(email1, password1);
            // Intent intent=new Intent(LogInActivity.this,MainFCMActivity.class);
            //   startActivity(intent);
        }
    }
}

