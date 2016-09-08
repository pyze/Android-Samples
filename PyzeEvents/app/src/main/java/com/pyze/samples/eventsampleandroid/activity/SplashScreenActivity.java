package com.pyze.samples.eventsampleandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pyze.android.Pyze;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Pyze.initialize(getApplication());
        Intent intent = new Intent(this, PyzeEventHomeActivty.class);
        startActivity(intent);
        finish();
    }
}
