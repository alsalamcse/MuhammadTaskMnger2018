package com.mousa.muhammad.muhammadtaskmnger;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mousa.muhammad.muhammadtaskmnger.taskfragment.data.MyTask;
        ;

import java.util.Date;

public class AddTaskActivity extends AppCompatActivity {
    private EditText title, text, duedate, createdate;
    private SeekBar important, necessary;
    private Button save, datepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        title = (EditText) findViewById(R.id.title);
        text = (EditText) findViewById(R.id.text);
        duedate = (EditText) findViewById(R.id.duedate);
        createdate = (EditText) findViewById(R.id.createdate);

        important = (SeekBar) findViewById(R.id.important);
        necessary = (SeekBar) findViewById(R.id.necessary);

        save = (Button) findViewById(R.id.save);
        datepicker = (Button) findViewById(R.id.datepicker);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });

    }

    private void dataHandler() {

        boolean isok = true;
        String title1 = title.getText().toString();
        String text1 = text.getText().toString();
        String duedate1 = duedate.getText().toString();
        String createdate1 = createdate.getText().toString();

        int important1 = important.getProgress();
        int necessary1 = necessary.getProgress();

        if (title1.length() < 8) {
            title.setError("Have to be at least 8 letters");
            isok = false;
        }
        if (text1.length() < 8) {
            text.setError("Have to be at least 8 letters");
            isok = false;
        }
        if (duedate1.length() < 8) {
            duedate.setError("Have to be at least 8 letters");
            isok = false;
        }
        if (isok) {
            MyTask task = new MyTask();
            task.setCreatedAT(new Date());
//            task.setDueDate(new Date(date));
            task.setText(text1);
            task.setTitle(title1);
            task.setImportant(important1);
            task.setNecessary(necessary1);

            FirebaseAuth auth = FirebaseAuth.getInstance();
            task.setOwner(auth.getCurrentUser().getEmail());

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            String key = reference.child("MyTasks").push().getKey();
            task.setKey(key);
            reference.child("MyTasks").child(key).setValue(task).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "it worked ", Toast.LENGTH_SHORT);
                        Intent i = new Intent(getApplicationContext(), MainTabsActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "it didnt work ", Toast.LENGTH_SHORT);
                    }
                }
            });


        }


    }
}