package com.mousa.muhammad.muhammadtaskmnger;

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

public class SignupActivity extends AppCompatActivity {
    //1.add auth to project
//2.
    private EditText etEmail2,etPassword2,etFirstName,etLastName,etPhone;
    private Button btnSave;
   //3.
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
                dataHandler();

            }
        });

    }

    /**
     * get email and password from the field and try to create new user
     */

    private void dataHandler() {
        boolean isok= true; // if all the fields filled well
        //if(etEmail2.getText().toString()
        String email= etEmail2.getText().toString();
        String passw=etPassword2.getText().toString();
        String fname=etFirstName.getText().toString();
        String lname=etLastName.getText().toString();
        String phone=etPhone.getText().toString();
        if(email.length()<4|| email.indexOf('@')<0 || email.indexOf('.')<0)
        {
            etEmail2.setError("wrong Email");
            isok=false;
        }
        if(passw.length()<8)
        {
            etPassword2.setError("Have to be at least 8 char");
            isok=false;
        }
        if(isok)
        {
            creatAcount(email, passw);
        }




    }


    /**
     * create firebase user using email and password
     * @param email user email
     * @param passw user password
     */
    //4.


    private void creatAcount(String email, String passw) {
        auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SignupActivity.this, new OnCompleteListener <AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SignupActivity.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                    //updateUserProfile(task.getResult().getUser());
                    finish();
                }
                else
                {
                    Toast.makeText(SignupActivity.this, "Authentication failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }


}
