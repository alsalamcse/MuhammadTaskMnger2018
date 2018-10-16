package com.mousa.muhammad.muhammadtaskmnger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    private EditText etEmail2,etPassword2,etFirstName,etLastName,etPhone;
    private Button btnSave;

    FirebaseAuth auth;//to establish sign in sign up
    FirebaseAuth user;//user






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
       // user = auth.getCurrentUser();//تعيد الكائن باليوزر الحالي اذا عامل sign in

        etEmail2=(EditText) findViewById(R.id.etEmail2);
        etPassword2=(EditText) findViewById(R.id.etPassword2);
        etFirstName=(EditText) findViewById(R.id.etFirstName);
        etLastName=(EditText) findViewById(R.id.etLastName);
        etPhone=(EditText) findViewById(R.id.etPhone);
        btnSave=(Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
