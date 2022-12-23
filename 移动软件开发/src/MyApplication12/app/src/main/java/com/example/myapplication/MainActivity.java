package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("OnCreate","OnCreate执行了==================");
    }

    @Override
    protected void onDestroy() {
        Log.i("OnDesTroy", "OnDestroy执行了===================");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("OnStart","OnStart执行了====================");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("OnRestart","OnRestart执行了=======================");
    }

    @Override
    protected void onStop() {
        Log.i("OnStop","OnStop执行了========================");

        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("OnPause","OnPause执行了======================");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("OnResume","OnResume执行了==========================");
    }
}