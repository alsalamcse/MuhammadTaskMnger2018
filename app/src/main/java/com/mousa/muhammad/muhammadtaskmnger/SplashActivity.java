package com.mousa.muhammad.muhammadtaskmnger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume()
    {


        super.onResume();

    }
    public class mythread extends Thread
    {
        @Override
        public void run() {

            try {
                sleep(3000);
                Intent i = new Intent(SplashActivity.this,MainTabsActivity.class);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
////





