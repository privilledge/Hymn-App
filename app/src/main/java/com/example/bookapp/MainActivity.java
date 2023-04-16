package com.example.bookapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Handler;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
                    public void run() {
                Intent i = new Intent(MainActivity.this, HomePage.class);

                startActivity(i);

                finish();

            }
        } ,3000);
    }
}