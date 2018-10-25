package com.mousa.muhammad.muhammadtaskmnger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class AddTaskActivity extends AppCompatActivity {
    private EditText title, text, duedate, createdate;
    private SeekBar important, necessary;
    private Button save, datepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        title = (EditText)findViewById(R.id.title);
        text = (EditText)findViewById(R.id.text);
        duedate = (EditText)findViewById(R.id.duedate);
        createdate = (EditText)findViewById(R.id.createdate);

        important = (SeekBar)findViewById(R.id.important);
        necessary = (SeekBar)findViewById(R.id.necessary);

        save = (Button)findViewById(R.id.save);
        datepicker = (Button)findViewById(R.id.datepicker);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}







