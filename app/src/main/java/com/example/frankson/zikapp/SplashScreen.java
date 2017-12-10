package com.example.frankson.zikapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                abrirMain();
            }
        }, 2000);
    }

    private void abrirMain() {
        Intent intent = new Intent(SplashScreen.this, MainScreens.class);
        startActivity(intent);
        finish();
    }
}
