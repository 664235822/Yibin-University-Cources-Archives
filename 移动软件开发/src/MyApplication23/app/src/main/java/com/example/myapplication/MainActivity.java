package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.example.myapplication.MyBroadcastReceiver");
                intent.setPackage("com.example.myapplication");

                String name = "张三";
                String number = "20200001";
                intent.putExtra("name", name);
                intent.putExtra("number", number);
                Log.i("【MainActivity，onCreate】", "onCreate：发送的信息是：姓名：" + name + "，学号：" + number);
                sendOrderedBroadcast(intent, null);
            }
        });
    }
}