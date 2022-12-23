package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startBtn, stopBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.startBtn);
        stopBtn = findViewById(R.id.stopBtn);
        intent = new Intent(this, MySecondService.class);

        ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MyBinder binder = (MyBinder) iBinder;
                Log.i("serviceConnection", "【onServiceConnected】连接建立" + binder.getCount());
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i("serviceConnection", "【onServiceConnected】断开连接");
            }
        };

        startBtn.setOnClickListener(view -> bindService(intent, serviceConnection, BIND_AUTO_CREATE));
        stopBtn.setOnClickListener(view -> unbindService(serviceConnection));
    }
}